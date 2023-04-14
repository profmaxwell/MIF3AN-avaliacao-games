package com.mobile.pacifier.adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cloudinary.Cloudinary;
import com.mobile.pacifier.R;
import com.mobile.pacifier.activities.ComentarActivity;
import com.mobile.pacifier.config.CloudinaryConfig;
import com.mobile.pacifier.model.Anuncio;

import java.util.List;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.MyViewHolder> {

    private List<Anuncio> listAnuncio;

    public AdapterHome(List<Anuncio> anuncios) {
        this.listAnuncio = anuncios;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_detalhe, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Anuncio anuncio = listAnuncio.get(position);
        holder.textNome.setText(anuncio.getNomeAnuncio());
        holder.textVendedor.setText(anuncio.getNomeVendedor());
        holder.textValor.setText(anuncio.getValorAnuncio().toString());

        Cloudinary cloudinary = new Cloudinary(CloudinaryConfig.getMyConfig());
        String imageUrl = cloudinary.url().generate(anuncio.getUrlImagem());
        Glide.with(holder.itemView.getContext()).load(imageUrl).into(holder.imageAvaliar);

        Button button = holder.itemView.findViewById(R.id.buttonAvaliar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Long codAnuncio = anuncio.getCodAnuncio();
                Intent intent = new Intent(v.getContext(), ComentarActivity.class);
                intent.putExtra("codAnuncio", codAnuncio);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listAnuncio.size();
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
