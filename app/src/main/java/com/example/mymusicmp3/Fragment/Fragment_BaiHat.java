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

import com.example.mymusicmp3.Adapter.BaiHatYeuThichAdapter;
import com.example.mymusicmp3.Model.Baihatyeuthich;
import com.example.mymusicmp3.R;
import com.example.mymusicmp3.Service.APIService;
import com.example.mymusicmp3.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_BaiHat extends Fragment {

    View view;
    RecyclerView recyclerViewBaiHatYeuThich;
    BaiHatYeuThichAdapter baiHatYeuThichAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_baihat_yeuthich,container,false);
        recyclerViewBaiHatYeuThich = view.findViewById(R.id.recyclerview_baihat_yeuthich);
        getData();
        return view;
    }

    private void getData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Baihatyeuthich>> callback = dataservice.getbaiHatYeuThich();
        callback.enqueue(new Callback<List<Baihatyeuthich>>() {
            @Override
            public void onResponse(Call<List<Baihatyeuthich>> call, Response<List<Baihatyeuthich>> response) {
                ArrayList<Baihatyeuthich> mangBaiHat = (ArrayList<Baihatyeuthich>) response.body();
                baiHatYeuThichAdapter = new BaiHatYeuThichAdapter(getActivity(),mangBaiHat);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                recyclerViewBaiHatYeuThich.setLayoutManager(linearLayoutManager);
                recyclerViewBaiHatYeuThich.setAdapter(baiHatYeuThichAdapter);
            }

            @Override
            public void onFailure(Call<List<Baihatyeuthich>> call, Throwable t) {

            }
        });
    }
}
