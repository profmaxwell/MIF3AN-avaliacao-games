package com.mobile.pacifier.services;

import android.util.Log;

import com.mobile.pacifier.config.DatabaseManager;
import com.mobile.pacifier.model.Comentario;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ComentarioService {

    private static final String TAG = "ComentarioService";

    public boolean avaliarProduto(Comentario comentario) {
        try {
            PreparedStatement statement = DatabaseManager.getConnection().prepareStatement("INSERT INTO comentario (aval_comentario, comen_comentario, cod_anuncio, cpf_usuario) VALUES (?, ?, ?, ?)");
            statement.setDouble(1, comentario.getAvalComentario());
            statement.setString(2, comentario.getComenComentario());
            statement.setLong(3, comentario.getCodAnuncio());
            statement.setLong(4, comentario.getCpfUsuario());

            int linhasInseridas = statement.executeUpdate();
            statement.close();
            DatabaseManager.getConnection().close();

            if (linhasInseridas > 0) {
                return true;
            }
            return false;

        } catch (SQLException ex) {
            Log.e("ComentarioService", "Erro ao avaliar: " + ex.getMessage());
            return false;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
