/**
 * Clase que ejecuta instrucciones SQL
 * Creado: 03/12/2020 por Victor Santillan
 * Realiza las peticiones a la base de datos, y devuelve los resultados
 */
package edu.heb.proyectofinal.control;

import edu.heb.proyectofinal.database.Conexion;
import edu.heb.proyectofinal.model.Cliente;
import edu.heb.proyectofinal.model.Pais;
import edu.heb.proyectofinal.model.Peticion;
import edu.heb.proyectofinal.model.Tamanio_empresa;
import edu.heb.proyectofinal.model.Usuario;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerPeticion {

    Conexion conn = new Conexion();

    CallableStatement cs;
    
    PreparedStatement ps;
    
    ResultSet rs;

    ControllerCliente cc = new ControllerCliente();

    ControllerUsuario cu = new ControllerUsuario();

    String query;

    public boolean recibirPeticion(Peticion peticion) {

        Cliente aux = peticion.getCliente();
        Pais[] paises = aux.getPaises();
        boolean pais1 = false;
        boolean pais2 = false;
        boolean pais3 = false;
        boolean resultado;

        try {
            if (cc.buscarCliente(peticion.getCliente().getCorreo_electronico())) {
                query = "CALL registrarPeticion0(?, ?, ?)";

                conn.conectar();

                cs = conn.getConnection().prepareCall(query);

                cs.setString("var_correo", aux.getCorreo_electronico());
                cs.setString("var_descripcion", peticion.getDescripcion());

                cs.registerOutParameter("resultado", Types.BOOLEAN);

                cs.execute();

                resultado = cs.getBoolean("resultado");

                conn.desconectar();

                return resultado;

            } else {
                query = "CALL registrarPeticion0(?, ?, ?, ?, ?, ?"
                        + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?"
                        + "?, ?, ?)";

                conn.conectar();

                cs = conn.getConnection().prepareCall(query);
                
                for(int i = 0; i < paises.length; i++) {
                    if(paises[i].getIdPais() == 1) {
                        pais1 = true;
                    }
                    if(paises[i].getIdPais() == 2) {
                        pais2 = true;
                    }
                    if(paises[i].getIdPais() == 3) {
                        pais3 = true;
                    }
                }

//                if (aux.getPaises(). == 1) {
//                    pais1 = true;
//                }
//
//                if (aux.getPaises().length == 2) {
//                    pais2 = true;
//                }
//
//                if (aux.getPaises().length == 3) {
//                    pais3 = true;
//                }

                cs.setString("var_nombres", aux.getNombre());
                cs.setString("var_primer_apellido", aux.getPrimer_apellido());
                cs.setString("var_segundo_apellido", aux.getSegundo_apellido());
                cs.setString("var_ciudad", aux.getCiudad());
                cs.setString("var_colonia", aux.getColonia());
                cs.setString("var_cp", aux.getCp());
                cs.setInt("var_numero_exterior", aux.getNumero_exterior());
                cs.setInt("var_numero_interior", aux.getNumero_interior());
                cs.setString("var_telefono", aux.getTelefono());
                cs.setString("var_celular", aux.getCelular());
                cs.setString("var_correo", aux.getCorreo_electronico());
                cs.setString("var_tamanio_empresa", aux.getTamanio_empresa().getTamanio_empresa());
                cs.setString("var_horario_disponible ", aux.getHorario_disponible());
                cs.setString("var_nombre_empresa ", aux.getNombre_empresa());
                cs.setString("var_persona_fisica_moral", aux.getPersona_fisica_moral());
                cs.setString("var_descripcion", peticion.getDescripcion());
                cs.setBoolean("pais1", pais1);
                cs.setBoolean("pais2", pais2);
                cs.setBoolean("pais3", pais3);

                cs.registerOutParameter("resultado", Types.BOOLEAN);

                cs.execute();

                resultado = cs.getBoolean("resultado");
                conn.desconectar();
                return resultado;

            }
        } catch (Exception e) {
            System.out.println("Ocurrio una excepción al registrar una petición");
            e.printStackTrace();
            conn.desconectar();
        }

        return false;
    }

    public boolean aceptarPeticion(Peticion peticion, Usuario usuario) {
        try {
            query = "CALL aceptarPeticion (?, ?, ?)";

            conn.conectar();

            cs = conn.getConnection().prepareCall(query);

            cs.setString("var_idpeticion", peticion.getIdPeticion());
            cs.setString("var_idUsuario", usuario.getIdUsuario());

            cs.registerOutParameter("resultado", Types.BOOLEAN);

            cs.execute();

            boolean resultado = cs.getBoolean("resultado");
            conn.desconectar();
            return resultado;

        } catch (Exception e) {
            System.out.println("Ocurrio una excepción al aceptar una petición");
            e.printStackTrace();
            conn.desconectar();
        }
        return false;
    }

    public Queue consultarPeticiones() {
        
        Queue<Peticion> peticiones = new LinkedList<>();
        
        try {
            
            query = "SELECT * FROM v_peticiones WHERE pet.estatus = 1";
            
            conn.conectar();
            
            ps = conn.getConnection().prepareCall(query);
            
            rs = ps.executeQuery();
            
            Peticion pe_aux;
            Tamanio_empresa te_aux;
            
            while(rs.next()) {
                
                pe_aux = new Peticion();
                te_aux = new Tamanio_empresa();
                
                te_aux.setTamanio_empresa(rs.getString("tamanio_empresa"));
                
                pe_aux.setIdPeticion(rs.getString("idPeticion"));
                pe_aux.getCliente().setNombre(rs.getString("nombres"));
                pe_aux.getCliente().setPrimer_apellido(rs.getString("primer_apellido"));
                pe_aux.getCliente().setSegundo_apellido(rs.getString("segundo_apellido"));
                pe_aux.getCliente().setCiudad(rs.getString("ciudad"));
                pe_aux.getCliente().setColonia(rs.getString("colonia"));
                pe_aux.getCliente().setCp(rs.getString("cp"));
                pe_aux.getCliente().setNumero_exterior(rs.getInt("numero_exterior"));
                pe_aux.getCliente().setNumero_interior(rs.getInt("numero_interior"));
                pe_aux.getCliente().setTelefono(rs.getString("telefono"));
                pe_aux.getCliente().setCelular(rs.getString("celular"));
                pe_aux.getCliente().setCorreo_electronico(rs.getString("correo"));
                pe_aux.getCliente().setTamanio_empresa(te_aux);
                pe_aux.getCliente().setPersona_fisica_moral(rs.getString("persona_fisica_moral"));
                pe_aux.setFechaPeticion(rs.getDate("fecha_peticion"));
                pe_aux.setDescripcion(rs.getString("descripcion"));
                
                peticiones.add(pe_aux);
            }
            
            conn.desconectar();
            return peticiones;

        } catch (Exception e) {
            System.out.println("Ocurrio una excepción al consultar las peticiones");
            e.printStackTrace();
            conn.desconectar();
        }

        return null;
    }

}
