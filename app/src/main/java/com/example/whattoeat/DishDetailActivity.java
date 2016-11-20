package com.example.whattoeat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DishDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_detail);

        Intent intent = getIntent();
        String dishName = intent.getStringExtra("dish_name");
        int dishImageId = intent.getIntExtra("dish_image", -1);

        TextView dishNameTextView =
                (TextView) findViewById(R.id.dish_name_text_view);
        dishNameTextView.setText(dishName);

        ImageView dishPictureImageView =
                (ImageView) findViewById(R.id.dish_picture_image_view);
        dishPictureImageView.setImageResource(dishImageId);

        Button backButton = (Button) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
