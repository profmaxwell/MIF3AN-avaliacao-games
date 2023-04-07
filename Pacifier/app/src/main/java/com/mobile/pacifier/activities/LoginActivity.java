package com.mobile.pacifier.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.mobile.pacifier.R;
import com.mobile.pacifier.model.Usuario;
import com.mobile.pacifier.services.AuthService;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText editEmail;
    private TextInputEditText editSenha;

    private AuthService authService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);

        authService = new AuthService();

    }

    public void logar(View view) {

        String email = editEmail.getText().toString();
        String senha = editSenha.getText().toString();

        Usuario usuario = new Usuario(email, senha);

        if (authService.authenticateUsuario(usuario)) {

            Intent intent = new Intent(this, NavigationActivity.class);
            startActivity(intent);

        } else {
            Snackbar.make(view, "Email ou Senha incorretos!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }
}