package com.mobile.pacifier.model;

public class Imagem {

    private Long codImagem;
    private Long url;

    public Imagem(Long codImagem, Long url) {
        this.codImagem = codImagem;
        this.url = url;
    }

    public Long getCodImagem() {
        return codImagem;
    }

    public void setCodImagem(Long codImagem) {
        this.codImagem = codImagem;
    }

    public Long getUrl() {
        return url;
    }

    public void setUrl(Long url) {
        this.url = url;
    }
}
