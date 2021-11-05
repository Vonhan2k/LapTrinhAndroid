package com.example.bai27_c2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class XemAlbumActivity extends AppCompatActivity {

    ListView lvDanhsachAlbum;
    AlbumAdapter adapterAlbum;
    ArrayList<Album> listAlbum;
    int posselected = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_album);

        lvDanhsachAlbum = (ListView) findViewById(R.id.listviewDsAlbum);

        //Nhan du lieu tu intent
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("ketqua");

        if (bundle != null) {
            listAlbum = (ArrayList<Album>) bundle.getSerializable("album");
            adapterAlbum = new AlbumAdapter(this,0,listAlbum);
            lvDanhsachAlbum.setAdapter(adapterAlbum);
        }

        //Click de sua Album
        lvDanhsachAlbum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                posselected = position;
                Intent intentEdit = new Intent(XemAlbumActivity.this, EditAlbumActivity.class);
                Bundle bundle1 = new Bundle();
                bundle1.putSerializable("album", listAlbum.get(position));
                intentEdit.putExtra("DATA",bundle1);
                startActivityForResult(intentEdit, 2);
            }
        });

        //Long Click de xoa Album
        lvDanhsachAlbum.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(XemAlbumActivity.this);
                builder.setTitle("Hỏi xóa");
                builder.setIcon(R.drawable.question);
                builder.setMessage("Bạn có muốn xóa?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listAlbum.remove(position);
                        adapterAlbum.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
                return false;
            }
        });
    }
    public void onBackPressed() {
        Intent intent=getIntent();
        Bundle bundle=new Bundle();
        //Album album=new Album(etMaAlbum.getText()+"",etTenAlbum.getText()+"");
        bundle.putSerializable("album", listAlbum);
        intent.putExtra("DATA",bundle);
        setResult(3,intent);
        super.onBackPressed();
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == RESULT_OK && data != null) {
            Bundle bundle = data.getBundleExtra("DATA");
            Album al = (Album) bundle.getSerializable("album");

            listAlbum.set(posselected,al);

            adapterAlbum.notifyDataSetChanged();
            Toast.makeText(XemAlbumActivity.this, "Đã cập nhật thành công!", Toast.LENGTH_SHORT).show();
        }
    }

}