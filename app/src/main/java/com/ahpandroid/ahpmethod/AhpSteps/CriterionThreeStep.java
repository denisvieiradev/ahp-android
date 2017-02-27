package com.ahpandroid.ahpmethod.AhpSteps;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahpandroid.R;
import com.ahpandroid.databinding.AhpMethodCriterionOneStepBinding;
import com.ahpandroid.domain.entity.Alternative;
import com.ahpandroid.domain.entity.Criterion;
import com.github.fcannizzaro.materialstepper.AbstractStep;

import java.util.List;

/**
 * Created by denisvieira on 04/01/17.
 */
public class CriterionThreeStep extends AbstractStep {

    private AhpMethodCriterionOneStepBinding mBinding;
    private List<Alternative> mAlternatives;
    private Criterion mCriterion;

    @SuppressLint("ValidFragment")
    public CriterionThreeStep(List<Alternative> alternatives, Criterion criterion){
        this.mAlternatives = alternatives;
        this.mCriterion = criterion;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.ahp_method_criterion_one_step,container,false);

        return mBinding.getRoot();
    }

    @Override
    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
    }

    @Override
    public String name() {
        return "Tab " + getArguments().getInt("position", 0);
    }

    @Override
    public boolean isOptional() {
        return true;
    }

    @Override
    public void onStepVisible() {
    }

    @Override
    public void onNext() {
        System.out.println("onNext");
    }

    @Override
    public void onPrevious() {
        System.out.println("onPrevious");
    }

    @Override
    public String optional() {
        return "You can skip";
    }


    @Override
    public String error() {
        return "<b>You must click!</b> <small>this is the condition!</small>";
    }
}
