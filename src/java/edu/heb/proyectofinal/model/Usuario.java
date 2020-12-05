/**
 * Entidad Usuario
 * Creado: 01/12/2020 por Victor Santillan
 */
package edu.heb.proyectofinal.model;

import java.sql.Date;

public class Usuario extends Persona{
    
    private String idUsuario;
    private String nombre_usuario;
    private String contrasenia;
    private Date fecha_alta;
    private Date fecha_baja;
    private int rol;
    private boolean estatus;

    public Usuario() {
    }

    public Usuario(String idUsuario, String nombre_usuario, String contrasenia, Date fecha_alta, Date fecha_baja, int rol, boolean estatus, String idPersona, String nombre, String primer_apellido, String segundo_apellido, String ciudad, String colonia, String cp, int numero_exterior, int numero_interior, String telefono, String celular, String correo_electronico) {
        super(idPersona, nombre, primer_apellido, segundo_apellido, ciudad, colonia, cp, numero_exterior, numero_interior, telefono, celular, correo_electronico);
        this.idUsuario = idUsuario;
        this.nombre_usuario = nombre_usuario;
        this.contrasenia = contrasenia;
        this.fecha_alta = fecha_alta;
        this.fecha_baja = fecha_baja;
        this.rol = rol;
        this.estatus = estatus;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public Date getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(Date fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
    
    
    
    
}
