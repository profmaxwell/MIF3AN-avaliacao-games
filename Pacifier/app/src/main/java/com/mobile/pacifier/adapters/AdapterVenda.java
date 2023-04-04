package com.mobile.pacifier.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.pacifier.R;

public class AdapterVenda extends RecyclerView.Adapter<AdapterVenda.MyViewHolderVenda> {

    @NonNull
    @Override
    public MyViewHolderVenda onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.venda_detalhe, parent, false);

        return new MyViewHolderVenda(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderVenda holder, int position) {

        holder.imageVenda.setImageResource(R.drawable.imagem4);
        holder.textNomeVenda.setText("Xbox series X");
        holder.textQuantVenda.setText("1.023");
        holder.textValorVenda.setText("3.699,50");

    }

    @Override
    public int getItemCount() {
        return 12;
    }

    public class MyViewHolderVenda extends RecyclerView.ViewHolder {

        private TextView textNomeVenda;
        private TextView textValorVenda;
        private TextView textQuantVenda;
        private ImageView imageVenda;

        public MyViewHolderVenda(View itemView) {
            super(itemView);
            textNomeVenda = itemView.findViewById(R.id.textNomeVenda);
            textValorVenda = itemView.findViewById(R.id.textValorVenda);
            textQuantVenda = itemView.findViewById(R.id.textQuantVenda);
            imageVenda = itemView.findViewById(R.id.imageVenda);
        }
    }
}
