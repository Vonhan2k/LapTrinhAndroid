package com.example.bai27_c2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class QuanlyBaihatActivity extends AppCompatActivity {

    Spinner spAlbum;
    EditText edtTenBH, edtNgay;
    Button btnChonNgay, btnThemBaiHat;
    ListView lvDanhSachBaiHat;

    ArrayList<Album> listAlbum;
    ArrayAdapter<Album> adapterAlbum = null;
    ArrayList<BaiHat> listBaihat=new ArrayList<>();
    BaiHatAdapter adapterbaihat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanly_baihat);

        AnhXa();


        //Hien thi danh sach Album len Spinner
       Intent intent = getIntent();
       Bundle bundle = intent.getBundleExtra("DATA");
       listAlbum = (ArrayList<Album>) bundle.getSerializable("list");
       adapterAlbum = new ArrayAdapter<Album>(this, android.R.layout.simple_spinner_item,listAlbum);
       adapterAlbum.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
       spAlbum.setAdapter(adapterAlbum);

       //Hien thi danh sach bai hat len listview
        adapterbaihat = new BaiHatAdapter(QuanlyBaihatActivity.this,android.R.layout.simple_list_item_1,listBaihat);
        lvDanhSachBaiHat.setAdapter(adapterbaihat);

        //Click Chon ngay bang DataPickerDialog
        btnChonNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();

                int ngay = calendar.get(Calendar.DATE);
                int thang = calendar.get(Calendar.MONTH);
                int nam = calendar.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(QuanlyBaihatActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(year, month, dayOfMonth);
                        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy");
                        edtNgay.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                },nam, thang, ngay);
                datePickerDialog.show();
            }
        });

        //Click Them Bai Hat
        btnThemBaiHat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenBH = edtTenBH.getText().toString().trim();
                String ngayraDia = edtNgay.getText().toString().trim();
                SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy");
                if (tenBH.equals("") || ngayraDia.equals("")){
                    Toast.makeText(QuanlyBaihatActivity.this, "Vui lòng thêm thông tin bài hát!", Toast.LENGTH_SHORT).show();
                } else{
                    Album album = listAlbum.get(spAlbum.getSelectedItemPosition());
                    try {
                        BaiHat baiHat = new BaiHat(album.getMaAlbum(),tenBH, simpleDateFormat.parse(ngayraDia));
                        listBaihat.add(baiHat);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    adapterbaihat.notifyDataSetChanged();
                    Toast.makeText(QuanlyBaihatActivity.this, "Da them thanh cong", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void AnhXa(){
        spAlbum = (Spinner) findViewById(R.id.spinnerAlbum);
        edtTenBH = (EditText) findViewById(R.id.editTextTenBH);
        edtNgay = (EditText) findViewById(R.id.editTextNgay);
        btnChonNgay = (Button) findViewById(R.id.buttonChonNgay);
        btnThemBaiHat = (Button) findViewById(R.id.buttonThemBaiHat);
        lvDanhSachBaiHat = (ListView) findViewById(R.id.listviewDanhsachBaihat);
    }
}