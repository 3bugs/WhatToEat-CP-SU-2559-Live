package com.example.whattoeat.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.whattoeat.fragment.FoodDetailFragment;
import com.example.whattoeat.model.Food;
import com.example.whattoeat.model.FoodMenu;

/**
 * Created by Promlert on 2016-12-04.
 */

public class FoodPagerAdapter extends FragmentStatePagerAdapter {

    private Context mContext;

    public FoodPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        FoodMenu foodMenu = FoodMenu.getInstance(mContext);
        Food food = foodMenu.getFoodList().get(position);

        FoodDetailFragment fragment = FoodDetailFragment.newInstance(
                food.name,
                food.pictureFilename
        );

        return fragment;
    }

    @Override
    public int getCount() {
        FoodMenu foodMenu = FoodMenu.getInstance(mContext);
        return foodMenu.getFoodList().size();
    }
}
