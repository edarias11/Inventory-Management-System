package Clases;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


public class Logistica extends Thread {
     private int id;

    private String producto;
    private int cantidadProducto;
    private int tiempoEntrega;
    private String nombreCliente;
    private String direccionEntrega;
    private String fechaPedido;
    private String estadoEntrega;
    private JProgressBar bar;
    public int progress = 0;

    public Logistica(int id, int tiempoEntrega) {
        this.id = id;
        this.tiempoEntrega = tiempoEntrega;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public Logistica(int id, String producto, int cantidadProducto, int tiempoEntrega, String nombreCliente, String direccionEntrega, String fechaPedido, String estadoEntrega, JProgressBar bar) {
        this.id = id;
        this.producto = producto;
        this.cantidadProducto = cantidadProducto;
        this.tiempoEntrega = tiempoEntrega;
        this.nombreCliente = nombreCliente;
        this.direccionEntrega = direccionEntrega;
        this.fechaPedido = fechaPedido;
        this.estadoEntrega = estadoEntrega;
        this.bar = bar;
    }

    public Logistica(String producto, int cantidadProducto, int tiempoEntrega, String nombreCliente, String direccionEntrega, String fechaPedido, String estadoEntrega, JProgressBar bar) {
        this.producto = producto;
        this.cantidadProducto = cantidadProducto;
        this.tiempoEntrega = tiempoEntrega;
        this.nombreCliente = nombreCliente;
        this.direccionEntrega = direccionEntrega;
        this.fechaPedido = fechaPedido;
        this.estadoEntrega = estadoEntrega;
        this.bar = bar;
    }

    public Logistica(int id) {
        this.id = id;
    }

    public Logistica(String producto, int cantidadProducto, int tiempoEntrega, String nombreCliente, String direccionEntrega, String fechaPedido, String estadoEntrega) {
        this.producto = producto;
        this.cantidadProducto = cantidadProducto;
        this.tiempoEntrega = tiempoEntrega;
        this.nombreCliente = nombreCliente;
        this.direccionEntrega = direccionEntrega;
        this.fechaPedido = fechaPedido;
        this.estadoEntrega = estadoEntrega;
    }


        public int getTiempoEntrega() {
        return tiempoEntrega;
    }

    public void setTiempoEntrega(int tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getEstadoEntrega() {
        return estadoEntrega;
    }

    public void setEstadoEntrega(String estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
    }

    public void destinoRutas() {

    }

   

    private void enviarOrden() {
        if (this.id == 0) {
            System.out.println("Seleccione una orden válida");
            return;
        }
        try {
            System.out.println("La orden " + this.id + " está en camino.");

            int tempEntrega = this.tiempoEntrega * 1000;

            Thread.sleep(tempEntrega);
        } catch (InterruptedException e) {
            System.out.println("La orden fue interrumpida.");
        }
    }
    
    /**
     *
     */
    
    public void detenerHilo() {
        boolean running = false; // Establece la bandera 'running' en false para detener el hilo
    }

    @Override
    public void run() {
        
        
        try {
        System.out.println("La orden " + this.id + " está en camino.");

        int tempEntrega = this.tiempoEntrega * 1000; 
        

       
        int step = 100 * 1000 / tempEntrega;

        while (progress <= 100) {
            Thread.sleep(tempEntrega / 100); // Intervalo de actualización basado en el tiempo de entrega
            progress += step;
            final int finalProgress = progress; // Variable final para acceder desde la clase interna
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    bar.setValue(Math.min(finalProgress, 100)); // Actualiza la barra de progreso en el hilo de despacho de eventos de Swing
                }
            });
            System.out.println(progress);
        }
        bar.setValue(0);
        System.out.println("Orden entregada.");
    } catch (InterruptedException e) {
        System.out.println("La orden fue interrumpida.");
    }
}
    public Logistica correrHilo(Logistica orden){
        try {
        System.out.println("La orden " + this.id + " está en camino.");

        int tempEntrega = this.tiempoEntrega * 1000; 
        

       
        int step = 100 * 1000 / tempEntrega;

        while (progress <= 100) {
            Thread.sleep(tempEntrega / 100); // Intervalo de actualización basado en el tiempo de entrega
            progress += step;
            final int finalProgress = progress; // Variable final para acceder desde la clase interna
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    bar.setValue(Math.min(finalProgress, 100)); // Actualiza la barra de progreso en el hilo de despacho de eventos de Swing
                }
            });
            System.out.println(progress);
        }
        bar.setValue(0);
        System.out.println("Orden entregada.");
    } catch (InterruptedException e) {
        System.out.println("La orden fue interrumpida.");
    }
        return orden;
    }
    
   


    public static DefaultTableModel mostrar() {
        Conexion conexion = new Conexion();
        DefaultTableModel modeloTabla = new DefaultTableModel();

        modeloTabla.addColumn("Id");
        modeloTabla.addColumn("Producto");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Nombre cliente");
        modeloTabla.addColumn("Direccion entrega");
        modeloTabla.addColumn("Tiempo entrega");
        modeloTabla.addColumn("Fecha pedido");
        modeloTabla.addColumn("Estado");

        String[] pedido = new String[8];

        try {
            Statement stmt = conexion.conectar().createStatement();
            ResultSet rs = stmt.executeQuery("select * from pedidos;");

            while (rs.next()) {

                pedido[0] = rs.getString("id");
                pedido[1] = rs.getString("producto");
                pedido[2] = rs.getString("cantidad");
                pedido[3] = rs.getString("nombre_cliente");
                pedido[4] = rs.getString("direccion_entrega");
                pedido[5] = rs.getString("tiempo_entrega");
                pedido[6] = rs.getString("fecha_pedido");
                pedido[7] = rs.getString("estado");

                modeloTabla.addRow(pedido);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al mostrar los pedidos",
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

        String sql = "INSERT INTO Pedidos (producto, cantidad, nombre_cliente, direccion_entrega, tiempo_entrega, fecha_pedido, estado)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);

            cs.setString(1, this.producto);
            cs.setInt(2, this.cantidadProducto);
            cs.setString(3, this.nombreCliente);
            cs.setString(4, this.direccionEntrega);
            cs.setInt(5, this.tiempoEntrega);
            cs.setString(6, this.fechaPedido);
            cs.setString(7, this.estadoEntrega);

            cs.execute();

            JOptionPane.showMessageDialog(null, "Pedido guardado con exito");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al agregar el pedido",
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

        String sql = "update Pedidos set "
                + "producto = ?,"
                + "cantidad = ?,"
                + "nombre_cliente = ?,"
                + "direccion_entrega = ?,"
                + "tiempo_entrega = ?,"
                + "fecha_pedido = ?,"
                + "estado = ?"
                + " where id = ?";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);

            cs.setString(1, this.producto);
            cs.setInt(2, this.cantidadProducto);
            cs.setInt(5, this.tiempoEntrega);
            cs.setString(3, this.nombreCliente);
            cs.setString(4, this.direccionEntrega);
            cs.setString(6, this.fechaPedido);
            cs.setString(7, this.estadoEntrega);
            cs.setInt(8, this.id);

            cs.execute();

            JOptionPane.showMessageDialog(null, "Pedido actualizado con exito");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar el Pedido",
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

        String sql = "DELETE FROM Pedidos WHERE id = ?";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);

            cs.setInt(1, this.id);

            cs.execute();

            JOptionPane.showMessageDialog(null, "Pedido eliminado con exito");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al eliminar el pedido",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
    }
    
}
