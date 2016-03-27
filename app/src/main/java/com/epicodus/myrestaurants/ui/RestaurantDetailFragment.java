package com.epicodus.myrestaurants.ui;


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

public class RestaurantDetailFragment extends Fragment {
    @Bind(R.id.restaurantImageView) ImageView mRestaurantImageView;
    @Bind(R.id.restaurantNameTextView) TextView mRestaurantNameTextView;
    @Bind(R.id.restaurantCuisineTextView) TextView mRestaurantCuisineTextView;
    @Bind(R.id.restaurantRatingTextView) TextView mRestaurantRatingTextView;
    @Bind(R.id.restaurantWebsiteTextView) TextView mRestaurantWebsiteTextView;
    @Bind(R.id.restaurantPhoneTextView) TextView mRestaurantPhoneTextView;
    @Bind(R.id.restaurantAddressTextView) TextView mRestaurantAddressTextView;
    @Bind(R.id.saveRestaurantButton) Button mSaveRestaurantButton;

    private Restaurant mRestaurant;

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

        Picasso.with(view.getContext()).load(mRestaurant.getImageUrl()).into(mRestaurantImageView);
        mRestaurantNameTextView.setText(mRestaurant.getName());
        mRestaurantCuisineTextView.setText(android.text.TextUtils.join(", ", mRestaurant.getCategories()));
        mRestaurantRatingTextView.setText(Double.toString(mRestaurant.getRating()) + "/5");
        mRestaurantPhoneTextView.setText(mRestaurant.getPhone());
        mRestaurantAddressTextView.setText(android.text.TextUtils.join(", ", mRestaurant.getAddress()));
        return view;
    }

}
