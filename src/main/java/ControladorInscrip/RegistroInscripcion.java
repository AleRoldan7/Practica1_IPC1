/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorInscrip;

import ConexionDBA.ConectarDBA;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author alejandro
 */
public class RegistroInscripcion {

    private ConectarDBA connection;

    public RegistroInscripcion() {
        connection = new ConectarDBA();
        connection.connect();
    }

    public boolean agregarInscripcion(String codigoEvento, String correoParticipante, String tipoInscripcion) {
        Connection conn = connection.getConnect();

        String query = "INSERT INTO inscripcion (codigoEvento, idParticipante, tipoInscripcion) "
                + "VALUES (?, (SELECT idParticipante FROM registro_participante WHERE Correo = ?), ?)";

        try (PreparedStatement pstm = conn.prepareStatement(query)) {
            pstm.setString(1, codigoEvento);
            pstm.setString(2, correoParticipante);
            pstm.setString(3, tipoInscripcion);

            int filas = pstm.executeUpdate();
            return filas > 0; 

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void mostrarParticipantes(JComboBox<String> correo) {

        Connection conn = connection.getConnect();

        correo.removeAllItems();
        correo.addItem("Seleccionar Correo");
        List<String> correParticipante = new ArrayList<>();

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
        Connection conn = connection.getConnect();

        evento.removeAllItems();
        evento.addItem("Seleccionar Evento");
        List<String> eventoExitente = new ArrayList<>();

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
