package com.mobile.pacifier.services;

import android.util.Log;

import com.mobile.pacifier.config.DatabaseManager;
import com.mobile.pacifier.model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthService {

    private static final String TAG = "AuthService";

    public Boolean authenticateUsuario(Usuario usuario) {

        try {
            PreparedStatement statement = DatabaseManager.getConnection().prepareStatement("SELECT * FROM usuario WHERE email=? AND senha=?");
            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getSenha());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException | ClassNotFoundException e) {
            Log.e(TAG, "Error authenticating user: " + e.getMessage());
            return false;
        }
    }

    public boolean cadastrarUsuario(Usuario usuario) {
        try {
            PreparedStatement statement = DatabaseManager.getConnection().prepareStatement("INSERT INTO usuario (nome, sobrenome, cpf, email, senha, celular) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getSobrenome());
            statement.setString(3, String.valueOf(usuario.getCpf()));
            statement.setString(4, usuario.getEmail());
            statement.setString(5, usuario.getSenha());
            statement.setString(6, usuario.getCelular());

            statement.addBatch();
            statement.executeBatch();

            statement.close();

            return true;

        } catch (SQLException ex) {
            Log.e("AuthService", "Erro ao cadastrar: " + ex.getMessage());
            return false;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkIfExists(String columnName, String value) {
        try {
            PreparedStatement statementCheck = DatabaseManager.getConnection().prepareStatement("SELECT COUNT(*) FROM Usuario WHERE " + columnName + " = ?");
            statementCheck.setString(1, value);
            ResultSet rs = statementCheck.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            return count > 0;
        } catch (Exception e) {
            Log.e(TAG, "Erro ao checar se o valor existe no banco de dados: " + e.getMessage());
            return false;
        }
    }

    public Long findByEmailAndSenha(String email, String senha) {

        Long cpf = null;

        try {
            PreparedStatement statement = DatabaseManager.getConnection().prepareStatement("SELECT * FROM usuario WHERE email=? AND senha=?");
            statement.setString(1, email);
            statement.setString(2, senha);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                cpf = rs.getLong("cpf");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return cpf;
    }
}
