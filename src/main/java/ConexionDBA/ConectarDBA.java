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

    private static final String URL = "jdbc:mysql://localhost:3306/Triforce";
    private static final String USER = "root";
    private static final String PASSWORD = "010418";

    private Connection connection;

    public ConectarDBA() {
        connect();
    }
    
    
    
    public void connect() {
        System.out.println("Conecto" + URL);

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Si conecto bien ");
        } catch (SQLException e) {
            System.out.println("No conecto");
            e.printStackTrace();
        }

    }
    
    public Connection getConnect(){
        return connection;
    }

}
