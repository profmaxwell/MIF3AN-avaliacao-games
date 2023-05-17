package com.mobile.pacifier.fragments.compras;

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
import com.mobile.pacifier.adapters.AdapterCompra;
import com.mobile.pacifier.model.Anuncio;
import com.mobile.pacifier.model.ItemPedido;
import com.mobile.pacifier.model.Pedido;
import com.mobile.pacifier.services.AnuncioService;
import com.mobile.pacifier.services.PedidoService;

import java.util.ArrayList;
import java.util.List;

public class ComprasFragment extends Fragment {

    private RecyclerView recyclerCompra;

    private PedidoService pedidoService;
    private AnuncioService anuncioService;

    private Long cpf = null;
    private List<Pedido> pedidos = new ArrayList<>();
    private List<ItemPedido> itensPedidos = new ArrayList<>();
    private List<Anuncio> anuncios = new ArrayList<>();

    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";


    public ComprasFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_compras, container, false);

        recyclerCompra = view.findViewById(R.id.recyclerCompra);
        pedidoService = new PedidoService();
        anuncioService = new AnuncioService();

        // Define layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerCompra.setLayoutManager(layoutManager);
        recyclerCompra.setHasFixedSize(true);

        // Pega o cpf do usuario
        SharedPreferences preferences = getActivity().getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        if (preferences.contains("cpfUsuarioLogado")) {
            cpf = preferences.getLong("cpfUsuarioLogado", 0);
        }

        // Pega a lista de anuncios
        //anuncios = anuncioService.listarAnuncioByPedido(cpf);

        //LoadDataTaskCompra loadDataTaskCompra = new LoadDataTaskCompra();
        //loadDataTaskCompra.execute();

        // Define adapter
        //AdapterCompra adapterCompra = new AdapterCompra(anuncios);
        //recyclerCompra.setAdapter(adapterCompra);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        LoadDataTaskCompra loadDataTaskCompra = new LoadDataTaskCompra();
        loadDataTaskCompra.execute();
    }

    private class LoadDataTaskCompra extends AsyncTask<Void, Void, List<Anuncio>> {

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

            anuncios = anuncioService.listarAnuncioByPedido(cpf);

            return anuncios;
        }

        @Override
        protected void onPostExecute(List<Anuncio> result) {
            // Esconde o progresso da tela
            dialog.dismiss();

            // Define adapter
            AdapterCompra adapterCompra = new AdapterCompra(anuncios);
            recyclerCompra.setAdapter(adapterCompra);
        }
    }
}