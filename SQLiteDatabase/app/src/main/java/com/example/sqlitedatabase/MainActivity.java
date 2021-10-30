package com.example.sqlitedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Database database;
    ListView lvCongViec;
    ArrayList<CongViec> arrayCongViec;
    CongViecAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCongViec = (ListView) findViewById(R.id.listviewCongViec);
        arrayCongViec = new ArrayList<>();

        adapter = new CongViecAdapter(this, R.layout.dong_cong_viec,arrayCongViec);
        lvCongViec.setAdapter(adapter);


        //tao database Ghi chu
        database = new Database(this,"ghichu.sqlite",null, 1);

        //tao bang CongViec
        database.QueryData("CREATE TABLE IF NOT EXISTS Congviec(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenCV VARCHAR(200))");

        //Them du lieu
        //database.QueryData("INSERT INTO CongViec VALUES(null, 'Viết ứng dụng ghi chú')");

        GetDataCongViec();
    }

    //Select du lieu
    private void GetDataCongViec(){
        //Select du lieu
        Cursor dataCongViec = database.GetData("SELECT * FROM CongViec");
        arrayCongViec.clear();
        while (dataCongViec.moveToNext()){
            String ten = dataCongViec.getString(1);
            int id = dataCongViec.getInt(0);
            arrayCongViec.add(new CongViec(id, ten));
        }
        adapter.notifyDataSetChanged();
    }
    //Menu them
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_congviec, menu);
        return super.onCreateOptionsMenu(menu);
    }
    //Menu them
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuAdd){
            DialogThem();
        }
        return super.onOptionsItemSelected(item);
    }

    //Hop thoai Dialog Them
    private  void DialogThem(){
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_them_cong_viec);

        //Anh xa Dialog
        EditText edtTen = dialog.findViewById(R.id.edittextTenCV);
        Button btnThem = dialog.findViewById(R.id.buttonThem);
        Button btnHuy = dialog.findViewById(R.id.buttonHuy);

        //button Them
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenCV = edtTen.getText().toString();
                if (tenCV.equals("")){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập tên công việc!", Toast.LENGTH_SHORT).show();
                } else{
                    database.QueryData("INSERT INTO CongViec VALUES(null, '"+ tenCV +"')");
                    Toast.makeText(MainActivity.this, "Đã Thêm", Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                    GetDataCongViec();
                }
            }
        });
        //button Huy
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

    //Hop thoai Dialog Sua
    public void DialogSuaCongViec( String ten, int id){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_sua);

        //Anh xa Dialog Sua
        EditText edtTenCV = (EditText) dialog.findViewById(R.id.edittextTenCVEdit);
        Button btnCapNhat = (Button) dialog.findViewById(R.id.buttonCapNhat);
        Button btnHuyCapNhat = (Button) dialog.findViewById(R.id.buttonHuyEdit);

        edtTenCV.setText(ten);

        //button Cap nhat
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenMoi =  edtTenCV.getText().toString().trim();
                database.QueryData("UPDATE CongViec SET TenCV = '"+ tenMoi +"' WHERE Id = '"+ id +"'");
                Toast.makeText(MainActivity.this, "Đã cập nhật", Toast.LENGTH_SHORT).show();
                dialog.cancel();
                GetDataCongViec();
            }
        });
        //button Huy cap nhat
        btnHuyCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        dialog.show();
    }

    public void DialogXoaCV(String tencv, int id){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(this);
        dialogXoa.setMessage("Bạn có muốn xóa công việc " + tencv + " không?");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                database.QueryData("DELETE FROM CongViec WHERE Id = '"+ id +"'");
                Toast.makeText(MainActivity.this, "Đã xóa" + tencv, Toast.LENGTH_SHORT).show();
                GetDataCongViec();
            }
        });
        dialogXoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogXoa.show();
    }
}