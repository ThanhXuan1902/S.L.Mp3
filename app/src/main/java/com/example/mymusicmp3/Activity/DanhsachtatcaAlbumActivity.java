package com.example.mymusicmp3.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.mymusicmp3.Adapter.AllAblumAdapter;
import com.example.mymusicmp3.Model.Album;
import com.example.mymusicmp3.R;
import com.example.mymusicmp3.Service.APIService;
import com.example.mymusicmp3.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtatcaAlbumActivity extends AppCompatActivity {

    Toolbar toolbardanhsachalbum;
    RecyclerView recyclerViewdanhsachalbum;
    Album album;
    AllAblumAdapter danhsachallAblumAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtatca_album);
        anhXa();
        iniit();
        GetData();
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Album>> callback = dataservice.getAllAlbum();
        callback.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> mangAlbum = (ArrayList<Album>) response.body();
                danhsachallAblumAdapter = new AllAblumAdapter(DanhsachtatcaAlbumActivity.this,mangAlbum);
                recyclerViewdanhsachalbum.setLayoutManager(new GridLayoutManager(DanhsachtatcaAlbumActivity.this,2));
                recyclerViewdanhsachalbum.setAdapter(danhsachallAblumAdapter);

            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }

    private void iniit() {
        setSupportActionBar(toolbardanhsachalbum);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Danh sách các album");
        toolbardanhsachalbum.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbardanhsachalbum.setTitleTextColor(Color.WHITE);

    }

    private void anhXa() {
        recyclerViewdanhsachalbum = findViewById(R.id.recyclerview_all_album);
        toolbardanhsachalbum = findViewById(R.id.toolbar_danhsach_all_album);
    }
}