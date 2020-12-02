/**
 * Entidad Tamanio_empresa
 * Creado: 01/12/2020 por Victor Santillan
 * Empleada en "Cliente"
 */
package edu.heb.proyectofinal.model;

public class Tamanio_empresa {

    private int idTamanio_empresa;
    private String Tamanio_empresa;

    public Tamanio_empresa() {
    }

    public Tamanio_empresa(int idTamanio_empresa, String Tamanio_empresa) {
        this.idTamanio_empresa = idTamanio_empresa;
        this.Tamanio_empresa = Tamanio_empresa;
    }

    public int getIdTamanio_empresa() {
        return idTamanio_empresa;
    }

    public void setIdTamanio_empresa(int idTamanio_empresa) {
        this.idTamanio_empresa = idTamanio_empresa;
    }

    public String getTamanio_empresa() {
        return Tamanio_empresa;
    }

    public void setTamanio_empresa(String Tamanio_empresa) {
        this.Tamanio_empresa = Tamanio_empresa;
    }

}
