/**
 * Servicio REST para peticiones
 * Creado: 01/12/2020 por Victor Santillan
 * Recibe las peticiones desde un servicio REST
 */
package edu.heb.proyectofinal.rest;

import edu.heb.proyectofinal.database.Conexion;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

@Path("Peticion")
public class RESTPeticion extends Application {

    @GET
    @Path("HelloWorld")
    public String helloWorld() {
        System.out.println("Hello world!");
        return null;
    }

    @GET
    @Path("Conn")
    public String probarConexion() {
        Conexion conexion = new Conexion();
        conexion.conectar();
        System.out.println("La conexion fue exitosa");
        return null;
    }

}
