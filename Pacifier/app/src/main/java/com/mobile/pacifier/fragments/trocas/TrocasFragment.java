package com.mobile.pacifier.fragments.trocas;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.pacifier.R;
import com.mobile.pacifier.adapters.AdapterTroca;
import com.mobile.pacifier.model.Troca;
import com.mobile.pacifier.services.TrocaService;

import java.util.ArrayList;
import java.util.List;


public class TrocasFragment extends Fragment {

    private RecyclerView recyclerTroca;
    private TrocaService trocaService;

    Long cpf = null;
    private List<Troca> trocas = new ArrayList<>();
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    public TrocasFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trocas, container, false);

        recyclerTroca = view.findViewById(R.id.recyclerTroca);

        // Recuperar usuario
        SharedPreferences preferences = getActivity().getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        if (preferences.contains("cpfUsuarioLogado")) {
            cpf = preferences.getLong("cpfUsuarioLogado", 0);
        }

        // Lista de trocas
        trocaService = new TrocaService();
        trocas = trocaService.listarTrocaByPedido(cpf);

        // Define o layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerTroca.setLayoutManager(layoutManager);

        // Define o adapter
        AdapterTroca adapterTroca = new AdapterTroca(trocas);
        recyclerTroca.setAdapter(adapterTroca);

        return view;
    }
}