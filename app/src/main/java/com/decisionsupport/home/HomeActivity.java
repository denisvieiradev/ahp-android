package com.decisionsupport.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.decisionsupport.R;

/**
 * Created by denisvieira on 04/01/17.
 */
public class HomeActivity extends AppCompatActivity {

    private HomeFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_act);

        if (mFragment == null){
            mFragment = HomeFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.home_content_frame, mFragment).commit();
        }
    }
}
