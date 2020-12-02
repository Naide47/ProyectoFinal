/**
 * Entidad Persona
 * Creado: 01/12/2020 por Victor Santillan
 * Empleada en "Cliente"
 */
package edu.heb.proyectofinal.model;

public class Seccion {

    private int idSeccion;
    private String nombre;
    private Campo[] campos;

    public Seccion() {
    }

    public Seccion(int idSeccion, String nombre, Campo[] campos) {
        this.idSeccion = idSeccion;
        this.nombre = nombre;
        this.campos = campos;
    }

    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Campo[] getCampos() {
        return campos;
    }

    public void setCampos(Campo[] campos) {
        this.campos = campos;
    }

}
