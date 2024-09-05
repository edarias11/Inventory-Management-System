package Clases;


import com.mycompany.proyecto.FMenuPrincipal;
import com.mysql.cj.xdevapi.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {

    public boolean validarUsuario(JTextField usuario, JPasswordField password){

        try {

            ResultSet rs = null;
            PreparedStatement ps = null;

            Clases.Conexion objetoConexion = new Clases.Conexion();
            String consulta = "select * from Usuarios where Usuarios.ingresoUsuario = (?) and Usuarios.ingresoPassword=(?);";
            ps = objetoConexion.conectar().prepareStatement(consulta);

            String contra = String.valueOf(password.getPassword());

            ps.setString(1, usuario.getText());
            ps.setString(2, contra);

            rs = ps.executeQuery();

            if (rs.next()) {

                return true;

            } else {
                return false;

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
            return false;

        }

    }
    
    public  boolean validarAcceso(String usuario,String rol )  {
        
        try {
            ResultSet rs =null;
            
            PreparedStatement ps=null;
            
              Clases.Conexion objetoConexion = new Clases.Conexion();
            
 
            String consulta ="SELECT * FROM login.usuarios as a,login.usuariosxroles as b where a.id=b.id_usuario and b.rol=(?) and a.ingresoUsuario=(?);";
            ps = objetoConexion.conectar().prepareStatement(consulta);
            
            ps.setString(1, rol);
            ps.setString(2, usuario);
            
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                
                return true;
                
      
            }else{
                return false;

            }
 
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
          return false;
        }
  
        
        
    }  
}
