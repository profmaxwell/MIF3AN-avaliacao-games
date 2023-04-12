package com.mobile.pacifier.model;

public class Comentario {

    private String comenComentario;
    private Double avalComentario;
    private Long codAnuncio;
    private Long cpfUsuario;

    public Comentario() {
    }

    public Comentario(String comenComentario, Double avalComentario, Long codAnuncio, Long cpfUsuario) {
        this.comenComentario = comenComentario;
        this.avalComentario = avalComentario;
        this.codAnuncio = codAnuncio;
        this.cpfUsuario = cpfUsuario;
    }

    public String getComenComentario() {
        return comenComentario;
    }

    public void setComenComentario(String comenComentario) {
        this.comenComentario = comenComentario;
    }

    public Double getAvalComentario() {
        return avalComentario;
    }

    public void setAvalComentario(Double avalComentario) {
        this.avalComentario = avalComentario;
    }

    public Long getCodAnuncio() {
        return codAnuncio;
    }

    public void setCodAnuncio(Long codAnuncio) {
        this.codAnuncio = codAnuncio;
    }

    public Long getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(Long cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }
}
