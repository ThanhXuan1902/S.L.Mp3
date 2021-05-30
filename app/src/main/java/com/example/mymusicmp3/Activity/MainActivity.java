package com.example.mymusicmp3.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.mymusicmp3.Adapter.MainViewPagerAdapter;
import com.example.mymusicmp3.Fragment.Fragment_Thong_Tin;
import com.example.mymusicmp3.Fragment.Fragment_Thu_Muc;
import com.example.mymusicmp3.Fragment.Fragment_Tim_Kiem;
import com.example.mymusicmp3.Fragment.Fragment_Trang_Chu;
import com.example.mymusicmp3.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        init();

    }



    private void init() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new Fragment_Trang_Chu(), "Trang Chủ");
        mainViewPagerAdapter.addFragment(new Fragment_Tim_Kiem(),"Tìm Kiếm");
        mainViewPagerAdapter.addFragment(new Fragment_Thu_Muc(), "Thư Mục");
        mainViewPagerAdapter.addFragment(new Fragment_Thong_Tin(), "Thông Tin");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.icontimkiem);
        tabLayout.getTabAt(2).setIcon(R.drawable.iconthuvien);
        tabLayout.getTabAt(3).setIcon(R.drawable.iconlogo);

    }

    private void AnhXa() {
        tabLayout = (TabLayout) findViewById(R.id.activity_main_TabLayout);
        viewPager = (ViewPager) findViewById(R.id.activity_main_ViewPager);
    }
}