package com.example.mymusicmp3.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mymusicmp3.Activity.DanhbaihatActivity;
import com.example.mymusicmp3.Activity.DanhsachcacplaylistActivity;
import com.example.mymusicmp3.Adapter.PlayListAdapter;
import com.example.mymusicmp3.Model.Play;
import com.example.mymusicmp3.R;
import com.example.mymusicmp3.Service.APIService;
import com.example.mymusicmp3.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Playlist extends Fragment {
    View view;
    ListView listViewPlayList;
    TextView txttitlePlayList, txtxemthemPlayList;
    PlayListAdapter playListAdapter;
    ArrayList<Play> mangPlaylist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playlist,container,false);
        anhXa();
        GetData();
        txtxemthemPlayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DanhsachcacplaylistActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    private void anhXa() {
        listViewPlayList = view.findViewById(R.id.listView_playList);
        txttitlePlayList = view.findViewById(R.id.txt_ten_playList);
        txtxemthemPlayList = view.findViewById(R.id.txt_xem_them_playlist);
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Play>> callBack = dataservice.getplayListCurrentDay();
        callBack.enqueue(new Callback<List<Play>>() {
            @Override
            public void onResponse(Call<List<Play>> call, Response<List<Play>> response) {
                mangPlaylist = (ArrayList<Play>) response.body();
                playListAdapter =new PlayListAdapter(getActivity(), android.R.layout.simple_expandable_list_item_1,mangPlaylist);
                listViewPlayList.setAdapter(playListAdapter);
                setListViewHeightBasedOnChildren(listViewPlayList);
                listViewPlayList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getActivity(), DanhbaihatActivity.class);
                        intent.putExtra("itemplayList",mangPlaylist.get(position));
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Play>> call, Throwable t) {

            }
        });
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}

