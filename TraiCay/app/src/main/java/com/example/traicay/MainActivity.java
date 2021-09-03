package com.example.traicay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvTraiCay;
    ArrayList<TraiCay> arrayTraiCay;
    TraiCayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        adapter = new TraiCayAdapter(this, R.layout.dong_trai_cay, arrayTraiCay);
        lvTraiCay.setAdapter(adapter);
    }

    private void AnhXa(){
        lvTraiCay = (ListView) findViewById(R.id.listviewTraiCay);
        arrayTraiCay = new ArrayList<>();

        arrayTraiCay.add(new TraiCay("Dâu Tây", "Dâu Tây Đà Lạt", "200.000 VNĐ", R.drawable.dau));
        arrayTraiCay.add(new TraiCay("Chuối", " Chuối Vàng Thái Lan", "50.000 VNĐ", R.drawable.chuoi));
        arrayTraiCay.add(new TraiCay("Táo Mỹ", "Nhập khẩu từ Mỹ", "200.000 VNĐ", R.drawable.tao));
        arrayTraiCay.add(new TraiCay("Thanh Long", " Thanh Long ruột đỏ Tiền Giang","150.000 VNĐ", R.drawable.thanhlong));
        arrayTraiCay.add(new TraiCay("Xoài", "Xoài Cát Hòa Lộc xuất khẩu", "120.000 VNĐ", R.drawable.xoai));
        arrayTraiCay.add(new TraiCay("Cam", "Cam Sành Vĩnh Long", "50.000 VNĐ", R.drawable.cam));
    }
}