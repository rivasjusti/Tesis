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

/**
 *
 * @author Justi
 */
public class f_reparacion {
    
     private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
   
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "Problema", "manodeobra","Garantia","Modelo","Mecanico ","Cliente","Factura","Accesorios"};
        
        String [] registro = new String [9];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL="select d.idReparacion,d.problema,d.manodeobra,d.garantia,m.modelo,me.nombremeca,c.nombrecli,f.nombrefac,a.nombreacc FROM Reparacion d "
                + "inner join Modelo m on m.idModelo = d.idModelo inner join Mecanico me on me.idmecanico = d.idmecanico "
                + "inner join Clientes c on c.idClientes= d.idClientes inner join Accesorios a on a.idAccesorios=d.idAccesorios "
                + "inner join TipoFactura f on f.idTipoFactura=d.idTipoFactura  like '%" + buscar + "%' order by idReparacion desc";
//        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0]=rs.getString("idReparacion");
                registro[1]=rs.getString("problema");
                registro[2]=rs.getString("manodeobra");
                registro[3]=rs.getString("garantia");
              
             
                registro[4]=rs.getString("modelo");
                registro[5]=rs.getString("nombremeca");
                registro[6]=rs.getString("nombrecli");
                registro[7]=rs.getString("nombrefac");
                registro[8]=rs.getString("nombreacc");
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
    public boolean insertar(vreparacion dts){
        sSQL="insert into Reparacion (problema,manodeobra,garantia,idmodelo,idmecanico,idClientes,idTipoFactura,idAccesorios) " +
                "values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getProblema());
            pst.setInt(2, dts.getManodeobra());
            pst.setString(3, dts.getGarantia());
        
            pst.setInt(4, dts.getIdModelo());  
            pst.setInt(5, dts.getIdmecanico());
            pst.setInt(6, dts.getIdClientes());
            pst.setInt(7, dts.getIdTipoFactura());
            pst.setInt(8, dts.getIdAccesorios());
            
           
            
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
    
    public boolean editar(vreparacion dts){
        sSQL="update Reparacion set problema=?,manodeobra=?,garantia=?,idModelo=?,idmecanico=?,idClientes=?,idTipoFactura=?,idAccesorios=?" +
                "where idReparacion=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
             pst.setString(1, dts.getProblema());
            pst.setInt(2, dts.getManodeobra());
            pst.setString(3, dts.getGarantia());
        
            pst.setInt(4, dts.getIdModelo());  
            pst.setInt(5, dts.getIdmecanico());
            pst.setInt(8, dts.getIdClientes());
            pst.setInt(9, dts.getIdTipoFactura());
            pst.setInt(10, dts.getIdAccesorios());
           
            
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
    
    public boolean eliminar(vreparacion dts){
        sSQL = "delete from Reparacion where idReparacion=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdreparacion());
            
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

    

