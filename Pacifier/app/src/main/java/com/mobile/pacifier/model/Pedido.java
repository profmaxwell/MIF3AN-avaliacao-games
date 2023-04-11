package com.mobile.pacifier.model;

public class Pedido {

    private Long codPedido;
    private String dataPedido;
    private Boolean statusPedido;

    public Pedido() {
    }

    public Pedido(Long codPedido, String dataPedido, Boolean statusPedido) {
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

    public Boolean getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(Boolean statusPedido) {
        this.statusPedido = statusPedido;
    }
}
