package com.example.apptoancau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtThongTin;
    Button btnXacNhan;
    EditText edtHoTen, edtSoDT, edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten = edtHoTen.getText().toString();
                String email = edtEmail.getText().toString();
                String soDT = edtSoDT.getText().toString();

                String textChaoBan = getResources().getString(R.string.text_ChaoBan);
                String textEmail = getResources().getString(R.string.text_Email);
                String textSoDT = getResources().getString(R.string.text_SoDT);

                txtThongTin.setText(textChaoBan + ": " + hoten + "\n"+ textEmail + ": " + email + "\n" +textSoDT +  ": " + soDT);
            }
        });
    }

    private  void AnhXa(){
        btnXacNhan = (Button) findViewById(R.id.buttonXacNhan);
        txtThongTin = (TextView) findViewById(R.id.textViewThongTin);
        edtHoTen = (EditText) findViewById(R.id.editTextHoTen);
        edtEmail = (EditText) findViewById(R.id.editTextEmail);
        edtSoDT = (EditText) findViewById(R.id.editTextSoDienThoai);



    }
}