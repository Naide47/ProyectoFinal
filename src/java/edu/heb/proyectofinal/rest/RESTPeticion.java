/**
 * Servicio REST para peticiones
 * Creado: 01/12/2020 por Victor Santillan
 * Recibe las peticiones consumiendo un servicio REST
 */
package edu.heb.proyectofinal.rest;

import com.google.gson.Gson;
import edu.heb.proyectofinal.control.ControllerPeticion;
import edu.heb.proyectofinal.database.Conexion;
import edu.heb.proyectofinal.model.Cliente;
import edu.heb.proyectofinal.model.Pais;
import edu.heb.proyectofinal.model.Peticion;
import edu.heb.proyectofinal.model.Tamanio_empresa;
import edu.heb.proyectofinal.model.Usuario;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("Peticion")
public class RESTPeticion extends Application {

    ControllerPeticion controllerPeticion = new ControllerPeticion();

    Peticion peticion;

    String respuesta; 

    @POST
    @Path("enviarPeticion")
    @Produces(MediaType.APPLICATION_JSON)
    public Response recibirPeticion(@FormParam("nombres") String nombres,
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
            @FormParam("tamanio_empresa") String tamanio_empresa,
            @FormParam("horario_disponible") String horario_disponible,
            @FormParam("nombre_empresa") String nombre_empresa,
            @FormParam("persona_fisica_moral") String perpersona_fisica_moral,
            @FormParam("descripcion") String descripcion,
            @FormParam("paises") String paises) {
        try {

            peticion = new Peticion();
            Cliente cliente = new Cliente();
            Pais[] ps = new Pais[3];
            Pais pais1 = new Pais(1, "Mexico");
            Pais pais2 = new Pais(2, "Estados Unidos");
            Pais pais3 = new Pais(3, "Canada");

            cliente.setNombre(nombres);
            cliente.setPrimer_apellido(primer_apellido);
            if (!segundo_apellido.equals("")) {
                cliente.setSegundo_apellido(segundo_apellido);
            } else {
                cliente.setSegundo_apellido("");
            }
            cliente.setCiudad(ciudad);
            cliente.setColonia(colonia);
            cliente.setCp(cp);
            cliente.setNumero_exterior(Integer.parseInt(numero_exterior));
            if (!numero_exterior.equals("") && numero_exterior != null) {
                cliente.setNumero_interior(Integer.parseInt(numero_interior));
            } else {
                cliente.setNumero_interior(0);
            }
            cliente.setTelefono(telefono);
            cliente.setCelular(celular);
            cliente.setCorreo_electronico(correo_electronico);
            Tamanio_empresa aux = new Tamanio_empresa();
            switch (tamanio_empresa) {
                case "Chica":
                    aux.setIdTamanio_empresa(1);
                    break;
                case "Mediana":
                    aux.setIdTamanio_empresa(2);
                    break;
                case "Grande":
                    aux.setIdTamanio_empresa(3);
                    break;
            }
            cliente.setTamanio_empresa(aux);
            cliente.setHorario_disponible(horario_disponible);
            cliente.setNombre_empresa(nombre_empresa);
            cliente.setPersona_fisica_moral(perpersona_fisica_moral);

            peticion.setDescripcion(descripcion);

            switch (paises) {
                case "1":
                    ps[1] = pais1;
                    break;
                case "10":
                    ps[1] = pais2;
                    break;
                case "100":
                    ps[1] = pais3;
                    break;
                case "11":
                    ps[1] = pais1;
                    ps[2] = pais2;
                    break;
                case "101":
                    ps[1] = pais1;
                    ps[2] = pais3;
                    break;
                case "111":
                    ps[1] = pais1;
                    ps[2] = pais2;
                    ps[3] = pais3;
                    break;
            }

            cliente.setPaises(ps);
            peticion.setCliente(cliente);
            respuesta = new Gson().toJson(controllerPeticion.recibirPeticion(peticion));
        } catch (Exception e) {
            System.out.println("Error al registrar a una peticion (REST)");
            respuesta = null;
            e.printStackTrace();

        }

        return Response.status(Response.Status.OK).entity(respuesta).build();
    }

    @POST
    @Path("aceptarPeticion")
    @Produces(MediaType.APPLICATION_JSON)
    public Response aceptarPeticion(@FormParam("idPeticion") String idPeticion,
            @FormParam("idUsuario") String idUsuario) {
        try {
            System.out.println("idUsuario: " + idUsuario);
            System.out.println("idPeticion: " + idPeticion);
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(idUsuario);
            peticion = new Peticion();
            peticion.setIdPeticion(idPeticion);

            respuesta = new Gson().toJson(controllerPeticion.aceptarPeticion(peticion, usuario));
        } catch (Exception e) {
            System.out.println("Error al aceptar una peticion (REST)");
            respuesta = null;
            e.printStackTrace();
        }
        return Response.status(Response.Status.OK).entity(respuesta).build();
    }

    @GET
    @Path("consultarPeticiones")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarPeticiones() {
        try {

            respuesta = new Gson().toJson(controllerPeticion.consultarPeticiones());

        } catch (Exception e) {
            System.out.println("Error al aceptar una peticion (REST)");
            respuesta = null;
            e.printStackTrace();
        }
        return Response.status(Response.Status.OK).entity(respuesta).build();
    }
}
