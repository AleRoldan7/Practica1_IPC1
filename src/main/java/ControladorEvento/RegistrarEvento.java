/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorEvento;

import ConexionDBA.ConectarDBA;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author alejandro
 */
public class RegistrarEvento extends ConectarDBA{


    public RegistrarEvento() {
        super();
    }

    public void agregarEvento(String codigo, String fecha, String tipo, String titulo, String ubi, String cupo) {

        Connection conn = getConnect();

        String query = "INSERT INTO registro_evento (Codigo, Fecha_Evento, Tipo_Evento, Titulo, Ubicacion, Cupo_Maximo) VALUES (?,?,?,?,?,?)";

        try (PreparedStatement pstm = conn.prepareStatement(query)) {

            pstm.setString(1, codigo);
            pstm.setString(2, fecha);
            pstm.setString(3, tipo);
            pstm.setString(4, titulo);
            pstm.setString(5, ubi);
            pstm.setString(6, cupo);

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
