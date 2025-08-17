/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorReportes;

/**
 *
 * @author alejandro
 */
public class ReporteActividad {

    private String codigoActividad;
    private String codigoEvento;
    private String titulo;
    private String encargado;
    private String horaInicio;
    private int cupoMaximo;
    private int cantidadParticipantes;

    public ReporteActividad(String codigoActividad, String codigoEvento, String titulo, String encargado,
            String horaInicio, int cupoMaximo, int cantidadParticipantes) {

        this.codigoActividad = codigoActividad;
        this.codigoEvento = codigoEvento;
        this.titulo = titulo;
        this.encargado = encargado;
        this.horaInicio = horaInicio;
        this.cupoMaximo = cupoMaximo;
        this.cantidadParticipantes = cantidadParticipantes;
    }

    public String getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(String codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    public String getCodigoEvento() {
        return codigoEvento;
    }

    public void setCodigoEvento(String codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public int getCantidadParticipantes() {
        return cantidadParticipantes;
    }

    public void setCantidadParticipantes(int cantidadParticipantes) {
        this.cantidadParticipantes = cantidadParticipantes;
    }

}
