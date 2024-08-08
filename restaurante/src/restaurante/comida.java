package restaurante;

import java.sql.CallableStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import restaurante.conexion.conexion;

public class comida {
    private int codigo;
    private String nombreComida;
    private String categoriaComida;
    private String precioComida;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreComida() {
        return nombreComida;
    }

    public void setNombreComida(String nombreComida) {
        this.nombreComida = nombreComida;
    }

    public String getCategoriaComida() {
        return categoriaComida;
    }

    public void setCategoriaComida(String categoriaComida) {
        this.categoriaComida = categoriaComida;
    }

    public String getPrecioComida() {
        return precioComida;
    }

    public void setPrecioComida(String precioComida) {
        this.precioComida = precioComida;
    }
    

    
    public void insertarComida (JTextField paramNombre, JTextField paramCategoria, JTextField paramPrecio){
        setNombreComida(paramNombre.getText());
        setCategoriaComida(paramCategoria.getText());
        setPrecioComida(paramPrecio.getText());
        
        conexion objetoConexion = new conexion();
        String consulta = "INSERT INTO Comida (nombre, categoria, precio) values(?,?,?);";
        
        try {
            CallableStatement cs=objetoConexion.establecerConexiondb().prepareCall(consulta);
            cs.setString(1, getNombreComida());
            cs.setString(2,getCategoriaComida());
            cs.setString(3, getPrecioComida());
            
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se inserto la comida al menu");
        } catch (Exception e) {
        }JOptionPane.showMessageDialog(null, "No se inserto la comida al menu");
   
        
        
        
    }
    
}
