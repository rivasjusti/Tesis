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
public class vpagar {
    private int idpago;
    private int cantidad;
    private int preciodeproducto;
    private Double iva;
    private Double totalpago;
    private Date fechapago;
    private String ruc;
    private int idClientes;
    private int idAccesorios;
    private int idTipoFactura;

    public vpagar() {
    }

    public vpagar(int idpago, int cantidad, int preciodeproducto, Double iva, Double totalpago, Date fechapago, String ruc, int idClientes, int idAccesorios, int idTipoFactura) {
        this.idpago = idpago;
        this.cantidad = cantidad;
        this.preciodeproducto = preciodeproducto;
        this.iva = iva;
        this.totalpago = totalpago;
        this.fechapago = fechapago;
        this.ruc = ruc;
        this.idClientes = idClientes;
        this.idAccesorios = idAccesorios;
        this.idTipoFactura = idTipoFactura;
    }

    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPreciodeproducto() {
        return preciodeproducto;
    }

    public void setPreciodeproducto(int preciodeproducto) {
        this.preciodeproducto = preciodeproducto;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getTotalpago() {
        return totalpago;
    }

    public void setTotalpago(Double totalpago) {
        this.totalpago = totalpago;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public int getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    public int getIdAccesorios() {
        return idAccesorios;
    }

    public void setIdAccesorios(int idAccesorios) {
        this.idAccesorios = idAccesorios;
    }

    public int getIdTipoFactura() {
        return idTipoFactura;
    }

    public void setIdTipoFactura(int idTipoFactura) {
        this.idTipoFactura = idTipoFactura;
    }


    
    
}
