package com.jb.example.dto;

import java.math.BigDecimal;

public class ProdutoDTO {
    private String nome;
    private BigDecimal preco;

    public ProdutoDTO(String nome, BigDecimal preco) {
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
        return "ProdutoDTO{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}
