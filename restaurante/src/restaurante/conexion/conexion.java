package restaurante.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class conexion {
    Connection establecerConexion = null;
    String usuario = "root";
    String contraseña ="";
    String bd = "restaurante";
    String ip = "localhost";
    String puerto = "3306";

    String comando = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection establecerConexiondb(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            establecerConexion = DriverManager.getConnection(comando, usuario, contraseña);
            JOptionPane.showMessageDialog(null, "Se establecio la conexion");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se establecio la conexion, error: "+e.toString());
        }
        
        return establecerConexion;
    }

}
