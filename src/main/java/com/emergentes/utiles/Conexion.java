
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    static String url="jdbc:mysql://localhost:3309/bd_ventas";
    static String usuario="root";
    static String password="";
    static String driver="com.mysql.cj.jdbc.Driver";
    
    protected Connection conn=null;

    public Conexion() {
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url,usuario,password);
            if(conn !=null){
                System.out.println("CONEXION OK"+ conn);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("ERROR: "+ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("ERROR AL CONECTAR: "+ex.getMessage());
        }
    }
    public Connection conectar(){
        return conn;
    }
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("ERROR AL CERRAR CONEXION: "+ex.getMessage());
        }
    }
}
