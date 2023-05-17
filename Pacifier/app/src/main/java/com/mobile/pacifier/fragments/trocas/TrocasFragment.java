package com.mobile.pacifier.fragments.trocas;

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
import com.mobile.pacifier.adapters.AdapterTroca;
import com.mobile.pacifier.model.PedidoTroca;
import com.mobile.pacifier.services.TrocaService;

import java.util.ArrayList;
import java.util.List;


public class TrocasFragment extends Fragment {

    private RecyclerView recyclerTroca;
    private TrocaService trocaService;

    Long cpf = null;
    private List<PedidoTroca> trocas = new ArrayList<>();
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    public TrocasFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trocas, container, false);

        recyclerTroca = view.findViewById(R.id.recyclerTroca);
        trocaService = new TrocaService();

        // Define o layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerTroca.setLayoutManager(layoutManager);

        // Recuperar usuario
        SharedPreferences preferences = getActivity().getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        if (preferences.contains("cpfUsuarioLogado")) {
            cpf = preferences.getLong("cpfUsuarioLogado", 0);
        }

        // Lista de trocas
        //trocas = trocaService.listarTrocaByPedido(cpf);

        //LoadDataTaskTroca loadDataTaskTroca = new LoadDataTaskTroca();
        //loadDataTaskTroca.execute();

        // Define o adapter
        //AdapterTroca adapterTroca = new AdapterTroca(trocas);
        //recyclerTroca.setAdapter(adapterTroca);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        LoadDataTaskTroca loadDataTaskTroca = new LoadDataTaskTroca();
        loadDataTaskTroca.execute();
    }

    private class LoadDataTaskTroca extends AsyncTask<Void, Void, List<PedidoTroca>> {

        private Dialog dialog;

        @Override
        protected void onPreExecute() {
            // Mostra o progresso na tela
            dialog = new Dialog(getActivity());
            dialog.setContentView(R.layout.tela_carregamento);
            dialog.show();
        }

        @Override
        protected List<PedidoTroca> doInBackground(Void... voids) {

            trocas = trocaService.listarTrocaByPedido(cpf);

            return trocas;
        }

        @Override
        protected void onPostExecute(List<PedidoTroca> result) {
            // Esconde o progresso da tela
            dialog.dismiss();

            // Define adapter
            AdapterTroca adapterTroca = new AdapterTroca(trocas);
            recyclerTroca.setAdapter(adapterTroca);
        }
    }
}