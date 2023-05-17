package com.mobile.pacifier.fragments.vendas;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.pacifier.R;
import com.mobile.pacifier.adapters.AdapterVenda;
import com.mobile.pacifier.model.Anuncio;
import com.mobile.pacifier.services.AnuncioService;

import java.util.ArrayList;
import java.util.List;

public class VendasFragment extends Fragment {

    private RecyclerView recyclerVenda;
    private AnuncioService anuncioService;

    Long cpf = null;
    List<Anuncio> anuncios = new ArrayList<>();
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    public VendasFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_vendas, container, false);

        recyclerVenda = view.findViewById(R.id.recyclerVenda);
        anuncioService = new AnuncioService();

        // Define o layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerVenda.setLayoutManager(layoutManager);

        // Pega o cpf do usuario
        SharedPreferences preferences = getActivity().getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        if (preferences.contains("cpfUsuarioLogado")) {
            cpf = preferences.getLong("cpfUsuarioLogado", 0);
        }

        // Pega lista de anuncios do usuario
        //anuncios = anuncioService.listarAnuncio(cpf);

        //LoadDataTaskVenda loadDataTaskVenda = new LoadDataTaskVenda();
        //loadDataTaskVenda.execute();

        // Define o adapter
        //AdapterVenda adapterVenda = new AdapterVenda(anuncios);
        //recyclerVenda.setAdapter(adapterVenda);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        LoadDataTaskVenda loadDataTaskVenda = new LoadDataTaskVenda();
        loadDataTaskVenda.execute();
    }

    private class LoadDataTaskVenda extends AsyncTask<Void, Void, List<Anuncio>> {

        private Dialog dialog;

        @Override
        protected void onPreExecute() {
            // Mostra o progresso na tela
            dialog = new Dialog(getActivity());
            dialog.setContentView(R.layout.tela_carregamento);
            dialog.show();
        }

        @Override
        protected List<Anuncio> doInBackground(Void... voids) {

            anuncios = anuncioService.listarAnuncio(cpf);

            return anuncios;
        }

        @Override
        protected void onPostExecute(List<Anuncio> result) {
            // Esconde o progresso da tela
            dialog.dismiss();

            // Define adapter
            AdapterVenda adapterVenda = new AdapterVenda(anuncios);
            recyclerVenda.setAdapter(adapterVenda);
        }
    }
}