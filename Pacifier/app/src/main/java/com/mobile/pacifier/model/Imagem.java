package com.mobile.pacifier.model;

public class Imagem {

    private Long codImagem;
    private String name;
    private String type;
    private Long size;
    private String location;
    private String url;

    public Imagem() {
    }

    public Imagem(Long codImagem, String name, String type, Long size, String location, String url) {
        this.codImagem = codImagem;
        this.name = name;
        this.type = type;
        this.size = size;
        this.location = location;
        this.url = url;
    }

    public Long getCodImagem() {
        return codImagem;
    }

    public void setCodImagem(Long codImagem) {
        this.codImagem = codImagem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
