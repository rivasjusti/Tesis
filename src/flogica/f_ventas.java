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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vdatos.vdepartamento;
import vdatos.vreparacion;
import vdatos.vventas;

/**
 *
 * @author Justi
 */
public class f_ventas {
    
     private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
   
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "Descripcion","Accesorios", "Cliente"};
        
        String [] registro = new String [4];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL="select d.idventas,d.descripcion,c.nombrecli,a.nombreacc FROM ventas d "
              
                + "inner join Clientes c on c.idClientes= d.idClientes inner join Accesorios a on a.idAccesorios=d.idAccesorios "
                + "  like '%" + buscar + "%' order by idventas desc";
//        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0]=rs.getString("idventas");
                registro[1]=rs.getString("descripcion");
                 registro[2]=rs.getString("nombreacc");
                registro[3]=rs.getString("nombrecli");
              
               
//                registro[9]=rs.getString("idmecanico");
//                registro[10]=rs.getString("idClientes");
//                registro[11]=rs.getString("idAccesorios");
               
           
              
                
                totalregistros = totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
//     public void cargarComboPais(JComboBox combo)
//    {
//        sSQL = "SELECT nombre FROM Pais";
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
//    
    public boolean insertar(vventas dts){
        sSQL="insert into ventas (descripcion,idAccesorios,idClientes) " +
                "values (?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getDescripcion());
            pst.setInt(2, dts.getIdAccesorios());
            pst.setInt(3, dts.getIdClientes());
        
           
            
           
            
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
    
    public boolean editar(vventas dts){
        sSQL="update ventas set descripcion=?,idAccesorios=?,idClientes=?" +
                "where idReparacion=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
             pst.setString(1, dts.getDescripcion());
            pst.setInt(2, dts.getIdAccesorios());
          
           
            
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
    
    public boolean eliminar(vventas dts){
        sSQL = "delete from ventas where idventas=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdventas());
            
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

    

