/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorPago;

import ConexionDBA.ConectarDBA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

/**
 *
 * @author alejandro
 */
public class RegistroPago {

    private ConectarDBA connection;

    public RegistroPago() {
        connection = new ConectarDBA();
        connection.connect();
    }
    
     /*
    public void pagoRegistrado(String codigoEvento, String correoParticipante, String tipoPago, String monto) {
        Connection conn = connection.getConnect();

        try {
            
            String sqlIdParticipante = "SELECT idParticipante FROM registro_participante";
            
           
            String sqlId = "SELECT idParticipante FROM registro_participante WHERE Correo = ?";
            int idParticipante = -1;
            try (PreparedStatement psId = conn.prepareStatement(sqlId)) {
                psId.setString(1, correoParticipante);
                try (ResultSet rs = psId.executeQuery()) {
                    if (rs.next()) {
                        idParticipante = rs.getInt("idParticipante");
                    }
                }
            }

            if (idParticipante == -1) {
                System.out.println("No se encontró el participante con ese correo");
                return;
            }

            */
            
            /*
            String sqlPago = "INSERT INTO pago (codigoEvento, idParticipante, tipoPago, monto) VALUES (?, ?, ?, ?)";
            try (PreparedStatement psPago = conn.prepareStatement(sqlPago)) {
                psPago.setString(1, codigoEvento);
                psPago.setInt(2, idParticipante);
                psPago.setString(3, tipoPago);
                psPago.setInt(4, Integer.parseInt(monto));

                int filas = psPago.executeUpdate();
                if (filas > 0) {
                    System.out.println("Pago registrado correctamente");
                } else {
                    System.out.println("No se registró el pago");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    */

    public void mostrarParticipantes(JComboBox<String> correo) {

        Connection conn = connection.getConnect();

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
        Connection conn = connection.getConnect();

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
