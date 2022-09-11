/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flogica;

//import Datos.vmecanico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vdatos.vmecanico;

/**
 *
 * @author Justi
 */
public class f_mecanico {
    
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;
    
     public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "Nombre","Apellido","Direccion"};
        
        String [] registro = new String [4];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL="SELECT * FROM Mecanico WHERE nombremeca like '%" + buscar + "%' OR "
                + "apellidomeca like '%" + buscar + "%' OR direccionmeca like '%" + buscar + "%' order by idmecanico desc";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0]=rs.getString("idmecanico");
                registro[1]=rs.getString("nombremeca");
                registro[2]=rs.getString("apellidomeca");
                registro[3]=rs.getString("direccionmeca");
               
                
                totalregistros = totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
     
     
//      public DefaultTableModel mostrarvistamecanico(String buscar){
//        DefaultTableModel modelo;
//        
//        String [] titulos = {"ID", "Nombre","Apellido","Direccion"};
//        
//        String [] registro = new String [4];
//        
//        totalregistros=0;
//        modelo = new DefaultTableModel(null, titulos);
//        
//        sSQL="SELECT * FROM Mecanico WHERE nombremeca like '%" + buscar + "%' OR "
//                + "apellidomeca like '%" + buscar + "%' OR direccionmeca like '%" + buscar + "%' order by idmecanico desc";
//        try {
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
//            
//            while(rs.next()){
//                registro[0]=rs.getString("idmecanico");
//                registro[1]=rs.getString("nombremeca");
//                registro[2]=rs.getString("apellidomeca");
//                registro[3]=rs.getString("direccionmeca");
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
//      }
//     
    public void cargarComboMecanico(JComboBox combo)
    {
        sSQL = "SELECT nombremeca FROM Mecanico";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            ResultSet rs = pst.executeQuery();
            combo.removeAllItems();
            while (rs.next()) {
                combo.addItem(rs.getString(1));
               // combo.addItem(rs.getString("nombretipodoc")); //es valido tambien
            }
            sSQL = "";
            cn.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    public int obtenerIdMecanico(JComboBox combo)
    {
        int id = 0;
        sSQL = "SELECT idmecanico FROM Mecanico WHERE nombremeca='" +
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
    
    public boolean insertar(vmecanico dts){
        sSQL="INSERT INTO Mecanico (nombremeca,apellidomeca,direccionmeca) " +
                "values (?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombremeca());
            pst.setString(2, dts.getApellidomeca());
            pst.setString(3, dts.getDireccionmeca());
            
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
    
    public boolean editar(vmecanico dts){
        sSQL="UPDATE Mecanico SET nombreestado=?" +
                "WHERE idmecanico=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombremeca());
            pst.setInt(2, dts.getIdmecanico());
            
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
    
    public boolean eliminar(vmecanico dts){
        sSQL = "DELETE FROM Mecanico WHERE idmecanico=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdmecanico());
            
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
