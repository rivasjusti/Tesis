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
public class vreparacion {
    private int Idreparacion;
    private String problema;
    private int manodeobra;
    private String garantia;
   
   
    private int idModelo;
    private int idmecanico;
    private int idClientes;
    private int idTipoFactura;
    private int idAccesorios;

    public vreparacion() {
    }

    public vreparacion(int Idreparacion, String problema, int manodeobra, String garantia, int idModelo, int idmecanico, int idClientes, int idTipoFactura, int idAccesorios) {
        this.Idreparacion = Idreparacion;
        this.problema = problema;
        this.manodeobra = manodeobra;
        this.garantia = garantia;
        this.idModelo = idModelo;
        this.idmecanico = idmecanico;
        this.idClientes = idClientes;
        this.idTipoFactura = idTipoFactura;
        this.idAccesorios = idAccesorios;
    }

    public int getIdreparacion() {
        return Idreparacion;
    }

    public void setIdreparacion(int Idreparacion) {
        this.Idreparacion = Idreparacion;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public int getManodeobra() {
        return manodeobra;
    }

    public void setManodeobra(int manodeobra) {
        this.manodeobra = manodeobra;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public int getIdmecanico() {
        return idmecanico;
    }

    public void setIdmecanico(int idmecanico) {
        this.idmecanico = idmecanico;
    }

    public int getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    public int getIdTipoFactura() {
        return idTipoFactura;
    }

    public void setIdTipoFactura(int idTipoFactura) {
        this.idTipoFactura = idTipoFactura;
    }

    public int getIdAccesorios() {
        return idAccesorios;
    }

    public void setIdAccesorios(int idAccesorios) {
        this.idAccesorios = idAccesorios;
    }

   
}
