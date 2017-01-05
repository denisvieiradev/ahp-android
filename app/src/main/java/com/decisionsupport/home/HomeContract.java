package com.decisionsupport.home;

import com.decisionsupport.BasePresenter;
import com.decisionsupport.BaseView;

/**
 * Created by denisvieira on 04/01/17.
 */
public interface HomeContract {
    interface View extends BaseView<Presenter> {
        void goToDashboard();
    }

    interface Presenter extends BasePresenter {}
}
