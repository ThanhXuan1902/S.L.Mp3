package com.example.mymusicmp3.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymusicmp3.Activity.DanhbaihatActivity;
import com.example.mymusicmp3.Model.Album;
import com.example.mymusicmp3.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AllAblumAdapter extends RecyclerView.Adapter<AllAblumAdapter.ViewHolder>{

    Context context;
    ArrayList<Album> mangallalbums;

    public AllAblumAdapter(Context context, ArrayList<Album> mangallalbums) {
        this.context = context;
        this.mangallalbums = mangallalbums;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danhsach_tatca_album,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = mangallalbums.get(position);
        Picasso.with(context).load(album.getHinhAlbum()).into(holder.imageViewhinhalbum);
        holder.txttenalbum.setText(album.getTenAlbum());
        holder.txttencasialbum.setText(album.getTenCaSiAlbum());
    }

    @Override
    public int getItemCount() {
        return mangallalbums.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewhinhalbum;
        TextView txttenalbum;
        TextView txttencasialbum;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewhinhalbum = itemView.findViewById(R.id.img_view_danhsach_album);
            txttenalbum = itemView.findViewById(R.id.txt_ten_album);
            txttencasialbum = itemView.findViewById(R.id.txt_tencasi_allalbum);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,DanhbaihatActivity.class);
                    intent.putExtra("album", mangallalbums.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
