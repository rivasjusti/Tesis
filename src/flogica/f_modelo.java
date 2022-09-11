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
import vdatos.vdepartamento;
import vdatos.vmodelo;

/**
 *
 * @author Justi
 */
public class f_modelo {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "Descripcion", "Cilindrada","Chapa","Chasis","Marcas"};
        
        String [] registro = new String [6];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL="select d.idModelo,d.modelo,d.cilindrada,d.chapa,d.chasis,m.descripcion from Modelo d "
                + "inner join marcas m on m.idmarcas = d.idmarcas like '%" + buscar + "%' order by idModelo desc";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0]=rs.getString("idModelo");
                registro[1]=rs.getString("modelo");
                registro[2]=rs.getString("cilindrada");
                registro[3]=rs.getString("chapa");
                registro[4]=rs.getString("chasis");
                registro[5]=rs.getString("descripcion");
              
                
                totalregistros = totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
     public void cargarComboModelo(JComboBox combo)
    {
        sSQL = "SELECT chasis FROM Modelo ";
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
      public int obtenerIdModelo(JComboBox combo)
    {
        int id = 0;
        sSQL = "SELECT idModelo FROM Modelo WHERE chasis='" +
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
    
    public boolean insertar(vmodelo dts){
        sSQL="insert into Modelo (modelo,cilindrada,chapa,chasis,idmarcas) "+
                "values (?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getModelo());
            pst.setInt(2, dts.getCilindrada());
            pst.setString(3, dts.getChapa());
            pst.setString(4, dts.getChasis());
            pst.setInt(5, dts.getIdmarcas());
           // pst.setInt(6, dts.getIdModelo());
           
            
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
    
    public boolean editar(vmodelo dts){
        sSQL="update Modelo set modelo=?,cilindrada=?,chapa=?,chasis=?,idmarcas=? " +
                "where idModelo=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getModelo());
            pst.setInt(2, dts.getCilindrada());
            pst.setString(3, dts.getChapa());
             pst.setString(4, dts.getChasis());
           pst.setInt(5, dts.getIdmarcas());
           pst.setInt(6, dts.getIdModelo());
            
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
    
    public boolean eliminar(vmodelo dts){
        sSQL = "delete from Modelo where idModelo=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdModelo());
            
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
