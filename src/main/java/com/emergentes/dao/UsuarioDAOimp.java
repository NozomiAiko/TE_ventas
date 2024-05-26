/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.dao;
import com.emergentes.modelo.Usuario;
import com.emergentes.utiles.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 999ma
 */
public class UsuarioDAOimp extends Conexion implements UsuarioDAO {
    @Override
    public void insert(Usuario usuario) throws Exception {
         try {
            this.conectar();
            String sql = "INSERT INTO usuarios(email,password) values (?,sha1(?))";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getPassword());
            ps.executeUpdate();

        } catch (Exception ex) {
            System.out.println("ERROR AL GUARDAR" + ex.getMessage());
        }
        this.desconectar();
         }

    @Override
    public void update(Usuario usuario) throws Exception {
        String sql = "update usuarios set email=?,password=sha1(?) where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, usuario.getEmail());
        ps.setString(2, usuario.getPassword());
        ps.setInt(3, usuario.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
         String sql = "Delete from usuarios where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public Usuario getById(int id) throws Exception {
        Usuario usu = new Usuario();
        String sql = "Select * from usuarios where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            usu.setId(rs.getInt("id"));
            usu.setEmail(rs.getString("email"));
            usu.setPassword(rs.getString("password"));
        }
        this.desconectar();
        return usu;
    }

    @Override
    public List<Usuario> getAll() throws Exception {
        List<Usuario> lista = null;
        String sql = "Select * from usuarios";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        lista = new ArrayList<Usuario>();
        ResultSet rs = ps .executeQuery();
        while (rs.next()) {
            Usuario usu = new Usuario();
            usu.setId(rs.getInt("id"));
            usu.setEmail(rs.getString("email"));
            usu.setPassword(rs.getString("password"));
            lista.add(usu);
        }
        rs.close();
        ps.close();
        this.desconectar();
        return lista;
    }
    
}
