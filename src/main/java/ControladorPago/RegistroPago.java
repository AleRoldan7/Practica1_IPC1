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
public class RegistroPago extends ConectarDBA{

    

    public RegistroPago() {
        super();
        connect();
    }

    public boolean pagoRegistrado(EntidadPago entidadPago) {
        

        String queryPago = "INSERT INTO pago (codigoEvento, idParticipante, tipoPago, monto)" +
                            "VALUES (?, (SELECT idParticipante FROM registro_participante WHERE Correo = ?), ?, ?)";
        
        try (PreparedStatement pstm = getConnect().prepareStatement(queryPago)){
            
            pstm.setString(1, entidadPago.getCodigoEvento());
            pstm.setString(2, entidadPago.getIdParticipante());
            pstm.setString(3, entidadPago.getTipoPago().name());
            pstm.setDouble(4, entidadPago.getMonto());
           
            int fila =  pstm.executeUpdate();
            return fila > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }

   

}
