package com.example.mymusicmp3.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymusicmp3.Activity.PlayNhacActivity;
import com.example.mymusicmp3.Model.Baihatyeuthich;
import com.example.mymusicmp3.R;
import com.example.mymusicmp3.Service.APIService;
import com.example.mymusicmp3.Service.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaiHatYeuThichAdapter extends RecyclerView.Adapter<BaiHatYeuThichAdapter.ViewHolder> {

    Context context;
    ArrayList<Baihatyeuthich> baihatyeuthichArrayList;

    public BaiHatYeuThichAdapter(Context context, ArrayList<Baihatyeuthich> baihatyeuthichArrayList) {
        this.context = context;
        this.baihatyeuthichArrayList = baihatyeuthichArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dong_baihat_yeuthich,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { //gan du lieu
        Baihatyeuthich baihatyeuthich = baihatyeuthichArrayList.get(position);
        holder.txttenbaihat.setText(baihatyeuthich.getTenBaiHat());
        holder.txttencasi.setText(baihatyeuthich.getCaSi());
        Picasso.with(context).load(baihatyeuthich.getHinhBaiHat()).into(holder.imageViewHinh);
    }

    @Override
    public int getItemCount() {
        return baihatyeuthichArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txttenbaihat,txttencasi;
        ImageView imageViewHinh,imageViewLuotThich;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttenbaihat = itemView.findViewById(R.id.txt_ten_baihat);
            txttencasi = itemView.findViewById(R.id.txt_ten_casi_baihat);
            imageViewHinh = itemView.findViewById(R.id.imgView_hinhbaihat);
            imageViewLuotThich = itemView.findViewById(R.id.imgView_LuotThich);

            imageViewLuotThich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageViewLuotThich.setImageResource(R.drawable.iconloved);
                    Dataservice dataservice = APIService.getService();
                    Call<String> callback = dataservice.getCapNhatLuotThich("1", baihatyeuthichArrayList.get(getPosition()).getIdBaiHat());
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String ketqua = response.body();
                            if (ketqua.equals("Success")){
                                Toast.makeText(context,"Đã Thích Bài Hát",Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(context,"Bị Lỗi",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                    imageViewLuotThich.setEnabled(false);
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayNhacActivity.class);
                    intent.putExtra("cakhuc",baihatyeuthichArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
