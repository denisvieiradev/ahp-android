package com.decisionsupport.SelectAssistMethod;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.decisionsupport.R;
import com.decisionsupport.utils.ActivityUtils;

public class SelectAssistMethodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SelectAssistMethodFragment selectAssistMethodFragment = (SelectAssistMethodFragment) getSupportFragmentManager().findFragmentById(R.id.dashboard_content_frame);

        if (selectAssistMethodFragment == null) {
            selectAssistMethodFragment = SelectAssistMethodFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), selectAssistMethodFragment, R.id.dashboard_content_frame);
        }
    }
}
