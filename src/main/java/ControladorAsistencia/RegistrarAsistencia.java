/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorAsistencia;

import ConexionDBA.ConectarDBA;
import DatosParticipanteEventos.ControladorGeneral;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author alejandro
 */
public class RegistrarAsistencia extends ConectarDBA{

    private ControladorGeneral controladorGeneral = new ControladorGeneral();
    
    
    public RegistrarAsistencia() {
        super();
    }
    
    public boolean agregarAsistencia(String correo, String codigoActividad){
        
        String queryAsistencia = "INSERT INTO asistencia (idParticipante, idActividad) "
                + "VALUES (SELECT idParticipante FROM registro_participante WHERE Correo = ?,"
                + "SELECT idActividad FROM registrar_actividad WHERE codigoActividad = ?)";
        
        try (PreparedStatement pstm = getConnect().prepareStatement(queryAsistencia)){
            
            pstm.setString(1, correo);
            pstm.setString(2, codigoActividad);
            
            int fila = pstm.executeUpdate();
            return fila > 0;
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            return false;
        }
        
    }
    
    
    
    
}
