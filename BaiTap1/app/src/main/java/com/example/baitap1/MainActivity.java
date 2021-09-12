package com.example.baitap1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtThongTin;
    Button btnXacNhan;
    EditText edtTaiKhoan, edtMatKhau, edtNgaySinh, edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtThongTin = (TextView) findViewById(R.id.textViewThongTin);
        edtTaiKhoan = (EditText) findViewById(R.id.editTextTaiKhoan);
        edtMatKhau = (EditText) findViewById(R.id.editTextMatKhau);
        edtNgaySinh = (EditText) findViewById(R.id.editTextNgaySinh);
        edtEmail = (EditText) findViewById(R.id.editTextEmail);
        btnXacNhan = (Button) findViewById(R.id.buttonXacNhan);

        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String taikhoan = edtTaiKhoan.getText().toString();
                String matkhau = edtMatKhau.getText().toString();
                String ngaysinh =  edtNgaySinh.getText().toString();
                String email = edtEmail.getText().toString();


                txtThongTin.setText("Thông tin tài khoản: \n" + "Tài khoản: "+ taikhoan + "\n" + "Mật Khẩu: " + matkhau + "\n" + "Ngày sinh: " + ngaysinh + "\n" + "Email: " + email );
                txtThongTin.setBackgroundColor(Color.GREEN);
            }
        });

    }


}