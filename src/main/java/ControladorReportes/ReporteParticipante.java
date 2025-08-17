/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorReportes;

/**
 *
 * @author alejandro
 */
public class ReporteParticipante {

    private String correo;
    private String tipo;
    private String nombreCompleto;
    private String institucion;
    private boolean validado;

    public ReporteParticipante(String correo, String tipo, String nombreCompleto, String institucion, boolean validado) {
        this.correo = correo;
        this.tipo = tipo;
        this.nombreCompleto = nombreCompleto;
        this.institucion = institucion;
        this.validado = validado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }

}
