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
import vdatos.vprovedor;

/**
 *
 * @author Justi
 */
public class f_provedor {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "Nombre Proveodor", "Telefono", "Direcion ", "Ruc ","Fecha de compra","Empresa","Departamento","Estados"};
        
        String [] registro = new String [10];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL="select p.idProovedor,p.nombrepro,p.telefonopro,p.direccionpro,p.rucpro,p.fechaingresopro,p.empresapro,d.nombredepa,e.nombreestado from Proovedor p "
                +"inner join Departamento d on p.idDepartamento = d.idDepartamento "
                + "inner join Estado e on p.idEstado= e.idEstado where nombrepro  like '%" + buscar + "%' order by idProovedor desc";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0]=rs.getString("idProovedor");
                registro[1]=rs.getString("nombrepro");
                registro[2]=rs.getString("telefonopro");
                registro[3]=rs.getString("direccionpro");
                registro[4]=rs.getString("rucpro");
                registro[5]=rs.getString("fechaingresopro");
                registro[6]=rs.getString("empresapro");
                registro[7]=rs.getString("nombredepa");
               
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
    
    public boolean insertar(vprovedor dts){
        sSQL="insert into Proovedor (nombrepro,telefonopro,direccionpro,rucpro,fechaingresopro,empresapro,idDepartamento,idEstado) " +
                "values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombrepro());
            pst.setString(2, dts.getTelefonopro());
            pst.setString(3, dts.getDirecionopro());
            pst.setString(4, dts.getRucpro());
            pst.setDate(5, dts.getFechaingresopro());
            pst.setString(6, dts.getEmpresapro());
            pst.setInt(7, dts.getIdDepartamento());
           
            pst.setInt(8, dts.getIdEstado());
          
            
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
    
    public boolean editar(vprovedor dts){
        sSQL="update Proovedor set nombrepro=?,telefonopro=?, direccionpro=?, rucpro=?, fechaingresopro=?, empresapro=?, IdDepartamento=?, idEstado=? " +
                "where idProovedor=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombrepro());
            pst.setString(2, dts.getTelefonopro());
            pst.setString(3, dts.getDirecionopro());
            pst.setString(4, dts.getRucpro());
            pst.setDate(5, dts.getFechaingresopro());
            pst.setString(6, dts.getEmpresapro());
            pst.setInt(7, dts.getIdDepartamento());
            
            pst.setInt(8, dts.getIdEstado());
            
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
    
    public boolean eliminar(vprovedor dts){
        sSQL = "delete from Proovedor where idProovedor=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdProovedor());
            
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
