/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vdatos;

import java.sql.Timestamp;

/**
 *
 * @author Justi
 */
public class vmovimiento {
    private int idmovi;
    private int idtipotrabajador;
    private String comentario;
    private double monto;
    private java.sql.Timestamp fechamovi;
    private int idarqueo;
    private int idTipoFactura;

    public vmovimiento() {
    }

    public vmovimiento(int idmovi, int idtipotrabajador, String comentario, double monto, Timestamp fechamovi, int idarqueo, int idTipoFactura) {
        this.idmovi = idmovi;
        this.idtipotrabajador = idtipotrabajador;
        this.comentario = comentario;
        this.monto = monto;
        this.fechamovi = fechamovi;
        this.idarqueo = idarqueo;
        this.idTipoFactura = idTipoFactura;
    }

    public int getIdmovi() {
        return idmovi;
    }

    public void setIdmovi(int idmovi) {
        this.idmovi = idmovi;
    }

    public int getIdtipotrabajador() {
        return idtipotrabajador;
    }

    public void setIdtipotrabajador(int idtipotrabajador) {
        this.idtipotrabajador = idtipotrabajador;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Timestamp getFechamovi() {
        return fechamovi;
    }

    public void setFechamovi(Timestamp fechamovi) {
        this.fechamovi = fechamovi;
    }

    public int getIdarqueo() {
        return idarqueo;
    }

    public void setIdarqueo(int idarqueo) {
        this.idarqueo = idarqueo;
    }

    public int getIdTipoFactura() {
        return idTipoFactura;
    }

    public void setIdTipoFactura(int idTipoFactura) {
        this.idTipoFactura = idTipoFactura;
    }

   
   
}
