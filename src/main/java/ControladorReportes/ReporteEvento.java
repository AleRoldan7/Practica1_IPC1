/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorReportes;

/**
 *
 * @author alejandro
 */
public class ReporteEvento {

    private String codigoEvento;
    private String fechaEvento;
    private String titulo;
    private String tipoEvento;
    private String ubicacion;
    private int cupoMaximo;
    private String correoParticipante;
    private String nombreParticipante;
    private String tipoParticipante;
    private String metodoPago;
    private double montoPagado;

    public ReporteEvento(String codigoEvento, String fechaEvento, String titulo, String tipoEvento,
            String ubicacion, int cupoMaximo, String correoParticipante,
            String nombreParticipante, String tipoParticipante,
            String metodoPago, double montoPagado) {
        
        this.codigoEvento = codigoEvento;
        this.fechaEvento = fechaEvento;
        this.titulo = titulo;
        this.tipoEvento = tipoEvento;
        this.ubicacion = ubicacion;
        this.cupoMaximo = cupoMaximo;
        this.correoParticipante = correoParticipante;
        this.nombreParticipante = nombreParticipante;
        this.tipoParticipante = tipoParticipante;
        this.metodoPago = metodoPago;
        this.montoPagado = montoPagado;
    }

    public String getCodigoEvento() {
        return codigoEvento;
    }

    public void setCodigoEvento(String codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public String getCorreoParticipante() {
        return correoParticipante;
    }

    public void setCorreoParticipante(String correoParticipante) {
        this.correoParticipante = correoParticipante;
    }

    public String getNombreParticipante() {
        return nombreParticipante;
    }

    public void setNombreParticipante(String nombreParticipante) {
        this.nombreParticipante = nombreParticipante;
    }

    public String getTipoParticipante() {
        return tipoParticipante;
    }

    public void setTipoParticipante(String tipoParticipante) {
        this.tipoParticipante = tipoParticipante;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(double montoPagado) {
        this.montoPagado = montoPagado;
    }
    
    
}
