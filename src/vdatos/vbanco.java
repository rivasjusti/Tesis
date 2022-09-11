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
public class vbanco {
    
    private int idbanco;
    private String ruc;
    private String descri;
    private String direc;
    private String telef;
    private String email;

    public vbanco() {
    }

    public vbanco(int idbanco, String ruc, String descri, String direc, String telef, String email) {
        this.idbanco = idbanco;
        this.ruc = ruc;
        this.descri = descri;
        this.direc = direc;
        this.telef = telef;
        this.email = email;
    }

    public int getIdbanco() {
        return idbanco;
    }

    public void setIdbanco(int idbanco) {
        this.idbanco = idbanco;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
    }

    public String getTelef() {
        return telef;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
            
            
            
    
}
