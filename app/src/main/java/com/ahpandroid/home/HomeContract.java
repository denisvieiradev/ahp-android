package com.ahpandroid.home;

import android.view.View;

import com.ahpandroid.BasePresenter;
import com.ahpandroid.BaseView;

/**
 * Created by denisvieira on 04/01/17.
 */
public interface HomeContract {
    interface View extends BaseView<Presenter> {
        void goToDashboard(android.view.View view);
        void showAppInfo(android.view.View view);
        void closeAppInfo(android.view.View view);
        void goToDenisGithub(android.view.View view);
        void goToGabrielGithub(android.view.View view);
        void goToProjectGithub(android.view.View view);
    }

    interface Presenter extends BasePresenter {}
}
