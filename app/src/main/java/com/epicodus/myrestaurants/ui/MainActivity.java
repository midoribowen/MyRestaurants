package com.epicodus.myrestaurants.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.myrestaurants.MyRestaurantsApplication;
import com.epicodus.myrestaurants.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Bind(R.id.loginButton) Button mLoginButton;

    @Bind(R.id.findRestaurantsButton) Button mFindRestaurantsButton;
    @Bind(R.id.locationEditText) EditText mLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSharedPreferences = this.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        mLoginButton.setOnClickListener(this);
        mFindRestaurantsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.findRestaurantsButton:
                String location = mLocationEditText.getText().toString();
//                saveLocationToFirebase(location);
                if (!(location).equals("")) {
                    addToSharedPreferences(location);
                }
                Intent findRestaurantsIntent = new Intent(MainActivity.this, RestaurantListActivity.class);
                startActivity(findRestaurantsIntent);
                break;
            case R.id.loginButton:
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginIntent);
                break;
        }
    }

    private void addToSharedPreferences(String location) {
        mEditor.putString("location", location).commit();
    }

//    public void saveLocationToFirebase(String location) {
//        MyRestaurantsApplication.getAppInstance()
//                .getFirebaseRef()
//                .child("searchedLocations")
//                .push()
//                .setValue(location);
//    }
}
