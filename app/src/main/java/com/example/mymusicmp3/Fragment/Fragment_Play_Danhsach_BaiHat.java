package com.example.mymusicmp3.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymusicmp3.Activity.PlayNhacActivity;
import com.example.mymusicmp3.Adapter.PlayNhacAdapter;
import com.example.mymusicmp3.R;

public class Fragment_Play_Danhsach_BaiHat extends Fragment {

    View view;
    RecyclerView recyclerview_play_danhsach_baihat;
    PlayNhacAdapter nhacAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_play_danhsach_baihat,container,false);
        recyclerview_play_danhsach_baihat = view.findViewById(R.id.recyclerview_play_danhsach_baihat);
        if (PlayNhacActivity.mangbaihat.size() > 0) {
            nhacAdapter = new PlayNhacAdapter(getActivity(), PlayNhacActivity.mangbaihat);
            recyclerview_play_danhsach_baihat.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerview_play_danhsach_baihat.setAdapter(nhacAdapter);
        }

        return view;
    }
}
