package com.emergentes.dao;

import com.emergentes.modelo.Venta;
import com.emergentes.utiles.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VentaDAOimp extends Conexion implements VentaDAO {

    @Override
    public void insert(Venta venta) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO ventas(producto_id,cliente_id,fecha) values (?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, venta.getProducto_id());
            ps.setInt(2, venta.getCliente_id());
            ps.setString(3, venta.getFecha());
            ps.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("ERROR AL GUARDAR" + ex.getMessage());
        }
        this.desconectar();
    }

    @Override
    public void update(Venta venta) throws Exception {
        String sql = "Update ventas set producto_id=?,cliente_id=?,fecha=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, venta.getProducto_id());
        ps.setInt(2, venta.getCliente_id());
        ps.setString(3, venta.getFecha());
        ps.setInt(4, venta.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
         String sql = "Delete from ventas where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public Venta getById(int id) throws Exception {
         Venta v = new Venta();
        String sql = "Select * from ventas where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            v.setId(rs.getInt("id"));
            v.setProducto_id(rs.getInt("producto_id"));
            v.setCliente_id(rs.getInt("cliente_id"));
            v.setFecha(rs.getString("fecha"));

        }
        this.desconectar();
        return v;
    }

    @Override
    public List<Venta> getAll() throws Exception {
        
        List<Venta> lista = null;
        String sql = "select v.* ,p.nombre as producto,c.nombre as cliente from ventas v "
                + " left join productos p on v.producto_id=p.id" 
                +" left join clientes c on v.cliente_id = c.id";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        lista = new ArrayList<Venta>();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Venta v = new Venta();
            v.setId(rs.getInt("id"));
            v.setProducto_id(rs.getInt("producto_id"));
            v.setCliente_id(rs.getInt("cliente_id"));
            v.setFecha(rs.getString("fecha"));
            v.setProducto(rs.getString("producto"));
            v.setCliente(rs.getString("cliente"));
            lista.add(v);
        }
        rs.close();
        ps.close();
        this.desconectar();
        return lista;
    }

}
