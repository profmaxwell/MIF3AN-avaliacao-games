package com.mobile.pacifier.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.mobile.pacifier.R;

public class CarregamentoActivity extends AppCompatActivity {

    private CarregamentoTask carregamentoTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_carregamento);

        carregamentoTask = new CarregamentoTask();
        carregamentoTask.execute();
    }


    private class CarregamentoTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Intent intent = new Intent(CarregamentoActivity.this, NavigationActivity.class);
            startActivity(intent);
            finish();
        }
    }

    /*public class HomeFragment extends Fragment {

    private RecyclerView recyclerHome;

    private PedidoService pedidoService;
    private AnuncioService anuncioService;
    private AuthService authService;

    private Long cpf = null;
    private List<Pedido> pedidos = new ArrayList<>();
    private List<ItemPedido> itensPedidos = new ArrayList<>();
    private List<Anuncio> anuncios = new ArrayList<>();

    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerHome = view.findViewById(R.id.recyclerHome);
        pedidoService = new PedidoService();
        anuncioService = new AnuncioService();
        authService = new AuthService();

        // Pega o cpf do usuario
        SharedPreferences preferences = getActivity().getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        if (preferences.contains("cpfUsuarioLogado")) {
            cpf = preferences.getLong("cpfUsuarioLogado", 0);
        }

        // Pega a lista de anuncios
        try {
            anuncios = listarAnuncioDoItemPedido();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Define layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerHome.setLayoutManager(layoutManager);

        // Define adapter
        AdapterHome adapterHome = new AdapterHome(anuncios);
        recyclerHome.setAdapter(adapterHome);

        return view;
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
}*/
}