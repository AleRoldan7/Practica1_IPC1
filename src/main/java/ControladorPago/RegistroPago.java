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
public class RegistroPago extends ConectarDBA{

    

    public RegistroPago() {
        super();
    }

    public boolean pagoRegistrado(String correoParticipante, String codigoEvento, String tipoPago, String monto) {
        

        String queryPago = "INSERT INTO pago (codigoEvento, idParticipante, tipoPago, monto)" +
                            "VALUES (?, (SELECT idParticipante FROM registro_participante WHERE Correo = ?), ?, ?)";
        
        try (PreparedStatement pstm = getConnect().prepareStatement(queryPago)){
            
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

   

}
