package com.mobile.pacifier.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.pacifier.R;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.MyViewHolder> {

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_detalhe, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.textNome.setText("GTA V");
        holder.textVendedor.setText("Abner");
        holder.textValor.setText("50.65");
        holder.imageAvaliar.setImageResource(R.drawable.imagem1);

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textNome;
        private TextView textValor;
        private TextView textVendedor;
        private ImageView imageAvaliar;


        public MyViewHolder(View itemView) {
            super(itemView);
            textNome = itemView.findViewById(R.id.textNome);
            textValor = itemView.findViewById(R.id.textValor);
            textVendedor = itemView.findViewById(R.id.textNomeTroca);
            imageAvaliar = itemView.findViewById(R.id.imageTroca);
        }
    }


}
