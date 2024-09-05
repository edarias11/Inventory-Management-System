package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private String url;
    private String database;
    private String usuario;
    private String password;
    private String driver;
    private Connection connection;

    public Conexion() {
        this.url = "jdbc:mysql://127.0.0.1:3306/";
        this.database = "login";
        this.usuario = "root";
        this.password = "Password2024.";
        this.driver = "com.mysql.cj.jdbc.Driver";
   }
    public Connection conectar() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url + database, usuario, password);
            return connection;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error (class): " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error (sql): " + ex.getMessage());
        }
        return null;
    }
    
        public void desconectar(){
        try {
            System.out.println("Conexion finalizada");
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Error (sql): " + ex.getMessage());
        }
    }
}
