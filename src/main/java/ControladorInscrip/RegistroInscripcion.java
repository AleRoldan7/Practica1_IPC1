/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorInscrip;

import ConexionDBA.ConectarDBA;
import ModelosEntidad.EntidadInscripcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

/**
 *
 * @author alejandro
 */
public class RegistroInscripcion extends ConectarDBA {

    public RegistroInscripcion() {
        super();
        connect();
    }

    public boolean agregarInscripcion(EntidadInscripcion entidadInscripcion) {

        int idParticipante = obtenerIdParticipante(entidadInscripcion.getCorreoParticipante());
        if (idParticipante == -1) {
            System.out.println("❌ Participante no encontrado: " + entidadInscripcion.getCorreoParticipante());
            return false;
        }

        String query = "INSERT INTO inscripcion (codigoEvento, idParticipante, tipoInscripcion, inscripcionValida) "
                + "VALUES (?, ?, ?, 0)"; 

        try (PreparedStatement pstm = getConnect().prepareStatement(query)) {
            pstm.setString(1, entidadInscripcion.getCodigoEvento());
            pstm.setInt(2, idParticipante);
            pstm.setString(3, entidadInscripcion.getTipoInscripcion().name());

            int filas = pstm.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean validarInscripcion(EntidadInscripcion entidadInscripcion) {
        int idParticipante = obtenerIdParticipante(entidadInscripcion.getCorreoParticipante());
        if (idParticipante == -1) {
            return false;
        }

        String queryValidar = "SELECT 1 FROM pago WHERE idParticipante = ? AND codigoEvento = ?";

        try (PreparedStatement pstm = getConnect().prepareStatement(queryValidar)) {
            pstm.setInt(1, idParticipante);
            pstm.setString(2, entidadInscripcion.getCodigoEvento());

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                String update = "UPDATE inscripcion SET inscripcionValida = 1 "
                        + "WHERE idParticipante = ? AND codigoEvento = ?";
                try (PreparedStatement psUpdate = getConnect().prepareStatement(update)) {
                    psUpdate.setInt(1, idParticipante);
                    psUpdate.setString(2, entidadInscripcion.getCodigoEvento());
                    psUpdate.executeUpdate();
                }
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private int obtenerIdParticipante(String correo) {
        String query = "SELECT idParticipante FROM registro_participante WHERE Correo = ?";
        try (PreparedStatement ps = getConnect().prepareStatement(query)) {
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("idParticipante");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; 
    }

}
