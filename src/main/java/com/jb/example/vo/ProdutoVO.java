package com.jb.example.vo;

import java.math.BigDecimal;

public class ProdutoVO {
    private String nome;
    private BigDecimal preco;

    public ProdutoVO(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "ProdutoVO{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}
