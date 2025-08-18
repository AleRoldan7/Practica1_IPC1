/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorEvento;

import ConexionDBA.ConectarDBA;
import ModelosEntidad.EntidadEvento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author alejandro
 */
public class RegistrarEvento extends ConectarDBA {

    private DateTimeFormatter formatoFecha;
    
    public RegistrarEvento() {
        super();
        connect();
        this.formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public boolean agregarEvento(EntidadEvento entidadEvento) {

        String queryEvento = "INSERT INTO registro_evento (Codigo, Fecha_Evento, Tipo_Evento, Titulo, Ubicacion, Cupo_Maximo, Pago_Evento)"
                + "VALUES (?,?,?,?,?,?,?)";

        try (PreparedStatement pstm = getConnect().prepareStatement(queryEvento)) {

            pstm.setString(1, entidadEvento.getCodigo());
            pstm.setString(2, entidadEvento.getFechaEvento().toString());
            pstm.setString(3, entidadEvento.getTipoEvento().name());
            pstm.setString(4, entidadEvento.getTitulo());
            pstm.setString(5, entidadEvento.getUbicacion());
            pstm.setInt(6, entidadEvento.getCupoMaximo());
            pstm.setDouble(7, entidadEvento.getPagoEVento());

            int filas = pstm.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public LocalDate fechaValida(String fecha){
        try {
            return LocalDate.parse(fecha, formatoFecha);
        } catch (DateTimeException e) {
            return null;
        }
    }

}
