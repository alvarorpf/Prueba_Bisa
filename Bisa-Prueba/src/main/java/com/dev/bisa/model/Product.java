package com.dev.bisa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Product {

    private long id;
    private String nombre;
    private float valor_asegurado;
    private float prima_usd;
 
    public Product() {
  
    }
 
    public Product(String nombre, float valor_asegurado, float prima_usd) {
         this.nombre = nombre;
         this.valor_asegurado = valor_asegurado;
         this.prima_usd = prima_usd;
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

    @Override
    public String toString() {
        return "Product [id=" + id + ", nombre=" + nombre + ", valor_asegurado=" + valor_asegurado + ", prima_usd=" + prima_usd
       + "]";
    }
 
}