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

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSachBaiHatAdapter extends RecyclerView.Adapter<DanhSachBaiHatAdapter.ViewHolder> {

    Context context;
    ArrayList<Baihatyeuthich> mangBaiHat;

    public DanhSachBaiHatAdapter(Context context, ArrayList<Baihatyeuthich> mangBaiHat) {
        this.context = context;
        this.mangBaiHat = mangBaiHat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //khoi tạo RecyclerView
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danhsach_baihat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { // gan du lieu
        Baihatyeuthich baihatyeuthich = mangBaiHat.get(position);
        holder.txttenbaihat.setText(baihatyeuthich.getTenBaiHat());
        holder.txttencasi.setText(baihatyeuthich.getCaSi());
        holder.txtdemslbaihat.setText(position + 1 + "");

    }

    @Override
    public int getItemCount() {
        return mangBaiHat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtdemslbaihat,txttenbaihat,txttencasi;
        ImageView imageViewluotthich;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtdemslbaihat = itemView.findViewById(R.id.txt_danhsach_baihat_index);
            txttenbaihat = itemView.findViewById(R.id.txt_tênbaihat_danhsach);
            txttencasi = itemView.findViewById(R.id.txt_ten_casi_danhsachbaihat);
            imageViewluotthich = itemView.findViewById(R.id.imgView_luotthich_danhsach_baihat);

            imageViewluotthich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageViewluotthich.setImageResource(R.drawable.iconloved);
                    Dataservice dataservice = APIService.getService();
                    Call<String> callback = dataservice.getCapNhatLuotThich("1", mangBaiHat.get(getPosition()).getIdBaiHat());
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
                    imageViewluotthich.setEnabled(false);
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayNhacActivity.class);
                    intent.putExtra("cakhuc",mangBaiHat.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}

