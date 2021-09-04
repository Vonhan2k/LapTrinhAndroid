package com.example.hinhanh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gvHinhAnh;
    ArrayList<HinhAnh> arrayImage;
    HinhAnhAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        adapter = new HinhAnhAdapter(this, R.layout.dong_hinh_anh, arrayImage);
        gvHinhAnh.setAdapter(adapter);

        gvHinhAnh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arrayImage.get(position).getTen(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void AnhXa(){
       gvHinhAnh = (GridView) findViewById(R.id.gridviewHinhAnh);
       arrayImage = new ArrayList<>();
       arrayImage.add(new HinhAnh("Hình số 1", R.drawable.android1));
       arrayImage.add(new HinhAnh("Hình số 2", R.drawable.android2));
       arrayImage.add(new HinhAnh("Hình số 3", R.drawable.android3));
       arrayImage.add(new HinhAnh("Hình số 4", R.drawable.android4));
       arrayImage.add(new HinhAnh("Hình số 5", R.drawable.android5));
       arrayImage.add(new HinhAnh("Hình số 6", R.drawable.android6));
       arrayImage.add(new HinhAnh("Hình số 7", R.drawable.android7));
       arrayImage.add(new HinhAnh("Hình số 8", R.drawable.android8));
       arrayImage.add(new HinhAnh("Hình số 9", R.drawable.android9));
    }
}