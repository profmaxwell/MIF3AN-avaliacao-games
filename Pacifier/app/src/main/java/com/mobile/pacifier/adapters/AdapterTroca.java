package com.mobile.pacifier.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cloudinary.Cloudinary;
import com.mobile.pacifier.R;
import com.mobile.pacifier.config.CloudinaryConfig;
import com.mobile.pacifier.model.PedidoTroca;

import java.util.List;

public class AdapterTroca extends RecyclerView.Adapter<AdapterTroca.MyViewHolderTroca> {

    private List<PedidoTroca> listPedidoTrocas;

    public AdapterTroca(List<PedidoTroca> trocas) {
        this.listPedidoTrocas = trocas;
    }

    @NonNull
    @Override
    public MyViewHolderTroca onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.troca_detalhe, parent, false);

        return new MyViewHolderTroca(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderTroca holder, int position) {

        PedidoTroca pedidoTroca = listPedidoTrocas.get(position);
        holder.textStatusRemetente.setText(pedidoTroca.getStatusRemetente());
        holder.textStatusDestinatario.setText(pedidoTroca.getStatusDestinatario());
        holder.textNomeTroca.setText(pedidoTroca.getNomeTroca());

        Cloudinary cloudinary = new Cloudinary(CloudinaryConfig.getMyConfig());
        String imageUrl = cloudinary.url().generate(pedidoTroca.getUrlImagem());
        Glide.with(holder.itemView.getContext()).load(imageUrl).into(holder.imageTroca);

    }

    @Override
    public int getItemCount() {
        return listPedidoTrocas.size();
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
