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
import com.example.mymusicmp3.Model.TheLoai;
import com.example.mymusicmp3.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhsachtheloaitheochudeAdapter extends RecyclerView.Adapter<DanhsachtheloaitheochudeAdapter.ViewHolder>{

    Context context;
    ArrayList<TheLoai> mangalltheloai;

    public DanhsachtheloaitheochudeAdapter(Context context, ArrayList<TheLoai> mangalltheloai) {
        this.context = context;
        this.mangalltheloai = mangalltheloai;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danhsach_theloai_theo_chude,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TheLoai theLoai = mangalltheloai.get(position);
        Picasso.with(context).load(theLoai.getHinhTheLoai()).into(holder.imageViewhinhtheloai);
        holder.txttentheloai.setText(theLoai.getTenTheLoai());
    }

    @Override
    public int getItemCount() {
        return mangalltheloai.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewhinhtheloai;
        TextView txttentheloai;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewhinhtheloai = itemView.findViewById(R.id.img_view_theloai_theo_chude);
            txttentheloai = itemView.findViewById(R.id.txt_tentheloai_theo_chude);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhbaihatActivity.class);
                    intent.putExtra("idtheloai",mangalltheloai.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
