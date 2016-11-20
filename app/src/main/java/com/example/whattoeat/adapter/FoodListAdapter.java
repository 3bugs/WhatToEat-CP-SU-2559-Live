package com.example.whattoeat.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whattoeat.R;
import com.example.whattoeat.etc.Utils;
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
        View itemLayout = View.inflate(mContext, mLayoutResId, null);
        ImageView foodImageView = (ImageView) itemLayout.findViewById(R.id.food_image_view);
        TextView foodNameTextView = (TextView) itemLayout.findViewById(R.id.food_name_text_view);

        Food food = mFoodList.get(position);
        foodNameTextView.setText(food.name);

        Drawable drawable = Utils.getDrawableFromAssets(mContext, food.pictureFilename);
        foodImageView.setImageDrawable(drawable);

        return itemLayout;
    }
}
