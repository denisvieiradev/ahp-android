package com.decisionsupport.SelectAssistMethod;

import com.decisionsupport.BasePresenter;
import com.decisionsupport.BaseView;

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
