/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosEntidad;

import ControladorActividad.TipoCharla;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author alejandro
 */
public class EntidadActividad {
    
    private String codigoActividad;
    private String codigoEvento;
    private TipoCharla tipoCharla;
    private String titulo;
    private String idParticipante;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private int cupoMaximo;

    public EntidadActividad(String codigoActividad, String codigoEvento, TipoCharla tipoCharla, String titulo, String idParticipante, LocalTime horaInicio, LocalTime horaFin, int cupoMaximo) {
        this.codigoActividad = codigoActividad;
        this.codigoEvento = codigoEvento;
        this.tipoCharla = tipoCharla;
        this.titulo = titulo;
        this.idParticipante = idParticipante;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.cupoMaximo = cupoMaximo;
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

    public TipoCharla getTipoCharla() {
        return tipoCharla;
    }

    public void setTipoCharla(TipoCharla tipoCharla) {
        this.tipoCharla = tipoCharla;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(String idParticipante) {
        this.idParticipante = idParticipante;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }
    
    
}
