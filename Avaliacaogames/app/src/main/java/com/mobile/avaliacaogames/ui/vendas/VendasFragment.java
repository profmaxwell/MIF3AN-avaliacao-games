package com.mobile.avaliacaogames.ui.vendas;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.avaliacaogames.databinding.FragmentVendasBinding;

public class VendasFragment extends Fragment {

    private FragmentVendasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentVendasBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
}