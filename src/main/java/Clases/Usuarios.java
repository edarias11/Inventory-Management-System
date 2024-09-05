/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author elias
 */
abstract public class Usuarios {
    
        int id;
        String ingresoUsuario;
        String ingresoPassword;


 
    public Usuarios(int id, String ingresoUsuario, String ingresoPassword) {
        this.id = id;
        this.ingresoUsuario = ingresoUsuario;
        this.ingresoPassword = ingresoPassword;
    }

    public Usuarios(String ingresoUsuario, String ingresoPassword) {
        this.ingresoUsuario = ingresoUsuario;
        this.ingresoPassword = ingresoPassword;
    }

    public Usuarios(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getingresoUsuario() {
        return ingresoUsuario;
    }

    public void setingresoUsuario(String ingresoUsuario) {
        this.ingresoUsuario = ingresoUsuario;
    }

    public String getIngresoPassword() {
        return ingresoPassword;
    }

    public void setIngresoPassword(String ingresoPassword) {
        this.ingresoPassword = ingresoPassword;
    }
      

    
     public static DefaultTableModel gestionDeUsuarios() {

        Conexion conexion = new Conexion();
        DefaultTableModel modeloTabla = new DefaultTableModel();

        modeloTabla.addColumn("Id");
        modeloTabla.addColumn("Usuario");
        modeloTabla.addColumn("Contraseña");

        String[] usuario = new String[3];

        try {
            Statement stmt = conexion.conectar().createStatement();
            ResultSet rs = stmt.executeQuery("select * from usuarios;");

            while (rs.next()) {

                usuario[0] = rs.getString("id");
                usuario[1] = rs.getString("ingresoUsuario");
                usuario[2] = rs.getString("ingresoPassword");
                
                modeloTabla.addRow(usuario);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al mostrar los usuarios",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }

        return modeloTabla;
    }

    public abstract void creacionDeUsuarios();

    public abstract void modificarUsuario();

    public abstract void eliminarUsuarios();
  
}
