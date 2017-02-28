package com.ahpandroid.ahpmethod.ahpresultsdialog;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.ahpandroid.BasePresenter;
import com.ahpandroid.BaseView;

import java.util.List;

/**
 * Created by denisvieira on 27/02/17.
 */

public interface AhpResultsDialogContract {

    interface View extends BaseView<Presenter> {
        void ahpResultsDialogConfiguration();
        void show();
        void close(android.view.View view);
        void showPreferenceMatrix(float[][] preferenceMatrix, List<String> alternatives, List<String> criterions);
    }

    interface Presenter extends BasePresenter {
        void loadInspectionFromProblemsIdentified(String problemIdentifiedGuid);
    }

}
