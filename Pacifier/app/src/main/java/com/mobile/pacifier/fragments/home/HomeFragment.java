package com.mobile.pacifier.fragments.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.pacifier.R;
import com.mobile.pacifier.adapters.AdapterHome;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerHome;

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

        // Define adapter
        AdapterHome adapterHome = new AdapterHome();
        recyclerHome.setAdapter(adapterHome);

        return view;
    }
}