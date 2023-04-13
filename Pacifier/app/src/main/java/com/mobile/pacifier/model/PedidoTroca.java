package com.mobile.pacifier.model;

public class PedidoTroca {

    private Long codPedidoTroca;
    private String dataPedidoTroca;
    private String statusRemetente;
    private String statusDestinatario;

    public PedidoTroca() {
    }

    public PedidoTroca(Long codPedidoTroca, String dataPedidoTroca, String statusRemetente, String statusDestinatario) {
        this.codPedidoTroca = codPedidoTroca;
        this.dataPedidoTroca = dataPedidoTroca;
        this.statusRemetente = statusRemetente;
        this.statusDestinatario = statusDestinatario;
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
}