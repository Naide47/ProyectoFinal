/**
 * Entidad Cliente
 * Creado: 01/12/2020 por Victor Santillan
 */
package edu.heb.proyectofinal.model;

public class Cliente extends Persona {

    private int idCliente;
    private String horario_disponible;
    private String nombre_empresa;
    private String persona_fisica_moral;
    private Tamanio_empresa tamanio_empresa;
    private Pais[] paises;

    public Cliente() {
    }

    public Cliente(int idCliente, String horario_disponible, String nombre_empresa, String persona_fisica_moral, Tamanio_empresa tamanio_empresa, Pais[] paises, int idPersona, String nombre, String primer_apellido, String segundo_apellido, String ciudad, String colonia, String cp, int numero_exterior, int numero_interior, String telefono, String celular, String correo_electronico) {
        super(idPersona, nombre, primer_apellido, segundo_apellido, ciudad, colonia, cp, numero_exterior, numero_interior, telefono, celular, correo_electronico);
        this.idCliente = idCliente;
        this.horario_disponible = horario_disponible;
        this.nombre_empresa = nombre_empresa;
        this.persona_fisica_moral = persona_fisica_moral;
        this.tamanio_empresa = tamanio_empresa;
        this.paises = paises;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getHorario_disponible() {
        return horario_disponible;
    }

    public void setHorario_disponible(String horario_disponible) {
        this.horario_disponible = horario_disponible;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getPersona_fisica_moral() {
        return persona_fisica_moral;
    }

    public void setPersona_fisica_moral(String persona_fisica_moral) {
        this.persona_fisica_moral = persona_fisica_moral;
    }

    public Tamanio_empresa getTamanio_empresa() {
        return tamanio_empresa;
    }

    public void setTamanio_empresa(Tamanio_empresa tamanio_empresa) {
        this.tamanio_empresa = tamanio_empresa;
    }

    public Pais[] getPaises() {
        return paises;
    }

    public void setPaises(Pais[] paises) {
        this.paises = paises;
    }

}
