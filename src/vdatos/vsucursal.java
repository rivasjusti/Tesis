/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vdatos;

/**
 *
 * @author Justi
 */
public class vsucursal {
    private int idSucursal;
    private String descripcion;
    private String direccion;
    private int telefono;
    private int idDepartamento;

    public vsucursal() {
    }

    public vsucursal(int idSucursal, String descripcion, String direccion, int telefono, int idDepartamento) {
        this.idSucursal = idSucursal;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.idDepartamento = idDepartamento;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

   
    
}
