/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosEntidad;

import ControladorInscrip.TipoInscripcion;

/**
 *
 * @author alejandro
 */
public class EntidadInscripcion {
    
    private String codigoEvento;
    private String correoParticipante;
    private TipoInscripcion tipoInscripcion;

    public EntidadInscripcion(String codigoEvento, String correoParticipante, TipoInscripcion tipoInscripcion) {
        this.codigoEvento = codigoEvento;
        this.correoParticipante = correoParticipante;
        this.tipoInscripcion = tipoInscripcion;
    }

    public String getCodigoEvento() {
        return codigoEvento;
    }

    public void setCodigoEvento(String codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    public String getCorreoParticipante() {
        return correoParticipante;
    }

    public void setCorreoParticipante(String correoParticipante) {
        this.correoParticipante = correoParticipante;
    }

  

    public TipoInscripcion getTipoInscripcion() {
        return tipoInscripcion;
    }

    public void setTipoInscripcion(TipoInscripcion tipoInscripcion) {
        this.tipoInscripcion = tipoInscripcion;
    }
    
    
}
