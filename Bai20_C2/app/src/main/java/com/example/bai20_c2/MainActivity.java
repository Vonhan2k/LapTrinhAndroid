package com.example.bai20_c2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spDanhmucSP;
    ListView lvSanPham;
    /*String danhmuc[]={"Điện thoại","Máy tính","Đồng hồ"};*/
    String[] danhmuc = {"IPhone", "IPAD", "SamSung", "Xiaomi", "Oppo"};
    ArrayAdapter<String> adapterDanhmuc;
    SanPhamAdapter adapterSanPham;
    ArrayList<SanPham> arrSanPham;
    ArrayList<SanPham> arrSanPhamFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spDanhmucSP = (Spinner) findViewById(R.id.DanhmucSP);
        lvSanPham = (ListView) findViewById(R.id.lvSanPham);

        //Spinner hien thi danh muc
        adapterDanhmuc = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, danhmuc);
        adapterDanhmuc.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spDanhmucSP.setAdapter(adapterDanhmuc);
        spDanhmucSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                arrSanPhamFilter.clear();
                String dm = danhmuc[position];
                for (int k = 0; k < arrSanPham.size(); k++)
                    if (arrSanPham.get(k).getDanhMuc().equals(dm))
                        arrSanPhamFilter.add(arrSanPham.get(k));

                adapterSanPham.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        arrSanPham=new ArrayList<SanPham>();
        arrSanPham.add(new SanPham("iphone11","Iphone 11","IPhone"));
        arrSanPham.add(new SanPham("iphone12","Iphone 12","IPhone"));

        arrSanPham.add(new SanPham("xiaomi1","Xiaomi 1","Xiaomi"));
        arrSanPham.add(new SanPham("xiaomi2","Xiaomi 2","Xiaomi"));

        arrSanPham.add(new SanPham("oppo1","Oppo 1","Oppo"));
        arrSanPham.add(new SanPham("oppo2","Oppo 2","Oppo"));

        arrSanPham.add(new SanPham("ipad1","IPAD 1","IPAD"));
        arrSanPham.add(new SanPham("ipad2","IPAD 2","IPAD"));

        arrSanPham.add(new SanPham("samsung1","SamSung 1","SamSung"));
        arrSanPham.add(new SanPham("samsung2","SamSung 2","SamSung"));

        arrSanPhamFilter = new ArrayList<SanPham>();
        adapterSanPham = new SanPhamAdapter(this, 0, arrSanPhamFilter);
        lvSanPham.setAdapter(adapterSanPham);
    }
}
