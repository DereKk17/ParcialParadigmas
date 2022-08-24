/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;
import java.sql.*;

/**
 *
 * @author derekmac
 */

public class Conexion {
    
    private final String url = "jdbc:mysql://localhost:3306/productos";
    private final String user = "root";
    private final String pwd = "12345678";
    
    public Conexion(){}
    
    
    public ResultSet Listar(String Cad){
        try
        {
            Connection cn = DriverManager.getConnection(url, user, pwd);
            PreparedStatement da = cn.prepareStatement(Cad);
            ResultSet tbl = da.executeQuery();
            return tbl;
        }
        catch(SQLException e)
        {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    public String Ejecutar(String Cad)
    {
        try{
            Connection cn = DriverManager.getConnection(url, user, pwd);
            PreparedStatement da = cn.prepareStatement(Cad);
            int a = da.executeUpdate();
            return "Se afectaron " + a + " filas";        
        }
        catch(SQLException e){
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
            return "Error " + e.getMessage();
        }
    
    }
   
    
}
