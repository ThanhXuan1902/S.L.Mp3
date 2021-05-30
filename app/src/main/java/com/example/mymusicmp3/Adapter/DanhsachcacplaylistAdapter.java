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
import com.example.mymusicmp3.Model.Play;
import com.example.mymusicmp3.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhsachcacplaylistAdapter extends RecyclerView.Adapter<DanhsachcacplaylistAdapter.Viewholder>{

    Context context;
    ArrayList<Play> mangplaylist;

    public DanhsachcacplaylistAdapter(Context context, ArrayList<Play> mangplaylist) {
        this.context = context;
        this.mangplaylist = mangplaylist;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danhsach_cac_playlist,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Play playlist = mangplaylist.get(position);
        Picasso.with(context).load(playlist.getHinhPlayList()).into(holder.imageViewHinhplaylist);
        holder.txttenplaylist.setText(playlist.getTen());
    }

    @Override
    public int getItemCount() {
        return mangplaylist.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        ImageView imageViewHinhplaylist;
        TextView txttenplaylist;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imageViewHinhplaylist = itemView.findViewById(R.id.img_view_danhsach_all_playlist);
            txttenplaylist = itemView.findViewById(R.id.txt_ten_dachsach_playlist);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhbaihatActivity.class);
                    intent.putExtra("itemplayList",mangplaylist.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
