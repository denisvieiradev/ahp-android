package com.decisionsupport.SelectAssistMethod;

import android.support.annotation.NonNull;

import static com.google.common.base.Preconditions.checkNotNull;


/**
 * Created by denisvieira on 28/12/16.
 */
public class SelectAssistMethodPresenter implements SelectAssistMethodContract.Presenter {

    private final SelectAssistMethodContract.View mDashboardView;

    public SelectAssistMethodPresenter(@NonNull SelectAssistMethodContract.View dashboardView) {

        this.mDashboardView = checkNotNull(dashboardView);

        mDashboardView.setPresenter(this);
    }

}