package com.example.whattoeat.model;

import android.content.Context;

/**
 * Created by Promlert on 2016-11-20.
 */

public class FoodMenu {

    private static FoodMenu mInstance;
    private Context mContext;

    public static FoodMenu getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new FoodMenu(context);
        }
        return mInstance;
    }

    private FoodMenu(Context context) {
        this.mContext = context;
    }
}
