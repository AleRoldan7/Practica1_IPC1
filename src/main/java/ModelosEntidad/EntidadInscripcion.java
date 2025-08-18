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
    private String idParticipante;
    private TipoInscripcion tipoInscripcion;

    public EntidadInscripcion(String codigoEvento, String idParticipante, TipoInscripcion tipoInscripcion) {
        this.codigoEvento = codigoEvento;
        this.idParticipante = idParticipante;
        this.tipoInscripcion = tipoInscripcion;
    }

    public String getCodigoEvento() {
        return codigoEvento;
    }

    public void setCodigoEvento(String codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    public String getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(String idParticipante) {
        this.idParticipante = idParticipante;
    }

    public TipoInscripcion getTipoInscripcion() {
        return tipoInscripcion;
    }

    public void setTipoInscripcion(TipoInscripcion tipoInscripcion) {
        this.tipoInscripcion = tipoInscripcion;
    }
    
    
}
