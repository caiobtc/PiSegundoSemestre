/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exemplopdv.models;

/**
 *
 * @author henri
 */
public class Produto {
    
    private int idProduto;
    private int codProduto;
    private String nomeProduto;
    private int qtdProduto;
    private float valorProduto;
    
    public Produto() {
    }

    public Produto(int codProduto, String nomeProduto, int qtdProduto, float valorProduto) {
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.qtdProduto = qtdProduto;
        this.valorProduto = valorProduto;
    }

    public Produto(int idProduto, int codProduto, String nomeProduto, int qtdProduto, float valorProduto) {
        this.idProduto = idProduto;
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.qtdProduto = qtdProduto;
        this.valorProduto = valorProduto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public float getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(float valorProduto) {
        this.valorProduto = valorProduto;
    }
      
    
}
