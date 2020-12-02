/**
 * Clase Conexion
 * Creado: 01/12/2020 por Victor Santillan
 * Permite la conexión con la base de datos
 */
package edu.heb.proyectofinal.database;

import java.sql.*;

public class Conexion {

    private Connection conn;
    private String user = "root";
    private String pass = "root";
    private String db = "ProyectoFinal";

    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en el constructor de Conexion");
            ex.printStackTrace();
        }
    }

    public void conectar() {
        try {

            String ubicacion = "jdbc:mysql://127.0.0.1:3306/" + db
                    + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

            conn = DriverManager.getConnection(ubicacion, user, pass);

        } catch (Exception ex) {
            System.out.println("Error en Conexion/conectar ");
            ex.printStackTrace();
        }
    }

    public void desconectar() {
        try {

            conn.close();

        } catch (Exception ex) {
            System.out.println("Error en Conexion/desconectar ");
            ex.printStackTrace();
        }
    }
    
    public Connection getConnection() {
        return this.conn;
    }

}
