package com.example.mymusicmp3.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymusicmp3.Activity.DanhsachtheloaitheochudeActivity;
import com.example.mymusicmp3.Model.ChuDe;
import com.example.mymusicmp3.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhsachtatcachudeAdapter extends RecyclerView.Adapter<DanhsachtatcachudeAdapter.ViewHolder> {

    Context context;
    ArrayList<ChuDe> mangtatcachude;

    public DanhsachtatcachudeAdapter(Context context, ArrayList<ChuDe> mangtatcachude) {
        this.context = context;
        this.mangtatcachude = mangtatcachude;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_tatca_chude,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChuDe chuDe = mangtatcachude.get(position);
        Picasso.with(context).load(chuDe.getHinhChuDe()).into(holder.imageViewchude);
    }

    @Override
    public int getItemCount() {
        return mangtatcachude.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewchude;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewchude = itemView.findViewById(R.id.img_view_dong_chude);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhsachtheloaitheochudeActivity.class);
                    intent.putExtra("chude", mangtatcachude.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
