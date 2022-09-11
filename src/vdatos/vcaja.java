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
public class vcaja {
    private int idCaja;
    private int idClientes;
    private int idtipotrabajador;
  
    private String descri;
    private int cant;
    private int precio;
    private Date fechaventa;
    private int iva;
    private int subtotal;
    private int totalpago;
    private int idTipoFactura;
    private int idtarjeta;
    private int idAccesorios;
    private int idModelo;

    public vcaja() {
    }

    public vcaja(int idCaja, int idClientes, int idtipotrabajador, String descri, int cant, int precio, Date fechaventa, int iva, int subtotal, int totalpago, int idTipoFactura, int idtarjeta, int idAccesorios, int idModelo) {
        this.idCaja = idCaja;
        this.idClientes = idClientes;
        this.idtipotrabajador = idtipotrabajador;
        this.descri = descri;
        this.cant = cant;
        this.precio = precio;
        this.fechaventa = fechaventa;
        this.iva = iva;
        this.subtotal = subtotal;
        this.totalpago = totalpago;
        this.idTipoFactura = idTipoFactura;
        this.idtarjeta = idtarjeta;
        this.idAccesorios = idAccesorios;
        this.idModelo = idModelo;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public int getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    public int getIdtipotrabajador() {
        return idtipotrabajador;
    }

    public void setIdtipotrabajador(int idtipotrabajador) {
        this.idtipotrabajador = idtipotrabajador;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Date getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(Date fechaventa) {
        this.fechaventa = fechaventa;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getTotalpago() {
        return totalpago;
    }

    public void setTotalpago(int totalpago) {
        this.totalpago = totalpago;
    }

    public int getIdTipoFactura() {
        return idTipoFactura;
    }

    public void setIdTipoFactura(int idTipoFactura) {
        this.idTipoFactura = idTipoFactura;
    }

    public int getIdtarjeta() {
        return idtarjeta;
    }

    public void setIdtarjeta(int idtarjeta) {
        this.idtarjeta = idtarjeta;
    }

    public int getIdAccesorios() {
        return idAccesorios;
    }

    public void setIdAccesorios(int idAccesorios) {
        this.idAccesorios = idAccesorios;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }
    

    
    
}
