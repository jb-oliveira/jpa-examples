package com.jb.example.vo;

import java.time.LocalDate;

public class RelatorioVendasVO {
    private String produto;
    private Long quantidade;
    private LocalDate ultimaData;

    public RelatorioVendasVO(String produto, Long quantidade, LocalDate ultimaData) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.ultimaData = ultimaData;
    }

    public String getProduto() {
        return produto;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public LocalDate getUltimaData() {
        return ultimaData;
    }

    @Override
    public String toString() {
        return "RelatorioVendasVO{" +
                "produto='" + produto + '\'' +
                ", quantidade=" + quantidade +
                ", ultimaData=" + ultimaData +
                '}';
    }
}
