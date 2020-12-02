/**
 * Entidad Persona
 * Creado: 01/12/2020 por Victor Santillan
 * Empleada en "Cliente"
 */
package edu.heb.proyectofinal.model;

public class Cuestionario {

    private int idCuestionario;
    private String nombre;
    private int estatus;
    private Peticion peticion;
    private Usuario[] usuarios;
    private Seccion[] secciones;

    public Cuestionario() {
    }

    public Cuestionario(int idCuestionario, String nombre, int estatus, Peticion peticion, Usuario[] usuarios, Seccion[] secciones) {
        this.idCuestionario = idCuestionario;
        this.nombre = nombre;
        this.estatus = estatus;
        this.peticion = peticion;
        this.usuarios = usuarios;
        this.secciones = secciones;
    }

    public int getIdCuestionario() {
        return idCuestionario;
    }

    public void setIdCuestionario(int idCuestionario) {
        this.idCuestionario = idCuestionario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public Peticion getPeticion() {
        return peticion;
    }

    public void setPeticion(Peticion peticion) {
        this.peticion = peticion;
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

    public Seccion[] getSecciones() {
        return secciones;
    }

    public void setSecciones(Seccion[] secciones) {
        this.secciones = secciones;
    }

}
