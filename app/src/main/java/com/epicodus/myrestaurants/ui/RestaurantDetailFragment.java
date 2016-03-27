package com.epicodus.myrestaurants.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.myrestaurants.R;
import com.epicodus.myrestaurants.models.Restaurant;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RestaurantDetailFragment extends Fragment implements View.OnClickListener {
    @Bind(R.id.restaurantImageView) ImageView mRestaurantImageView;
    @Bind(R.id.restaurantNameTextView) TextView mRestaurantNameTextView;
    @Bind(R.id.restaurantCuisineTextView) TextView mRestaurantCuisineTextView;
    @Bind(R.id.restaurantRatingTextView) TextView mRestaurantRatingTextView;
    @Bind(R.id.restaurantWebsiteTextView) TextView mRestaurantWebsiteTextView;
    @Bind(R.id.restaurantPhoneTextView) TextView mRestaurantPhoneTextView;
    @Bind(R.id.restaurantAddressTextView) TextView mRestaurantAddressTextView;
    @Bind(R.id.saveRestaurantButton) Button mSaveRestaurantButton;

    private Restaurant mRestaurant;

    private static final int MAX_WIDTH = 400;
    private static final int MAX_HEIGHT = 300;

    public static RestaurantDetailFragment newInstance(Restaurant restaurant) {
        RestaurantDetailFragment restaurantDetailFragment = new RestaurantDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("restaurant", Parcels.wrap(restaurant));
        restaurantDetailFragment.setArguments(args);
        return restaurantDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRestaurant = Parcels.unwrap(getArguments().getParcelable("restaurant"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext())
                .load(mRestaurant.getImageUrl())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerInside()
                .into(mRestaurantImageView);
        mRestaurantNameTextView.setText(mRestaurant.getName());
        mRestaurantCuisineTextView.setText(android.text.TextUtils.join(", ", mRestaurant.getCategories()));
        mRestaurantRatingTextView.setText(Double.toString(mRestaurant.getRating()) + "/5");
        mRestaurantPhoneTextView.setText(mRestaurant.getPhone());
        mRestaurantAddressTextView.setText(android.text.TextUtils.join(", ", mRestaurant.getAddress()));

        mRestaurantWebsiteTextView.setOnClickListener(this);
        mRestaurantPhoneTextView.setOnClickListener(this);
        mRestaurantAddressTextView.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.restaurantWebsiteTextView:
                Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(mRestaurant.getWebsite()));
                startActivity(webIntent);
                break;
            case R.id.restaurantPhoneTextView:
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:" + mRestaurant.getPhone()));
                startActivity(phoneIntent);
                break;
            case R.id.restaurantAddressTextView:
                Intent mapIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:" + mRestaurant.getLatitude()
                                + "," + mRestaurant.getLongitude()
                                + "?q=" + mRestaurant.getName()));
                startActivity(mapIntent);
                break;
        }
    }

}
