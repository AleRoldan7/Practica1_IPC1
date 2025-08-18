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

    public EntidadAsistencia(String idParticipante, String codigoActividad) {
        this.idParticipante = idParticipante;
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
    
    
}
