/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vdatos;

import java.sql.Timestamp;

/**
 *
 * @author Justi
 */
public class vcierrecaja {
    private int idcaja;
    private int idtipotrabajador;
    private int idapertura;
    private double totalrecaudado;
    private java.sql.Timestamp fechacierre;
    private int idEstado;

    public vcierrecaja() {
    }

    public vcierrecaja(int idcaja, int idtipotrabajador, int idapertura, double totalrecaudado, Timestamp fechacierre, int idEstado) {
        this.idcaja = idcaja;
        this.idtipotrabajador = idtipotrabajador;
        this.idapertura = idapertura;
        this.totalrecaudado = totalrecaudado;
        this.fechacierre = fechacierre;
        this.idEstado = idEstado;
    }

    public int getIdcaja() {
        return idcaja;
    }

    public void setIdcaja(int idcaja) {
        this.idcaja = idcaja;
    }

    public int getIdtipotrabajador() {
        return idtipotrabajador;
    }

    public void setIdtipotrabajador(int idtipotrabajador) {
        this.idtipotrabajador = idtipotrabajador;
    }

    public int getIdapertura() {
        return idapertura;
    }

    public void setIdapertura(int idapertura) {
        this.idapertura = idapertura;
    }

    public double getTotalrecaudado() {
        return totalrecaudado;
    }

    public void setTotalrecaudado(double totalrecaudado) {
        this.totalrecaudado = totalrecaudado;
    }

    public Timestamp getFechacierre() {
        return fechacierre;
    }

    public void setFechacierre(Timestamp fechacierre) {
        this.fechacierre = fechacierre;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
    
    
    
}
