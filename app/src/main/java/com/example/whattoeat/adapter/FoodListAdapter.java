package com.example.whattoeat.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.whattoeat.model.Food;

import java.util.ArrayList;

/**
 * Created by Promlert on 2016-11-20.
 */

public class FoodListAdapter extends ArrayAdapter<Food> {

    private Context mContext;
    private int mLayoutResId;
    private ArrayList<Food> mFoodList;

    public FoodListAdapter(Context context, int resource, ArrayList<Food> foodList) {
        super(context, resource, foodList);

        this.mContext = context;
        this.mLayoutResId = resource;
        this.mFoodList = foodList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
