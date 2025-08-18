/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorAsistencia;

import ConexionDBA.ConectarDBA;
import DatosParticipanteEventos.ControladorGeneral;
import ModelosEntidad.EntidadAsistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alejandro
 */
public class RegistrarAsistencia extends ConectarDBA {

    public RegistrarAsistencia() {
        super();
        connect();
    }

    public boolean agregarAsistencia(EntidadAsistencia entidadAsistencia) {

        int idParticipante = -1;
        String queryParticipante = "SELECT idParticipante FROM registro_participante WHERE Correo = ?";

        try (PreparedStatement ps = getConnect().prepareStatement(queryParticipante)) {
            ps.setString(1, entidadAsistencia.getIdParticipante());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idParticipante = rs.getInt("idParticipante");
            } else {
                System.out.println("Participante no encontrado: " + entidadAsistencia.getIdParticipante());
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        String queryInsert = "INSERT IGNORE INTO asistencia (idParticipante, idActividad) VALUES (?, ?)";

        try (PreparedStatement psInsert = getConnect().prepareStatement(queryInsert)) {
            psInsert.setInt(1, idParticipante);
            psInsert.setString(2, entidadAsistencia.getCodigoActividad());
            int filas = psInsert.executeUpdate();
            return filas > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}


