package com.mobile.pacifier.model;

public class Troca {

    private Long codTroca;
    private String nomeTroca;
    private String descTroca;
    private Boolean statusTroca;
    private String statusRemetente;
    private String statusDestinatario;

    private Long codImagem;
    private String urlImagem;


    public Troca() {
    }

    public Troca(Long codTroca, String nomeTroca, String descTroca, Boolean statusTroca) {
        this.codTroca = codTroca;
        this.nomeTroca = nomeTroca;
        this.descTroca = descTroca;
        this.statusTroca = statusTroca;
    }

    public Troca(Long codTroca, String nomeTroca, String descTroca, Boolean statusTroca, String statusRemetente, String statusDestinatario) {
        this.codTroca = codTroca;
        this.nomeTroca = nomeTroca;
        this.descTroca = descTroca;
        this.statusTroca = statusTroca;
        this.statusRemetente = statusRemetente;
        this.statusDestinatario = statusDestinatario;
    }

    public Troca(Long codTroca, String nomeTroca, String descTroca, Boolean statusTroca, String statusRemetente, String statusDestinatario, Long codImagem, String urlImagem) {
        this.codTroca = codTroca;
        this.nomeTroca = nomeTroca;
        this.descTroca = descTroca;
        this.statusTroca = statusTroca;
        this.statusRemetente = statusRemetente;
        this.statusDestinatario = statusDestinatario;
        this.codImagem = codImagem;
        this.urlImagem = urlImagem;
    }

    public Long getCodTroca() {
        return codTroca;
    }

    public void setCodTroca(Long codTroca) {
        this.codTroca = codTroca;
    }

    public String getNomeTroca() {
        return nomeTroca;
    }

    public void setNomeTroca(String nomeTroca) {
        this.nomeTroca = nomeTroca;
    }

    public String getDescTroca() {
        return descTroca;
    }

    public void setDescTroca(String descTroca) {
        this.descTroca = descTroca;
    }

    public Boolean getStatusTroca() {
        return statusTroca;
    }

    public void setStatusTroca(Boolean statusTroca) {
        this.statusTroca = statusTroca;
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
