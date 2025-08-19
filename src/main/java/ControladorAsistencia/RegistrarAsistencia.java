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

    public boolean registrarAsistencia(EntidadAsistencia entidadAsistencia) {
        
        int idParticipante = obtenerIdParticipante(entidadAsistencia.getIdParticipante());
        if (idParticipante == -1) {
            System.out.println("Participante no encontrado: " + entidadAsistencia.getIdParticipante());
            return false;
        }

        String queryInsert = "INSERT IGNORE INTO asistencia (idParticipante, idActividad) "
                + "VALUES (?, (SELECT idActividad FROM registrar_actividad WHERE codigoActividad = ?))";

        try (PreparedStatement ps = getConnect().prepareStatement(queryInsert)) {
            ps.setInt(1, idParticipante);
            ps.setString(2, entidadAsistencia.getCodigoActividad());
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Asistencia registrada correctamente.");
            } else {
                System.out.println("El participante ya tenía registrada la asistencia.");
            }
            return filas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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

    public boolean validarAsistencia(EntidadAsistencia entidadAsistencia) {
        int idParticipante = obtenerIdParticipante(entidadAsistencia.getIdParticipante());
        if (idParticipante == -1) {
            return false;
        }

        String query = "SELECT COUNT(*) FROM asistencia a "
                + "INNER JOIN registrar_actividad ra ON a.idActividad = ra.idActividad "
                + "WHERE a.idParticipante = ? AND ra.codigoActividad = ?";

        try (PreparedStatement ps = getConnect().prepareStatement(query)) {
            ps.setInt(1, idParticipante);
            ps.setString(2, entidadAsistencia.getCodigoActividad());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
