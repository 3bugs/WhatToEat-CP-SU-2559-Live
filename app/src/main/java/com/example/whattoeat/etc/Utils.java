package com.example.whattoeat.etc;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Promlert on 2016-11-20.
 */

public class Utils {

    public static Drawable getDrawableFromAssets(Context context, String pictureFilename) {
        AssetManager am = context.getAssets();

        try {
            InputStream stream = am.open(pictureFilename);
            Drawable drawable = Drawable.createFromStream(stream, null);
            return drawable;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
