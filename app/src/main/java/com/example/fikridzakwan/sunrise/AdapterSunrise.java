package com.example.fikridzakwan.sunrise;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterSunrise extends RecyclerView.Adapter<AdapterSunrise.ViewHolder> {

    Context context;
    String[] namaGunung;
    int[] gambarGunung;

    public AdapterSunrise(Context context, String[] namaGunung, int[] gambarGunung) {
        this.context = context;
        this.namaGunung = namaGunung;
        this.gambarGunung = gambarGunung;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sunrise, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.txtNamaGunung.setText(namaGunung[i]);
        Glide.with(context).load(gambarGunung[i]).into(viewHolder.imgGambarGunung);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailSunrise.class);
                intent.putExtra("NG", namaGunung[i]);
                intent.putExtra("GG", gambarGunung[i]);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gambarGunung.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNamaGunung;
        ImageView imgGambarGunung;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNamaGunung = itemView.findViewById(R.id.txtNamaGunung);
            imgGambarGunung = itemView.findViewById(R.id.imgGambaGunung);
        }
    }
}
