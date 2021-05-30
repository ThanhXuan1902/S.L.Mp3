package com.example.mymusicmp3.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymusicmp3.Model.Baihatyeuthich;
import com.example.mymusicmp3.R;

import java.util.ArrayList;

public class PlayNhacAdapter extends RecyclerView.Adapter<PlayNhacAdapter.ViewHolder>{

    Context context;
    ArrayList<Baihatyeuthich> mangdanhsachbaihat;

    public PlayNhacAdapter(Context context, ArrayList<Baihatyeuthich> mangdanhsachbaihat) {
        this.context = context;
        this.mangdanhsachbaihat = mangdanhsachbaihat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_play_danhsach_baihat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Baihatyeuthich baihat = mangdanhsachbaihat.get(position);
        holder.txttencasi.setText(baihat.getCaSi());
        holder.txttenbaihat.setText(baihat.getTenBaiHat());
        holder.txtindex.setText(position + 1 + "");
    }

    @Override
    public int getItemCount() {
        return mangdanhsachbaihat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtindex, txttenbaihat, txttencasi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtindex = itemView.findViewById(R.id.txt_playNhac_index);
            txttenbaihat = itemView.findViewById(R.id.textview_playnhactenbaihat);
            txttencasi = itemView.findViewById(R.id.textview_tencasi_playNhac);
        }
    }
}
