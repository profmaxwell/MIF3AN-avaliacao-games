package com.mobile.pacifier.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.mobile.pacifier.R;
import com.mobile.pacifier.model.Usuario;
import com.mobile.pacifier.services.AuthService;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText editEmail;
    private TextInputEditText editSenha;
    private TextView textCadastrar;

    private AuthService authService;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);
        textCadastrar = findViewById(R.id.textCadastrar);

        authService = new AuthService();

    }

    public void logar(View view) {

        String email = editEmail.getText().toString();
        String senha = editSenha.getText().toString();

        Usuario usuario = new Usuario(email, senha);


        if (!email.isEmpty()) {
            if (!senha.isEmpty()) {

                if (authService.authenticateUsuario(usuario)) {

                    Long cpfUsuario = authService.findByEmailAndSenha(email, senha);
                    salvarCpfUsuario(cpfUsuario);

                    Intent intent = new Intent(this, NavigationActivity.class);
                    //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                } else {
                    Snackbar.make(view, "Email ou Senha incorretos!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

            } else {
                editSenha.setError("Campo obrigatório!");
            }
        } else {
            editEmail.setError("Campo obrigatório!");
        }
    }

    public void salvarCpfUsuario(Long cpf) {
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putLong("cpfUsuarioLogado", cpf);
        editor.commit();
    }

    public void redirectCadastro(View view) {
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }

}