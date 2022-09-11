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
import vdatos.vpais;
import vdatos.vtrabajador;

/**
 *
 * @author Justi
 */
public class ftrabajador {
    
     private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL="";
   
    public Integer totalregistros;
 //  public Double totalpagar; 
    
   
     public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "Nombre", "Apellido","Direccion", "Telefono","Numero Documento","Login","Clave","Estado","Acceso","Departamento"};
        
        String [] registro = new String [11];
        
        totalregistros=0;
       // totalpagar=0.0;
        modelo = new DefaultTableModel(null, titulos);
        
       sSQL="select t.idtipotrabajador,t.nombretra,t.apellidotra,t.direciontra,t.telefonotra,"
               + "t.Numerodocumento,t.login,t.password,e.nombreestado,tp.nombrea,d.nombredepa from  TipoTrabajador t "               
               + "inner join Tipoacceso tp on t.idTipoacceso=tp.idTipoacceso inner join Estado e on t.idEstado=e.idEstado "
               + "inner join  Departamento d on t.idDepartamento=d.idDepartamento WHERE Numerodocumento like'%"  
               + buscar + "%' order by idtipotrabajador desc";
           
           //sSQL="select * from pago where idreserva=" + buscar + " order by idpago desc";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
               registro[0]=rs.getString("idtipotrabajador");
               registro[1]=rs.getString("nombretra");
               registro[2]=rs.getString("apellidotra");
               registro[3]=rs.getString("direciontra");
               registro[4]=rs.getString("telefonotra");
               registro[5]=rs.getString("Numerodocumento");
               registro[6]=rs.getString("login");
               registro[7]=rs.getString("password");
               registro[8]=rs.getString("nombreestado");
               registro[9]=rs.getString("nombrea");
                registro[10]=rs.getString("nombredepa");
                
              
                
                totalregistros = totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
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
      public void cargarCombotrabajador(JComboBox combo)
    {
        sSQL = "SELECT nombretra FROM TipoTrabajador ";
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
    public int obtenerIdtrabajador(JComboBox combo)
    {
        int id = 0;
        sSQL = "SELECT idtipotrabajador FROM TipoTrabajador WHERE nombretra='" +
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
    
    public boolean insertar(vpais dts){
        sSQL="INSERT INTO Pais (nombrepa) " +
                "values (?) ";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            
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
    
    public boolean editar(vpais dts){
        sSQL="UPDATE Pais SET nombrepa=? " +
                "WHERE idPais=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setInt(2, dts.getIdPais());
            
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
    
    public boolean insertar(vtrabajador dts){
        sSQL="insert into TipoTrabajador (nombretra, apellidotra, direciontra,telefonotra,Numerodocumento,login,password,idEstado,idTipoacceso, idDepartamento) " +
                "values (?,?,?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
           
         
            
            pst.setString(1, dts.getNombretra());
            pst.setString(2, dts.getApellidotra());
            pst.setString(3, dts.getDireciontra());
            pst.setString(4, dts.getTelefonotra());  
            pst.setString(5, dts.getNumerodocumento());
            pst.setString(6, dts.getLogin());
            pst.setString(7, dts.getPassword());
            pst.setInt(8, dts.getIdestado());
            pst.setInt(9, dts.getIdTipoaceso());
            pst.setInt(10, dts.getIdDepartamento());
      
            
            
            
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

    
    public boolean editar(vtrabajador dts){
        sSQL="UPDATE TipoTrabajador SET nombretra=?" +
                "WHERE idtipotrabajador=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombretra());
            pst.setInt(2, dts.getIdtipotrabajador());
            
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
    
    public boolean eliminar(vtrabajador dts){
       
        sSQL = "DELETE FROM TipoTrabajador WHERE idtipotrabajador=? ";
        
       
            
         

           try {
           PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdtipotrabajador());
            
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
    
     public DefaultTableModel login (String login, String password) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Apellido","Login", "Clave", "Estado", "Acceso"};

        String[] registro = new String[7];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select t.idtipotrabajador, t.nombretra, t.apellidotra,t.login,t.password,e.nombreestado,"
                + "a.nombrea from TipoTrabajador t "
               
                + "inner join Estado e on t.idEstado = e.idEstado inner join Tipoacceso a on t.idTipoacceso = a.idTipoacceso where t.login='"
                + login + "' and t.password='" + password + "' and e.nombreestado='ACTIVO'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idtipotrabajador");
                registro[1] = rs.getString("nombretra");
                registro[2] = rs.getString("apellidotra");
    
               
                registro[3] = rs.getString("login");
                registro[4] = rs.getString("password");
                registro[5] = rs.getString("nombreestado");
                 registro[6] = rs.getString("nombrea");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
}
