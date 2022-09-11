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
import vdatos.vpagar;

import vdatos.vreparacion;

/**
 *
 * @author Justi
 */
public class f_pago {
    
     private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    public Integer totalpagar;
   
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "CANTIDAD", "PRECIO DEL PRODUCTO","IVA","FECHA DE PAGO","RUC","CLIENTES","ACCESOIOS ","FACTURA"};
        
        String [] registro = new String [9];
        
        totalregistros=0;
        totalpagar=0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL="select d.idpago,d.cantidad,preciodeproducto,d.iva,d.fechapago,d.ruc,c.nombrecli,a.nombreacc,f.nombrefac from pago d "
                + "inner join Clientes c on c.idClientes= d.idClientes inner join Accesorios a on a.idAccesorios=d.idAccesorios "
                + "inner join TipoFactura f on f.idTipoFactura=d.idTipoFactura like '%" + buscar + "%' order by idpago desc";
//        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0]=rs.getString("idpago");
                registro[1]=rs.getString("cantidad");
                registro[2]=rs.getString("preciodeproducto");
                registro[3]=rs.getString("iva");
                registro[4]=rs.getString("fechapago");
                registro[5]=rs.getString("ruc");
                registro[6]=rs.getString("nombrecli");
                registro[7]=rs.getString("nombreacc");
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
    public boolean insertar(vpagar dts){
        sSQL="insert into pago (cantidad,preciodeproducto,iva,fechapago,ruc,idClientes,idAccesorios,idTipoFactura) " +
                "values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getCantidad());
            pst.setInt(2, dts.getPreciodeproducto());
            pst.setDouble(3, dts.getIva());       
              
            pst.setDate(4, dts.getFechapago());
            pst.setString(5, dts.getRuc());
            pst.setInt(6, dts.getIdClientes());
             pst.setInt(7, dts.getIdAccesorios());
            pst.setInt(8, dts.getIdTipoFactura());
           
            
           
            
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
    
    public boolean editar(vpagar dts){
        sSQL="update pago set cantidad=?,preciodeproducto=?,iva=?,fechapago=?,ruc=?,idClientes=?,idAccesorios=?,idTipoFactura=?" +
                "where idpago=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getCantidad());
            pst.setInt(2, dts.getPreciodeproducto());
            pst.setDouble(3, dts.getIva());       
           
            pst.setDate(4, dts.getFechapago());
            pst.setString(5, dts.getRuc());
            pst.setInt(6, dts.getIdClientes());
            pst.setInt(7, dts.getIdAccesorios());
            pst.setInt(8, dts.getIdTipoFactura());
            pst.setInt(9, dts.getIdpago());
            
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
    
    public boolean eliminar(vpagar dts){
        sSQL = "delete from pago where idpago=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdpago());
            
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
