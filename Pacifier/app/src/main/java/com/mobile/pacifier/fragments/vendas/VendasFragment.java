package com.mobile.pacifier.fragments.vendas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.pacifier.R;
import com.mobile.pacifier.adapters.AdapterVenda;

public class VendasFragment extends Fragment {

    private RecyclerView recyclerVenda;

    public VendasFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_vendas, container, false);

        recyclerVenda = view.findViewById(R.id.recyclerVenda);

        // Define o layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerVenda.setLayoutManager(layoutManager);

        // Define o adapter
        AdapterVenda adapterVenda = new AdapterVenda();
        recyclerVenda.setAdapter(adapterVenda);
        return view;
    }
}