package com.mobile.pacifier.model;

public class PedidoTroca {

    private Long codPedidoTroca;
    private String dataPedidoTroca;
    private String statusRemetente;
    private String statusDestinatario;
    private String nomeTroca;
    private Long codImagem;
    private String urlImagem;

    public PedidoTroca() {
    }

    public PedidoTroca(Long codPedidoTroca, String dataPedidoTroca, String statusRemetente, String statusDestinatario) {
        this.codPedidoTroca = codPedidoTroca;
        this.dataPedidoTroca = dataPedidoTroca;
        this.statusRemetente = statusRemetente;
        this.statusDestinatario = statusDestinatario;
    }

    public PedidoTroca(Long codPedidoTroca, String dataPedidoTroca, String statusRemetente, String statusDestinatario, String nomeTroca, Long codImagem, String urlImagem) {
        this.codPedidoTroca = codPedidoTroca;
        this.dataPedidoTroca = dataPedidoTroca;
        this.statusRemetente = statusRemetente;
        this.statusDestinatario = statusDestinatario;
        this.nomeTroca = nomeTroca;
        this.codImagem = codImagem;
        this.urlImagem = urlImagem;
    }

    public Long getCodPedidoTroca() {
        return codPedidoTroca;
    }

    public void setCodPedidoTroca(Long codPedidoTroca) {
        this.codPedidoTroca = codPedidoTroca;
    }

    public String getDataPedidoTroca() {
        return dataPedidoTroca;
    }

    public void setDataPedidoTroca(String dataPedidoTroca) {
        this.dataPedidoTroca = dataPedidoTroca;
    }

    public String getStatusRemetente() {
        return statusRemetente;
    }

    public void setStatusRemetente(String statusRemetente) {
        this.statusRemetente = statusRemetente;
    }

    public String getStatusDestinatario() {
        return statusDestinatario;
    }

    public void setStatusDestinatario(String statusDestinatario) {
        this.statusDestinatario = statusDestinatario;
    }

    public String getNomeTroca() {
        return nomeTroca;
    }

    public void setNomeTroca(String nomeTroca) {
        this.nomeTroca = nomeTroca;
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
