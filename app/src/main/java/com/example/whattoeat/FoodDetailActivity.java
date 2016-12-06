package com.example.whattoeat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whattoeat.adapter.FoodPagerAdapter;

public class FoodDetailActivity extends AppCompatActivity {

    private TextView mFoodNameTextView;
    private ImageView mFoodImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        Intent intent = getIntent();
/*
        String foodName = intent.getStringExtra("name");
        String foodPicture = intent.getStringExtra("picture");
*/
        int position = intent.getIntExtra("position", 0);

        ViewPager pager = (ViewPager) findViewById(R.id.view_pager);
        FoodPagerAdapter adapter = new FoodPagerAdapter(this, getSupportFragmentManager());

        pager.setAdapter(adapter);
        pager.setCurrentItem(position);


/*
        FoodDetailFragment fragment = FoodDetailFragment.newInstance(foodName, foodPicture);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
*/



/*
        mFoodNameTextView = (TextView) findViewById(R.id.food_name_text_view);
        mFoodImageView = (ImageView) findViewById(R.id.food_image_view);

        mFoodNameTextView.setText(foodName);
        mFoodImageView.setImageDrawable(Utils.getDrawableFromAssets(this, foodPicture));
*/


    }
}
