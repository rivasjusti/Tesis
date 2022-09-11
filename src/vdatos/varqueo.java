/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vdatos;

import java.sql.Timestamp;
import java.time.DateTimeException;
import java.util.Date;
import static javax.xml.datatype.DatatypeConstants.DATETIME;

/**
 *
 * @author Justi
 */
public class varqueo {
    
    private int idarqueo;
     private int idtipotrabajador;
    private int monto_aper;
      private java.sql.Timestamp fechacierre;
    private int montocierre;
    private java.sql.Timestamp fechaaper;
    private int totalrecaudado;
  
    private int idEstado;

    public varqueo() {
    }

    public varqueo(int idarqueo, int idtipotrabajador, int monto_aper, Timestamp fechacierre, int montocierre, Timestamp fechaaper, int totalrecaudado, int idEstado) {
        this.idarqueo = idarqueo;
        this.idtipotrabajador = idtipotrabajador;
        this.monto_aper = monto_aper;
        this.fechacierre = fechacierre;
        this.montocierre = montocierre;
        this.fechaaper = fechaaper;
        this.totalrecaudado = totalrecaudado;
        this.idEstado = idEstado;
    }

    public int getIdarqueo() {
        return idarqueo;
    }

    public void setIdarqueo(int idarqueo) {
        this.idarqueo = idarqueo;
    }

    public int getIdtipotrabajador() {
        return idtipotrabajador;
    }

    public void setIdtipotrabajador(int idtipotrabajador) {
        this.idtipotrabajador = idtipotrabajador;
    }

    public int getMonto_aper() {
        return monto_aper;
    }

    public void setMonto_aper(int monto_aper) {
        this.monto_aper = monto_aper;
    }

    public Timestamp getFechacierre() {
        return fechacierre;
    }

    public void setFechacierre(Timestamp fechacierre) {
        this.fechacierre = fechacierre;
    }

    public int getMontocierre() {
        return montocierre;
    }

    public void setMontocierre(int montocierre) {
        this.montocierre = montocierre;
    }

    public Timestamp getFechaaper() {
        return fechaaper;
    }

    public void setFechaaper(Timestamp fechaaper) {
        this.fechaaper = fechaaper;
    }

    public int getTotalrecaudado() {
        return totalrecaudado;
    }

    public void setTotalrecaudado(int totalrecaudado) {
        this.totalrecaudado = totalrecaudado;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

   
    
        
   
   
   
}
