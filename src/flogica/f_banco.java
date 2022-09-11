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
import vdatos.vbanco;
import vdatos.vdepartamento;

/**
 *
 * @author Justi
 */
public class f_banco {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "RUC", "EMPRESA","DIRECCION","TELEFONO","EMAIL"};
        
        String [] registro = new String [6];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL="SELECT * FROM banco WHERE ruc like '%" + buscar + "%' OR "
                + "descri like '%" + buscar + "%' OR direc like '%" + buscar + "%' OR telef like '%" + buscar +"%' OR direc like '%" + buscar +"%' OR email like '%" + buscar + "%' order by idbanco desc";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0]=rs.getString("idbanco");
                registro[1]=rs.getString("ruc");
                 registro[2]=rs.getString("descri");
                registro[3]=rs.getString("direc");
                registro[4]=rs.getString("telef");
                registro[5]=rs.getString("email");
              
                
                totalregistros = totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
     public void cargarCombobanco(JComboBox combo)
    {
        sSQL = "SELECT descri FROM banco ";
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
      public int obtenerIdbanco(JComboBox combo)
    {
        int id = 0;
        sSQL = "SELECT idbanco FROM banco WHERE descri='" +
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
    
    public boolean insertar(vbanco dts){
        sSQL="insert into banco (ruc,descri,direc,telef,email) "+
                "values (?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
             pst.setString(1, dts.getRuc());
            pst.setString(2, dts.getDescri());
            pst.setString(3, dts.getDirec());
            pst.setString(4, dts.getTelef());
            pst.setString(5, dts.getEmail());
           
            
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
    
    public boolean editar(vbanco dts){
        sSQL="update banco set ruc=?,descri=?,direc=?,telef=?,email=? " +
                "where idbanco=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getRuc());
            pst.setString(2, dts.getDescri());
            pst.setString(3, dts.getDirec());
            pst.setString(4, dts.getTelef());
            pst.setString(5, dts.getEmail());
            
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
    
    public boolean eliminar(vbanco dts){
        sSQL = "delete from banco where idbanco=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdbanco());
            
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
