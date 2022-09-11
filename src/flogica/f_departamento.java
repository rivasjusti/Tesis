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

/**
 *
 * @author Justi
 */
public class f_departamento {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "Departamento", "Barrio","Pais"};
        
        String [] registro = new String [4];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL="select d.idDepartamento,d.nombredepa,d.barriodepa,p.nombrepa from Departamento d "
                + "inner join Pais p on p.idPais = d.idPais like '%" + buscar + "%' order by idDepartamento desc";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0]=rs.getString("idDepartamento");
                registro[1]=rs.getString("nombredepa");
                registro[2]=rs.getString("barriodepa");
                registro[3]=rs.getString("nombrepa");
              
                
                totalregistros = totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
     public void cargarComboDepartamento(JComboBox combo)
    {
        sSQL = "SELECT nombredepa FROM Departamento ";
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
      public int obtenerIdDepartamento(JComboBox combo)
    {
        int id = 0;
        sSQL = "SELECT idDepartamento FROM Departamento WHERE nombredepa='" +
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
    
    public boolean insertar(vdepartamento dts){
        sSQL="insert into Departamento (nombredepa,barriodepa,idPais) "+
                "values (?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombredepa());
            pst.setString(2, dts.getBarriodepa());
            
            pst.setInt(3, dts.getIdPais());
           
            
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
    
    public boolean editar(vdepartamento dts){
        sSQL="update Departamento set nombredepa=?,barriodepa=?,idPais=? " +
                "where idDepartamento=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombredepa());
            pst.setString(2, dts.getBarriodepa());
           
            pst.setInt(3, dts.getIdPais());
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
    
    public boolean eliminar(vdepartamento dts){
        sSQL = "delete from Departamento where idDepartamento=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdDepartamento());
            
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
