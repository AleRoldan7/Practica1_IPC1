/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorAsistencia;

import ConexionDBA.ConectarDBA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alejandro
 */
public class ValidarAsistencia extends ConectarDBA {

    public ValidarAsistencia() {
        super();
        connect();
    }

    public boolean registrarAsistencia(int idParticipante, int idActividad) {
        try (Connection conn = getConnect()) {

            // 1. Verificar que no sea el encargado de la actividad
            String encargadoQuery = "SELECT rp.Correo AS correoEncargado "
                    + "FROM registrar_actividad ra "
                    + "INNER JOIN registro_participante rp ON ra.idParticipante = rp.idParticipante "
                    + "WHERE ra.idActividad = ?";
            try (PreparedStatement ps = conn.prepareStatement(encargadoQuery)) {
                ps.setInt(1, idActividad);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String correoEncargado = rs.getString("correoEncargado");
                    String correoParticipante = getCorreoParticipante(idParticipante, conn);

                    if (correoEncargado.equalsIgnoreCase(correoParticipante)) {
                        System.out.println("El encargado no puede registrarse como asistente.");
                        return false;
                    }
                }
            }

            // 2. Verificar si ya está inscrito
            String existeQuery = "SELECT 1 FROM asistencia WHERE idParticipante = ? AND idActividad = ?";
            try (PreparedStatement ps = conn.prepareStatement(existeQuery)) {
                ps.setInt(1, idParticipante);
                ps.setInt(2, idActividad);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    System.out.println("El participante ya está registrado en esta actividad.");
                    return false;
                }
            }

            // 3. Verificar el cupo
            String cupoQuery = "SELECT cupoMaximo FROM registrar_actividad WHERE idActividad = ?";
            int cupoMaximo = 0;
            try (PreparedStatement ps = conn.prepareStatement(cupoQuery)) {
                ps.setInt(1, idActividad);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    cupoMaximo = rs.getInt("cupoMaximo");
                }
            }

            String countQuery = "SELECT COUNT(*) AS inscritos FROM asistencia WHERE idActividad = ?";
            int inscritos = 0;
            try (PreparedStatement ps = conn.prepareStatement(countQuery)) {
                ps.setInt(1, idActividad);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    inscritos = rs.getInt("inscritos");
                }
            }

            if (inscritos >= cupoMaximo) {
                System.out.println("La actividad ya alcanzó el cupo máximo.");
                return false;
            }

            // 4. Insertar en asistencia
            String insert = "INSERT INTO asistencia (idParticipante, idActividad) VALUES (?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(insert)) {
                ps.setInt(1, idParticipante);
                ps.setInt(2, idActividad);
                ps.executeUpdate();
            }

            System.out.println("Asistencia registrada correctamente.");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método auxiliar para obtener el correo del participante
    private String getCorreoParticipante(int idParticipante, Connection conn) throws SQLException {
        String correo = "";
        String query = "SELECT Correo FROM registro_participante WHERE idParticipante = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, idParticipante);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                correo = rs.getString("Correo");
            }
        }
        return correo;
    }

}
