/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorActividad;

import ConexionDBA.ConectarDBA;
import ModelosEntidad.EntidadActividad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;


/**
 *
 * @author alejandro
 */
public class RegistrarActividad extends ConectarDBA {

    public RegistrarActividad() {
        super();
        connect();
    }

    public boolean agregarActividad(EntidadActividad entidadActividad) {

        int idParticipante = -1;
        String consultaParticipante = "SELECT p.idParticipante "
                + "FROM registro_participante p "
                + "INNER JOIN inscripcion i ON p.idParticipante = i.idParticipante "
                + "WHERE p.Correo = ? AND i.tipoInscripcion <> 'ASISTENTE' AND i.codigoEvento = ?";
        
        try (PreparedStatement ps = getConnect().prepareStatement(consultaParticipante)) {
            ps.setString(1, entidadActividad.getIdParticipante());
            ps.setString(2, entidadActividad.getCodigoEvento());
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                idParticipante = resultado.getInt("idParticipante");
            } else {
                System.out.println("Participante no válido o solo ASISTENTE: " + entidadActividad.getIdParticipante());
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        String insertarActividad = "INSERT INTO registrar_actividad "
                + "(codigoActividad, codigoEvento, tipoActividad, tituloActividad, idParticipante, horaInicio, horaFin, cupoMaximo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement psInsert = getConnect().prepareStatement(insertarActividad)) {
            psInsert.setString(1, entidadActividad.getCodigoActividad());
            psInsert.setString(2, entidadActividad.getCodigoEvento());
            psInsert.setString(3, entidadActividad.getTipoCharla().name());
            psInsert.setString(4, entidadActividad.getTitulo());
            psInsert.setInt(5, idParticipante);
            psInsert.setTime(6, Time.valueOf(entidadActividad.getHoraInicio()));
            psInsert.setTime(7, Time.valueOf(entidadActividad.getHoraFin()));
            psInsert.setInt(8, entidadActividad.getCupoMaximo());

            int filas = psInsert.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
