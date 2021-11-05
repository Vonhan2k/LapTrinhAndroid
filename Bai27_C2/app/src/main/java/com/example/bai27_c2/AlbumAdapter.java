package com.example.bai27_c2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class AlbumAdapter extends BaseAdapter {

    ArrayList<Album> arrAlbum;
    Activity context;

    public AlbumAdapter(@NonNull Activity  context, int resource, ArrayList<Album> arrAlbum) {
        super();
        this.context=context;
        this.arrAlbum=arrAlbum;
    }
    @Override
    public int getCount() {
        return arrAlbum.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater=this.context.getLayoutInflater();
        View row=inflater.inflate(R.layout.custom_layout_album,null);

        TextView txtStt =(TextView)row.findViewById(R.id.textviewStt);
        TextView txtmaAlbum =(TextView)row.findViewById(R.id.textviewMaAlbum);
        TextView txttenAlbum =(TextView)row.findViewById(R.id.textviewTenAlbum);

        txtStt.setText(position+1+"");
        txtmaAlbum.setText(arrAlbum.get(position).getMaAlbum());
        txttenAlbum.setText(arrAlbum.get(position).getTenAlbum());
        return row;
    }
}
