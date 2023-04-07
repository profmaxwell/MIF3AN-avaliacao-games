package com.mobile.pacifier.services;

import com.mobile.pacifier.model.Usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UsuarioService {

    void saveUsuario(Usuario usuario);

    void deleteUsuario(Usuario usuario);

    @GET("users/{id}")
    Usuario getUserById(@Path("cpf") int id);

    @POST("login")
    Call<Usuario> loginUser(@Body Usuario usuario);

}
