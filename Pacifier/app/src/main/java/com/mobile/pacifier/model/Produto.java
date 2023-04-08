package com.mobile.pacifier.model;

public class Produto {

    private Long codProd;
    private String nomeProd;
    private Integer valorProd;
    private String descProd;

    private Imagem imagem;

    public Produto() {
    }

    public Produto(Long codProd, String nomeProd, Integer valorProd, String descProd, Imagem imagem) {
        this.codProd = codProd;
        this.nomeProd = nomeProd;
        this.valorProd = valorProd;
        this.descProd = descProd;
        this.imagem = imagem;
    }

    public Long getCodProd() {
        return codProd;
    }

    public void setCodProd(Long codProd) {
        this.codProd = codProd;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public Integer getValorProd() {
        return valorProd;
    }

    public void setValorProd(Integer valorProd) {
        this.valorProd = valorProd;
    }

    public String getDescProd() {
        return descProd;
    }

    public void setDescProd(String descProd) {
        this.descProd = descProd;
    }

    public Imagem getImagem() {
        return imagem;
    }

    public void setImagem(Imagem imagem) {
        this.imagem = imagem;
    }
}
