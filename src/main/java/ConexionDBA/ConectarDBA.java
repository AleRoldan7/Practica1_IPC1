/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionDBA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alejandro
 */
public class ConectarDBA {

    private final String URL = "jdbc:mysql://localhost:3306/Triforce";
    private final String USER = "root";
    private final String PASSWORD = "010418";
    private Connection connection;

    public ConectarDBA() {
        connect();
    }

    public void connect() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conectoooooo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No conectoooo");
        }
    }

    public Connection getConnect() {

        try {
            if (connection == null || connection.isClosed()) {
                connect();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Se cerro conexion");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
