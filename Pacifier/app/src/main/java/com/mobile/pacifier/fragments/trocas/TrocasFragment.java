package com.mobile.pacifier.fragments.trocas;

import android.os.Bundle;
import android.util.Log;
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
    private List<Troca> trocas = new ArrayList<>();
    private Long cpf = 89854665412L;

    public TrocasFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trocas, container, false);

        recyclerTroca = view.findViewById(R.id.recyclerTroca);

        // Lista de trocas
        trocaService = new TrocaService();
        trocas = trocaService.listarTrocas(cpf);

        // Define o layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerTroca.setLayoutManager(layoutManager);

        // Define o adapter
        AdapterTroca adapterTroca = new AdapterTroca(trocas);
        recyclerTroca.setAdapter(adapterTroca);

        for (Troca t : trocas) {
            if (t != null) {
                if (t.getNomeTroca() != null) {
                    Log.d("TROCA: ", t.getNomeTroca());
                } else {
                    Log.d("TROCA NOME: ", "Valor NULO");
                }
            } else {
                Log.d("TROCA OBJETO: ", "Valor NULO");
            }
        }

        return view;
    }
}