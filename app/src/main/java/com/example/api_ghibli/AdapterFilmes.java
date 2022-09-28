package com.example.api_ghibli;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterFilmes extends RecyclerView.Adapter<AdapterFilmes.ViewHolder>{

    DataFilmes[] dataFilmes;
    Context context;

    public AdapterFilmes(DataFilmes[] dataFilmes, MainActivity activity) {
        this.dataFilmes = dataFilmes;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.filme_item_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DataFilmes dataFilmesList = dataFilmes[position];
        holder.textViewNome.setText(dataFilmesList.getNomeFilme());
        holder.textViewData.setText(dataFilmesList.getDataFilme());
        holder.imageViewFilme.setImageResource(dataFilmesList.getImagemFilme());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, dataFilmesList.getNomeFilme(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataFilmes.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewNome;
        TextView textViewData;
        ImageView imageViewFilme;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewFilme = itemView.findViewById(R.id.imagePosterFilme);
            textViewNome = itemView.findViewById(R.id.txtNomeFilme);
            textViewData = itemView.findViewById(R.id.txtDataFilme);

        }
    }
}
