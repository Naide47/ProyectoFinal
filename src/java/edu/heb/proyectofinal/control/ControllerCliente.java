/**
 * Clase que ejecuta instrucciones SQL
 * Creado: 03/12/2020 por Victor Santillan
 * Comunica la información de los clientes con el sistema
 */
package edu.heb.proyectofinal.control;

import edu.heb.proyectofinal.database.Conexion;
import edu.heb.proyectofinal.model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerCliente {

    Conexion conn = new Conexion();

    PreparedStatement ps;

    ResultSet rs;

    String query;

    public boolean buscarCliente(String correo_electronico) throws SQLException {

        query = "SELECT nombres FROM v_cliente1 WHERE correo_electronico = ?";

        conn.conectar();

        ps = conn.getConnection().prepareCall(query);
        ps.setString(1, correo_electronico);

        rs = ps.executeQuery();

        return rs.next();

    }

    public boolean registrarCliente(Cliente cliente) {

        return false;
    }

}
