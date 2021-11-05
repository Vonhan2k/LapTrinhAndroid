package com.example.bai27_c2;

import android.app.Activity;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Date;

public class BaiHatAdapter extends BaseAdapter {

    ArrayList<BaiHat> arrBaiHat;
    Activity context;

    public BaiHatAdapter(@NonNull Activity  context, int resource, ArrayList<BaiHat> arrBaiHat) {
        super();
        this.context=context;
        this.arrBaiHat=arrBaiHat;
    }


    @Override
    public int getCount() {
        return arrBaiHat.size() ;
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
        View row=inflater.inflate(R.layout.custom_layout_baihat,null);

        TextView txtStt =(TextView)row.findViewById(R.id.textviewStt);
        TextView txttenBH =(TextView)row.findViewById(R.id.textviewTenBaiHat);
        TextView txtNgay =(TextView)row.findViewById(R.id.textviewNgay);

        txtStt.setText(position+1+"");
        txttenBH.setText(arrBaiHat.get(position).getTenBH());
        Date ngayRaDia=arrBaiHat.get(position).getNgayraDia();
        txtNgay.setText(DateFormat.format("dd/MM/yyyy", ngayRaDia).toString());
        return row;

    }
}
