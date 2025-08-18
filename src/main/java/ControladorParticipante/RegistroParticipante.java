/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorParticipante;

import ConexionDBA.ConectarDBA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;

/**
 *
 * @author alejandro
 */
public class RegistroParticipante extends ConectarDBA {

    public RegistroParticipante() {
        super();
    }

    public void agregarParticipante(String nombre, String tipo, String institu, String correo) {

        
        String query = "INSERT INTO registro_participante (NombreParticipante, TipoParticipante, Institucion, Correo) VALUES (?,?,?,?)";

        try (PreparedStatement pstm = getConnect().prepareStatement(query)) {

            pstm.setString(1, nombre);
            pstm.setString(2, tipo);
            pstm.setString(3, institu);
            pstm.setString(4, correo);

            int filas = pstm.executeUpdate();

            if (filas > 0) {
                System.out.println("SI agrego datos");

            } else {
                System.out.println("No agrego nada");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
