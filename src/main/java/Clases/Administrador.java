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
public class Administrador extends Usuarios {

    public Administrador(int id, String ingresoUsuario, String ingresoPassword) {
        super(id, ingresoUsuario, ingresoPassword);
    }
    
    public Administrador(String ingresoUsuario, String ingresoPassword) {
        super(ingresoUsuario, ingresoPassword);
    }
    
    public Administrador(int id) {
        super(id);
    }

    //Metodos
    public void creacionDeUsuarios() {
        Conexion conexion = new Conexion();

        String sql = "INSERT INTO usuarios (ingresoUsuario, ingresoPassword)"
                + "VALUES (?, ?)";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);

            cs.setString(1, this.ingresoUsuario);
            cs.setString(2, this.ingresoPassword);

            cs.execute();

            JOptionPane.showMessageDialog(null, "Usuario guardado con exito");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al agregar el usuario",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
    }

    public void modificarUsuario() {
        Conexion conexion = new Conexion();

        String sql = "update usuarios set "
                + "ingresoUsuario = ?,"
                + "ingresoPassword = ?"
                + " where id = ?";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);

            cs.setString(1, this.ingresoUsuario);
            cs.setString(2, this.ingresoPassword);
            cs.setInt(3, this.id);

            cs.execute();

            JOptionPane.showMessageDialog(null, "Usuario actualizado con exito");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar el usuario",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
    }

    public void eliminarUsuarios() {
        Conexion conexion = new Conexion();

        String sql = "DELETE FROM usuarios WHERE id = ?";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);

            cs.setInt(1, this.id);

            cs.execute();

            JOptionPane.showMessageDialog(null, "Usuario eliminado con exito");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al eliminar el usuario",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
    }


}
