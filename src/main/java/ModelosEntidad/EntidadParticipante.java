/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosEntidad;

import ControladorParticipante.TipoParticipante;

/**
 *
 * @author alejandro
 */
public class EntidadParticipante {
    
    private String nombreParticipante;
    private TipoParticipante tipoParticipante;
    private String institucion;
    private String correoParticipante;

    public EntidadParticipante(String nombreParticipante, TipoParticipante tipoParticipante, String institucion, String correoParticipante) {
        this.nombreParticipante = nombreParticipante;
        this.tipoParticipante = tipoParticipante;
        this.institucion = institucion;
        this.correoParticipante = correoParticipante;
    }

    public String getNombreParticipante() {
        return nombreParticipante;
    }

    public void setNombreParticipante(String nombreParticipante) {
        this.nombreParticipante = nombreParticipante;
    }

    public TipoParticipante getTipoParticipante() {
        return tipoParticipante;
    }

    public void setTipoParticipante(TipoParticipante tipoParticipante) {
        this.tipoParticipante = tipoParticipante;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getCorreoParticipante() {
        return correoParticipante;
    }

    public void setCorreoParticipante(String correoParticipante) {
        this.correoParticipante = correoParticipante;
    }

    
    
    
}
