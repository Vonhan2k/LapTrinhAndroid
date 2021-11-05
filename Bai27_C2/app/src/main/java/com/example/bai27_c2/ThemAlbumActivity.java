package com.example.bai27_c2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class ThemAlbumActivity extends AppCompatActivity {

    EditText edtMaAlbum, edtTenAlbum;
    Button btnXoatrang, btnLuuAlbum;
    ArrayList<Album> listAlbum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_album);

        edtMaAlbum = (EditText) findViewById(R.id.editTextMaAlbum);
        edtTenAlbum = (EditText) findViewById(R.id.editTextTenAlbum);
        btnXoatrang = (Button) findViewById(R.id.buttonXoaTrang);
        btnLuuAlbum = (Button) findViewById(R.id.buttonLuuAlbum);

        btnXoatrang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtMaAlbum.setText("");
                edtTenAlbum.setText("");
                edtMaAlbum.requestFocus();
            }
        });

        btnLuuAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maAlbum = edtMaAlbum.getText().toString();
                String tenAlbum = edtTenAlbum.getText().toString();

                if (maAlbum.equals("") || tenAlbum.equals("")){
                    Toast.makeText(ThemAlbumActivity.this, "Vui lòng nhập thông tin!", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intentTroVe = new Intent();
                    Bundle bundle = new Bundle();

                    Album al = new Album(maAlbum,tenAlbum);
                    bundle.putSerializable("album",al);
                    intentTroVe.putExtra("DATA", bundle);
                    setResult(RESULT_OK, intentTroVe);
                    finish();
                }
            }
        });
    }
}