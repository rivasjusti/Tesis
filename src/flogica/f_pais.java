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

/**
 *
 * @author Justi
 */
public class f_pais {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;
    
     public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "Nombre de Pais"};
        
        String [] registro = new String [2];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL="SELECT * FROM Pais where nombrepa like '%" + buscar + "%' order by idPais desc";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0]=rs.getString("idPais");
                registro[1]=rs.getString("nombrepa");
                
                totalregistros = totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
     
    public void cargarComboPais(JComboBox combo)
    {
        sSQL = "SELECT nombrepa FROM Pais ";
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
    public int obtenerIdPais(JComboBox combo)
    {
        int id = 0;
        sSQL = "SELECT idPais FROM Pais WHERE nombrepa='" +
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
    
    public boolean insertar(vpais dts){
        sSQL="INSERT INTO Pais (nombrepa) " +
                "values (?) ";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            
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
    
    public boolean editar(vpais dts){
        sSQL="UPDATE Pais SET nombrepa=? " +
                "WHERE idPais=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setInt(2, dts.getIdPais());
            
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
    
    public boolean eliminar(vpais dts){
        sSQL = "DELETE FROM Pais WHERE idPais=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdPais());
            
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
