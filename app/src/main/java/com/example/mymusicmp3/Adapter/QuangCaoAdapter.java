package com.example.mymusicmp3.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.mymusicmp3.Activity.DanhbaihatActivity;
import com.example.mymusicmp3.Model.QuangCao;
import com.example.mymusicmp3.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class QuangCaoAdapter extends PagerAdapter {
    Context context;
    ArrayList<QuangCao> arrayListQuangCao;

    public QuangCaoAdapter(Context context, ArrayList<QuangCao> arrayListQuangCao) {
        this.context = context;
        this.arrayListQuangCao = arrayListQuangCao;
    }

    @Override
    public int getCount() {
        return arrayListQuangCao.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_quang_cao,null);

        ImageView imageViewBackgroundQuangCao = view.findViewById(R.id.imgView_background_dong_quang_cao);
        ImageView imageViewanhBaiHat = view.findViewById(R.id.img_quang_cao);
        TextView txttileBaiHat = view.findViewById(R.id.txt_ten_bai_hat_quang_cao);
        TextView txtNoiDung = view.findViewById(R.id.txt_noi_dung);

        Picasso.with(context).load(arrayListQuangCao.get(position).getHinhAnh()).into(imageViewBackgroundQuangCao);
        Picasso.with(context).load(arrayListQuangCao.get(position).getHinhBaiHat()).into(imageViewanhBaiHat);
        txttileBaiHat.setText(arrayListQuangCao.get(position).getTenBaiHat());
        txtNoiDung.setText(arrayListQuangCao.get(position).getNoiDung());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DanhbaihatActivity.class);
                intent.putExtra("quang_cao",arrayListQuangCao.get(position));
                context.startActivity(intent);
            }
        });

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}