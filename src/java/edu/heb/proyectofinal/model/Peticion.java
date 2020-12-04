/**
 * Entidad Peticion
 * Creado: 01/12/2020 por Victor Santillan
 * Empleada en "Cliente"
 */
package edu.heb.proyectofinal.model;

import java.sql.Date;

public class Peticion {

    private String idPeticion;
    private Date fechaPeticion;
    private String descripcion;
    private int estatus;
    private Cliente cliente;
    private Usuario[] usuarios;

    public Peticion() {
    }

    public Peticion(String idPeticion, Date fechaPeticion, String descripcion, int estatus, Cliente cliente, Usuario[] usuarios) {
        this.idPeticion = idPeticion;
        this.fechaPeticion = fechaPeticion;
        this.descripcion = descripcion;
        this.estatus = estatus;
        this.cliente = cliente;
        this.usuarios = usuarios;
    }

    public String getIdPeticion() {
        return idPeticion;
    }

    public void setIdPeticion(String idPeticion) {
        this.idPeticion = idPeticion;
    }

    public Date getFechaPeticion() {
        return fechaPeticion;
    }

    public void setFechaPeticion(Date fechaPeticion) {
        this.fechaPeticion = fechaPeticion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

}
