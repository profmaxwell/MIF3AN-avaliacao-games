package com.mobile.avaliacaogames.ui.trocas;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.avaliacaogames.databinding.FragmentTrocasBinding;

public class TrocasFragment extends Fragment {

    private FragmentTrocasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentTrocasBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
}