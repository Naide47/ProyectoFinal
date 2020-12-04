/**
 * Servicio REST para usuarios
 * Creado: 01/12/2020 por Victor Santillan
 * Recibe las peticiones consumiendo un servicio REST
 */
package edu.heb.proyectofinal.rest;

import com.google.gson.Gson;
import edu.heb.proyectofinal.control.ControllerUsuario;
import edu.heb.proyectofinal.model.Usuario;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("Usuario")
public class RESTUsuario extends Application {

    ControllerUsuario cu = new ControllerUsuario();

    Usuario usuario;

    String respuesta;

    @GET
    @Path("registrar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarUsuario(@FormParam("nombres") String nombres,
            @FormParam("primer_apellido") String primer_apellido,
            @FormParam("segundo_apellido") String segundo_apellido,
            @FormParam("ciudad") String ciudad,
            @FormParam("colonia") String colonia,
            @FormParam("cp") String cp,
            @FormParam("numero_exterior") String numero_exterior,
            @FormParam("numero_interior") String numero_interior,
            @FormParam("telefono") String telefono,
            @FormParam("celular") String celular,
            @FormParam("correo") String correo_electronico,
            @FormParam("rol") String rol) {
        try {
            usuario = new Usuario();

            usuario.setNombre(nombres);
            usuario.setPrimer_apellido(primer_apellido);
            if (!segundo_apellido.equals("")) {
                usuario.setSegundo_apellido(segundo_apellido);
            } else {
                usuario.setSegundo_apellido("");
            }
            usuario.setCiudad(ciudad);
            usuario.setColonia(colonia);
            usuario.setCp(cp);
            usuario.setNumero_exterior(Integer.parseInt(numero_exterior));
            if (!numero_interior.equals("")) {
                usuario.setNumero_interior(Integer.parseInt(numero_interior));
            } else {
                usuario.setNumero_interior(0);
            }
            usuario.setTelefono(telefono);
            usuario.setCelular(celular);
            usuario.setCorreo_electronico(correo_electronico);

            respuesta = new Gson().toJson(cu.registrarUsuario(usuario));

        } catch (Exception e) {
            System.out.println("Error al registrar a un usuario (REST)");
            respuesta = null;
            e.printStackTrace();
        }
        return Response.status(Response.Status.OK).entity(respuesta).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response iniciarSesion(@FormParam("nombre_usuario") String nombre_usuario,
            @FormParam("contrasenia") String contrasenia) {

        try {
            usuario = new Usuario();
            usuario.setNombre_usuario(nombre_usuario);
            usuario.setContrasenia(contrasenia);
            
            usuario = cu.iniciarSesion(usuario);
        } catch (Exception e) {
            System.out.println("Error al iniciar sesión (REST)");
            respuesta = null;
            e.printStackTrace();
        }

        return Response.status(Response.Status.OK).entity(respuesta).build();
    }

}
