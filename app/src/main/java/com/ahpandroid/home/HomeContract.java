package com.ahpandroid.home;

import com.ahpandroid.BasePresenter;
import com.ahpandroid.BaseView;

/**
 * Created by denisvieira on 04/01/17.
 */
public interface HomeContract {
    interface View extends BaseView<Presenter> {
        void goToDashboard();
    }

    interface Presenter extends BasePresenter {}
}
