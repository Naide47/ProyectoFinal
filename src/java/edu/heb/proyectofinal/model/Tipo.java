/**
 * Entidad Tipo
 * Creado: 01/12/2020 por Victor Santillan
 * Empleada en "Campo"
 */
package edu.heb.proyectofinal.model;

public class Tipo {
    
    private int idTipo;
    private String tipo;

    public Tipo() {
    }

    public Tipo(int idTipo, String tipo) {
        this.idTipo = idTipo;
        this.tipo = tipo;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
