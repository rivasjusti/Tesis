/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vdatos;

import java.util.Date;

/**
 *
 * @author Justi
 */
public class vreclamos {
    private int idreclamos;
    private String descripcion;
    private Date fecharecla;
    private int idClientes;
    private int idModelo;

    public vreclamos() {
    }

    public vreclamos(int idreclamos, String descripcion, Date fecharecla, int idClientes, int idModelo) {
        this.idreclamos = idreclamos;
        this.descripcion = descripcion;
        this.fecharecla = fecharecla;
        this.idClientes = idClientes;
        this.idModelo = idModelo;
    }

    public int getIdreclamos() {
        return idreclamos;
    }

    public void setIdreclamos(int idreclamos) {
        this.idreclamos = idreclamos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecharecla() {
        return fecharecla;
    }

    public void setFecharecla(Date fecharecla) {
        this.fecharecla = fecharecla;
    }

    public int getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

   
}
