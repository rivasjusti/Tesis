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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import vdatos.vaccesorios;
import vdatos.vaperturar;
import vdatos.varqueo;
import vdatos.vestados;
import vdatos.vmovimiento;
import vdatos.vventas;

/**
 *
 * @author Justi
 */
public class f_apertura {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;
    public Double totalpagar;
    
     public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "idTrabajador", "Trabajador","Monto Ingreso","Fecha Apertura"};
        
        String [] registro = new String [5];
        
        totalregistros=0;
       // totalpagar=0.0;
        modelo = new DefaultTableModel(null, titulos);
         sSQL="select d.idapertura, "
                  +"d.idtipotrabajador, (select nombretra from TipoTrabajador where idtipotrabajador = d.idtipotrabajador)as trabajadorn, " +
                " (select apellidotra from TipoTrabajador where idtipotrabajador = d.idtipotrabajador)as trabajadorap, "
                 
                
                 + "d.montoaper,d.fechaaper from arpertura d "
                
                 
                 + "where fechaaper like'%" + buscar + "%' order by idapertura desc";
//       
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0]=rs.getString("idapertura");
                registro[1]=rs.getString("idtipotrabajador");
                registro[2]=rs.getString("trabajadorn") + " " + rs.getString("trabajadorap");
                ;
                registro[3]=rs.getString("montoaper");
                registro[4]=rs.getString("fechaaper");
               
             
               
                  
             
                
                
                totalregistros = totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    
    
    public boolean insertar(vaperturar dts){
        sSQL="INSERT INTO apertura (idtipotrabajador,montoaper,fechaaper) " +
                "values (?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdtipotrabajador());
            pst.setDouble(2, dts.getMontoaper());
           
          // pst.setString(3, ((JTextField)f);
            pst.setTimestamp(3, dts.getFechaaper());
           
           
        
            
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
    
    public boolean editar(vaperturar dts){
        sSQL="UPDATE apertura SET idtipotrabajador=?,montoaper=?,fechaaper=? " +
                "WHERE idapertura=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdtipotrabajador());
           
            pst.setDouble(2, dts.getMontoaper());
            pst.setTimestamp(3, dts.getFechaaper());
           
         
            pst.setInt(4, dts.getIdaapertura());
            
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
    
    public boolean eliminar(vaperturar dts){
        sSQL = "DELETE FROM apertura WHERE idapertura=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdaapertura());
            
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
