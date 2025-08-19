/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorPago;

import ConexionDBA.ConectarDBA;
import ModelosEntidad.EntidadPago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

/**
 *
 * @author alejandro
 */
public class RegistroPago extends ConectarDBA {

    public RegistroPago() {
        super();
        connect();
    }

    public boolean registrarPago(EntidadPago entidadPago) {

        int idParticipante = obtenerIdParticipante(entidadPago.getIdParticipante());
        if (idParticipante == -1) {
            System.out.println("❌ Participante no encontrado: " + entidadPago.getIdParticipante());
            return false;
        }

        if (pagoExistente(idParticipante, entidadPago.getCodigoEvento())) {
            System.out.println("❌ El participante ya tiene registrado un pago para este evento.");
            return false;
        }

        String queryPago = "INSERT INTO pago (codigoEvento, idParticipante, tipoPago, monto) "
                + "VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstm = getConnect().prepareStatement(queryPago)) {
            pstm.setString(1, entidadPago.getCodigoEvento());
            pstm.setInt(2, idParticipante);
            pstm.setString(3, entidadPago.getTipoPago().name());
            pstm.setDouble(4, entidadPago.getMonto());

            int filas = pstm.executeUpdate();
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

    private boolean pagoExistente(int idParticipante, String codigoEvento) {
        String query = "SELECT 1 FROM pago WHERE idParticipante = ? AND codigoEvento = ?";
        try (PreparedStatement ps = getConnect().prepareStatement(query)) {
            ps.setInt(1, idParticipante);
            ps.setString(2, codigoEvento);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
