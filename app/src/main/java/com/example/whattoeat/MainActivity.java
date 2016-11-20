package com.example.whattoeat;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.whattoeat.model.Food;
import com.example.whattoeat.model.FoodMenu;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button randomButton = (Button) findViewById(R.id.random_button);
        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FoodMenu foodMenu = FoodMenu.getInstance(MainActivity.this);
                foodMenu.loadFromDatabase();
                Food randomFood = foodMenu.getRandomFood();

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setMessage(randomFood.name);
                dialog.show();
            }
        });
    }
}
