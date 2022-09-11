/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vdatos;

import java.sql.Date;

/**
 *
 * @author Justi
 */
public class vllegada {
    private int idllegada;
    private Date fechallega;
    private String ordenllegada;
    private int idModelo;
    private int idClientes;
    private int idmecanico;

    public vllegada() {
    }

    public vllegada(int idllegada, Date fechallega, String ordenllegada, int idModelo, int idClientes, int idmecanico) {
        this.idllegada = idllegada;
        this.fechallega = fechallega;
        this.ordenllegada = ordenllegada;
        this.idModelo = idModelo;
        this.idClientes = idClientes;
        this.idmecanico = idmecanico;
    }

    public int getIdllegada() {
        return idllegada;
    }

    public void setIdllegada(int idllegada) {
        this.idllegada = idllegada;
    }

    public Date getFechallega() {
        return fechallega;
    }

    public void setFechallega(Date fechallega) {
        this.fechallega = fechallega;
    }

    public String getOrdenllegada() {
        return ordenllegada;
    }

    public void setOrdenllegada(String ordenllegada) {
        this.ordenllegada = ordenllegada;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public int getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    public int getIdmecanico() {
        return idmecanico;
    }

    public void setIdmecanico(int idmecanico) {
        this.idmecanico = idmecanico;
    }

  

    
}
