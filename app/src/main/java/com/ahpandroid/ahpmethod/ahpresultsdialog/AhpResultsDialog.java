package com.ahpandroid.ahpmethod.ahpresultsdialog;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;

import com.ahpandroid.R;
import com.ahpandroid.databinding.AhpResultsDialogBinding;

import java.util.List;

import static com.ahpandroid.R.style.DialogTheme;

/**
 * Created by denisvieira on 27/02/17.
 */

public class AhpResultsDialog implements AhpResultsDialogContract.View{

    private final Context mContext;
    private Dialog mAhpResultsDialog;
    private Fragment mFragment;
    private AhpResultsDialogBinding mAhpResultsDialogBinding;

    public AhpResultsDialog(Context context, Fragment fragment){
        mContext  = context;
        mFragment = fragment;

        ahpResultsDialogConfiguration();
    }

    @Override
    public void ahpResultsDialogConfiguration() {
        mAhpResultsDialog = new Dialog(mContext,DialogTheme);
        mAhpResultsDialogBinding =
                DataBindingUtil.inflate(LayoutInflater.from(mContext),
                        R.layout.ahp_results_dialog,
                        null,
                        false);
        mAhpResultsDialog.setContentView(mAhpResultsDialogBinding.getRoot());
        mAhpResultsDialogBinding.setHandler(this);
        mAhpResultsDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mAhpResultsDialog.setCanceledOnTouchOutside(false);
        mAhpResultsDialog.setCancelable(false);
    }

    @Override
    public void show() {
        mAhpResultsDialog.show();
    }

    @Override
    public void close(View view) {
        mAhpResultsDialog.cancel();
    }

    @Override
    public void showPreferenceMatrix(float[][] preferenceMatrix, List<String> alternatives,List<String> criterions) {

        mAhpResultsDialogBinding.ahpResultPreferenceMatrixAlt0.setText(alternatives.get(0));
        mAhpResultsDialogBinding.ahpResultPreferenceMatrixAlt1.setText(alternatives.get(1));
        mAhpResultsDialogBinding.ahpResultPreferenceMatrixAlt2.setText(alternatives.get(2));
        mAhpResultsDialogBinding.ahpResultPreferenceMatrixAlt3.setText(alternatives.get(3));

        mAhpResultsDialogBinding.ahpResultPreferenceMatrixCrit0.setText(criterions.get(0));
        mAhpResultsDialogBinding.ahpResultPreferenceMatrixCrit1.setText(criterions.get(1));
        mAhpResultsDialogBinding.ahpResultPreferenceMatrixCrit2.setText(criterions.get(2));
        mAhpResultsDialogBinding.ahpResultPreferenceMatrixCrit3.setText(criterions.get(3));

        mAhpResultsDialogBinding.ahpResultPreferenceMatrixAlt0Crit0.setText(String.valueOf(preferenceMatrix[0][0]));
        mAhpResultsDialogBinding.ahpResultPreferenceMatrixAlt0Crit1.setText(String.valueOf(preferenceMatrix[0][1]));
        mAhpResultsDialogBinding.ahpResultPreferenceMatrixAlt0Crit2.setText(String.valueOf(preferenceMatrix[0][2]));
        mAhpResultsDialogBinding.ahpResultPreferenceMatrixAlt0Crit3.setText(String.valueOf(preferenceMatrix[0][3]));

        mAhpResultsDialogBinding.ahpResultPreferenceMatrixAlt1Crit0.setText(String.valueOf(preferenceMatrix[1][0]));
        mAhpResultsDialogBinding.ahpResultPreferenceMatrixAlt1Crit1.setText(String.valueOf(preferenceMatrix[1][1]));
        mAhpResultsDialogBinding.ahpResultPreferenceMatrixAlt1Crit2.setText(String.valueOf(preferenceMatrix[1][2]));
        mAhpResultsDialogBinding.ahpResultPreferenceMatrixAlt1Crit3.setText(String.valueOf(preferenceMatrix[1][3]));

        mAhpResultsDialogBinding.ahpResultPreferenceMatrixAlt2Crit0.setText(String.valueOf(preferenceMatrix[2][0]));
        mAhpResultsDialogBinding.ahpResultPreferenceMatrixAlt2Crit1.setText(String.valueOf(preferenceMatrix[2][1]));
        mAhpResultsDialogBinding.ahpResultPreferenceMatrixAlt2Crit2.setText(String.valueOf(preferenceMatrix[2][2]));
        mAhpResultsDialogBinding.ahpResultPreferenceMatrixAlt2Crit3.setText(String.valueOf(preferenceMatrix[2][3]));

        mAhpResultsDialogBinding.ahpResultPreferenceMatrixAlt3Crit0.setText(String.valueOf(preferenceMatrix[3][0]));
        mAhpResultsDialogBinding.ahpResultPreferenceMatrixAlt3Crit1.setText(String.valueOf(preferenceMatrix[3][1]));
        mAhpResultsDialogBinding.ahpResultPreferenceMatrixAlt3Crit2.setText(String.valueOf(preferenceMatrix[3][2]));
        mAhpResultsDialogBinding.ahpResultPreferenceMatrixAlt3Crit3.setText(String.valueOf(preferenceMatrix[3][3]));

        show();
    }

    @Override
    public void setPresenter(AhpResultsDialogContract.Presenter presenter) {

    }
}
