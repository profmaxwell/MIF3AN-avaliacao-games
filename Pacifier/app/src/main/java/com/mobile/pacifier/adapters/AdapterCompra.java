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
import com.mobile.pacifier.model.Anuncio;

import java.util.List;

public class AdapterCompra extends RecyclerView.Adapter<AdapterCompra.MyViewHolderCompra> {

    private List<Anuncio> listAnuncios;

    public AdapterCompra(List<Anuncio> anuncios) {
        this.listAnuncios = anuncios;
    }

    @NonNull
    @Override
    public MyViewHolderCompra onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.compra_detalhe, parent, false);

        return new MyViewHolderCompra(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderCompra holder, int position) {

        Anuncio anuncio = listAnuncios.get(position);
        holder.textNomeAnuncio.setText(anuncio.getNomeAnuncio());
        holder.textValorCompra.setText(anuncio.getValorAnuncio().toString());
        holder.textStatus.setText(anuncio.getStatusPedido());

        Cloudinary cloudinary = new Cloudinary(CloudinaryConfig.getMyConfig());
        String imageUrl = cloudinary.url().generate(anuncio.getUrlImagem());
        Glide.with(holder.itemView.getContext()).load(imageUrl).into(holder.imageAnuncio);

    }

    @Override
    public int getItemCount() {
        return listAnuncios.size();
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
