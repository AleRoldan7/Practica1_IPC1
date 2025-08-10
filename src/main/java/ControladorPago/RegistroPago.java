/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorPago;

import ConexionDBA.ConectarDBA;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    
    public void pagoRegistrado(String codigoEvento, String correoParticipante, String tipoPago, String monto){
        Connection conn = connection.getConnect();
        
        String query = "INSERT INTO pago (codigoEvento, idParticipante, tipoPago)" 
                + "VALUES (?, (SELECT idParticipante FROM registro_participante WHERE Correo = ?), ?, ?)";
        
        try (PreparedStatement pstm = conn.prepareStatement(query)){
            
            pstm.setString(1, codigoEvento);
            pstm.setString(2, correoParticipante);
            pstm.setString(3, tipoPago);
            pstm.setString(4, monto);
            
            int filas = pstm.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
                
        
    }
    
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
