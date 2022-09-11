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
import vdatos.vventas;

/**
 *
 * @author Justi
 */
public class f_arqueo {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;
  //  public Double totalpagar;
    
     public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "idTrabajador", "Trabajador","Monto Apertura","Fecha Aperturado","Monto Cierre","Fecha Cierre","Total Recaudado","Estado"};
        
        String [] registro = new String [9];
        
        totalregistros=0;
       // totalpagar=0.0;
        modelo = new DefaultTableModel(null, titulos);
         sSQL="select d.idarqueo, "
                + " d.idtipotrabajador, (select nombretra from TipoTrabajador where idtipotrabajador = d.idtipotrabajador)as trabajadorn, " +
                " (select apellidotra from TipoTrabajador where idtipotrabajador = d.idtipotrabajador)as trabajadorap, "
                 + "d.monto_aper,d.fechaaper,d.montocierre,d.fechacierre,d.totalrecaudado,e.nombreestado from Arqueo d "
                 + "inner join Estado e on e.idEstado = d.idEstado " 
                 + "where montocierre like'%" + buscar + "%' order by idarqueo desc";
//       
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0]=rs.getString("idarqueo");
                registro[1]=rs.getString("idtipotrabajador");
                registro[2]=rs.getString("trabajadorn") + " " + rs.getString("trabajadorap");
                registro[3]=rs.getString("monto_aper");
                registro[4]=rs.getString("fechaaper");
                registro[5]=rs.getString("montocierre");
           
                registro[6]=rs.getString("fechacierre");
                registro[7]=rs.getString("totalrecaudado");
                registro[8]=rs.getString("nombreestado");
               
                  
             
                
                
                totalregistros = totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
      public void cargarComboarqueo(JComboBox combo)
    {
        sSQL = "SELECT monto FROM Arqueo ";
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
      public int obtenerIdArqueo(JComboBox combo)
    {
        int id = 0;
        sSQL = "SELECT idArqueo FROM Arqueo WHERE monto='" +
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

    
    public boolean insertar(varqueo dts){
        sSQL="INSERT INTO Arqueo (idtipotrabajador,monto_aper,fechaaper,Monto Cierre,fechacierre,totalrecaudado,idEstado) " +
                "values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdtipotrabajador());
            pst.setInt(2, dts.getMonto_aper());
            pst.setTimestamp(3, dts.getFechaaper());
            pst.setInt(4, dts.getMontocierre());
           
           
            pst.setTimestamp(5, dts.getFechacierre());
            pst.setInt(6, dts.getTotalrecaudado());
            pst.setInt(7, dts.getIdEstado());
           
        
            
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
    
    public boolean editar(varqueo dts){
        sSQL="UPDATE Arqueo SET idtipotrabajador=?,monto_aper=?,montocierre=?,fechaaper=?,fechacierre=?,idEstado=? " +
                "WHERE idArqueo=? ";
        try {
            //PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdtipotrabajador());
            pst.setInt(2, dts.getMonto_aper());
            pst.setTimestamp(3, dts.getFechaaper());
            pst.setInt(4, dts.getMontocierre());
           
           
            pst.setTimestamp(5, dts.getFechacierre());
            pst.setInt(6, dts.getTotalrecaudado());
            pst.setInt(7, dts.getIdEstado());
           
             pst.setInt(7, dts.getIdarqueo());
            
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
    
    public boolean eliminar(varqueo dts){
        sSQL = "DELETE FROM Arqueo WHERE idarqueo=?";
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
