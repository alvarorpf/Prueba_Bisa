package com.dev.bisa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "poliza")
public class Policy {
	private long id;
    private String nombre;
    private String ap_paterno;
    private String ap_materno;
    private long product_id;
    private float valor_asegurado;
    private float prima_usd;
    private Date vig_inicio;
    private Date vig_fin;
    
    public Policy() {
    	  
    }
 
    public Policy(String nombre,String ap_paterno, String ap_materno, int product_id, float valor_asegurado, float prima_usd, Date vig_inicio, Date vig_fin) {
         this.nombre = nombre;
         this.ap_paterno = ap_paterno;
         this.ap_materno = ap_materno;
         this.product_id = product_id;
         this.valor_asegurado = valor_asegurado;
         this.prima_usd = prima_usd;
         this.vig_inicio = vig_inicio;
         this.vig_fin = vig_fin;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    @Column(name = "nombre", nullable = false)
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Column(name = "ap_paterno", nullable = false)
    public String getApPaterno() {
        return ap_paterno;
    }
    public void setApPaterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }
    
    @Column(name = "ap_materno", nullable = false)
    public String getApMaterno() {
        return ap_materno;
    }
    public void setApMaterno(String ap_materno) {
        this.ap_materno = ap_materno;
    }
    
    @Column(name = "product_id", nullable = false)
    public long getProductId() {
        return product_id;
    }
    public void setProductId(long product_id) {
        this.product_id = product_id;
    }
    
    @Column(name = "valor_asegurado", nullable = false)
    public float getValorAsegurado() {
        return valor_asegurado;
    }
    public void setValorAsegurado(float valor_asegurado) {
        this.valor_asegurado = valor_asegurado;
    }
 
    @Column(name = "prima_usd", nullable = false)
    public float getPrimaUsd() {
        return prima_usd;
    }
    public void setPrimaUsd(float prima_usd) {
        this.prima_usd = prima_usd;
    }
    
    @Column(name = "vig_inicio", nullable = false)
    public Date getVigInicio() {
        return vig_inicio;
    }
    public void setVigInicio(Date vig_inicio) {
        this.vig_inicio = vig_inicio;
    }
    
    @Column(name = "vig_fin", nullable = false)
    public Date getVigFin() {
        return vig_fin;
    }
    public void setVigFin(Date vig_fin) {
        this.vig_fin = vig_fin;
    }
    
    @Override
    public String toString() {
        return "Policy [id=" + id 
        		+ ", nombre=" + nombre 
        		+ ", ap_paterno=" + ap_paterno 
        		+ ", ap_materno=" + ap_materno
        		+ ", product_id=" + product_id 
        		+ ", valor_asegurado=" + valor_asegurado 
        		+ ", prima_usd=" + prima_usd
        		+ ", vig_inicio=" + vig_inicio 
        		+ ", vig_fin=" + vig_fin
       + "]";
    }
}
