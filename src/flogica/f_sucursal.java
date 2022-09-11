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
import vdatos.vdepartamento;
import vdatos.vsucursal;

/**
 *
 * @author Justi
 */
public class f_sucursal {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "Descripcion", "Direccion","Telefono","Departamento"};
        
        String [] registro = new String [5];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL="select d.idSucursal,d.descripcion,d.direccion,d.telefono,p.nombredepa from Sucursal d "
                + "inner join Departamento p on p.idDepartamento = d.idDepartamento like '%" + buscar + "%' order by idSucursal desc";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0]=rs.getString("idSucursal");
                registro[1]=rs.getString("descripcion");
                registro[2]=rs.getString("direccion");
                registro[3]=rs.getString("telefono");
                registro[4]=rs.getString("nombredepa");
              
                
                totalregistros = totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
//     public void cargarComboDepartamento(JComboBox combo)
//    {
//        sSQL = "SELECT nombredepa FROM Departamento ";
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
//      public int obtenerIdDepartamento(JComboBox combo)
//    {
//        int id = 0;
//        sSQL = "SELECT idDepartamento FROM Departamento WHERE nombredepa='" +
//                combo.getSelectedItem()+"'";
//        ResultSet rs = null;
//        try {
//            Statement st = cn.createStatement();
//            rs = st.executeQuery(sSQL);
//            if(rs.first())
//            {
//                id = rs.getInt(1);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return id;
//    }
    
    public boolean insertar(vsucursal dts){
            sSQL="insert into Sucursal (descripcion,direccion,telefono,idDepartamento) "+
                "values (?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getDescripcion());
            pst.setString(2, dts.getDireccion());
             pst.setInt(3, dts.getTelefono());
            pst.setInt(4, dts.getIdDepartamento());
           
            
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
    
    public boolean editar(vsucursal dts){
        sSQL="update Sucursal set descripcion=?,direccion=?,telefono=?,idDepartamento=? " +
                "where idSucursal=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getDescripcion());
            pst.setString(2, dts.getDireccion());
           pst.setInt(3, dts.getTelefono());
           
           pst.setInt(4, dts.getIdDepartamento());
            
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
    
    public boolean eliminar(vsucursal dts){
        sSQL = "delete from Sucursal where idSucursal=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdSucursal());
            
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
