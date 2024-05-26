package com.emergentes.dao;

import com.emergentes.modelo.Cliente;
import com.emergentes.utiles.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOimp extends Conexion implements ClienteDAO {

    @Override
    public void insert(Cliente cliente) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO clientes(nombre,correo,celular) values (?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getCorreo());
            ps.setString(3, cliente.getCelular());
            ps.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("ERROR AL GUARDAR" + ex.getMessage());
        }
        this.desconectar();

    }

    @Override
    public void update(Cliente cliente) throws Exception {
        String sql = "Update clientes set nombre=?,correo=?,celular=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, cliente.getNombre());
        ps.setString(2, cliente.getCorreo());
        ps.setString(3, cliente.getCelular());
        ps.setInt(4, cliente.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "Delete from clientes where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public Cliente getById(int id) throws Exception {
        Cliente cli = new Cliente();
        String sql = "Select * from clientes where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            cli.setId(rs.getInt("id"));
            cli.setNombre(rs.getString("nombre"));
            cli.setCorreo(rs.getString("correo"));
            cli.setCelular(rs.getString("celular"));

        }
        this.desconectar();
        return cli;
    }

    @Override
    public List<Cliente> getAll() throws Exception {

        List<Cliente> lista = null;
        String sql = "Select * from clientes";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        lista = new ArrayList<Cliente>();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Cliente cli = new Cliente();
            cli.setId(rs.getInt("id"));
            cli.setNombre(rs.getString("nombre"));
            cli.setCorreo(rs.getString("correo"));
            cli.setCelular(rs.getString("celular"));
            lista.add(cli);
        }
        rs.close();
        ps.close();
        this.desconectar();
        return lista;
    }

}
