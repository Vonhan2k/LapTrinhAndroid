package com.example.bai15_c2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtHoten, edtSoluongSach, edtTongKH, edtTongKHVip, edtTongdoanhthu;
    TextView txtThanhTien;
    CheckBox chkKHVip;
    Button btnTinhTT, btnTiep, btnThongke;
    ImageButton imgBtnThoat;

    ArrayList<KhachHang> listKH = new ArrayList<KhachHang>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        //Tinh tien sach
        btnTinhTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten = edtHoten.getText().toString();
                String soluongsach = edtSoluongSach.getText().toString();
                if (hoten.equals("") || soluongsach.equals("")){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập thông tin!", Toast.LENGTH_SHORT).show();
                } else{
                    TinhTien();
                    KhachHang kh = new KhachHang(edtHoten.getText()+"",
                            Integer.parseInt(edtSoluongSach.getText()+""),
                            chkKHVip.isChecked(), Integer.parseInt(txtThanhTien.getText()+""));
                    listKH.add(kh);
                }

            }
        });

        //Tiep
        btnTiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               edtHoten.setText("");
               edtSoluongSach.setText("");
               txtThanhTien.setText("");
               chkKHVip.setChecked(false);
               edtHoten.requestFocus();
            }
        });

        //Thong ke
        btnThongke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slVip = 0, Tong = 0;

                for (KhachHang kh: listKH){
                    if (kh.isVip())
                        slVip++;
                    Tong +=kh.getThanhTien();
                }

                edtTongKH.setText("" + listKH.size());
                edtTongKHVip.setText("" + slVip);
                edtTongdoanhthu.setText("" + Tong);
            }
        });

        imgBtnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, android.app.AlertDialog.THEME_HOLO_LIGHT);
                builder.setTitle("Xác nhận để thoát!");
                builder.setIcon(R.drawable.question);
                builder.setMessage("Bạn có muốn thoát?");


                builder.setNegativeButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                builder.setPositiveButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });


    }

    private void AnhXa(){
        edtHoten = (EditText) findViewById(R.id.edittextTen);
        edtSoluongSach = (EditText) findViewById(R.id.edittextSoluongKhach);
        edtTongKH = (EditText) findViewById(R.id.edittextTongsoKH);
        edtTongKHVip = (EditText) findViewById(R.id.edittextTongsoKHVIP);
        edtTongdoanhthu = (EditText) findViewById(R.id.edittextTongdoanhthu);
        txtThanhTien = (TextView) findViewById(R.id.txtThanhTien);
        chkKHVip = (CheckBox) findViewById(R.id.chkVip);
        btnTinhTT = (Button) findViewById(R.id.btnTinhTT);
        btnTiep = (Button) findViewById(R.id.btnTiep);
        btnThongke = (Button) findViewById(R.id.btnThongke);
        imgBtnThoat = (ImageButton) findViewById(R.id.btnThoat);
    }


    private void TinhTien(){
        int SoluongSach = Integer.parseInt(edtSoluongSach.getText().toString());
        int TinhTien = 20000;

        if (!chkKHVip.isChecked()){
            Boolean b = false;
            TinhTien *= SoluongSach;
        } else{
            Boolean b = true;
            TinhTien *= SoluongSach;
            TinhTien -= TinhTien * 0.1;
        }
        txtThanhTien.setText((int)TinhTien +"");
    }
}