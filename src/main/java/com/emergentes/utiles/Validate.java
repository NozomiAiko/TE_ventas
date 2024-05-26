package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validate extends Conexion {

    Connection con = this.conectar();
    PreparedStatement pr;
    public boolean checkUser(String email, String password) {
        boolean resultado = false;
        try {
            
            String sql = "select * from usuarios where email=? and password=sha1(?)";     
            pr=con.prepareStatement(sql);
            pr.setString(1,email);
            pr.setString(2,password);
            ResultSet rs=pr.executeQuery();
            //cambia de falso a verdader
            resultado=rs.next();
        } catch (SQLException ex) {
            System.out.println("Error al autenticar"+ex.getMessage());
        }
        return resultado;
    }
}
