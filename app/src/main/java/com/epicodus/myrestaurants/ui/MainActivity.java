package com.epicodus.myrestaurants.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.myrestaurants.MyRestaurantsApplication;
import com.epicodus.myrestaurants.R;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();

    private Firebase mFirebaseRef;
    @Bind(R.id.findRestaurantsButton) Button mFindRestaurantsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFirebaseRef = MyRestaurantsApplication.getAppInstance().getFirebaseRef();
        checkForAuthenticatedUser();

        mFindRestaurantsButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                this.logout();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        mFirebaseRef.unauth();
        goToLoginActivity();
    }

    private void checkForAuthenticatedUser() {
        AuthData authData = mFirebaseRef.getAuth();
        if (authData == null) {
            goToLoginActivity();
        }
    }

    private void goToLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.findRestaurantsButton:
                Intent findRestaurantsIntent = new Intent(MainActivity.this, RestaurantListActivity.class);
                startActivity(findRestaurantsIntent);
                break;
        }
    }

}
