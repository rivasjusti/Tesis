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
public class vprovedor {
    
    private int idProovedor;
    private String nombrepro;
    private String telefonopro;
    private String direcionopro;
    private String rucpro;
    private Date fechaingresopro;
    private String empresapro;
    private int idDepartamento;
  
    private int idEstado;

    public vprovedor() {
    }

    public vprovedor(int idProovedor, String nombrepro, String telefonopro, String direcionopro, String rucpro, Date fechaingresopro, String empresapro, int idDepartamento, int idEstado) {
        this.idProovedor = idProovedor;
        this.nombrepro = nombrepro;
        this.telefonopro = telefonopro;
        this.direcionopro = direcionopro;
        this.rucpro = rucpro;
        this.fechaingresopro = fechaingresopro;
        this.empresapro = empresapro;
        this.idDepartamento = idDepartamento;
        this.idEstado = idEstado;
    }

    public int getIdProovedor() {
        return idProovedor;
    }

    public void setIdProovedor(int idProovedor) {
        this.idProovedor = idProovedor;
    }

    public String getNombrepro() {
        return nombrepro;
    }

    public void setNombrepro(String nombrepro) {
        this.nombrepro = nombrepro;
    }

    public String getTelefonopro() {
        return telefonopro;
    }

    public void setTelefonopro(String telefonopro) {
        this.telefonopro = telefonopro;
    }

    public String getDirecionopro() {
        return direcionopro;
    }

    public void setDirecionopro(String direcionopro) {
        this.direcionopro = direcionopro;
    }

    public String getRucpro() {
        return rucpro;
    }

    public void setRucpro(String rucpro) {
        this.rucpro = rucpro;
    }

    public Date getFechaingresopro() {
        return fechaingresopro;
    }

    public void setFechaingresopro(Date fechaingresopro) {
        this.fechaingresopro = fechaingresopro;
    }

    public String getEmpresapro() {
        return empresapro;
    }

    public void setEmpresapro(String empresapro) {
        this.empresapro = empresapro;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    
    
}
