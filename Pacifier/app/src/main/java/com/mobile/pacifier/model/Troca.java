package com.mobile.pacifier.model;

public class Troca {

    private Long cod_troca;
    private String nome_troca;
    private String desc_troca;
    private Boolean status_troca;

    private Imagem cod_imagem;
    private Cad_Produto cod_cad_produto;
    private Usuario cpf_usuario;

    public Troca(long cod_troca, String nome_troca, String desc_troca, boolean status_troca, Object cod_imagem, Object cod_cad_produto, Object cpf_usuario) {
    }

    public Troca(Long cod_troca, String nome_troca, String desc_troca, Boolean status_troca, Imagem cod_imagem, Cad_Produto cod_cad_produto, Usuario cpf_usuario) {
        this.cod_troca = cod_troca;
        this.nome_troca = nome_troca;
        this.desc_troca = desc_troca;
        this.status_troca = status_troca;
        this.cod_imagem = cod_imagem;
        this.cod_cad_produto = cod_cad_produto;
        this.cpf_usuario = cpf_usuario;
    }

    public Long getCod_troca() {
        return cod_troca;
    }

    public void setCod_troca(Long cod_troca) {
        this.cod_troca = cod_troca;
    }

    public String getNome_troca() {
        return nome_troca;
    }

    public void setNome_troca(String nome_troca) {
        this.nome_troca = nome_troca;
    }

    public String getDesc_troca() {
        return desc_troca;
    }

    public void setDesc_troca(String desc_troca) {
        this.desc_troca = desc_troca;
    }

    public Boolean getStatus_troca() {
        return status_troca;
    }

    public void setStatus_troca(Boolean status_troca) {
        this.status_troca = status_troca;
    }

    public Imagem getCod_imagem() {
        return cod_imagem;
    }

    public void setCod_imagem(Imagem cod_imagem) {
        this.cod_imagem = cod_imagem;
    }

    public Cad_Produto getCod_cad_produto() {
        return cod_cad_produto;
    }

    public void setCod_cad_produto(Cad_Produto cod_cad_produto) {
        this.cod_cad_produto = cod_cad_produto;
    }

    public Usuario getCpfUsuario() {
        return cpf_usuario;
    }

    public void setCpf_usuario(Usuario cpf_usuario) {
        this.cpf_usuario = cpf_usuario;
    }
}
