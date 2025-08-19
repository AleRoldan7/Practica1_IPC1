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

        String query = "INSERT INTO inscripcion (codigoEvento, idParticipante, tipoInscripcion) "
                + "VALUES (?, (SELECT idParticipante FROM registro_participante WHERE Correo = ?), ?)";

        try (PreparedStatement pstm = getConnect().prepareStatement(query)) {
            pstm.setString(1, entidadInscripcion.getCodigoEvento());
            pstm.setString(2, entidadInscripcion.getCorreoParticipante());
            pstm.setString(3, entidadInscripcion.getTipoInscripcion().name());

            int filas = pstm.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean validarInscripcion(EntidadInscripcion entidadInscripcion) {
        String queryValidar = "SELECT rp.idParticipante "
                + "FROM pago p "
                + "INNER JOIN registro_participante rp ON p.idParticipante = rp.idParticipante "
                + "WHERE rp.Correo = ? AND p.codigoEvento = ?";

        try (PreparedStatement pstm = getConnect().prepareStatement(queryValidar)) {
            pstm.setString(1, entidadInscripcion.getCorreoParticipante()); 
            pstm.setString(2, entidadInscripcion.getCodigoEvento());

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                int idParticipante = rs.getInt("idParticipante");

                String update = "UPDATE inscripcion SET inscripcionValida = 1 WHERE codigoEvento = ? AND idParticipante = ?";
                try (PreparedStatement psUpdate = getConnect().prepareStatement(update)) {
                    psUpdate.setString(1, entidadInscripcion.getCodigoEvento());
                    psUpdate.setInt(2, idParticipante);
                    psUpdate.executeUpdate();
                }

                return true; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; 
    }

}
