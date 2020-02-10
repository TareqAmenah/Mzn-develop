package com.tradinos.mzn.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.tradinos.mzn.R;
import com.tradinos.mzn.data.MznUser;
import com.tradinos.mzn.models.User;
import com.tradinos.mzn.ui.cart.MyCartActivity;
import com.tradinos.mzn.ui.home.HomeFragment;
import com.tradinos.mzn.ui.settings.SettingsFragment;
import com.tradinos.mzn.ui.signin.SignInActivity;

import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity
        implements HomeFragment.LogOutCallBack, SettingsFragment.ChangeLanguageCallBack {

    public static final String SHOULD_FINISH = "Should finish";
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent().getBooleanExtra(SHOULD_FINISH, false)) {
            finish();
        }

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(0);
        toolbar.setElevation(0);

        ImageView imageView = toolbar.findViewById(R.id.toolbar_shopping_cart);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyCartActivity.class);
                startActivity(intent);
            }
        });

        toolbar.findViewById(R.id.toolbar_back_arrow).setVisibility(View.GONE);


        String userName = " ";

        try {
            User user = MznUser.getINSTANCE().getMyUser(this);
            Toast.makeText(this,user.getName(), Toast.LENGTH_SHORT).show();
            Log.v("****** id: ", MznUser.getINSTANCE().getMyUser(this).getId() + "");
            Log.v("****** token: ", MznUser.getINSTANCE().getMyUser(this).getToken());

            userName = user.getName();

        } catch (MznUser.UserNotFoundException e) {
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_my_orders, R.id.nav_settings)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
//        navigationView.setNavigationItemSelectedListener(this);

//        TextView userNameTextView = findViewById(R.id.drawer_layout_user_name);
//        userNameTextView.setText(userName);


    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public void logOutCall() {
        MznUser.getINSTANCE().clear(this);
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }

    @Override
    public void changeLanguageCall(String s) {
        setAppLocale(s);
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);

    }

    private void setAppLocale(String localeCode){
        Resources resources = getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR1){
            config.setLocale(new Locale(localeCode.toLowerCase()));
        } else {
            config.locale = new Locale(localeCode.toLowerCase());
        }
        resources.updateConfiguration(config, dm);
    }
}
