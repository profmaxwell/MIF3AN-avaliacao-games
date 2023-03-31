package com.mobile.pacifier.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.mobile.pacifier.R;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void cadastrar(View view) {
        Intent intent = new Intent(CadastroActivity.this, NavigationActivity.class);
        startActivity(intent);
    }

}