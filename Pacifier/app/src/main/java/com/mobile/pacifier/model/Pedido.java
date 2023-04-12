package com.mobile.pacifier.model;

public class Pedido {

    private Long codPedido;
    private String dataPedido;
    private String statusPedido;

    public Pedido() {
    }

    public Pedido(Long codPedido, String dataPedido, String statusPedido) {
        this.codPedido = codPedido;
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
    }

    public Long getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(Long codPedido) {
        this.codPedido = codPedido;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }
}
