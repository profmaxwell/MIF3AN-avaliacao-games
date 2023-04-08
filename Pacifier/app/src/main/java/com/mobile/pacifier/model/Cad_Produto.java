package com.mobile.pacifier.model;

public class Cad_Produto {

    private Long codCadProd;
    private Long quantidade;
    private Boolean status;

    private Produto produto;
    private Usuario usuario;


    public Cad_Produto() {
    }

    public Cad_Produto(Long codCadProd, Long quantidade, Boolean status, Produto produto, Usuario usuario) {
        this.codCadProd = codCadProd;
        this.quantidade = quantidade;
        this.status = status;
        this.produto = produto;
        this.usuario = usuario;
    }

    public Long getCodCadProd() {
        return codCadProd;
    }

    public void setCodCadProd(Long codCadProd) {
        this.codCadProd = codCadProd;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
