package com.example.whattoeat.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.whattoeat.db.DatabaseHelper;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Promlert on 2016-11-20.
 */

public class FoodMenu {

    private static final String TAG = FoodMenu.class.getSimpleName();

    private static FoodMenu mInstance;
    private Context mContext;

    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;

    private ArrayList<Food> mFoodList = new ArrayList<>();
    private Random mRandom = new Random();

    public static FoodMenu getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new FoodMenu(context);
        }
        return mInstance;
    }

    private FoodMenu(Context context) {
        this.mContext = context;
    }

    public void loadFromDatabase() {
        mFoodList.clear();

        mHelper = new DatabaseHelper(mContext);
        mDb = mHelper.getWritableDatabase();

        Cursor cursor = mDb.query(DatabaseHelper.TABLE_NAME, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME));
            String picture = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PICTURE));

            Food food = new Food(name, picture);
            mFoodList.add(food);
        }
        cursor.close();
        //mDb.close();
        //mHelper.close();
    }

    public ArrayList<Food> getFoodList() {
        return mFoodList;
    }

    public Food getRandomFood() {
        int randomIndex = mRandom.nextInt(mFoodList.size());
        Food food = mFoodList.get(randomIndex);

        Log.i(TAG, food.name + ", " + food.pictureFilename);
        return food;
    }
}
