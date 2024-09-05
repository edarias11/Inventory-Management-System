package Clases;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Inventario {

    private int codigo;
    private String producto;
    private String descripcion;
    private double precio;
    private int cantidad;
    private String fecha;

    public Inventario(int codigo, String producto, String descripcion, double precio, int cantidad, String fecha) {
        this.codigo = codigo;
        this.producto = producto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public Inventario(String producto, String descripcion, double precio, int cantidad, String fecha) {
        this.producto = producto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public Inventario(int codigo) {
        this.codigo = codigo;
    }

    public static DefaultTableModel vizualizadorDeInfo() {

        Conexion conexion = new Conexion();
        DefaultTableModel modeloTabla = new DefaultTableModel();

        modeloTabla.addColumn("Id");
        modeloTabla.addColumn("Producto");
        modeloTabla.addColumn("Descripcion");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Fecha Ingreso");

        String[] inven = new String[6];

        try {
            Statement stmt = conexion.conectar().createStatement();
            ResultSet rs = stmt.executeQuery("select * from inventario;");

            while (rs.next()) {

                inven[0] = rs.getString("id");
                inven[1] = rs.getString("nombre");
                inven[2] = rs.getString("descripcion");
                inven[3] = rs.getString("precio");
                inven[4] = rs.getString("cantidad");
                inven[5] = rs.getString("fecha_ingreso");

                modeloTabla.addRow(inven);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al mostrar los inventario",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }

        return modeloTabla;
    }

    public void registroProducto() {
        Conexion conexion = new Conexion();

        String sql = "INSERT INTO inventario (Nombre, descripcion, precio, cantidad, fecha_ingreso)"
                + "VALUES (?, ?, ?, ?, ?)";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);

            cs.setString(1, this.producto);
            cs.setString(2, this.descripcion);
            cs.setDouble(3, this.precio);
            cs.setInt(4, this.cantidad);
            cs.setString(5, this.fecha);

            cs.execute();

            JOptionPane.showMessageDialog(null, "Producto guardado con exito");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al agregar el inventario",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
    }

    public void actualizacionProducto() {
        Conexion conexion = new Conexion();

        String sql = "update inventario set "
                + "nombre = ?,"
                + "descripcion = ?,"
                + "precio = ?,"
                + "cantidad = ?,"
                + "fecha_ingreso = ?"
                + " where id = ?";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);

            cs.setString(1, this.producto);
            cs.setString(2, this.descripcion);
            cs.setDouble(3, this.precio);
            cs.setInt(4, this.cantidad);
            cs.setString(5, this.fecha);
            cs.setInt(6, this.codigo);

            cs.execute();

            JOptionPane.showMessageDialog(null, "Producto actualizado con exito");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar el inventario",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
    }

    public void eliminarProducto() {
        Conexion conexion = new Conexion();

        String sql = "DELETE FROM inventario WHERE id = ?";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);

            cs.setInt(1, this.codigo);

            cs.execute();

            JOptionPane.showMessageDialog(null, "Producto eliminado con exito");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al eliminar el inventario",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
