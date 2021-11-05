package com.example.bai27_c2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnThemAlbum, btnXemdsAlbum, btnQuanlyBaihat;
    ArrayList<Album> listAlbum = new ArrayList<Album>();
    ArrayAdapter<Album> adapterAlbum = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Anh xa
        btnThemAlbum = (Button) findViewById(R.id.buttonThemAlbum);
        btnXemdsAlbum = (Button) findViewById(R.id.buttonXemDsAlbum);
        btnQuanlyBaihat = (Button) findViewById(R.id.buttonQuanly);

        adapterAlbum = new ArrayAdapter<Album>(this,android.R.layout.simple_list_item_1, listAlbum);

        listAlbum.add(new Album("1","Bolero"));

        //Chuyen Activity Them Album
        btnThemAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentThem = new Intent(MainActivity.this, ThemAlbumActivity.class);
                startActivityForResult(intentThem, 1);
            }
        });

        //Chuyen Activity Xem Album
        btnXemdsAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentXem = new Intent(MainActivity.this, XemAlbumActivity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("album", listAlbum);

                intentXem.putExtra("ketqua", bundle);
                startActivityForResult(intentXem, 3);

            }
        });
        //Chuyen Activity Quan ly bai hat
        btnQuanlyBaihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentQuanly = new Intent(MainActivity.this, QuanlyBaihatActivity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("list", listAlbum);
                intentQuanly.putExtra("DATA", bundle);
                startActivity(intentQuanly);
            }
        });
    }

    //Nhan du lieu
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Bundle bundle = data.getBundleExtra("DATA");
            Album al = (Album) bundle.getSerializable("album");

            listAlbum.add(al);

            adapterAlbum.notifyDataSetChanged();
            Toast.makeText(MainActivity.this, "Da them thanh cong \n" + al.getMaAlbum() + "\t" + al.getTenAlbum(), Toast.LENGTH_SHORT).show();
        }

        if (requestCode == 3 && resultCode == 3 && data != null){
            Bundle bundle1 = data.getBundleExtra("DATA");
            listAlbum = (ArrayList<Album>) bundle1.getSerializable("album");
        }
    }
}