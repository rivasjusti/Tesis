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
public class vaperturar {
    private int idaapertura;
    private int idtipotrabajador;
    private double montoaper;
    private java.sql.Timestamp fechaaper;

    public vaperturar() {
    }

    public vaperturar(int idaapertura, int idtipotrabajador, double montoaper, Timestamp fechaaper) {
        this.idaapertura = idaapertura;
        this.idtipotrabajador = idtipotrabajador;
        this.montoaper = montoaper;
        this.fechaaper = fechaaper;
    }

    public int getIdaapertura() {
        return idaapertura;
    }

    public void setIdaapertura(int idaapertura) {
        this.idaapertura = idaapertura;
    }

    public int getIdtipotrabajador() {
        return idtipotrabajador;
    }

    public void setIdtipotrabajador(int idtipotrabajador) {
        this.idtipotrabajador = idtipotrabajador;
    }

    public double getMontoaper() {
        return montoaper;
    }

    public void setMontoaper(double montoaper) {
        this.montoaper = montoaper;
    }

    public Timestamp getFechaaper() {
        return fechaaper;
    }

    public void setFechaaper(Timestamp fechaaper) {
        this.fechaaper = fechaaper;
    }

  
    
    
}
