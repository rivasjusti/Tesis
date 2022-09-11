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
public class vestados {
    private int idEstado;
    private String nombreestado;

    public vestados() {
    }

    public vestados(int idEstado, String nombreestado) {
        this.idEstado = idEstado;
        this.nombreestado = nombreestado;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombreestado() {
        return nombreestado;
    }

    public void setNombreestado(String nombreestado) {
        this.nombreestado = nombreestado;
    }
    

   
    
}
