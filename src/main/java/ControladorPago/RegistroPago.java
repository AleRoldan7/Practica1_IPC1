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

    public boolean pagoRegistrado(String correoParticipante, String codigoEvento, String tipoPago, String monto) {
        Connection conn = connection.getConnect();

        String queryPago = "INSERT INTO pago (codigoEvento, idParticipante, tipoPago, monto)" +
                            "VALUES (?, (SELECT idParticipante FROM registro_participante WHERE Correo = ?), ?, ?)";
        
        try (PreparedStatement pstm = conn.prepareStatement(queryPago)){
            
            pstm.setString(1, codigoEvento);
            pstm.setString(2, correoParticipante);
            pstm.setString(3, tipoPago);
            pstm.setString(4, monto);
           
            int fila =  pstm.executeUpdate();
            return fila > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }

    public void mostrarParticipantes(JComboBox<String> correo) {

        Connection conn = connection.getConnect();

        correo.removeAllItems();
        correo.addItem("Seleccionar Correo");

        String queryCorreo = "SELECT Correo FROM registro_participante";
        System.out.println(queryCorreo);
        try (PreparedStatement pstm = conn.prepareStatement(queryCorreo); ResultSet rs = pstm.executeQuery()) {

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

        String queryEvento = "SELECT Codigo FROM registro_evento";

        try (PreparedStatement pstm = conn.prepareStatement(queryEvento); ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {

                evento.addItem(rs.getString("Codigo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
