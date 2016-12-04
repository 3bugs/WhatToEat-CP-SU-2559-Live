package com.example.whattoeat.etc;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Promlert on 2016-11-20.
 */

public class Utils {

    public static Drawable getDrawableFromAssets(Context context, String pictureFilename) {
        AssetManager am = context.getAssets();

        try {
            // รูปภาพที่เราเตรียมไว้เองในโฟลเดอร์ assets
            InputStream stream = am.open(pictureFilename);
            Drawable drawable = Drawable.createFromStream(stream, null);
            return drawable;
        } catch (IOException e) {
            e.printStackTrace();

            try {
                // รูปภาพที่ user เพิ่มเข้ามาทีหลัง
                InputStream stream = new FileInputStream(pictureFilename);
                Drawable drawable = Drawable.createFromStream(stream, null);
                return drawable;
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }

}
