package com.example.whattoeat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whattoeat.etc.Utils;

public class FoodDetailActivity extends AppCompatActivity {

    private TextView mFoodNameTextView;
    private ImageView mFoodImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        Intent intent = getIntent();
        String foodName = intent.getStringExtra("name");
        String foodPicture = intent.getStringExtra("picture");

        mFoodNameTextView = (TextView) findViewById(R.id.food_name_text_view);
        mFoodImageView = (ImageView) findViewById(R.id.food_image_view);

        mFoodNameTextView.setText(foodName);
        mFoodImageView.setImageDrawable(Utils.getDrawableFromAssets(this, foodPicture));
    }
}
