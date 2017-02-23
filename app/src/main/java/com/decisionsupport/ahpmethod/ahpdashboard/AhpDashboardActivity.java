package com.decisionsupport.ahpmethod.ahpdashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.decisionsupport.R;

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

        if (data != null && data.getExtras() != null)
            for (String key : data.getExtras().keySet())
                Toast.makeText(this, key + " : " + data.getExtras().get(key).toString(), Toast.LENGTH_SHORT).show();

        super.onActivityResult(requestCode, resultCode, data);

    }
}
