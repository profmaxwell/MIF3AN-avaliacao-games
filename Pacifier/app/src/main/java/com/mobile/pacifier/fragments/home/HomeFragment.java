package com.mobile.pacifier.fragments.home;

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
import com.mobile.pacifier.adapters.AdapterHome;
import com.mobile.pacifier.model.Anuncio;
import com.mobile.pacifier.model.ItemPedido;
import com.mobile.pacifier.model.Pedido;
import com.mobile.pacifier.services.AnuncioService;
import com.mobile.pacifier.services.AuthService;
import com.mobile.pacifier.services.PedidoService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerHome;

    private PedidoService pedidoService;
    private AnuncioService anuncioService;
    private AuthService authService;

    private Long cpf = null;
    private List<Pedido> pedidos = new ArrayList<>();
    private List<ItemPedido> itensPedidos = new ArrayList<>();
    private List<Anuncio> anuncios = new ArrayList<>();

    private boolean primeiraVez = true;

    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerHome = view.findViewById(R.id.recyclerHome);

        // Define layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerHome.setLayoutManager(layoutManager);

        pedidoService = new PedidoService();
        anuncioService = new AnuncioService();
        authService = new AuthService();

        // Pega o cpf do usuario
        SharedPreferences preferences = getActivity().getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        primeiraVez = preferences.getBoolean("primeiraVez", true);
        if (preferences.contains("cpfUsuarioLogado")) {
            cpf = preferences.getLong("cpfUsuarioLogado", 0);
        }


        if (primeiraVez) {
            LoadDataTask loadDataTask = new LoadDataTask();
            loadDataTask.execute();
        } else {
            try {
                anuncios = listarAnuncioDoItemPedido();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


            AdapterHome adapterHome = new AdapterHome(anuncios);
            recyclerHome.setAdapter(adapterHome);
        }

        return view;
    }

    private class LoadDataTask extends AsyncTask<Void, Void, List<Anuncio>> {

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
            List<Anuncio> listAnuncios = new ArrayList<>();

            anuncios = listAnuncios;

            pedidos = pedidoService.listarPedido(cpf);

            for (Pedido p : pedidos) {
                List<ItemPedido> itens = new ArrayList<>();
                try {
                    itens = pedidoService.listarItemPedido(p.getCodPedido());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                for (ItemPedido ip : itens) {
                    ip.setStatusPedido(p.getStatusPedido());
                    itensPedidos.addAll(itens);
                }
            }

            for (ItemPedido ip : itensPedidos) {
                Anuncio anuncio = new Anuncio();
                anuncio = anuncioService.listarAnuncioAndNomePorCodAnuncio(ip.getCodAnuncio());
                //anuncio.setNomeVendedor(authService.nomeVendedorPorCpf(anuncio.getCpfUsuario()));
                anuncio.setStatusPedido(ip.getStatusPedido());
                listAnuncios.add(anuncio);
            }

            return listAnuncios;
        }

        @Override
        protected void onPostExecute(List<Anuncio> result) {
            // Esconde o progresso da tela
            dialog.dismiss();

            // Define adapter com os dados carregados
            AdapterHome adapterHome = new AdapterHome(result);
            recyclerHome.setAdapter(adapterHome);

            // Atualiza o valor do SharedPreferences
            SharedPreferences.Editor editor = getActivity().getSharedPreferences(ARQUIVO_PREFERENCIA, 0).edit();
            editor.putBoolean("primeiraVez", false);
            editor.apply();
        }
    }

    public List<Anuncio> listarAnuncioDoItemPedido() throws SQLException, ClassNotFoundException {
        List<Anuncio> listAnuncios = new ArrayList<>();

        pedidos = pedidoService.listarPedido(cpf);

        for (Pedido p : pedidos) {
            List<ItemPedido> itens = new ArrayList<>();
            itens = pedidoService.listarItemPedido(p.getCodPedido());
            for (ItemPedido ip : itens) {
                ip.setStatusPedido(p.getStatusPedido());
                itensPedidos.addAll(itens);
            }
        }

        for (ItemPedido ip : itensPedidos) {
            Anuncio anuncio = new Anuncio();
            anuncio = anuncioService.listarAnuncioAndNomePorCodAnuncio(ip.getCodAnuncio());
            //anuncio.setNomeVendedor(authService.nomeVendedorPorCpf(anuncio.getCpfUsuario()));
            anuncio.setStatusPedido(ip.getStatusPedido());
            listAnuncios.add(anuncio);
        }

        return listAnuncios;
    }
}