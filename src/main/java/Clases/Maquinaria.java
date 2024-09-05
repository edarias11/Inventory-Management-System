package Clases;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Maquinaria {
        
        private int idVehiculo;
        private String marca;
        private String tipoMaquinaria;     
        private String descripcion;
        private String anno;

    public Maquinaria(int idVehiculo, String marca, String tipoMaquinaria, String descripcion, String anno) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.tipoMaquinaria = tipoMaquinaria;
        this.descripcion = descripcion;
        this.anno = anno;
    }

    public Maquinaria(String marca, String tipoMaquinaria, String descripcion, String anno) {
        this.marca = marca;
        this.tipoMaquinaria = tipoMaquinaria;
        this.descripcion = descripcion;
        this.anno = anno;
    }

    public Maquinaria(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }
        
    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String gettipoMaquinaria() {
        return tipoMaquinaria;
    }

    public void setTipoMaquinaria(String tipoMaquinaria) {
        this.tipoMaquinaria = tipoMaquinaria;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }
    
      
        
    //Metodos
  
     public static DefaultTableModel mostrar() {

        Conexion conexion = new Conexion();
        DefaultTableModel modeloTabla = new DefaultTableModel();

        modeloTabla.addColumn("IdVehiculo");
        modeloTabla.addColumn("Marca");
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Description");
        modeloTabla.addColumn("Año");

        String[] maquinaria = new String[5];

        try {
            Statement stmt = conexion.conectar().createStatement();
            ResultSet rs = stmt.executeQuery("select * from maquinaria;");

            while (rs.next()) {

                maquinaria[0] = rs.getString("id");
                maquinaria[1] = rs.getString("marca");
                maquinaria[2] = rs.getString("tipo");
                maquinaria[3] = rs.getString("descripcion");
                maquinaria[4] = rs.getString("anno");

                modeloTabla.addRow(maquinaria);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al mostrar las maquinaria",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }

        return modeloTabla;
    }
     public void registrarMaquinaria() {
        Conexion conexion = new Conexion();

        String sql = "INSERT INTO maquinaria (marca, tipo, descripcion, anno)"
                + "VALUES (?, ?, ?, ?)";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);

            cs.setString(1, this.marca);
            cs.setString(2, this.tipoMaquinaria);
            cs.setString(3, this.descripcion);
            cs.setString(4, this.anno);

            cs.execute();

            JOptionPane.showMessageDialog(null, "Maquinaria guardada con exito");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al agregar la maquinaria",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
    }

    public void actualizarMaquinaria() {
        Conexion conexion = new Conexion();

        String sql = "update maquinaria set "
                + "marca = ?,"
                + "tipo = ?,"
                + "descripcion = ?,"
                + "anno = ?"
                + " where id = ?";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);

            cs.setString(1, this.marca);
            cs.setString(2, this.tipoMaquinaria);
            cs.setString(3, this.descripcion);
            cs.setString(4, this.anno);
            cs.setInt(5, this.idVehiculo);

            cs.execute();

            JOptionPane.showMessageDialog(null, "Maquinaria actualizada con exito");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar la maquinaria",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
    }

    public void eliminarMaquinaria() {
        Conexion conexion = new Conexion();

        String sql = "DELETE FROM maquinaria WHERE id = ?";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);

            cs.setInt(1, this.idVehiculo);

            cs.execute();

            JOptionPane.showMessageDialog(null, "Maquinaria eliminada con exito");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al eliminar la maquinaria",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
    }


}
