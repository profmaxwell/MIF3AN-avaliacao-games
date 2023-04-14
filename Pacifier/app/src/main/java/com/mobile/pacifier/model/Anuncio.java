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
    private Integer quantVendida;

    private String statusPedido;
    private String nomeVendedor;
    private Long codImagem;
    private String urlImagem;

    public Anuncio() {
    }

    public Anuncio(Long codAnuncio, String nomeAnuncio, String descAnuncio, Double valorAnuncio, Integer quantAnuncio, Boolean statusAnuncio, String generoAnuncio, Long cpfUsuario, String statusPedido, String nomeVendedor) {
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

    public Anuncio(Long codAnuncio, String nomeAnuncio, String descAnuncio, Double valorAnuncio, Integer quantAnuncio, Boolean statusAnuncio, String generoAnuncio, Long cpfUsuario, Integer quantVendida, String statusPedido, String nomeVendedor, Long codImagem, String urlImagem) {
        this.codAnuncio = codAnuncio;
        this.nomeAnuncio = nomeAnuncio;
        this.descAnuncio = descAnuncio;
        this.valorAnuncio = valorAnuncio;
        this.quantAnuncio = quantAnuncio;
        this.statusAnuncio = statusAnuncio;
        this.generoAnuncio = generoAnuncio;
        this.cpfUsuario = cpfUsuario;
        this.quantVendida = quantVendida;
        this.statusPedido = statusPedido;
        this.nomeVendedor = nomeVendedor;
        this.codImagem = codImagem;
        this.urlImagem = urlImagem;
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

    public Integer getQuantVendida() {
        return quantVendida;
    }

    public void setQuantVendida(Integer quantVendida) {
        this.quantVendida = quantVendida;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public Long getCodImagem() {
        return codImagem;
    }

    public void setCodImagem(Long codImagem) {
        this.codImagem = codImagem;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
