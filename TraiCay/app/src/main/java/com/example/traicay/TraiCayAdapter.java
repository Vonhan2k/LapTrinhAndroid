package com.example.traicay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TraiCayAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private List<TraiCay> TraiCayList;

    public TraiCayAdapter(Context context, int layout, List<TraiCay> traiCayList) {
        this.context = context;
        this.layout = layout;
        TraiCayList = traiCayList;
    }

    @Override
    public int getCount() {
        return TraiCayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgHinh;
        TextView txtTen, txtMoTa, txtGiaBan;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            holder = new ViewHolder();

            //anh xa view

            holder.txtTen = (TextView) convertView.findViewById(R.id.textviewTen);
            holder.txtMoTa = (TextView) convertView.findViewById(R.id.textviewMoTa);
            holder.txtGiaBan = (TextView) convertView.findViewById(R.id.textviewGiaBan);
            holder.imgHinh = (ImageView) convertView.findViewById(R.id.imageviewHinh);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        //gia gia tri
        TraiCay traiCay = TraiCayList.get(position);

        holder.txtTen.setText(traiCay.getTen());
        holder.txtMoTa.setText(traiCay.getMoTa());
        holder.txtGiaBan.setText(traiCay.getGiaBan());
        holder.imgHinh.setImageResource(traiCay.getHinh());

        return convertView;
    }
}
