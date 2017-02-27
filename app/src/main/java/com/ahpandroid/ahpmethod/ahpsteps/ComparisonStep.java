package com.ahpandroid.ahpmethod.ahpsteps;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahpandroid.R;
import com.ahpandroid.databinding.AhpMethodComparisonStepBinding;
import com.ahpandroid.domain.entity.ComparisonItem;
import com.github.fcannizzaro.materialstepper.AbstractStep;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by denisvieira on 04/01/17.
 */
public class ComparisonStep extends AbstractStep {

    AhpMethodComparisonStepBinding mBinding;
    private AhpComparionItemAdapter mAhpComparionItemAdapter;
    private float[][] comparisonMatrix;
    private List<String> mComparisonItems;
    private String mComparisonTitle;
    private int mStepIndex;

    @SuppressLint("ValidFragment")
    public ComparisonStep(List<String> comparisonItems, String comparisonTitle, int stepIndex){
        this.mComparisonItems = comparisonItems;
        this.mComparisonTitle = comparisonTitle;
        this.mStepIndex = stepIndex;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAhpComparionItemAdapter = new AhpComparionItemAdapter(getContext(), new ArrayList<>());

        System.out.println(name());

        List<ComparisonItem> comparisonItemList = new ArrayList<>();
        comparisonItemList.add(new ComparisonItem(mComparisonItems.get(0), mComparisonItems.get(1)));
        comparisonItemList.add(new ComparisonItem(mComparisonItems.get(0), mComparisonItems.get(2)));
        comparisonItemList.add(new ComparisonItem(mComparisonItems.get(0), mComparisonItems.get(3)));
        comparisonItemList.add(new ComparisonItem(mComparisonItems.get(1), mComparisonItems.get(2)));
        comparisonItemList.add(new ComparisonItem(mComparisonItems.get(1), mComparisonItems.get(3)));
        comparisonItemList.add(new ComparisonItem(mComparisonItems.get(2), mComparisonItems.get(3)));

        mAhpComparionItemAdapter.replaceData(comparisonItemList);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.ahp_method_comparison_step,container,false);
        mBinding.setComparisonTitle(mComparisonTitle);

        mBinding.ahpMethodCriterionComparisonListRecyclerView.setNestedScrollingEnabled(false);
        mBinding.ahpMethodCriterionComparisonListRecyclerView.setFocusable(false);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mBinding.ahpMethodCriterionComparisonListRecyclerView.setLayoutManager(layout);
        mBinding.ahpMethodCriterionComparisonListRecyclerView.setAdapter(mAhpComparionItemAdapter);

        return mBinding.getRoot();
    }


    private void generateComparisonMatrice(){

        List<ComparisonItem> comparisonItems = mAhpComparionItemAdapter.getComparisonItems();
        ComparisonItem comparisonItem0 = comparisonItems.get(0);
        ComparisonItem comparisonItem1 = comparisonItems.get(1);
        ComparisonItem comparisonItem2 = comparisonItems.get(2);
        ComparisonItem comparisonItem3 = comparisonItems.get(3);
        ComparisonItem comparisonItem4 = comparisonItems.get(4);
        ComparisonItem comparisonItem5 = comparisonItems.get(5);

        float[][] matrix ={
                {1, comparisonItem0.getSecondAlternativeValue(), comparisonItem1.getSecondAlternativeValue(), comparisonItem2.getSecondAlternativeValue()},
                {comparisonItem0.getFirstAlternativeValue(), 1, comparisonItem3.getSecondAlternativeValue(), comparisonItem4.getSecondAlternativeValue()},
                {comparisonItem1.getFirstAlternativeValue(), comparisonItem3.getFirstAlternativeValue(), 1, comparisonItem5.getSecondAlternativeValue()},
                {comparisonItem2.getFirstAlternativeValue(), comparisonItem4.getFirstAlternativeValue(), comparisonItem5.getFirstAlternativeValue(), 1}
        };

        comparisonMatrix = matrix;
    }

    @Override
    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
    }

    @Override
    public String name() {
        return "Tab_"+mStepIndex;
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
        generateComparisonMatrice();

        imprimeMatriz(comparisonMatrix);
        mStepper.getExtras().putSerializable(name(), comparisonMatrix);

        System.out.println("onNext ");
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


    private void imprimeMatriz(float [][] criterion1matrix3){
        for(float[] c : criterion1matrix3){

            for(float elemento : c)
                System.out.printf(" %.2f ", elemento);
            System.out.printf("\n");
        }

    }

}
