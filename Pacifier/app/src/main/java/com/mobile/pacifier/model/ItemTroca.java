package com.mobile.pacifier.model;

public class ItemTroca {

    private Long codItemTroca;
    private Long codTroca;
    private Long codProduto;

    public ItemTroca() {
    }

    public ItemTroca(Long codItemTroca, Long codTroca, Long codProduto) {
        this.codItemTroca = codItemTroca;
        this.codTroca = codTroca;
        this.codProduto = codProduto;
    }

    public Long getCodItemTroca() {
        return codItemTroca;
    }

    public void setCodItemTroca(Long codItemTroca) {
        this.codItemTroca = codItemTroca;
    }

    public Long getCodTroca() {
        return codTroca;
    }

    public void setCodTroca(Long codTroca) {
        this.codTroca = codTroca;
    }

    public Long getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Long codProduto) {
        this.codProduto = codProduto;
    }
}
