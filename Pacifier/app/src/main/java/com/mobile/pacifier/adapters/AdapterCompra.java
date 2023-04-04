package com.mobile.pacifier.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.pacifier.R;

public class AdapterCompra extends RecyclerView.Adapter<AdapterCompra.MyViewHolderCompra> {

    @NonNull
    @Override
    public MyViewHolderCompra onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.compra_detalhe, parent, false);

        return new MyViewHolderCompra(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderCompra holder, int position) {

        holder.textNomeAnuncio.setText("Outlast 2");
        holder.textValorCompra.setText("25,65");
        holder.textStatus.setText("ENVIADO PARA TRANSPORTADORA");
        holder.imageAnuncio.setImageResource(R.drawable.imagem2);

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolderCompra extends RecyclerView.ViewHolder {

        private TextView textNomeAnuncio;
        private TextView textValorCompra;
        private ImageView imageAnuncio;
        private TextView textStatus;

        public MyViewHolderCompra(View itemView) {
            super(itemView);
            textNomeAnuncio = itemView.findViewById(R.id.textNomeVenda);
            textValorCompra = itemView.findViewById(R.id.textValorVenda);
            textStatus = itemView.findViewById(R.id.textStatusCompra);
            imageAnuncio = itemView.findViewById(R.id.imageVenda);
        }
    }

}
