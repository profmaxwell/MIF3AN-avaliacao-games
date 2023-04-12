package com.mobile.pacifier.model;

public class ItemPedido {

    private Long codPedido;
    private Long codAnuncio;
    private Integer quantidade;
    private Double preco;
    private String statusPedido;

    public ItemPedido() {
    }

    public ItemPedido(Long codPedido, Long codAnuncio, Integer quantidade, Double preco, String statusPedido) {
        this.codPedido = codPedido;
        this.codAnuncio = codAnuncio;
        this.quantidade = quantidade;
        this.preco = preco;
        this.statusPedido = statusPedido;
    }

    public Long getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(Long codPedido) {
        this.codPedido = codPedido;
    }

    public Long getCodAnuncio() {
        return codAnuncio;
    }

    public void setCodAnuncio(Long codAnuncio) {
        this.codAnuncio = codAnuncio;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }
}
