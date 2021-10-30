package com.example.intentbaitap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> arrayName;
    ImageView imgCauHoi, imgTraLoi;
    int MacDinh = 123;
    String tenHinhGoc ="";
    TextView txtDiem;
    int total = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgCauHoi = (ImageView) findViewById(R.id.imageViewCauHoi);
        imgTraLoi = (ImageView) findViewById(R.id.imageViewTraLoi);
        txtDiem = (TextView) findViewById(R.id.textViewDiem);

        txtDiem.setText(total + "");

        String[] mangTen = getResources().getStringArray(R.array.list_name);
        arrayName = new ArrayList<>(Arrays.asList(mangTen));

        //tron mang
        Collections.shuffle(arrayName);
        tenHinhGoc = arrayName.get(5);
        //lay hinh trong drawable va ten hinh trong array
        int idHinh = getResources().getIdentifier(arrayName.get(5), "drawable", getPackageName());

        imgCauHoi.setImageResource(idHinh);

        imgTraLoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImageActivity.class);
                startActivityForResult(intent, MacDinh);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == MacDinh && resultCode == RESULT_OK && data != null){
            String tenHinhNhan = data.getStringExtra("tenhinhchon");
            int idHinhNhan = getResources().getIdentifier(tenHinhNhan,"drawable", getPackageName());
            imgTraLoi.setImageResource(idHinhNhan);
            //so sanh theo ten hinh
            if (tenHinhGoc.equals(tenHinhNhan)){
                Toast.makeText(this, "Chính xác", Toast.LENGTH_SHORT).show();

                //Cong diem
                total +=10;
                //neu dung doi hinh goc
                new CountDownTimer(2000, 100){

                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        //tron mang
                        Collections.shuffle(arrayName);
                        tenHinhGoc = arrayName.get(5);
                        //lay hinh trong drawable va ten hinh trong array
                        int idHinh = getResources().getIdentifier(arrayName.get(5), "drawable", getPackageName());

                        imgCauHoi.setImageResource(idHinh);
                    }
                }.start();
            }else{
                Toast.makeText(this, "Sai rồi", Toast.LENGTH_SHORT).show();
                total -= 5;
            }
            txtDiem.setText(total + "");
        }
        //kiem tra man hinh thu hai k chon hinh
        if (requestCode == MacDinh && resultCode == RESULT_CANCELED){
            Toast.makeText(this, "Bạn chưa chọn hình?", Toast.LENGTH_SHORT).show();
            total -= 15;
            txtDiem.setText(total + "");
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.reload, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuReload){
            //tron mang
            Collections.shuffle(arrayName);
            tenHinhGoc = arrayName.get(5);
            //lay hinh trong drawable va ten hinh trong array
            int idHinh = getResources().getIdentifier(arrayName.get(5), "drawable", getPackageName());

            imgCauHoi.setImageResource(idHinh);
        }
        return super.onOptionsItemSelected(item);
    }
}