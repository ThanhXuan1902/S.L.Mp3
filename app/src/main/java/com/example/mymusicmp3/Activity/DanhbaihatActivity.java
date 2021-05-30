package com.example.mymusicmp3.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mymusicmp3.Adapter.DanhSachBaiHatAdapter;
import com.example.mymusicmp3.Model.Album;
import com.example.mymusicmp3.Model.Baihatyeuthich;
import com.example.mymusicmp3.Model.Play;
import com.example.mymusicmp3.Model.QuangCao;
import com.example.mymusicmp3.Model.TheLoai;
import com.example.mymusicmp3.R;
import com.example.mymusicmp3.Service.APIService;
import com.example.mymusicmp3.Service.Dataservice;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhbaihatActivity extends AppCompatActivity {

    QuangCao quangcao;
    Play playlist;
    TheLoai theLoai;
    Album album;
    CoordinatorLayout coordinatorLayout;
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    RecyclerView recyclerViewdanhsachbaihat;
    FloatingActionButton floatingActionButton_dsbaihat;
    ImageView imageViewhinhdanhsachbaihat;
    ArrayList<Baihatyeuthich> mangbaihat;
    DanhSachBaiHatAdapter danhSachBaiHatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhbaihat);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        anhXa();
        init();
        DataIntent();

        if (quangcao != null && !quangcao.getTenBaiHat().equals("")) {
            setValueInView(quangcao.getTenBaiHat(), quangcao.getHinhBaiHat());
            getDataQuangCao(quangcao.getIdQuangCao());
        }
        if (playlist != null && !playlist.getTen().equals("")) {
            setValueInView(playlist.getTen(), playlist.getHinhPlayList());
            getDataPlayList(playlist.getIdPlayList());
        }
        if (theLoai != null && !theLoai.getTenTheLoai().equals("")){
            setValueInView(theLoai.getTenTheLoai(), theLoai.getHinhTheLoai());
            getDataTheLoai(theLoai.getIdTheLoai());
        }
        if (album != null && !album.getTenAlbum().equals("")){
            setValueInView(album.getTenAlbum(),album.getHinhAlbum());
            getDataAlbum(album.getIdAlbum());
        }



    }

    private void getDataAlbum(String idAlbum) {
        Dataservice dataservice = APIService.getService();
        Call<List<Baihatyeuthich>> callback = dataservice.getdanhsachbaihattheoAlbum(idAlbum);
        callback.enqueue(new Callback<List<Baihatyeuthich>>() {
            @Override
            public void onResponse(Call<List<Baihatyeuthich>> call, Response<List<Baihatyeuthich>> response) {
                mangbaihat = (ArrayList<Baihatyeuthich>) response.body();
                danhSachBaiHatAdapter = new DanhSachBaiHatAdapter(DanhbaihatActivity.this, mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(DanhbaihatActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(danhSachBaiHatAdapter);
                eventClik();
            }

            @Override
            public void onFailure(Call<List<Baihatyeuthich>> call, Throwable t) {

            }
        });
    }

    private void getDataTheLoai(String idtheloai) {
        Dataservice dataservice = APIService.getService();
        Call<List<Baihatyeuthich>> callback = dataservice.getdanhsachbaihattheotheloai(idtheloai);
        callback.enqueue(new Callback<List<Baihatyeuthich>>() {
            @Override
            public void onResponse(Call<List<Baihatyeuthich>> call, Response<List<Baihatyeuthich>> response) {
                mangbaihat = (ArrayList<Baihatyeuthich>) response.body();
                danhSachBaiHatAdapter = new DanhSachBaiHatAdapter(DanhbaihatActivity.this, mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(DanhbaihatActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(danhSachBaiHatAdapter);
                eventClik();
            }

            @Override
            public void onFailure(Call<List<Baihatyeuthich>> call, Throwable t) {

            }
        });
    }


    private void getDataPlayList(String idplaylist) {
        Dataservice dataservice = APIService.getService();
        Call<List<Baihatyeuthich>> callback = dataservice.getdanhsachbaihattheoplaylist(idplaylist);
        callback.enqueue(new Callback<List<Baihatyeuthich>>() {
            @Override
            public void onResponse(Call<List<Baihatyeuthich>> call, Response<List<Baihatyeuthich>> response) {
                mangbaihat = (ArrayList<Baihatyeuthich>) response.body();
                danhSachBaiHatAdapter = new DanhSachBaiHatAdapter(DanhbaihatActivity.this, mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(DanhbaihatActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(danhSachBaiHatAdapter);
                eventClik();
            }

            @Override
            public void onFailure(Call<List<Baihatyeuthich>> call, Throwable t) {

            }
        });
    }

    private void setValueInView(String ten, String hinh) {
        collapsingToolbarLayout.setTitle(ten);
        try {
            URL url = new URL(hinh);
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
            collapsingToolbarLayout.setBackground(bitmapDrawable);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Picasso.with(this).load(hinh).into(imageViewhinhdanhsachbaihat);
    }

    private void getDataQuangCao(String idQuangCao) {
        Dataservice dataservice = APIService.getService();
        Call<List<Baihatyeuthich>> callback = dataservice.getdanhsachbaihattheoquangcao(idQuangCao);
        callback.enqueue(new Callback<List<Baihatyeuthich>>() {
            @Override
            public void onResponse(Call<List<Baihatyeuthich>> call, Response<List<Baihatyeuthich>> response) {
                mangbaihat = (ArrayList<Baihatyeuthich>) response.body();
                danhSachBaiHatAdapter = new DanhSachBaiHatAdapter(DanhbaihatActivity.this, mangbaihat);

                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(DanhbaihatActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(danhSachBaiHatAdapter);
                eventClik();
            }

            @Override
            public void onFailure(Call<List<Baihatyeuthich>> call, Throwable t) {

            }
        });

    }

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        collapsingToolbarLayout.setContentScrimColor(Color.BLACK);
        floatingActionButton_dsbaihat.setEnabled(false);
    }

    private void anhXa() {
        coordinatorLayout = findViewById(R.id.coordinatorlayout_danhsachbaihat);
        toolbar = findViewById(R.id.toolbar_danhsach);
        collapsingToolbarLayout = findViewById(R.id.collapsingToobarLayout);
        recyclerViewdanhsachbaihat = findViewById(R.id.relativeLayout_danhsachbaihat);
        imageViewhinhdanhsachbaihat = findViewById(R.id.imgView_danhsachcakhuc);
        floatingActionButton_dsbaihat = findViewById(R.id.floatingActionButton_dsbaihat);
    }

    private void DataIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("quang_cao")) {
                quangcao = (QuangCao) intent.getSerializableExtra("quang_cao");
                Toast.makeText(this, quangcao.getTenBaiHat(), Toast.LENGTH_SHORT).show();
            }
            if (intent.hasExtra("itemplayList")) {
                playlist = (Play) intent.getSerializableExtra("itemplayList");
                Toast.makeText(this, playlist.getTen(), Toast.LENGTH_SHORT).show();
            }
            if (intent.hasExtra("idtheloai")) {
                theLoai = (TheLoai) intent.getSerializableExtra("idtheloai");
            }
            if (intent.hasExtra("album")) {
                album = (Album) intent.getSerializableExtra("album");
            }

        }
    }
    private void eventClik(){
        floatingActionButton_dsbaihat.setEnabled(true);
        floatingActionButton_dsbaihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DanhbaihatActivity.this,PlayNhacActivity.class);
                intent.putExtra("cacbaihat",mangbaihat);
                startActivity(intent);
            }
        });
    }
}