package com.mobile.pacifier.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.mobile.pacifier.R;
import com.mobile.pacifier.model.Comentario;
import com.mobile.pacifier.services.ComentarioService;

public class ComentarActivity extends AppCompatActivity {

    private TextInputEditText editComentario;
    private RatingBar ratingAvaliacao;

    private ComentarioService comentarioService;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    private Long cpf = null;
    private Long codAnuncio = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentar);

        editComentario = findViewById(R.id.editComentario);
        ratingAvaliacao = findViewById(R.id.ratingAvaliacao);

        comentarioService = new ComentarioService();

        // Pega o cpf do usuario
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        if (preferences.contains("cpfUsuarioLogado")) {
            cpf = preferences.getLong("cpfUsuarioLogado", 0);
        }

        // Pega o codigo do anuncio
        Intent intent = getIntent();
        if (intent.hasExtra("codAnuncio")) {
            codAnuncio = intent.getLongExtra("codAnuncio", 0);
        }
    }

    public void avaliar(View view) {

        String comentar = editComentario.getText().toString();
        Double avaliar = Double.valueOf(ratingAvaliacao.getRating());

        if (!comentar.isEmpty()) {
            Comentario comentario = new Comentario();
            comentario.setAvalComentario(avaliar);
            comentario.setComenComentario(comentar);
            comentario.setCodAnuncio(codAnuncio);
            comentario.setCpfUsuario(cpf);
            comentarioService.avaliarProduto(comentario);

            Intent intent = new Intent(this, NavigationActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(ComentarActivity.this, "Comente algo!", Toast.LENGTH_SHORT).show();
        }

    }

}