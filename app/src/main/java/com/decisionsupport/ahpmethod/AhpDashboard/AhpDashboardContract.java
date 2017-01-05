package com.decisionsupport.ahpmethod.AhpDashboard;

import com.decisionsupport.BasePresenter;
import com.decisionsupport.BaseView;

/**
 * Created by denisvieira on 04/01/17.
 */
public interface AhpDashboardContract {

    interface View extends BaseView<Presenter> {
        void startNew();
    }

    interface Presenter extends BasePresenter {}
}
