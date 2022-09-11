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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vdatos.vcliente;
import vdatos.vcodigo_cliente;

/**
 *
 * @author Justi
 */
public class f_codigocliente {
    
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL="";
    private String sSQL2="";
    public Integer totalregistros;
   public Double totalpagar; 
    
   
     public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "Nombre", "Apellido", "Direccion","telefono",  "Departamento","codigo cliente"};
        
        String [] registro = new String [7];
        
        totalregistros=0;
        //totalpagar=0.0;
        modelo = new DefaultTableModel(null, titulos);
        
       sSQL="select p.idClientes,p.nombrecli,p.apellidocli,p.direcioncli,p.telefonocli,d.nombredepa,c.codigo_cliente from Clientes p "
                + "inner join  Departamento d on p.idDepartamento=d.idDepartamento "
               + "inner join codigocliente c on p.idClientes=c.idClientes "  
               + "  like '%" + buscar + "%' order by idClientes desc";
           
           //sSQL="select * from pago where idreserva=" + buscar + " order by idpago desc";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0]=rs.getString("idClientes");
                registro[1]=rs.getString("nombrecli");
                registro[2]=rs.getString("apellidocli");
                registro[3]=rs.getString("direcioncli");
               registro[4]=rs.getString("telefonocli");
                registro[5]=rs.getString("nombredepa");
                registro[6]=rs.getString("codigo_cliente");
                
                totalregistros = totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
        public void cargarComboCliente(JComboBox combo)
    {
        sSQL = "SELECT nombrecli FROM Clientes ";
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
     public int obtenerIdCliente(JComboBox combo)
    {
        int id = 0;
        sSQL = "SELECT idClientes FROM Clientes WHERE nombrecli='" +
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
//     public DefaultTableModel mostrarvista(String buscar){
//        DefaultTableModel modelo;
//        
//        String [] titulos = {"ID", "Nombre", "Apellido", "Direccion","telefono",  "Departamento"};
//        
//        String [] registro = new String [6];
//        
//        totalregistros=0;
//        modelo = new DefaultTableModel(null, titulos);
//        
//       sSQL="select p.idClientes, p.nombrecli, p.apellidocli, p.direcioncli, p.telefonocli, d.nombredepa "
//                +"  from Clientes p  inner join Departamento d on d.idDepartamento=d.idDepartamento "   + buscar + " order by idClientes desc";
//           
//          // sSQL="select * from pago where idclientes=" + buscar + " order by idpago desc";
//        try {
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
//            
//            while(rs.next()){
//                registro[0]=rs.getString("idClientes");
//                registro[1]=rs.getString("nombrecli");
//                registro[2]=rs.getString("apellidocli");
//                registro[3]=rs.getString("direcioncli");
//               registro[4]=rs.getString("telefonocli");
//                
//                registro[5]=rs.getString("nombredepa");
//                
//                totalregistros = totalregistros+1;
//                modelo.addRow(registro);
//            }
//            return modelo;
//        } catch (Exception e) {
//            JOptionPane.showConfirmDialog(null, e);
//            return null;
//        }
//    }
    
    public boolean insertar(vcodigo_cliente dts){
        sSQL="insert into Clientes (nombrecli, apellidocli, direcioncli,telefonocli,idDepartamento) " +
                "values (?,?,?,?,?)";
        sSQL2="insert into codigocliente (idClientes,codigo_cliente)" + 
                "values((select idClientes from Clientes order by idClientes desc limit 1),?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
           PreparedStatement pst2 = cn.prepareStatement(sSQL2);
         
            
            pst.setString(1, dts.getNombrecli());
            pst.setString(2, dts.getApellidocli());
            pst.setString(3, dts.getDireccioncli());
            pst.setString(4, dts.getTelefono());
         
            pst.setInt(5, dts.getIdDepartamento());
             
            pst2.setString(1, dts.getCodigo_cliente());
            
            
            int n = pst.executeUpdate();
            
            if(n != 0){
                int n2 =pst2.executeUpdate();
                if (n2!=0) {
                    return true;
                    
                } else{
                    return false;
                }
                
            }
            else{
            
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
     
        }
   
    }

    
    public boolean editar(vcodigo_cliente dts){
        sSQL="update Clientes set nombrecli=?, apellidocli=?, direcioncli=?,telefonocli=?, idDepartamento=? " +
                "where idClientes=? ";
        sSQL2="update Codigocliente set codigo_cliente=? "
                +"where idClientes";
         try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
           PreparedStatement pst2 = cn.prepareStatement(sSQL2);
             pst.setInt(1, dts.getIdClientes());
            
            pst.setString(2, dts.getNombrecli());
            pst.setString(3, dts.getApellidocli());
            pst.setString(4, dts.getDireccioncli());
            pst.setString(5, dts.getTelefono());
         
            pst.setInt(6, dts.getIdDepartamento());
            pst.setInt(7, dts.getIdClientes());
             
            pst2.setString(1, dts.getCodigo_cliente());
            pst.setInt(2, dts.getIdClientes());
            
            
            int n = pst.executeUpdate();
            
            if(n != 0){
                int n2 =pst2.executeUpdate();
                if (n2!=0) {
                    return true;
                    
                } else{
                    return false;
                }
                
            }
            else{
            
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
     
        }
   
    }
//    public boolean pagar(vcliente dts){
//        sSQL="update Cliente set estados='pagado' " +
//                "where idClientes=?";
//        try {
//            PreparedStatement pst = cn.prepareStatement(sSQL);
//            
//            pst.setInt(1, dts.getIdClientes());
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
//           // JOptionPane.showConfirmDialog(null, e);
//            return false;
//        }
//    }
    
    public boolean eliminar(vcodigo_cliente dts){
        sSQL = "delete from Clientes where idClientes=? ";
        sSQL2 = "delete from Clientes where idClientes=? ";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setInt(1, dts.getIdClientes());

            pst2.setInt(1, dts.getIdClientes());
            
            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}
