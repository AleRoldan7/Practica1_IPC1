/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosEntidad;

import ControladorPago.TipoPago;

/**
 *
 * @author alejandro
 */
public class EntidadPago {
    
    private String codigoEvento;
    private String idParticipante;
    private TipoPago tipoPago;
    private double monto;

    public EntidadPago(String codigoEvento, String idParticipante, TipoPago tipoPago, double monto) {
        this.codigoEvento = codigoEvento;
        this.idParticipante = idParticipante;
        this.tipoPago = tipoPago;
        this.monto = monto;
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

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
}
