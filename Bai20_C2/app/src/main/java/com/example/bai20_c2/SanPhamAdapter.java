package com.example.bai20_c2;


import android.app.Activity;
import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SanPhamAdapter extends BaseAdapter {

    ArrayList<SanPham> arr;
    Activity context;
    public SanPhamAdapter(@NonNull Activity  context, int resource, ArrayList<SanPham> arr) {
        super();
        this.context=context;
        this.arr=arr;
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public SanPham getItem(int i) {
        return arr.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull  ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        LayoutInflater inflater=this.context.getLayoutInflater();
        View row=inflater.inflate(R.layout.customlayout,null);

        ImageView imgHinhSanPham=(ImageView)row.findViewById(R.id.imageViewHinh);
        TextView txtTenSanPham=(TextView)row.findViewById(R.id.textviewSanPham);

        int resourceId = context.getResources().getIdentifier(
                arr.get(position).getTenHinh(), "drawable", context.getPackageName());
        imgHinhSanPham.setImageResource(resourceId);
        txtTenSanPham.setText(arr.get(position).getTenSanPham());
        return row;
    }
}
