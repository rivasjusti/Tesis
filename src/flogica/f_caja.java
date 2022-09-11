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
import vdatos.vcaja;
import vdatos.vpagar;

import vdatos.vreparacion;

/**
 *
 * @author Justi
 */
public class f_caja {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "idCliente", "Cliente", "idTrabajador", "Trabajador","Descripcion", "cantidad", "PRECIO", "FECHA VENTA", "IVA", "SUB TOTAL","TOTAL PAGO","FACTURA","TAJETA","ACCESORIOS","MODELO"};
       
        String [] registro = new String [16];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL="select r.idcaja,idClientes, " +
                " (select nombrecli from Clientes where idClientes = r.idClientes)as clienten, " +
                " (select apellidocli from Clientes where idClientes = r.idClientes)as clienteap, " +
                " r.idtipotrabajador, (select nombretra from TipoTrabajador where idtipotrabajador = r.idtipotrabajador)as trabajadorn, " +
                " (select apellidotra from TipoTrabajador where idtipotrabajador = r.idtipotrabajador)as trabajadorap, " +
                "  r.descri, r.cant, r.precio, r.fechaventa,r.iva,r.subtotal,r.totalpago, " +
                "  tf.nombrefac, tt.descrii,a.nombreacc,m.chasis from caja r inner join TipoFactura tf on r.idtipofactura=tf.idtipofactura "
                + "inner join tarjeta tt on r.idtarjeta=tt.idtarjeta inner join Accesorios a on r.idAccesorios=a.idAccesorios "
                + " inner join Modelo m on r.idModelo=m.idModelo where r.fechaventa like '%" + buscar + "%' order by idcaja desc";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0]=rs.getString("idcaja");
                registro[1]=rs.getString("idClientes");
                registro[2]=rs.getString("clienten") + " " + rs.getString("clienteap");
                registro[3]=rs.getString("idtipotrabajador");
                registro[4]=rs.getString("trabajadorn") + " " + rs.getString("trabajadorap");
                registro[5]=rs.getString("descri");
                registro[6]=rs.getString("cant");
                registro[7]=rs.getString("precio");
                registro[8]=rs.getString("fechaventa");
                registro[9]=rs.getString("iva");
                registro[10]=rs.getString("subtotal");
                registro[11]=rs.getString("totalpago");
                registro[12]=rs.getString("nombrefac");
                registro[13]=rs.getString("descrii");
                registro[14]=rs.getString("nombreacc");
                registro[15]=rs.getString("chasis");
               
                
                totalregistros = totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    public boolean insertar(vcaja dts){
        sSQL="insert into caja (idClientes, idtipotrabajador,descri, cant, precio, fechaventa, iva, subtotal, totalpago,idTipoFactura,idtarjeta,idAccesorios,idModelo)" +
                "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdClientes());
            pst.setInt(2, dts.getIdtipotrabajador());
            pst.setString(3, dts.getDescri());
             pst.setInt(4, dts.getPrecio());
            pst.setInt(5, dts.getPrecio());
            pst.setDate(6, dts.getFechaventa());
            pst.setInt(7, dts.getIva());
            pst.setInt(8, dts.getSubtotal());
            pst.setInt(9, dts.getTotalpago());
            pst.setInt(10, dts.getIdTipoFactura());
            pst.setInt(11, dts.getIdtarjeta());
             pst.setInt(12, dts.getIdAccesorios());
            pst.setInt(13, dts.getIdModelo());
            
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
    
    public boolean editar(vcaja dts){
        sSQL="update reserva set idhabitacion=?, idcliente=?, idtrabajador=?, fecha_reserva=?, fecha_ingreso=?, "
                + "fecha_salida=?, costo_alojamiento=?, idestados=?, idtiporeserva=? " + "where idreserva=?";
                 
                
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
//           pst.setInt(1, dts.getIdHabitacion());
//           pst.setInt(2, dts.getIdCliente());
//            pst.setInt(3, dts.getIdTrabajadores());
//            pst.setDate(4, dts.getFecha_reserva());
//            pst.setDate(5, dts.getFecha_ingreso());
//            pst.setDate(6, dts.getFecha_salida());
//            pst.setDouble(7, dts.getCosto_alojamiento());  
//            pst.setInt(9, dts.getIdestados());
//            pst.setInt(10, dts.getIdiporeserva());
//            pst.setInt(10, dts.getIdReserva());

            
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
    
    public boolean pagar(vcaja dts){
        sSQL="update reserva set estados='11' " +
                "where idreserva=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdCaja());
            
            int n = pst.executeUpdate();
            
            if(n != 0){
                return true;
            }
            else
            {
                return false;
            }   
        } catch (Exception e) {
           // JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean eliminar(vcaja dts){
        sSQL = "delete from caja where idcaja=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdCaja());
            
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
