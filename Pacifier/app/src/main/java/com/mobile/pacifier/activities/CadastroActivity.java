package com.mobile.pacifier.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.mobile.pacifier.R;
import com.mobile.pacifier.model.Usuario;

public class CadastroActivity extends AppCompatActivity {

    private TextInputEditText editNome, editSobrenome, editEmail, editNum, editCpf, editSenha;
    private Button buttonCadastrar;

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
    }


    public void cadastrar(View view) {
        Intent intent = new Intent(CadastroActivity.this, NavigationActivity.class);
        startActivity(intent);
    }

    public void validarCadastroUsuario() {
        String textoNome = editNome.getText().toString();
        String textoSobrenome = editSobrenome.getText().toString();
        String textoEmail = editEmail.getText().toString();
        String textoNum = editNum.getText().toString();
        Long textoCpf = Long.valueOf(editCpf.getText().toString());
        String textoSenha = editSenha.getText().toString();

        if (!textoNome.isEmpty()) { // Verificar nome
            if (!textoSobrenome.isEmpty()) { // Verificar sobrenome
                if (!textoEmail.isEmpty()) { // Verificar email
                    if (!textoNum.isEmpty()) { // Verificar numero
                        if (!(textoCpf == null)) { // Verificar cpf
                            if (!textoSenha.isEmpty()) { // Verificar senha

                                Usuario usuario = new Usuario();
                                usuario.setCpf(textoCpf);
                                usuario.setNome(textoNome);
                                usuario.setSobrenome(textoSobrenome);
                                usuario.setEmail(textoEmail);
                                usuario.setCelular(textoNum);
                                usuario.setSenha(textoSenha);

                            } else {
                                Toast.makeText(CadastroActivity.this, "Preencha a senha!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(CadastroActivity.this, "Preencha o cpf!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(CadastroActivity.this, "Preencha o numero!", Toast.LENGTH_SHORT).show();
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