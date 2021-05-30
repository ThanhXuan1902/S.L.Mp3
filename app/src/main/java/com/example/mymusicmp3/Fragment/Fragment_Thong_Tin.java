package com.example.mymusicmp3.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mymusicmp3.Activity.DanhsachcacplaylistActivity;
import com.example.mymusicmp3.Activity.LoginActivity;
import com.example.mymusicmp3.Activity.RegisterActivity;
import com.example.mymusicmp3.R;

public class Fragment_Thong_Tin extends Fragment {
    View view;
    Button btnDangKy,btnDangNhap;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_thong_tin,container,false);
        btnDangKy = view.findViewById(R.id.btndangky);
        btnDangNhap = view.findViewById(R.id.btndangnhap);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
