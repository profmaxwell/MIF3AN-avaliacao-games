package com.mobile.pacifier.fragments.trocas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.pacifier.R;
import com.mobile.pacifier.adapters.AdapterTroca;


public class TrocasFragment extends Fragment {

    private RecyclerView recyclerTroca;

    public TrocasFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trocas, container, false);

        recyclerTroca = view.findViewById(R.id.recyclerTroca);

        // Define o layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerTroca.setLayoutManager(layoutManager);

        // Define o adapter
        AdapterTroca adapterTroca = new AdapterTroca();
        recyclerTroca.setAdapter(adapterTroca);

        return view;
    }
}