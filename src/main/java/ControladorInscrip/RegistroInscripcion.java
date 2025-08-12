/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorInscrip;

import ConexionDBA.ConectarDBA;
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

    /*
    public boolean validarInscripcion(String correoParticipante, String codigoEvento) {
        Connection conn = connection.getConnect();
        
        String query =  "UPDATE inscripcion i " +
                        "JOIN registro_participante p ON i.idParticipante = p.idParticipante " +
                        "JOIN pago pa ON pa.correo = p.Correo AND pa.codigoEvento = i.codigoEvento "  +
                        "SET i.inscripcionValida = TRUE " +
                        "WHERE p.Correo = ? AND i.codigoEvento = ?";
        
        try (PreparedStatement pstm = conn.prepareCall(query)){
            
            pstm.setString(1, correoParticipante);
            pstm.setString(2, codigoEvento);
            
            int filas = pstm.executeUpdate();
            return filas > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
     
    public boolean validarInscripcion(String correoParticipante, String codigoEvento) {
        Connection conn = connection.getConnect();

        // 1️⃣ Verificar que haya pago registrado
        String sqlVerificar
                = "SELECT COUNT(*) "
                + "FROM pago pa "
                + "JOIN registro_participante p ON pa.idParticipante = p.idParticipante "
                + "WHERE p.Correo = ? AND pa.codigoEvento = ?";

        try (PreparedStatement psVerificar = conn.prepareStatement(sqlVerificar)) {
            psVerificar.setString(1, correoParticipante);
            psVerificar.setString(2, codigoEvento);

            try (ResultSet rs = psVerificar.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {

                    // 2️⃣ Marcar inscripción como válida (1)
                    String sqlActualizar
                            = "UPDATE inscripcion i "
                            + "JOIN registro_participante p ON i.idParticipante = p.idParticipante "
                            + "SET i.inscripcionValida = 1 "
                            + "WHERE p.Correo = ? AND i.codigoEvento = ?";

                    try (PreparedStatement psActualizar = conn.prepareStatement(sqlActualizar)) {
                        psActualizar.setString(1, correoParticipante);
                        psActualizar.setString(2, codigoEvento);

                        int filas = psActualizar.executeUpdate();
                        if (filas > 0) {
                            System.out.println("✅ Inscripción validada correctamente");
                            return true;
                        } else {
                            System.out.println("⚠ La inscripción no existe para este participante y evento");
                            return false;
                        }
                    }
                } else {
                    System.out.println("❌ No existe pago registrado para este participante y evento");
                    return false;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    */

}
