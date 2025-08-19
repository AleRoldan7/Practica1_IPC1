/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosEntidad;

/**
 *
 * @author alejandro
 */
public class EntidadAsistencia {
    
    private String idParticipante;
    private String codigoActividad;
    private String correoParticipante;

    public EntidadAsistencia(String correoParticipante, String codigoActividad) {
        this.correoParticipante = correoParticipante;
        this.codigoActividad = codigoActividad;
    }

    public String getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(String idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(String codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    public String getCorreoParticipante() {
        return correoParticipante;
    }

    public void setCorreoParticipante(String correoParticipante) {
        this.correoParticipante = correoParticipante;
    }
    
    
    
}
