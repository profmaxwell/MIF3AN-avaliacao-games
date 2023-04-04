package com.mobile.pacifier.fragments.compras;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.pacifier.R;
import com.mobile.pacifier.adapters.AdapterCompra;

public class ComprasFragment extends Fragment {

    private RecyclerView recyclerCompra;

    public ComprasFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_compras, container, false);

        recyclerCompra = view.findViewById(R.id.recyclerCompra);

        // Define layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerCompra.setLayoutManager(layoutManager);
        recyclerCompra.setHasFixedSize(true);

        // Define adapter
        AdapterCompra adapterCompra = new AdapterCompra();
        recyclerCompra.setAdapter(adapterCompra);

        return view;
    }
}