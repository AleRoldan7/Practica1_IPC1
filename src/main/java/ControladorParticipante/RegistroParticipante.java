/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorParticipante;

import ConexionDBA.ConectarDBA;
import ModelosEntidad.EntidadParticipante;
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
        connect();
    }

    public boolean agregarParticipante(EntidadParticipante entidadParticipante) {

        String queryParticipante = "INSERT INTO registro_participante (NombreParticipante, TipoParticipante, Institucion, Correo) VALUES (?,?,?,?)";

        try (PreparedStatement pstm = getConnect().prepareStatement(queryParticipante)) {

            pstm.setString(1, entidadParticipante.getNombreParticipante());
            pstm.setString(2, entidadParticipante.getTipoParticipante().name());
            pstm.setString(3, entidadParticipante.getInstitucion());
            pstm.setString(4, entidadParticipante.getCorreoParticipante());

            int filas = pstm.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
