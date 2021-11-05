package com.example.bai27_c2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditAlbumActivity extends AppCompatActivity {

    EditText edtMaAlbum, edtTenAlbum;
    Button btnXoaTrang, btnCapNhat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_album);

        //Anh xa
        edtMaAlbum = (EditText) findViewById(R.id.editTextEditMaAlbum);
        edtTenAlbum = (EditText) findViewById(R.id.editTextEditTenAlbum);
        btnXoaTrang =(Button) findViewById(R.id.buttonXoatrang);
        btnCapNhat = (Button) findViewById(R.id.buttonCapNhatAlbum);


        //Nhan du lieu tu name DATA va Key album
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("DATA");
        Album al = (Album) bundle.getSerializable("album");

        edtMaAlbum.setText(al.getMaAlbum());
        edtTenAlbum.setText(al.getTenAlbum());
        edtMaAlbum.setEnabled(false);

        //Click xoa trang
        btnXoaTrang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtTenAlbum.setText("");
                edtTenAlbum.requestFocus();
            }
        });

        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maAlbum = edtMaAlbum.getText().toString();
                String tenAlbum = edtTenAlbum.getText().toString();

                if (maAlbum.equals("") || tenAlbum.equals("")) {
                    Toast.makeText(EditAlbumActivity.this, "Vui lòng nhập thông tin!", Toast.LENGTH_SHORT).show();
                } else {
                    //Lay du lieu name moi nhap
                    al.setTenAlbum(edtTenAlbum.getText()+"");
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
    }
}