/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorActividad;

import ConexionDBA.ConectarDBA;
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
    }

    public boolean agregarActividad(String codigoAct, String codigoEvento, String tipo, String titulo,
            String correoPersona, LocalTime inicio, LocalTime fin, int maxCupo) {

        int idParticipante = -1;
        String consultaParticipante = "SELECT p.idParticipante "
                + "FROM registro_participante p "
                + "INNER JOIN inscripcion i ON p.idParticipante = i.idParticipante "
                + "WHERE p.Correo = ? AND i.tipoInscripcion <> 'ASISTENTE' AND i.codigoEvento = ?";
        try (PreparedStatement ps = getConnect().prepareStatement(consultaParticipante)) {
            ps.setString(1, correoPersona);
            ps.setString(2, codigoEvento);
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                idParticipante = resultado.getInt("idParticipante");
            } else {
                System.out.println("Participante no válido o solo ASISTENTE: " + correoPersona);
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
            psInsert.setString(1, codigoAct);
            psInsert.setString(2, codigoEvento);
            psInsert.setString(3, tipo);
            psInsert.setString(4, titulo);
            psInsert.setInt(5, idParticipante);
            psInsert.setTime(6, Time.valueOf(inicio));
            psInsert.setTime(7, Time.valueOf(fin));
            psInsert.setInt(8, maxCupo);

            int filas = psInsert.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
