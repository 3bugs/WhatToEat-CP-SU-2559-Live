package com.example.whattoeat.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whattoeat.R;
import com.example.whattoeat.etc.Utils;


public class FoodDetailFragment extends Fragment {

    private static final String ARG_FOOD_NAME = "name";
    private static final String ARG_FOOD_PICTURE = "picture";

    private String mFoodName;
    private String mFoodPicture;

    public FoodDetailFragment() {
        // Required empty public constructor
    }

    public static FoodDetailFragment newInstance(String name, String picture) {
        FoodDetailFragment fragment = new FoodDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_FOOD_NAME, name);
        args.putString(ARG_FOOD_PICTURE, picture);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mFoodName = getArguments().getString(ARG_FOOD_NAME);
            mFoodPicture = getArguments().getString(ARG_FOOD_PICTURE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView foodNameTextView = (TextView) view.findViewById(R.id.food_name_text_view);
        ImageView foodImageView = (ImageView) view.findViewById(R.id.food_image_view);

        foodNameTextView.setText(mFoodName);
        foodImageView.setImageDrawable(Utils.getDrawableFromAssets(getActivity(), mFoodPicture));
    }
}
