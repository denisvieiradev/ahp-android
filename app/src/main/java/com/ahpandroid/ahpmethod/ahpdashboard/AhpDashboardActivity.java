package com.ahpandroid.ahpmethod.ahpdashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ahpandroid.R;

/**
 * Created by denisvieira on 04/01/17.
 */
public class AhpDashboardActivity extends AppCompatActivity {

    private AhpDashboardFragment mAhpDashboardFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ahp_dashboard_act);

        if (mAhpDashboardFragment == null){
            mAhpDashboardFragment = AhpDashboardFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.ahp_dashboard_content_frame, mAhpDashboardFragment).commit();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Toast.makeText(this,"init on ActivityResult", Toast.LENGTH_SHORT).show();

        super.onActivityResult(requestCode, resultCode, data);

    }
}
