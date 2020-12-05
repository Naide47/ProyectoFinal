/**
 * Clase que ejecuta instrucciones SQL
 * Creado: 03/12/2020 por Victor Santillan
 * Comunica la información de los usuarios con el sistema
 */
package edu.heb.proyectofinal.control;

import edu.heb.proyectofinal.database.Conexion;
import edu.heb.proyectofinal.model.Usuario;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

public class ControllerUsuario {

    Conexion conn = new Conexion();

    CallableStatement cs;

    PreparedStatement ps;

    ResultSet rs;

    String query;

    public Usuario registrarUsuario(Usuario usuario) {
        try {
            
            System.out.println("query");
            query = "CALL registrarUsuario(?, ?, ?, ?,"
                    + "?, ?, ?, ?, ?"
                    + "?, ?, ?, ?";

            conn.conectar();
            System.out.println("conn.conectar();");

            cs = conn.getConnection().prepareCall(query);
            System.out.println("cs = conn.getConnection().prepareCall(query);");

            cs.setString("var_nombres", usuario.getNombre());
            cs.setString("var_primer_apellido", usuario.getPrimer_apellido());
            cs.setString("var_segundo_apellido", usuario.getSegundo_apellido());
            cs.setString("var_ciudad", usuario.getCiudad());
            cs.setString("var_colonia", usuario.getColonia());
            cs.setString("var_cp", usuario.getCp());
            cs.setInt("var_numero_exterior", usuario.getNumero_exterior());
            cs.setInt("var_numero_interior", usuario.getNumero_interior());
            cs.setString("var_telefono ", usuario.getTelefono());
            cs.setString("var_celular", usuario.getCelular());
            cs.setString("var_correo", usuario.getCorreo_electronico());
            cs.setInt("var_rol", usuario.getRol());
            System.out.println("preparo el cs");
            
            cs.registerOutParameter("resultado", Types.BOOLEAN);
            System.out.println("preparo el cs de salida");

            cs.execute();
            System.out.println("cs.execute();");
            System.out.println(query);

            boolean resultado = cs.getBoolean("resultado");
            System.out.println("resultado: " + resultado);

            if (resultado) {
                query = "SELECT nombre_usuario, contrasenia FROM Usuario WHERE correo = ?";

                ps = conn.getConnection().prepareCall(query);

                rs = ps.executeQuery();
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setNombre_usuario(rs.getString("nombre_usuario"));
                    usuario.setContrasenia(rs.getString("contrasenia"));

                    conn.desconectar();
                    return usuario;
                } else {
                    conn.desconectar();
                    return null;
                }
            } else {
                conn.desconectar();
                return null;
            }

        } catch (Exception e) {
            System.out.println("Ocurrio una excepción al registrar a un nuevo usuario");
            e.printStackTrace();
            conn.desconectar();
        }
        return null;
    }

    public Usuario iniciarSesion(Usuario usuario) {
        try {
            query = "CALL iniciarSesion(?, ?, ?)";
//            System.out.println("query = \"CALL iniciarSesion(?, ?, ?)\";");

            conn.conectar();
//            System.out.println("conn.conectar();");

            cs = conn.getConnection().prepareCall(query);
//            System.out.println("cs = conn.getConnection().prepareCall(query);");

            cs.setString("var_nombre_usuario", usuario.getNombre_usuario());
            cs.setString("var_contrasenia", usuario.getContrasenia());
//            System.out.println("cs set string");
            
            cs.registerOutParameter("resultado", Types.BOOLEAN);
//            System.out.println("cs.registerOutParameter(\"resultado\", Types.BOOLEAN);");
            
//            System.out.println("query: " + cs.toString());
            
            cs.execute();
//            System.out.println("cs.execute();");
            
//            System.out.println("Resultado de la busqueda: " + cs.getBoolean("resultado"));

            if (cs.getBoolean("resultado")) {
//                System.out.println("Encontro al usuario");
                
                query = "SELECT * FROM v_usuarios1 WHERE nombre_usuario = ?";
//                System.out.println("query = \"SELECT * FROM v_usuarios1 WHERE nombre_usuario = ?\";");

                ps = conn.getConnection().prepareCall(query);
//                System.out.println("ps = conn.getConnection().prepareCall(query);");

                ps.setString(1, usuario.getNombre_usuario());
//                System.out.println("ps.setString(1, usuario.getNombre_usuario());");
                
//                System.out.println("query: " + ps.toString());

                rs = ps.executeQuery();
//                System.out.println("rs = ps.executeQuery();");

                Usuario aux = new Usuario();
//                System.out.println("Usuario aux = new Usuario();");

                if (rs.next()) {
//                    System.out.println("if (rs.next())");
                    if (rs.getBoolean("estatus")) {
//                        System.out.println("estatus: " + rs.getBoolean("estatus"));
                        aux.setIdUsuario(rs.getString("idUsuario"));
//                        System.out.println("idUsuario: " + rs.getString("idUsuario"));
                        aux.setNombre_usuario(rs.getString("nombre_usuario"));
//                        System.out.println("nombre_usuario: " + rs.getString("nombre_usuario"));
                        aux.setRol(rs.getInt("rol"));
//                        System.out.println("rol: " + rs.getInt("rol"));
//                        aux.setIdPersona(rs.getString("idPersona"));
                        aux.setNombre(rs.getString("nombres"));
//                        System.out.println("nombres: " + rs.getString("nombres"));
                        aux.setPrimer_apellido(rs.getString("primer_apellido"));
//                        System.out.println("primer_apellido: " + rs.getString("primer_apellido"));
                        aux.setSegundo_apellido(rs.getString("segundo_apellido"));
//                        System.out.println("segundo_apellido: " + rs.getString("segundo_apellido"));
//                        aux.setCiudad(rs.getString("ciudad"));
//                        aux.setColonia(rs.getString("colonia"));
//                        aux.setCp(rs.getString("cp"));
//                        aux.setNumero_exterior(rs.getInt("numero_exterior"));
//                        aux.setNumero_interior(rs.getInt("numero_interior"));
//                        aux.setTelefono(rs.getString("telefono"));
//                        aux.setCelular(rs.getString("celular"));
                        aux.setCorreo_electronico(rs.getString("correo"));
//                        System.out.println("correo: " + rs.getString("correo"));

//                        System.out.println("retorno aux");
                        
                        conn.desconectar();
                        return aux;
                    } else {
//                        System.out.println("El usuario tiene estatus FALSE");
                        conn.desconectar();
                        return null;
                    }
                } else {
//                    System.out.println("El rs estaba vacio");
                    conn.desconectar();
                    return null;
                }
            } else {
//                System.out.println("No se encontro al usuario");
                conn.desconectar();
                return null;
            }

        } catch (Exception e) {
            System.out.println("Ocurrio una excepción al iniciar sesión");
            e.printStackTrace();
            conn.desconectar();
        }
        return null;
    }

}
