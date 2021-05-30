package com.example.mymusicmp3.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerPlayDanhSachAdapter extends FragmentPagerAdapter {
    public final ArrayList<Fragment> mangFragmentList = new ArrayList<>();
    public ViewPagerPlayDanhSachAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mangFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mangFragmentList.size();
    }
    public void AddFragment(Fragment fragment){
        mangFragmentList.add(fragment);
    }
}
