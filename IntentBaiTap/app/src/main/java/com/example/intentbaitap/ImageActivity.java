package com.example.intentbaitap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.Collections;

public class ImageActivity extends AppCompatActivity {

    TableLayout myTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        myTable = (TableLayout) findViewById(R.id.tableLayoutImage);

        int soDong = 6;
        int soCot = 3;

        //tron mang
        Collections.shuffle(MainActivity.arrayName);

        //Tao dong va cot
        for (int i = 1; i <= 6; i++){
            TableRow tableRow = new TableRow(this);

            //tao cot -> ImageView
            for (int j = 1; j <= soCot; j++){
                ImageView imageView = new ImageView(this);

                // Converts 14 dip into its equivalent px
                float dip = 120f;
                Resources r = getResources();
                int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, r.getDisplayMetrics()
                );
                //set kich thuoc hinh
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(px, px);
                imageView.setLayoutParams(layoutParams);
                //0 -> 17
                int vitri = soCot * (i - 1) + j - 1;

                int idHinh = getResources().getIdentifier(MainActivity.arrayName.get(vitri), "drawable", getPackageName());
                imageView.setImageResource(idHinh);

                //add image vao table row
                tableRow.addView(imageView);
                
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.putExtra("tenhinhchon", MainActivity.arrayName.get(vitri));
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
            }
            //add table row vao table
            myTable.addView(tableRow);
        }
    }
}