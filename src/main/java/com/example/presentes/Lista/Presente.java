package com.example.presentes.Lista;

import java.io.Serializable;

public class Presente implements Serializable {

    private String tipo;
    private String nome;
    private double preco;
    private int quantidade;

    public Presente(String tipo, String nome, int quantidade, double preco){
        this.nome = nome;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }
}
