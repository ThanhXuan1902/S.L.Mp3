package com.example.mymusicmp3.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mymusicmp3.Activity.MainActivity;
import com.example.mymusicmp3.Adapter.QuangCaoAdapter;
import com.example.mymusicmp3.Model.QuangCao;
import com.example.mymusicmp3.R;
import com.example.mymusicmp3.Service.APIService;
import com.example.mymusicmp3.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Quang_Cao extends Fragment {

    View view;
    ViewPager viewPagerQuangCao;
    CircleIndicator circleIndicatorQuangCao;
    QuangCaoAdapter quangCaoAdapter;
    //auto load
    Runnable runnable;
    Handler handler;
    int currentItem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_quang_cao,container,false);
        AnhXa();
        GetData();
        return view;
    }


    private void AnhXa() {
        viewPagerQuangCao = view.findViewById(R.id.ViewPager_quang_cao);
        circleIndicatorQuangCao = view.findViewById(R.id.circleindicator_quang_cao);
    }

    private void GetData() {
//
//        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
//        progressDialog.setTitle("Vui lòng chờ");
//        progressDialog.setMessage("Đang tải......");
//        progressDialog.setCancelable(false);
//        progressDialog.show();

        Dataservice dataservice = APIService.getService();
        Call<List<QuangCao>> mangQuangCao = dataservice.getDataQuangCao();
        mangQuangCao.enqueue(new Callback<List<QuangCao>>() {
            @Override
            public void onResponse(Call<List<QuangCao>> call, Response<List<QuangCao>> response) {
                ArrayList<QuangCao> quangCao = (ArrayList<QuangCao>) response.body();
//             Log.d("BBB", quangCao.get(0).getTenBaiHat());
                quangCaoAdapter = new QuangCaoAdapter(getActivity(),quangCao);
                viewPagerQuangCao.setAdapter(quangCaoAdapter);
                circleIndicatorQuangCao.setViewPager(viewPagerQuangCao);

                handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        currentItem = viewPagerQuangCao.getCurrentItem();
                        currentItem++;
                        if(currentItem >= viewPagerQuangCao.getAdapter().getCount()){
                            currentItem = 0;
                        }
                        viewPagerQuangCao.setCurrentItem(currentItem,true);
                        handler.postDelayed(runnable,5000);
                    }
                };
                handler.postDelayed(runnable,5000);
//                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<QuangCao>> call, Throwable t) {

            }
        });
    }
}