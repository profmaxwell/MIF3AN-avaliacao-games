package com.mobile.pacifier.model;

public class Usuario {

    private Long Cpf;
    private String Nome;
    private String Sobrenome;
    private String Email;
    private String Celular;
    private String Senha;

    private String genero;

    public Usuario() {
    }

    public Usuario(String email, String senha) {
        Email = email;
        Senha = senha;
    }

    public Usuario(Long cpf, String nome, String sobrenome, String email, String celular, String senha, String genero) {
        Cpf = cpf;
        Nome = nome;
        Sobrenome = sobrenome;
        Email = email;
        Celular = celular;
        Senha = senha;
        this.genero = genero;
    }

    public Long getCpf() {
        return Cpf;
    }

    public void setCpf(Long cpf) {
        Cpf = cpf;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        Sobrenome = sobrenome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
