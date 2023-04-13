package com.mobile.pacifier.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.mobile.pacifier.R;
import com.mobile.pacifier.model.Usuario;
import com.mobile.pacifier.services.AuthService;

public class CadastroActivity extends AppCompatActivity {

    private TextInputEditText editNome, editSobrenome, editEmail, editNum, editCpf, editSenha;
    private Button buttonCadastrar;

    private RadioButton radioMasc, radioFem, radioOutros;

    private AuthService authService;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editNome = findViewById(R.id.editNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editEmail = findViewById(R.id.editEmail);
        editNum = findViewById(R.id.editNum);
        editCpf = findViewById(R.id.editCpf);
        editSenha = findViewById(R.id.editSenha);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);
        radioMasc = findViewById(R.id.radioMasc);
        radioFem = findViewById(R.id.radioFem);
        radioOutros = findViewById(R.id.radioOutros);

        authService = new AuthService();

    }

    public void validarCadastroUsuario(View view) {
        String textoNome = editNome.getText().toString();
        String textoSobrenome = editSobrenome.getText().toString();
        String textoEmail = editEmail.getText().toString();
        String textoNum = editNum.getText().toString();
        Long textoCpf = Long.valueOf(editCpf.getText().toString());
        String textoSenha = editSenha.getText().toString();
        String textoGenero;

        if (radioMasc.isChecked()) {
            textoGenero = radioMasc.getText().toString();
        } else if (radioFem.isChecked()) {
            textoGenero = radioFem.getText().toString();
        } else if (radioOutros.isChecked()) {
            textoGenero = radioOutros.getText().toString();
        } else {
            textoGenero = "";
        }

        if (!textoNome.isEmpty()) { // Verificar nome
            if (!textoSobrenome.isEmpty()) { // Verificar sobrenome
                if (!textoEmail.isEmpty()) { // Verificar email
                    if (!(authService.checkIfExists("email", textoEmail))) { // Verifica se existe o email
                        if (!textoNum.isEmpty()) { // Verificar numero
                            if (!(authService.checkIfExists("celular", textoNum))) { // Verifica se existe o numero
                                if (!(textoCpf == null)) { // Verificar cpf
                                    if (!(authService.checkIfExists("cpf", String.valueOf(textoCpf)))) { // Verifica se existe o cpf
                                        if (!textoSenha.isEmpty()) { // Verificar senha

                                            Usuario usuario = new Usuario();
                                            usuario.setCpf(textoCpf);
                                            usuario.setNome(textoNome);
                                            usuario.setSobrenome(textoSobrenome);
                                            usuario.setEmail(textoEmail);
                                            usuario.setCelular(textoNum);
                                            usuario.setSenha(textoSenha);
                                            usuario.setGenero(textoGenero);

                                            authService.cadastrarUsuario(usuario);

                                            Intent intent = new Intent(this, LoginActivity.class);
                                            startActivity(intent);

                                        } else {
                                            Toast.makeText(CadastroActivity.this, "Preencha a senha!", Toast.LENGTH_SHORT).show();
                                        }
                                    } else {
                                        editEmail.setError("Esse CPF ja está cadastrado!");
                                    }
                                } else {
                                    Toast.makeText(CadastroActivity.this, "Preencha o cpf!", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                editEmail.setError("Esse numero ja está cadastrado!");
                            }
                        } else {
                            Toast.makeText(CadastroActivity.this, "Preencha o numero!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        editEmail.setError("Esse email ja está cadastrado!");
                    }
                } else {
                    Toast.makeText(CadastroActivity.this, "Preencha o email!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(CadastroActivity.this, "Preencha o sobrenome!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(CadastroActivity.this, "Preencha o nome!", Toast.LENGTH_SHORT).show();
        }
    }
}