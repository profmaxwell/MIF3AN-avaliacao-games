package com.mobile.pacifier.model;

public class ItemPedidoTroca {

    private Long codPedidoTroca;
    private Long codTroca;

    public ItemPedidoTroca() {
    }

    public ItemPedidoTroca(Long codPedidoTroca, Long codTroca) {
        this.codPedidoTroca = codPedidoTroca;
        this.codTroca = codTroca;
    }

    public Long getCodPedidoTroca() {
        return codPedidoTroca;
    }

    public void setCodPedidoTroca(Long codPedidoTroca) {
        this.codPedidoTroca = codPedidoTroca;
    }

    public Long getCodTroca() {
        return codTroca;
    }

    public void setCodTroca(Long codTroca) {
        this.codTroca = codTroca;
    }
}
