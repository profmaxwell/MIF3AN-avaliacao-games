package com.mobile.pacifier.fragments.vendas;

import android.content.SharedPreferences;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_vendas, container, false);

        recyclerVenda = view.findViewById(R.id.recyclerVenda);

        // Pega o cpf do usuario
        SharedPreferences preferences = getActivity().getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        if (preferences.contains("cpfUsuarioLogado")) {
            cpf = preferences.getLong("cpfUsuarioLogado", 0);
        }

        // Pega lista de anuncios do usuario
        anuncioService = new AnuncioService();
        anuncios = anuncioService.listarAnuncio(cpf);

        // Define o layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerVenda.setLayoutManager(layoutManager);

        // Define o adapter
        AdapterVenda adapterVenda = new AdapterVenda(anuncios);
        recyclerVenda.setAdapter(adapterVenda);

        return view;
    }
}