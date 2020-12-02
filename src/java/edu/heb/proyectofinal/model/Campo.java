/**
 * Entidad Campo
 * Creado: 01/12/2020 por Victor Santillan
 * Empleada en "Seccion"
 */
package edu.heb.proyectofinal.model;

public class Campo {

    private int idCampo;
    private String nombre;
    private String contenido;
    private Tipo tipo;

    public Campo() {
    }

    public Campo(int idCampo, String nombre, String contenido, Tipo tipo) {
        this.idCampo = idCampo;
        this.nombre = nombre;
        this.contenido = contenido;
        this.tipo = tipo;
    }

    public int getIdCampo() {
        return idCampo;
    }

    public void setIdCampo(int idCampo) {
        this.idCampo = idCampo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

}
