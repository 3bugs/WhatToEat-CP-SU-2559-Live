package com.example.whattoeat;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.whattoeat.adapter.FoodListAdapter;
import com.example.whattoeat.model.Food;
import com.example.whattoeat.model.FoodMenu;

public class FoodListActivity extends AppCompatActivity {

    private ListView mFoodListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFoodListView = (ListView) findViewById(R.id.food_list_view);
        mFoodListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FoodMenu foodMenu = FoodMenu.getInstance(FoodListActivity.this);
                Food food = foodMenu.getFoodList().get(i);

                Intent intent = new Intent(FoodListActivity.this, FoodDetailActivity.class);
                intent.putExtra("position", i);
/*
                intent.putExtra("name", food.name);
                intent.putExtra("picture", food.pictureFilename);
*/
                startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FoodListActivity.this, AddFoodActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        FoodMenu foodMenu = FoodMenu.getInstance(this);
        foodMenu.loadFromDatabase();

        FoodListAdapter adapter = new FoodListAdapter(
                this,
                R.layout.list_item,
                foodMenu.getFoodList()
        );

        mFoodListView.setAdapter(adapter);
    }
}
