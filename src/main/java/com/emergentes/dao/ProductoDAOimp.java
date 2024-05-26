package com.emergentes.dao;

import com.emergentes.modelo.Producto;
import com.emergentes.utiles.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOimp extends Conexion implements ProductoDAO {

    @Override
    public void insert(Producto producto) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO productos(nombre,descripcion,precio) values (?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setFloat(3, producto.getPrecio());
            ps.executeUpdate();

        } catch (Exception ex) {
            System.out.println("ERROR AL GUARDAR" + ex.getMessage());
        }
        this.desconectar();
    }

    @Override
    public void update(Producto producto) throws Exception {
        String sql = "Update productos set nombre=?,descripcion=?,precio=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, producto.getNombre());
        ps.setString(2, producto.getDescripcion());
        ps.setFloat(3, producto.getPrecio());
        ps.setInt(4, producto.getId());
        ps.executeUpdate();
        this.desconectar();

    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "Delete from productos where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public Producto getById(int id) throws Exception {
        Producto pro = new Producto();
        String sql = "Select * from productos where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            pro.setId(rs.getInt("id"));
            pro.setNombre(rs.getString("nombre"));
            pro.setDescripcion(rs.getString("descripcion"));
            pro.setPrecio(rs.getFloat("precio"));

        }
        this.desconectar();
        return pro;
    }

    @Override
    public List<Producto> getAll() throws Exception {

        List<Producto> lista = null;
        String sql = "Select * from productos";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        lista = new ArrayList<Producto>();
        ResultSet rs = ps .executeQuery();
        while (rs.next()) {
            Producto pro = new Producto();
            pro.setId(rs.getInt("id"));
            pro.setNombre(rs.getString("nombre"));
            pro.setDescripcion(rs.getString("descripcion"));
            pro.setPrecio(rs.getFloat("precio"));
            lista.add(pro);
        }
        rs.close();
        ps.close();
        this.desconectar();
        return lista;
    }

}
