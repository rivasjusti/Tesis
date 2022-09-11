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
public class vcliente {
    private int idClientes;
    private String nombrecli;
    private String apellidocli;
    private String direccioncli;
    private String telefono;

    private int idDepartamento;

    public vcliente() {
    }

    public vcliente(int idClientes, String nombrecli, String apellidocli, String direccioncli, String telefono, int idDepartamento) {
        this.idClientes = idClientes;
        this.nombrecli = nombrecli;
        this.apellidocli = apellidocli;
        this.direccioncli = direccioncli;
        this.telefono = telefono;
        this.idDepartamento = idDepartamento;
    }

    public int getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    public String getNombrecli() {
        return nombrecli;
    }

    public void setNombrecli(String nombrecli) {
        this.nombrecli = nombrecli;
    }

    public String getApellidocli() {
        return apellidocli;
    }

    public void setApellidocli(String apellidocli) {
        this.apellidocli = apellidocli;
    }

    public String getDireccioncli() {
        return direccioncli;
    }

    public void setDireccioncli(String direccioncli) {
        this.direccioncli = direccioncli;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    
    
}
