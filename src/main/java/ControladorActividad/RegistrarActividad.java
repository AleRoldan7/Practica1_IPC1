/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorActividad;

import ConexionDBA.ConectarDBA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JComboBox;

/**
 *
 * @author alejandro
 */
public class RegistrarActividad extends ConectarDBA {

    public RegistrarActividad() {
        super();
    }

    public boolean registrarActividad(String codigoActividad, String codigoEvento, String tipoActividad,
            String titulo, String correo, LocalTime horaInicio, LocalTime horaFin, String cupoMaximo) {

        Connection conn = getConnect();

        String queryActividad = "INSERT INTO registrar_actividad (codigoEvento, tipoActividad, tituloActividad, correoPersona, "
                + "horaInicio, horaFin, cupoMaximo) VALUES (?, ?, ?, (SELECT idParticipante FROM registro_participante WHERE Correo = ?), "
                + "?, ?, ?, ?)";

        try (PreparedStatement pstm = conn.prepareCall(queryActividad)) {

            pstm.setString(1, codigoActividad);
            pstm.setString(2, codigoEvento);
            pstm.setString(3, tipoActividad);
            pstm.setString(4, titulo);
            pstm.setString(5, correo);
            pstm.setString(6, horaInicio.format(DateTimeFormatter.ofPattern("hh:mm")));
            pstm.setString(7, horaFin.format(DateTimeFormatter.ofPattern("hh:mm")));
            pstm.setString(8, cupoMaximo);

            int fila = pstm.executeUpdate();
            return fila > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void mostrarParticipantes(JComboBox<String> correo) {

        Connection conn = getConnect();

        correo.removeAllItems();
        correo.addItem("Seleccionar Correo");

        String query = "SELECT Correo FROM registro_participante";
        System.out.println(query);
        try (PreparedStatement pstm = conn.prepareStatement(query); ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {

                correo.addItem(rs.getString("Correo"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void mostrarEventos(JComboBox<String> evento) {
        Connection conn = getConnect();

        evento.removeAllItems();
        evento.addItem("Seleccionar Evento");

        String query = "SELECT Codigo FROM registro_evento";

        try (PreparedStatement pstm = conn.prepareStatement(query); ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {

                evento.addItem(rs.getString("Codigo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
