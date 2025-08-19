/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosParticipanteEventos;

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
public class ControladorGeneral extends ConectarDBA {

    public ControladorGeneral() {
        super();
    }

    public void mostrarParticipantes(JComboBox<String> correo) {

        Connection conn = getConnect();

        correo.removeAllItems();
        correo.addItem("Seleccionar Correo");

        String queryParticipante = "SELECT Correo FROM registro_participante";
        System.out.println(queryParticipante);
        try (PreparedStatement pstm = conn.prepareStatement(queryParticipante); ResultSet rs = pstm.executeQuery()) {

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

        String queryEvento = "SELECT Codigo FROM registro_evento";

        try (PreparedStatement pstm = conn.prepareStatement(queryEvento); ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {

                evento.addItem(rs.getString("Codigo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarActividad(JComboBox<String> actividad) {
        getConnect();

        actividad.removeAllItems();
        actividad.addItem("Seleccionar Actividad");

        String queryActividad = "SELECT codigoActividad FROM registrar_actividad";

        try (PreparedStatement pstm = getConnect().prepareStatement(queryActividad); ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                actividad.addItem(rs.getString("codigoActividad"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int obtenerIdParticipante(String correo) {
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

    public int obtenerIdActividad(String codigoActividad) {
        String query = "SELECT idActividad FROM registrar_actividad WHERE codigoActividad = ?";
        try (PreparedStatement ps = getConnect().prepareStatement(query)) {
            ps.setString(1, codigoActividad);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("idActividad");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; 
    }

}
