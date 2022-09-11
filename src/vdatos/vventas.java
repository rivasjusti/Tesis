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
public class vventas {
    private int idventas;
    private String descripcion;
    private int idAccesorios;
    private int idClientes;

    public vventas() {
    }

    public vventas(int idventas, String descripcion, int idAccesorios, int idClientes) {
        this.idventas = idventas;
        this.descripcion = descripcion;
        this.idAccesorios = idAccesorios;
        this.idClientes = idClientes;
    }

    public int getIdventas() {
        return idventas;
    }

    public void setIdventas(int idventas) {
        this.idventas = idventas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdAccesorios() {
        return idAccesorios;
    }

    public void setIdAccesorios(int idAccesorios) {
        this.idAccesorios = idAccesorios;
    }

    public int getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    
   
    
}
