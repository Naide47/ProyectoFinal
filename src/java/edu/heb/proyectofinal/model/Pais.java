/**
 * Entidad Pais
 * Creado: 01/12/2020 por Victor Santillan
 * Empleada en "Cliente"
 */
package edu.heb.proyectofinal.model;

public class Pais {

    private int idPais;
    private String pais;

    public Pais() {
    }

    public Pais(int idPais, String pais) {
        this.idPais = idPais;
        this.pais = pais;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
