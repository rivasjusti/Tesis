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
import vdatos.vpais;
import vdatos.vTipoFactura;

/**
 *
 * @author Justi
 */
public class f_tipofactura {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;
    
     public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "tipos de factura "};
        
        String [] registro = new String [2];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL="SELECT * FROM TipoFactura where nombrefac like '%" + buscar + "%' order by idTipoFactura desc";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0]=rs.getString("idTipoFactura");
                registro[1]=rs.getString("nombrefac");
                
                totalregistros = totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
     
    public void cargarComboFactura(JComboBox combo)
    {
        sSQL = "SELECT nombrefac FROM TipoFactura ";
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
    public int obtenerIdFactura(JComboBox combo)
    {
        int id = 0;
        sSQL = "SELECT idTipoFactura FROM TipoFactura WHERE nombrefac='" +
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
    
    public boolean insertar(vTipoFactura dts){
        sSQL="INSERT INTO TipoFactura (nombrefac) " +
                "values (?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombrefac());
            
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
    
    public boolean editar(vTipoFactura dts){
        sSQL="UPDATE TipoFactura SET nombrefac=?" +
                "WHERE idTipoFactura=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombrefac());
            pst.setInt(2, dts.getIdTipoFactura());
            
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
    
    public boolean eliminar(vTipoFactura dts){
        sSQL = "DELETE FROM TipoFactura WHERE idTipoFactura=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdTipoFactura());
            
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
