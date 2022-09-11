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
public class vtarjeta {
    private int idtarjeta;
    private String descrii;
    private String tipo;
    private String emisor;
    private int idbanco;

    public int getIdtarjeta() {
        return idtarjeta;
    }

    public void setIdtarjeta(int idtarjeta) {
        this.idtarjeta = idtarjeta;
    }

    public String getDescrii() {
        return descrii;
    }

    public void setDescrii(String descrii) {
        this.descrii = descrii;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public int getIdbanco() {
        return idbanco;
    }

    public void setIdbanco(int idbanco) {
        this.idbanco = idbanco;
    }

    public vtarjeta() {
    }

    public vtarjeta(int idtarjeta, String descrii, String tipo, String emisor, int idbanco) {
        this.idtarjeta = idtarjeta;
        this.descrii = descrii;
        this.tipo = tipo;
        this.emisor = emisor;
        this.idbanco = idbanco;
    }

   
    
    
    
}
