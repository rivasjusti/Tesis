/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flogica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vdatos.vaccesorios;
import vdatos.vestados;
import vdatos.vventas;

/**
 *
 * @author Justi
 */
public class f_accesorios {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;
    public Double totalpagar;
    
     public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID","Codigo del Accesorios","Accesorios","Marca del producto","cantidad","Precio del producto"};
        
        String [] registro = new String [6];
        
        totalregistros=0;
       // totalpagar=0.0;
        modelo = new DefaultTableModel(null, titulos);
         sSQL="select d.idAccesorios,d.codigoaccesorios,d.nombreacc,d.marcaacc,d.cantidadacc,d.precioacc from Accesorios d "
                 + "where nombreacc like'%" + buscar + "%' order by idAccesorios desc";
//       sSQL="SELECT * FROM Accesorios WHERE nombreacc like '%" + buscar + "%' OR "
//                + "marcaacc like '%" + buscar + "%' OR cantidadacc like '%" + buscar + "%' OR total "
//               + "(cantidad*precio)  like '%" + buscar + "%' order by idAccesorios desc";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0]=rs.getString("idAccesorios");
                registro[1]=rs.getString("codigoaccesorios");
                registro[2]=rs.getString("nombreacc");
                registro[3]=rs.getString("marcaacc");
                 registro[4]=rs.getString("cantidadacc");
                  registro[5]=rs.getString("precioacc");
             
             
                
                
                totalregistros = totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
//      public DefaultTableModel mostrarAccesorios(String buscar){
//        DefaultTableModel modelo;
//        
//        String [] titulos = {"ID", "Accesorios","Marca del producto","cantidad","Precio del producto"};
//        
//        String [] registro = new String [5];
//        
//        totalregistros=0;
//       // totalpagar=0.0;
//        modelo = new DefaultTableModel(null, titulos);
//        
//       sSQL="SELECT * FROM Accesorios WHERE nombreacc like '%" + buscar + "%' OR "
//                + "marcaacc like '%" + buscar + "%' OR cantidadacc like '%" + buscar + "%'OR precioacc order by idAccesorios desc";
//        try {
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
//            
//            while(rs.next()){
//                registro[0]=rs.getString("idAccesorios");
//                registro[1]=rs.getString("nombreacc");
//                registro[2]=rs.getString("marcaacc");
//                 registro[3]=rs.getString("cantidadacc");
//                  registro[4]=rs.getString("precioacc");
//               
//                
//                totalregistros = totalregistros+1;
//                modelo.addRow(registro);
//            }
//            return modelo;
//        } catch (Exception e) {
//            JOptionPane.showConfirmDialog(null, e);
//            return null;
//        }
//    }
     
    public void cargarComboaccesorios(JComboBox combo)
    {
        sSQL = "SELECT nombreacc FROM Accesorios";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            ResultSet rs = pst.executeQuery();
            combo.removeAllItems();
            while (rs.next()) {
                combo.addItem(rs.getString(1));
                //combo.addItem(rs.getString("nombretipodoc")); //es valido tambien
            }
            sSQL = "";
            cn.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    public int obtenerIdAccesorios(JComboBox combo)
    {
        int id = 0;
        sSQL = "SELECT idAccesorios FROM Accesorios WHERE nombreacc='" +
                combo.getSelectedItem()+"'";
        ResultSet rs = null;
        try {
            Statement st = cn.createStatement();
            rs = st.executeQuery(sSQL);
            if(rs.first())
            {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    
    public boolean insertar(vaccesorios dts){
        sSQL="INSERT INTO Accesorios (codigoaccesorios,nombreacc,marcaacc,cantidadacc,precioacc) " +
                "values (?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getCodigoaccesorios());
            pst.setString(2, dts.getNombreacc());
            pst.setString(3, dts.getMarcaacc());
            pst.setInt(4, dts.getCantidadacc());
            pst.setInt(5, dts.getPrecioacc());
        
            
            int n = pst.executeUpdate();
            
            if(n != 0){
                return true;
            }
            else
            {
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean editar(vaccesorios dts){
        sSQL="UPDATE Accesorios SET codigoaccesorios=?,nombreacc=?,marcaacc=?,cantidadacc=?,precioacc=? " +
                "WHERE idAccesorios=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getCodigoaccesorios());
            pst.setString(2, dts.getNombreacc());
              pst.setString(3, dts.getMarcaacc());
                pst.setInt(4, dts.getCantidadacc());
                  pst.setInt(5, dts.getPrecioacc());
            pst.setInt(6, dts.getIdAccesorios());
            
            int n = pst.executeUpdate();
            
            if(n != 0){
                return true;
            }
            else
            {
                return false;
            }   
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
//    public boolean cancelarpagado(vaccesorios dts){
//        sSQL="UPDATE Accesorios SET estado='cancelado'" +
//                "WHERE idAccesorios=?";
//        try {
//            PreparedStatement pst = cn.prepareStatement(sSQL);
//            pst.setString(1, dts.getNombreacc());
//            pst.setInt(2, dts.getIdAccesorios());
//            
//            int n = pst.executeUpdate();
//            
//            if(n != 0){
//                return true;
//            }
//            else
//            {
//                return false;
//            }   
//        } catch (Exception e) {
//            JOptionPane.showConfirmDialog(null, e);
//            return false;
//        }
//    }
    
    public boolean eliminar(vaccesorios dts){
        sSQL = "DELETE FROM Accesorios WHERE idAccesorios=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdAccesorios());
            
            int n = pst.executeUpdate();
            
            if(n != 0){
                return true;
            }
            else
            {
                return false;
            }    
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

   
    
    
}
