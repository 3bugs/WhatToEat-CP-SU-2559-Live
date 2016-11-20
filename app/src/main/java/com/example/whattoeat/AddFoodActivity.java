package com.example.whattoeat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kbeanie.imagechooser.api.ChooserType;
import com.kbeanie.imagechooser.api.ChosenImage;
import com.kbeanie.imagechooser.api.ChosenImages;
import com.kbeanie.imagechooser.api.ImageChooserListener;
import com.kbeanie.imagechooser.api.ImageChooserManager;
import com.kbeanie.imagechooser.exceptions.ChooserException;

public class AddFoodActivity extends AppCompatActivity implements ImageChooserListener {

    private static final String TAG = AddFoodActivity.class.getSimpleName();

    private EditText mFoodNameEditText;
    private ImageView mFoodImageView;
    private Button mAddButton;

    private ImageChooserManager mImageChooserManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        mFoodNameEditText = (EditText) findViewById(R.id.food_name_edit_text);
        mFoodImageView = (ImageView) findViewById(R.id.food_image_view);
        mAddButton = (Button) findViewById(R.id.add_button);

        mFoodImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] items = {"เลือกภาพจากอัลบั้ม", "ถ่ายภาพ"};

                new AlertDialog.Builder(AddFoodActivity.this)
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0: // choose image
                                        chooseImage();
                                        break;
                                    case 1: // take photo
                                        takePicture();
                                        break;
                                }
                            }
                        })
                        .show();
            }
        });
    }

    private void chooseImage() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(Intent.EXTRA_ALLOW_MULTIPLE, false);

        mImageChooserManager = new ImageChooserManager(
                this,
                ChooserType.REQUEST_PICK_PICTURE,
                true
        );
        mImageChooserManager.setExtras(bundle);
        mImageChooserManager.setImageChooserListener(this);
        mImageChooserManager.clearOldFiles();

        try {
            mImageChooserManager.choose();
        } catch (ChooserException e) {
            e.printStackTrace();
        }
    }

    private void takePicture() {
        mImageChooserManager = new ImageChooserManager(
                this,
                ChooserType.REQUEST_CAPTURE_PICTURE,
                true
        );
        mImageChooserManager.setImageChooserListener(this);

        try {
            mImageChooserManager.choose();
        } catch (ChooserException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent returnedIntent) {
        super.onActivityResult(requestCode, resultCode, returnedIntent);

        if (resultCode == RESULT_OK
                && (requestCode == ChooserType.REQUEST_PICK_PICTURE
                || requestCode == ChooserType.REQUEST_CAPTURE_PICTURE)) {
            if (mImageChooserManager == null) {
                //reinitializeImageChooser();
                return;
            }
            mImageChooserManager.submit(requestCode, returnedIntent);
        }
    }

    @Override
    public void onImageChosen(final ChosenImage image) {
        new Handler(Looper.getMainLooper()).post(
                new Runnable() {
                    @Override
                    public void run() {
                        if (image != null) {
                            //mChosenImage = image;

                            String filePathOriginal = image.getFilePathOriginal();
                            //Log.i(TAG, "-----");
                            //Log.i(TAG, "Image path: " + filePathOriginal);
                            //Log.i(TAG, "Image thumbnail path: " + image.getFileThumbnail());
                            //Log.i(TAG, "Image small thumbnail path: " + image.getFileThumbnailSmall());

                            Glide.with(AddFoodActivity.this)
                                    .load(filePathOriginal)
                                    .into(mFoodImageView);
                        } else {
                            //mChosenImage = null;
                            Log.i(TAG, "Image is NULL !?!");
                        }
                    }
                }
        );
    }

    @Override
    public void onError(String s) {

    }

    @Override
    public void onImagesChosen(ChosenImages chosenImages) {

    }
}
