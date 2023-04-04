package com.mobile.pacifier.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.pacifier.R;

public class AdapterTroca extends RecyclerView.Adapter<AdapterTroca.MyViewHolderTroca> {

    @NonNull
    @Override
    public MyViewHolderTroca onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.troca_detalhe, parent, false);

        return new MyViewHolderTroca(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderTroca holder, int position) {

        holder.textStatusRemetente.setText("AGUARDANDO ENVIO");
        holder.textStatusDestinatario.setText("TRANSPORTADORA");
        holder.textNomeTroca.setText("GTA V semi-novo 3 meses de uso");
        holder.imageTroca.setImageResource(R.drawable.imagem3);

    }

    @Override
    public int getItemCount() {
        return 6;
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
