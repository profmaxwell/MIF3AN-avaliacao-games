package com.mobile.pacifier.model;

public class Anuncio {

    private Long codAnuncio;
    private String nomeAnuncio;
    private String descAnuncio;
    private Double valorAnuncio;
    private Integer quantAnuncio;
    private Boolean statusAnuncio;
    private String generoAnuncio;
    private Long cpfUsuario;

    private Boolean statusPedido;
    private String nomeVendedor;

    public Anuncio() {
    }

    public Anuncio(Long codAnuncio, String nomeAnuncio, String descAnuncio, Double valorAnuncio, Integer quantAnuncio, Boolean statusAnuncio, String generoAnuncio, Long cpfUsuario, Boolean statusPedido, String nomeVendedor) {
        this.codAnuncio = codAnuncio;
        this.nomeAnuncio = nomeAnuncio;
        this.descAnuncio = descAnuncio;
        this.valorAnuncio = valorAnuncio;
        this.quantAnuncio = quantAnuncio;
        this.statusAnuncio = statusAnuncio;
        this.generoAnuncio = generoAnuncio;
        this.cpfUsuario = cpfUsuario;
        this.statusPedido = statusPedido;
        this.nomeVendedor = nomeVendedor;
    }

    public Long getCodAnuncio() {
        return codAnuncio;
    }

    public void setCodAnuncio(Long codAnuncio) {
        this.codAnuncio = codAnuncio;
    }

    public String getNomeAnuncio() {
        return nomeAnuncio;
    }

    public void setNomeAnuncio(String nomeAnuncio) {
        this.nomeAnuncio = nomeAnuncio;
    }

    public String getDescAnuncio() {
        return descAnuncio;
    }

    public void setDescAnuncio(String descAnuncio) {
        this.descAnuncio = descAnuncio;
    }

    public Double getValorAnuncio() {
        return valorAnuncio;
    }

    public void setValorAnuncio(Double valorAnuncio) {
        this.valorAnuncio = valorAnuncio;
    }

    public Integer getQuantAnuncio() {
        return quantAnuncio;
    }

    public void setQuantAnuncio(Integer quantAnuncio) {
        this.quantAnuncio = quantAnuncio;
    }

    public Boolean getStatusAnuncio() {
        return statusAnuncio;
    }

    public void setStatusAnuncio(Boolean statusAnuncio) {
        this.statusAnuncio = statusAnuncio;
    }

    public String getGeneroAnuncio() {
        return generoAnuncio;
    }

    public void setGeneroAnuncio(String generoAnuncio) {
        this.generoAnuncio = generoAnuncio;
    }

    public Long getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(Long cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public Boolean getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(Boolean statusPedido) {
        this.statusPedido = statusPedido;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }
}
