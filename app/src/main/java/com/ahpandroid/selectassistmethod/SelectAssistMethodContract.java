package com.ahpandroid.selectassistmethod;

import com.ahpandroid.BasePresenter;
import com.ahpandroid.BaseView;

/**
 * Created by denisvieira on 28/12/16.
 */
public interface SelectAssistMethodContract {

    interface View extends BaseView<Presenter> {
        void goToAHP();
        void goToRegression();
        void goToProgression();
    }

    interface Presenter extends BasePresenter {}
}
