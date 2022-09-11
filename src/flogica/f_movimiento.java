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
import vdatos.varqueo;
import vdatos.vestados;
import vdatos.vmovimiento;
import vdatos.vventas;

/**
 *
 * @author Justi
 */
public class f_movimiento {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;
    public Double totalpagar;
    
     public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "idTrabajador", "Trabajador","Descripcion","Monto Ingreso","Fecha Movimiento","Arqueo","Tipo Factura"};
        
        String [] registro = new String [8];
        
        totalregistros=0;
       // totalpagar=0.0;
        modelo = new DefaultTableModel(null, titulos);
         sSQL="select d.idmovi, "
                  +"d.idtipotrabajador, (select nombretra from TipoTrabajador where idtipotrabajador = d.idtipotrabajador)as trabajadorn, " +
                " (select apellidotra from TipoTrabajador where idtipotrabajador = d.idtipotrabajador)as trabajadorap, "
                 +"d.idArqueo, (select monto_aper from Arqueo where idArqueo = d.idArqueo)as Arqueon, " 
                
                 + "d.comentario,d.monto,d.fechamovi,a.monto_aper,tf.nombrefac from movimiento d "
                 + "inner join Arqueo a on d.idArqueo=a.idArqueo inner join TipoFactura tf on d.idTipoFactura=tf.idTipoFactura "
                 
                 + "where comentario like'%" + buscar + "%' order by idmovi desc";
//       
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0]=rs.getString("idmovi");
                registro[1]=rs.getString("idtipotrabajador");
                registro[2]=rs.getString("trabajadorn") + " " + rs.getString("trabajadorap");
                registro[3]=rs.getString("idArqueo");
                registro[4]=rs.getString("Arqueon");
                registro[5]=rs.getString("comentario");
                registro[6]=rs.getString("monto");
                registro[7]=rs.getString("fechamovi");
               
                registro[8]=rs.getString("nombrefac");
               
                  
             
                
                
                totalregistros = totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    
    
    public boolean insertar(vmovimiento dts){
        sSQL="INSERT INTO movimiento (idtipotrabajador,idArqueo,comentario,monto,fechamovi,idTipoFactura) " +
                "values (?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdtipotrabajador());
            pst.setDouble(2, dts.getIdarqueo());
            pst.setString(3, dts.getComentario());
            pst.setDouble(4, dts.getMonto());
          // pst.setString(3, ((JTextField)f);
            pst.setTimestamp(5, dts.getFechamovi());
           
            
            pst.setInt(6, dts.getIdTipoFactura());
        
            
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
    
    public boolean editar(vmovimiento dts){
        sSQL="UPDATE movimiento SET idtipotrabajador=?,comentario=?,monto=?,fechamovi=?,idArqueo=?,idTipoFactura=? " +
                "WHERE idmovi=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdtipotrabajador());
            pst.setString(2, dts.getComentario());
            pst.setDouble(3, dts.getMonto());
            pst.setTimestamp(4, dts.getFechamovi());
           
            pst.setInt(5, dts.getIdarqueo());
            pst.setInt(6, dts.getIdTipoFactura());
            
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
    
    public boolean eliminar(vmovimiento dts){
        sSQL = "DELETE FROM movimiento WHERE idmovi=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdarqueo());
            
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
