/**
 * Entidad Persona
 * Creado: 01/12/2020 por Victor Santillan
 */
package edu.heb.proyectofinal.model;

public class Persona {

    private int idPersona;
    private String nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String ciudad;
    private String colonia;
    private String cp;
    private int numero_exterior;
    private int numero_interior;
    private String telefono;
    private String celular;
    private String correo_electronico;

    public Persona() {
    }

    public Persona(int idPersona, String nombre, String primer_apellido, String segundo_apellido, String ciudad, String colonia, String cp, int numero_exterior, int numero_interior, String telefono, String celular, String correo_electronico) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.ciudad = ciudad;
        this.colonia = colonia;
        this.cp = cp;
        this.numero_exterior = numero_exterior;
        this.numero_interior = numero_interior;
        this.telefono = telefono;
        this.celular = celular;
        this.correo_electronico = correo_electronico;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public int getNumero_exterior() {
        return numero_exterior;
    }

    public void setNumero_exterior(int numero_exterior) {
        this.numero_exterior = numero_exterior;
    }

    public int getNumero_interior() {
        return numero_interior;
    }

    public void setNumero_interior(int numero_interior) {
        this.numero_interior = numero_interior;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }
    
    

}
