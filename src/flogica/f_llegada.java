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
import vdatos.vllegada;
import vdatos.vreparacion;

/**
 *
 * @author Justi
 */
public class f_llegada {
    
     private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
   
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "Fecha llegada", "Orden llegada","Modelo","Cliente","Mecanico"};
        
        String [] registro = new String [6];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL="select d.idllegada,d.fechallega,d.ordenllegada,m.modelo,c.nombrecli,me.nombremeca FROM llegada d "
                + "inner join Modelo m on m.idModelo=d.idModelo "
                + "inner join Clientes c on c.idClientes= d.idClientes inner join Mecanico me on me.idmecanico=d.idmecanico where ordenllegada  like '%" + buscar + "%' order by idllegada desc";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0]=rs.getString("idllegada");
                registro[1]=rs.getString("fechallega");
                registro[2]=rs.getString("ordenllegada");
               
               
              
             
                registro[3]=rs.getString("modelo");
                
                registro[4]=rs.getString("nombrecli");
                registro[5]=rs.getString("nombremeca");
                
               
           
              
                
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
    public boolean insertar(vllegada dts){
        sSQL="insert into llegada (fechallega,ordenllegada,idModelo,idClientes,idmecanico) " +
                "values (?,?,?,?,?) ";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setDate(1, dts.getFechallega());
            pst.setString(2, dts.getOrdenllegada());
           
        
            pst.setInt(3, dts.getIdModelo());  
           
            pst.setInt(4, dts.getIdClientes());
            pst.setInt(5, dts.getIdmecanico());
          
           
            
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
    
    public boolean editar(vllegada dts){
        sSQL="update llegada set fechallega=?,ordenllegada=?,idModelo=?,idClientes=?,idmecanico=?" +
                "where idllegada=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
           pst.setDate(1, dts.getFechallega());
            pst.setString(2, dts.getOrdenllegada());
           
        
            pst.setInt(3, dts.getIdModelo());  
           
            pst.setInt(4, dts.getIdClientes());
           pst.setInt(5, dts.getIdmecanico());
           
            
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
    
    public boolean eliminar(vllegada dts){
        sSQL = "delete from llegada where idllegada=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdllegada());
            
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

    

