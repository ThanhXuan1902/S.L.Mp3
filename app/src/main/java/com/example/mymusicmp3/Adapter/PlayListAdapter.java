package com.example.mymusicmp3.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mymusicmp3.Model.Play;
import com.example.mymusicmp3.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlayListAdapter extends ArrayAdapter<Play> {
    public PlayListAdapter(@NonNull Context context, int resource, @NonNull List<Play> objects) {
        super(context, resource, objects);
    }
    class ViewHolder{
        TextView txttilePlayList;
        ImageView imageViewBackgroundplayList,imageViewiconplayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.dong_playlist,null);
            viewHolder = new ViewHolder();
            viewHolder.txttilePlayList = convertView.findViewById(R.id.txt_title_playlist);
            viewHolder.imageViewBackgroundplayList = convertView.findViewById(R.id.img_view_background_playlist);
            viewHolder.imageViewiconplayList = convertView.findViewById(R.id.img_view_icon_playlist);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Play playList = getItem(position);
        Picasso.with(getContext()).load(playList.getHinhPlayList()).into(viewHolder.imageViewBackgroundplayList);
        Picasso.with(getContext()).load(playList.getIcon()).into(viewHolder.imageViewiconplayList);
        viewHolder.txttilePlayList.setText(playList.getTen());
        return convertView;
    }
}
