/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import java.sql.*;
import Datos.Conexion;
import java.util.ArrayList;

public class DataArticulo {
    private String placa;
    private String modelo;
    private String bahul;
    private int capacidad;
    private String motor;
    private int prePrestamo;
    private int tPrestamo;
    private String fPrestamo;
    private String fEntrega;
    private boolean estado;
    
    
    public String EliminarArticulo(){
        Conexion objmod = new Conexion();
        String cad = "delete from carros where placa='" + this.getPlaca() + "'";
        return objmod.Ejecutar(cad);
    }
    
    public String GuardarArticulo(){
        Conexion objmod = new Conexion();
        String cad = "insert into carros values('" + this.getPlaca() + "','" + this.getModelo()+ "','" + "," + this.getCapacidad() + "," +  this.getBahul() + "'," + this.getMotor() + "," + this.gettPrestamo()+ ",'"+ this.getfPrestamo() + "','" + this.getfEntrega() + "'," + this.getPrePrestamo() + ",'" + this.getEstado() + "')";
        return objmod.Ejecutar(cad);
    }
    
    public String EditarArticulo(){
        Conexion objmod = new Conexion();
        String cad = "update carros set placa='" + this.getPlaca()
                + "', bahul='" + this.getBahul() + "', modelo='" + this.getModelo()
                + "', capacidad=" + this.getCapacidad() + ", motor='" + this.getMotor() 
                + "', tPrestamo=" + this.gettPrestamo() + ", fPrestamo='" + this.getfPrestamo()
                + "', fPrestamo='" + this.getfPrestamo() + "', prePrestamo=" + this.getPrePrestamo()
                + "', estado='" + this.getEstado() 
                + "' where placa='" + this.getPlaca() + "'";
        return objmod.Ejecutar(cad);
    }
    
    
    public String AlquilarArticulo(){
        Conexion objmod = new Conexion();
        String cad = "update carros set estado = 1 where placa='" + this.getPlaca() + "'";
        return objmod.Ejecutar(cad);
        
    }
    
    public String asignarFechaPrestamo(){
        Conexion objmod = new Conexion();
        String cad = "update carros set fPrestamo = curdate() where placa='" + this.getPlaca() + "'";
        return objmod.Ejecutar(cad);
    }
    
    public String asignarFechaEntrega(){
       Conexion objmod = new Conexion();
        String cad = "update carros set fEntrega = date_add(curdate(), interval" + this.gettPrestamo() + "day) where placa='" + this.getPlaca() + "'";
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
                objart.setPlaca(tabla.getString("placa"));
                objart.setModelo(tabla.getString("modelo"));
                objart.setBahul(tabla.getString("bahul"));
                objart.setMotor(tabla.getString("motor"));
                objart.setCapacidad(tabla.getInt("capacidad"));
                objart.settPrestamo(tabla.getInt("tPrestamo"));
                objart.setfPrestamo(tabla.getString("fPrestamo"));
                objart.setfEntrega(tabla.getString("fEntrega"));
                objart.setPrePrestamo(tabla.getInt("prePrestamo"));
                objart.setEstado(tabla.getString("estado"));
                list2.add(objart);
            }
        }
        catch(SQLException e)
        {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        return list2;
    }

    

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getBahul() {
        return bahul;
    }

    public void setBahul(String bahul) {
        this.bahul = bahul;
    }

 

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public int getPrePrestamo() {
        return prePrestamo;
    }

    public void setPrePrestamo(int prePrestamo) {
        this.prePrestamo = prePrestamo;
    }

    public int gettPrestamo() {
        return tPrestamo;
    }

    public void settPrestamo(int tPrestamo) {
        this.tPrestamo = tPrestamo;
    }

    public String getfPrestamo() {
        return fPrestamo;
    }

    public void setfPrestamo(String fPrestamo) {
        this.fPrestamo = fPrestamo;
    }

    public String getfEntrega() {
        return fEntrega;
    }

    public void setfEntrega(String fEntrega) {
        this.fEntrega = fEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
    
    
}
