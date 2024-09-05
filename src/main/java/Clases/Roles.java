package Clases;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Roles {

    private int id_rol;
    private String id_usuario;
    private String Rol;

    public Roles(int id_rol, String id_usuario, String Rol) {
        this.id_rol = id_rol;
        this.id_usuario = id_usuario;
        this.Rol = Rol;
    }

    public Roles(int id_rol) {
        this.id_rol = id_rol;
    }

    public Roles(String id_usuario, String Rol) {
        this.id_usuario = id_usuario;
        this.Rol = Rol;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public static DefaultTableModel gestiondeRoles() {

        Conexion conexion = new Conexion();
        DefaultTableModel modeloTabla = new DefaultTableModel();

        modeloTabla.addColumn("Id");
        modeloTabla.addColumn("Id del Usuario");
        modeloTabla.addColumn("Rol");
        

        String[] Rol = new String[3];

        try {
            Statement stmt = conexion.conectar().createStatement();
            ResultSet rs = stmt.executeQuery("select * from usuariosxroles");
            

            while (rs.next()) {

                Rol[0] = rs.getString("id_rol");
                Rol[1] = rs.getString("id_usuario");
                Rol[2] = rs.getString("rol");
                
                
                modeloTabla.addRow(Rol);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al mostrar los roles",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }

        return modeloTabla;
    }

    public static DefaultTableModel gestionDeUsuarios() {

        Conexion conexion = new Conexion();
        DefaultTableModel modeloTabla = new DefaultTableModel();

        modeloTabla.addColumn("Id");
        modeloTabla.addColumn("Usuario");
        
        

        String[] Rol = new String[2];

        try {
            Statement stmt = conexion.conectar().createStatement();
            ResultSet rs = stmt.executeQuery("select * from usuarios");
            

            while (rs.next()) {

                Rol[0] = rs.getString("id");
                Rol[1] = rs.getString("ingresoUsuario");
                
                modeloTabla.addRow(Rol);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al mostrar los roles",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }

        return modeloTabla;
    }
    public void creacionDeUsuarios() {
        Conexion conexion = new Conexion();

        String sql = "INSERT INTO usuariosxroles (id_usuario, Rol)"
                + "VALUES (?, ?)";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);

            cs.setString(1, this.id_usuario);
            cs.setString(2, this.Rol);

            cs.execute();

            JOptionPane.showMessageDialog(null, "Rol guardado con exito");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al agregar el rol",
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

        String sql = "update usuariosxroles set "
                + "id_usuario = ?,"
                + "Rol = ?"
                + " where id_rol = ?";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);

            cs.setString(1, this.id_usuario);
            cs.setString(2, this.Rol);
            cs.setInt(3, this.id_rol);

            cs.execute();

            JOptionPane.showMessageDialog(null, "Rol actualizado con exito");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar el Rol",
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

        String sql = "DELETE FROM usuariosxroles WHERE id_rol = ?";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);

            cs.setInt(1, this.id_rol);

            cs.execute();

            JOptionPane.showMessageDialog(null, "Rol eliminado con exito");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al eliminar el rol",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
    }



}
