package Clases;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Cliente {

    private int id;
    private String nombre;
    private String empresa;
    private int contacto;
    private String correo;

    public Cliente(int id, String nombre, String empresa, int contacto, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.empresa = empresa;
        this.contacto = contacto;
        this.correo = correo;
    }

    public Cliente(String nombre, String empresa, int contacto, String correo) {
        this.nombre = nombre;
        this.empresa = empresa;
        this.contacto = contacto;
        this.correo = correo;
    }

    public Cliente(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public static DefaultTableModel vizualizadorDeInfo() {

        Conexion conexion = new Conexion();
        DefaultTableModel modeloTabla = new DefaultTableModel();

        modeloTabla.addColumn("Id");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Empresa");
        modeloTabla.addColumn("Contacto");
        modeloTabla.addColumn("Correo");

        String[] cliente = new String[5];

        try {
            Statement stmt = conexion.conectar().createStatement();
            ResultSet rs = stmt.executeQuery("select * from cliente;");

            while (rs.next()) {

                cliente[0] = rs.getString("id");
                cliente[1] = rs.getString("Nombre");
                cliente[2] = rs.getString("Empresa");
                cliente[3] = rs.getString("Contacto");
                cliente[4] = rs.getString("correo");

                modeloTabla.addRow(cliente);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al mostrar los clientes",
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

        String sql = "INSERT INTO cliente (Nombre, Empresa, Contacto, correo)"
                + "VALUES (?, ?, ?, ?)";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);

            cs.setString(1, this.nombre);
            cs.setString(2, this.empresa);
            cs.setInt(3, this.contacto);
            cs.setString(4, this.correo);

            cs.execute();

            JOptionPane.showMessageDialog(null, "Cliente guardado con exito");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al agregar el cliente",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
    }

    public void actualizarDatos() {
        Conexion conexion = new Conexion();

        String sql = "update cliente set "
                + "Nombre = ?,"
                + "Empresa = ?,"
                + "Contacto = ?,"
                + "correo = ?"
                + " where id = ?";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);

            cs.setString(1, this.nombre);
            cs.setString(2, this.empresa);
            cs.setInt(3, this.contacto);
            cs.setString(4, this.correo);
            cs.setInt(5, this.id);

            cs.execute();

            JOptionPane.showMessageDialog(null, "Cliente actualizado con exito");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar el cliente",
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

        String sql = "DELETE FROM clientes WHERE id = ?";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);

            cs.setInt(1, this.id);

            cs.execute();

            JOptionPane.showMessageDialog(null, "Cliente eliminado con exito");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al eliminar el cliente",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
    }

}
