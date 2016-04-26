package com.epicodus.myrestaurants.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.myrestaurants.R;
import com.epicodus.myrestaurants.models.Restaurant;
import com.epicodus.myrestaurants.ui.RestaurantDetailActivity;
import com.epicodus.myrestaurants.ui.RestaurantDetailFragment;
import com.epicodus.myrestaurants.util.ItemTouchHelperViewHolder;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class RestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, ItemTouchHelperViewHolder {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    @Bind(R.id.restaurantImageView) ImageView mRestaurantImageView;
    @Bind(R.id.restaurantNameTextView) TextView mNameTextView;
    @Bind(R.id.restaurantCuisineTextView) TextView mRestaurantCuisineTextView;
    @Bind(R.id.restaurantRatingTextView) TextView mRestaurantRatingTextView;
    private Context mContext;
    private int mOrientation;
    ArrayList<Restaurant> mRestaurants = new ArrayList<>();

    public RestaurantViewHolder(View itemView, ArrayList<Restaurant> restaurants) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
        mRestaurants = restaurants;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int currentPosition = getLayoutPosition();

        if (mOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            RestaurantDetailFragment detailFragment = RestaurantDetailFragment
                    .newInstance(mRestaurants.get(currentPosition));
            FragmentTransaction ft = ((FragmentActivity) mContext).getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.restaurantDetailContainer, detailFragment);
            ft.commit();
        } else {
            Intent intent = new Intent(mContext, RestaurantDetailActivity.class);
            intent.putExtra("position", getLayoutPosition() + "");
            intent.putExtra("restaurants", Parcels.wrap(mRestaurants));
            mContext.startActivity(intent);
        }

    }

    public void bindRestaurant(Restaurant restaurant) {
        Picasso.with(mContext)
                .load(restaurant.getImageUrl())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(mRestaurantImageView);

        mNameTextView.setText(restaurant.getName());
        mRestaurantCuisineTextView.setText(restaurant.getCategories().get(0));
        mRestaurantRatingTextView.setText("Rating: " + restaurant.getRating() + "/5");
        mOrientation = itemView.getResources().getConfiguration().orientation;
    }

    @Override
    public void onItemSelected() {
        itemView.animate()
                .alpha(0.7f)
                .scaleX(0.9f)
                .scaleY(0.9f)
                .setDuration(500);
    }

    @Override
    public void onItemClear() {
        itemView.animate()
                .alpha(1f)
                .scaleX(1f)
                .scaleY(1f);
    }

}
