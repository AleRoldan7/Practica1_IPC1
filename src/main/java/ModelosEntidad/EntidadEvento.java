/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosEntidad;

import ControladorEvento.TipoEvento;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author alejandro
 */
public class EntidadEvento {
    
    private String codigo;
    private LocalDate fechaEvento;
    private TipoEvento tipoEvento;
    private String titulo;
    private String ubicacion;
    private int cupoMaximo;
    private double pagoEVento;

    public EntidadEvento(String codigo, LocalDate fechaEvento, TipoEvento tipoEvento, String titulo, String ubicacion, int cupoMaximo, double pagoEVento) {
        this.codigo = codigo;
        this.fechaEvento = fechaEvento;
        this.tipoEvento = tipoEvento;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.cupoMaximo = cupoMaximo;
        this.pagoEVento = pagoEVento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(LocalDate fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public double getPagoEVento() {
        return pagoEVento;
    }

    public void setPagoEVento(double pagoEVento) {
        this.pagoEVento = pagoEVento;
    }
    
    
}
