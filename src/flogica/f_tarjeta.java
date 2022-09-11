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
import vdatos.vtarjeta;

/**
 *
 * @author Justi
 */
public class f_tarjeta {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "Descripcion", "Tipo","emisor","Banco"};
        
        String [] registro = new String [5];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null, titulos);
        
//        sSQL="select d.idtarjeta,d.descrii,d.tipo,d.emisor,p.descri from tarjeta d "
//                + "inner join banco p on p.idbanco = d.idbanco like '%" + buscar + "%' order by idtarjeta desc";
        
        sSQL="select p.idtarjeta,p.descrii,p.tipo,p.emisor,c.descri from tarjeta p "
                + "inner join  banco c on c.idbanco=c.idbanco "
               + "  like '%" + buscar + "%' order by idtarjeta desc";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0]=rs.getString("idtarjeta");
                registro[1]=rs.getString("descrii");
                registro[2]=rs.getString("tipo");
                registro[3]=rs.getString("emisor");
                registro[4]=rs.getString("descri");
              
                
                totalregistros = totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
     public void cargarCombotarjeta(JComboBox combo)
    {
        sSQL = "SELECT descrii FROM tarjeta ";
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
      public int obtenerIdtarjeta(JComboBox combo)
    {
        int id = 0;
        sSQL = "SELECT idtarjeta FROM tarjeta WHERE descrii='" +
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
    
    public boolean insertar(vtarjeta dts){
        sSQL="insert into tarjeta (descrii,tipo,emisor,idbanco) "+
                "values (?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getDescrii());
            pst.setString(2, dts.getTipo());
            pst.setString(3, dts.getEmisor());
            pst.setInt(4, dts.getIdbanco());
           
            
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
    
    public boolean editar(vtarjeta dts){
        sSQL="update tarjeta set descrii=?,tipo=?,emisor=?,idbanco=? " +
                "where idtarjeta=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getDescrii());
            pst.setString(2, dts.getTipo());
           pst.setString(3, dts.getEmisor());
            pst.setInt(4, dts.getIdbanco());
           pst.setInt(5, dts.getIdtarjeta());
            
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
    
    public boolean eliminar(vtarjeta dts){
        sSQL = "delete from tarjeta where idtarjeta=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdtarjeta());
            
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
