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
 * @author aaraya
 */
public class Choferes {
    private int id;
    private String Nombre;
    private String Licencia;
    private int Contacto;

    public Choferes(int id, String Nombre, String Licencia, int Contacto) {
        this.id = id;
        this.Nombre = Nombre;
        this.Licencia = Licencia;
        this.Contacto = Contacto;
    }

    public Choferes(String Nombre, String Licencia, int Contacto) {
        this.Nombre = Nombre;
        this.Licencia = Licencia;
        this.Contacto = Contacto;
    }

    public Choferes(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getLicencia() {
        return Licencia;
    }

    public void setLicencia(String Licencia) {
        this.Licencia = Licencia;
    }

    public int getContacto() {
        return Contacto;
    }

    public void setContacto(int Contacto) {
        this.Contacto = Contacto;
    }
    
    
    public static DefaultTableModel mostrar() {

        Conexion conexion = new Conexion();
        DefaultTableModel modeloTabla = new DefaultTableModel();

        modeloTabla.addColumn("Id");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Licencia");
        modeloTabla.addColumn("Contacto");

        String[] chofer = new String[4];

        try {
            Statement stmt = conexion.conectar().createStatement();
            ResultSet rs = stmt.executeQuery("select * from choferes;");

            while (rs.next()) {

                chofer[0] = rs.getString("id");
                chofer[1] = rs.getString("Nombre");
                chofer[2] = rs.getString("Licencia");
                chofer[3] = rs.getString("Contacto");

                modeloTabla.addRow(chofer);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al mostrar los choferes",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }

        return modeloTabla;
    }
     public void guardar() {
        Conexion conexion = new Conexion();

        String sql = "INSERT INTO choferes (Nombre, Licencia, Contacto)"
                + "VALUES (?, ?, ?)";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);

            cs.setString(1, this.Nombre);
            cs.setString(2, this.Licencia);
            cs.setInt(3, this.Contacto);

            cs.execute();

            JOptionPane.showMessageDialog(null, "Chofer guardado con exito");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al agregar el chofer",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
    }

    public void modificar() {
        Conexion conexion = new Conexion();

        String sql = "update choferes set "
                + "Nombre = ?,"
                + "Licencia = ?,"
                + "Contacto = ?"
                + " where id = ?";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);

            cs.setString(1, this.Nombre);
            cs.setString(2, this.Licencia);
            cs.setInt(3, this.Contacto);
            cs.setInt(4, this.id);

            cs.execute();

            JOptionPane.showMessageDialog(null, "Chofer actualizado con exito");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar el chofer",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
    }

    public void eliminar() {
        Conexion conexion = new Conexion();

        String sql = "DELETE FROM choferes WHERE id = ?";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);

            cs.setInt(1, this.id);

            cs.execute();

            JOptionPane.showMessageDialog(null, "Chofer eliminado con exito");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al eliminar el chofer",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
    }
}
