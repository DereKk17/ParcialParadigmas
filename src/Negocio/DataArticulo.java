/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import java.sql.*;
import Datos.Conexion;
import java.util.ArrayList;

public class DataArticulo {
    private String art_cod;
    private String art_nom;
    private String art_uni;
    private float art_pre;
    private int art_stk;
    private String art_marca;
    
    
    public String EliminarArticulo(){
        Conexion objmod = new Conexion();
        String cad = "delete from articulos where art_cod='" + this.getArt_cod() + "'";
        return objmod.Ejecutar(cad);
    }
    
    public String GuardarArticulo(){
        Conexion objmod = new Conexion();
        String cad = "insert into articulos values('" + this.getArt_cod() + "','" + this.getArt_nom()+ "','" + this.getArt_uni() + "'," + this.getArt_pre() + "," + this.getArt_stk() + ",'" + this.getArt_marca() + "')";
        return objmod.Ejecutar(cad);
    }
    
    public String EditarArticulo(){
        Conexion objmod = new Conexion();
        String cad = "update articulos set art_nom='" + this.getArt_nom()
                + "', art_uni='" + this.getArt_uni() + "', art_pre='" + this.getArt_pre()
                + "', art_stk=" + this.getArt_stk() + ", art_marca='" + this.getArt_marca() 
                + "' where art_cod='" + this.getArt_cod() + "'";
        return objmod.Ejecutar(cad);
    }
    
    
  
    
    public ArrayList<DataArticulo> ListArticulos(){
        ArrayList list2 = new ArrayList();
        
        try
        {
            Conexion objmod = new Conexion();
            ResultSet tabla = objmod.Listar("select * from articulos");
            DataArticulo objart;
            while(tabla.next())
            {
                objart = new DataArticulo();
                objart.setArt_cod(tabla.getString("art_cod"));
                objart.setArt_nom(tabla.getString("art_nom"));
                objart.setArt_uni(tabla.getString("art_uni"));
                objart.setArt_pre(tabla.getFloat("art_pre"));
                objart.setArt_stk(tabla.getInt("art_stk"));
                objart.setArt_marca(tabla.getString("art_marca"));
                list2.add(objart);
            }
        }
        catch(SQLException e)
        {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        return list2;
    }

    

    public String getArt_cod() {
        return art_cod;
    }

    public void setArt_cod(String art_cod) {
        this.art_cod = art_cod;
    }

    public String getArt_nom() {
        return art_nom;
    }

    public void setArt_nom(String art_nom) {
        this.art_nom = art_nom;
    }

    public String getArt_uni() {
        return art_uni;
    }

    public void setArt_uni(String art_uni) {
        this.art_uni = art_uni;
    }

    public float getArt_pre() {
        return art_pre;
    }

    public void setArt_pre(float art_pre) {
        this.art_pre = art_pre;
    }

    public int getArt_stk() {
        return art_stk;
    }

    public void setArt_stk(int art_stk) {
        this.art_stk = art_stk;
    }

    public String getArt_marca() {
        return art_marca;
    }

    public void setArt_marca(String art_marca) {
        this.art_marca = art_marca;
    }
    
    
    
    
    
}
