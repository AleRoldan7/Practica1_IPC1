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
import javax.swing.JComboBox;

/**
 *
 * @author alejandro
 */
public class RegistroInscripcion extends ConectarDBA {

    public RegistroInscripcion() {
        super();
    }

    public boolean agregarInscripcion(String codigoEvento, String correoParticipante, String tipoInscripcion) {

        String query = "INSERT INTO inscripcion (codigoEvento, idParticipante, tipoInscripcion) "
                + "VALUES (?, (SELECT idParticipante FROM registro_participante WHERE Correo = ?), ?)";

        try (PreparedStatement pstm = getConnect().prepareStatement(query)) {
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

    public boolean validarInscripcion(String correoParticipante, String codigoEvento) {
        String query = "SELECT COUNT(*) "
                + "FROM pago p "
                + "INNER JOIN registro_participante rp ON p.idParticipante = rp.idParticipante "
                + "WHERE rp.Correo = ? AND p.codigoEvento = ?";

        try (PreparedStatement pstm = getConnect().prepareStatement(query)) {
            pstm.setString(1, correoParticipante);
            pstm.setString(2, codigoEvento);

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
