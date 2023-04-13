package com.mobile.pacifier.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.pacifier.R;
import com.mobile.pacifier.model.Troca;

import java.util.List;

public class AdapterTroca extends RecyclerView.Adapter<AdapterTroca.MyViewHolderTroca> {

    private List<Troca> listTrocas;

    public AdapterTroca(List<Troca> trocas) {
        this.listTrocas = trocas;
    }

    @NonNull
    @Override
    public MyViewHolderTroca onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.troca_detalhe, parent, false);

        return new MyViewHolderTroca(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderTroca holder, int position) {

        Troca troca = listTrocas.get(position);
        holder.textStatusRemetente.setText(troca.getStatusRemetente());
        holder.textStatusDestinatario.setText(troca.getStatusDestinatario());
        holder.textNomeTroca.setText(troca.getNomeTroca());
        holder.imageTroca.setImageResource(R.drawable.imagem3);

    }

    @Override
    public int getItemCount() {
        return listTrocas.size();
    }

    public class MyViewHolderTroca extends RecyclerView.ViewHolder {

        private TextView textNomeTroca;
        private TextView textStatusDestinatario;
        private TextView textStatusRemetente;
        private ImageView imageTroca;

        public MyViewHolderTroca(View itemView) {
            super(itemView);
            textNomeTroca = itemView.findViewById(R.id.textNomeTroca);
            textStatusDestinatario = itemView.findViewById(R.id.textStatusDestinatario);
            textStatusRemetente = itemView.findViewById(R.id.textStatusRemetente);
            imageTroca = itemView.findViewById(R.id.imageTroca);
        }
    }

}
