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
}
