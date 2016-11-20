package com.example.whattoeat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private String[] mFood = {
            "ข้าวไข่เจียว", "ข้าวหมูแดง", "ข้าวมันไก่",
            "ข้าวหน้าเป็ด", "ข้าวผัด", "ผัดซีอิ๊ว",
            "ผัดไทย", "ราดหน้า", "ส้มตำไก่ย่าง",
    };

    private int[] mImageId = {
            R.drawable.kao_kai_jeaw,
            R.drawable.kao_moo_dang,
            R.drawable.kao_mun_kai,
            R.drawable.kao_na_ped,
            R.drawable.kao_pad,
            R.drawable.pad_sie_eew,
            R.drawable.pad_thai,
            R.drawable.rad_na,
            R.drawable.som_tum_kai_yang
    };

    private Random mRandom = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button randomButton = (Button) findViewById(R.id.random_button);
        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomIndex = mRandom.nextInt(mFood.length);
                String randomFood = mFood[randomIndex];
                int foodImageId = mImageId[randomIndex];
                Log.i(TAG, randomFood);

                Intent intent = new Intent(MainActivity.this, DishDetailActivity.class);
                intent.putExtra("dish_name", randomFood);
                intent.putExtra("dish_image", foodImageId);
                startActivity(intent);

/*
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("ชื่ออาหารที่สุ่มได้");
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setMessage(randomFood);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.setNeutralButton("xxx", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();
*/
            }
        });
    }
}
