package com.ahpandroid.ahpmethod.ahpresultsdialog;

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
        void showResults(float[] averagePriorityMatrix, float[][] preferenceMatrix, List<String> alternatives, List<String> criterions);
    }

    interface Presenter extends BasePresenter {
        void loadInspectionFromProblemsIdentified(String problemIdentifiedGuid);
    }

}
