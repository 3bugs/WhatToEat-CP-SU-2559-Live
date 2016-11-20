package com.example.whattoeat;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whattoeat.model.Food;
import com.example.whattoeat.model.FoodMenu;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private FoodMenu mFoodMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFoodMenu = FoodMenu.getInstance(this);
        mFoodMenu.loadFromDatabase();

        Button randomButton = (Button) findViewById(R.id.random_button);
        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Food randomFood = mFoodMenu.getRandomFood();

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.dialog_layout, null);

                ImageView foodImageView = (ImageView) layout.findViewById(R.id.food_image_view);
                TextView foodNameTextView = (TextView) layout.findViewById(R.id.food_name_text_view);

                // กำหนดชื่ออาหารลงใน layout ของไดอะล็อก
                foodNameTextView.setText(randomFood.name);

                // กำหนดรูปภาพอาหารลงใน layout ของไดอะล็อก
                Drawable drawable = getDrawableFromAssets(randomFood.pictureFilename);
                foodImageView.setImageDrawable(drawable);

                dialog.setView(layout);
                dialog.show();
            }
        });
    }

    private Drawable getDrawableFromAssets(String pictureFilename) {
        AssetManager am = getAssets();

        try {
            InputStream stream = am.open(pictureFilename);
            Drawable drawable = Drawable.createFromStream(stream, null);
            return drawable;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_show_list) {
            Intent intent = new Intent(this, FoodListActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
