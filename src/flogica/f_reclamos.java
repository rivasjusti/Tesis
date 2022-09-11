/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flogica;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vdatos.vdepartamento;
import vdatos.vmodelo;
import vdatos.vreclamos;

/**
 *
 * @author Justi
 */
public class f_reclamos {
         private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "Descripcion", "Fecha","Cliente","Chasis"};
        
        String [] registro = new String [5];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null, titulos);
        
//       
         sSQL="select d.idreclamos,d.descripcion,d.fecharecla,c.nombrecli,m.chasis FROM reclamos d  "
                 + "inner join Modelo m on m.idModelo = d.idModelo inner join Clientes c on c.idClientes= d.idClientes "
                + "  like '%" + buscar + "%' order by idreclamos desc";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0]=rs.getString("idreclamos");
                registro[1]=rs.getString("descripcion");
                registro[2]=rs.getString("fecharecla");
                
                registro[3]=rs.getString("nombrecli");
                registro[4]=rs.getString("chasis");
                
              
                
                totalregistros = totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
//     public void cargarComboreclamos(JComboBox combo)
//    {
//        sSQL = "SELECT chasis FROm Modelo ";
//        try {
//            PreparedStatement pst = cn.prepareStatement(sSQL);
//            ResultSet rs = pst.executeQuery();
//            combo.removeAllItems();
//            while (rs.next()) {
//                combo.addItem(rs.getString(1));
//                //combo.addItem(rs.getString("nombretipodoc")); //es valido tambien
//            }
//            sSQL = "";
//            cn.close();
//        } catch (Exception e) {
//           e.printStackTrace();
//        }
//    }
//     public int obtenerIdmodelo(JComboBox combo)
//    {
//        int id = 0;
//        sSQL = "SELECT idModelo FROM Modelo WHERE modelo='" +
//                combo.getSelectedItem()+"'";
//        ResultSet rs = null;
//        try {
//            Statement st = cn.createStatement();
//            rs = st.executeQuery(sSQL);
//            if(rs.first())
//            {
//                id = rs.getInt(1);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return id;
//    }
//    
    
    public boolean insertar(vreclamos dts){
        sSQL="insert into reclamos (descripcion,fecharecla,idClientes,idModelo) " +
                "values (?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getDescripcion());
            pst.setDate(2, (Date) dts.getFecharecla());
           
            pst.setInt(3, dts.getIdClientes());
            pst.setInt(4, dts.getIdModelo());
          
            
           
           
            
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
    
    public boolean editar(vreclamos dts){
        sSQL="update Modelo set descripcion=?,fecha=?,idClientes=?,idModelo=?" +
                "where idreclamos=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getDescripcion());
            pst.setDate(2, (Date) dts.getFecharecla());
           
            pst.setInt(3, dts.getIdClientes());
            pst.setInt(4, dts.getIdModelo());
            
           
            
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
    
    public boolean eliminar(vreclamos dts){
        sSQL = "delete from reclamos where idreclamos=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdreclamos());
            
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
