package com.ahpandroid.ahpmethod.AhpSteps;

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
import com.ahpandroid.databinding.AhpMethodCriterionOneStepBinding;
import com.ahpandroid.domain.entity.Alternative;
import com.ahpandroid.domain.entity.ComparisonItem;
import com.ahpandroid.domain.entity.Criterion;
import com.github.fcannizzaro.materialstepper.AbstractStep;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by denisvieira on 04/01/17.
 */
public class CriterionOneStep extends AbstractStep {

    AhpMethodCriterionOneStepBinding mBinding;
    private AhpComparionItemAdapter mAhpComparionItemAdapter;
    private float[][] criterionMatrix;
    private List<Alternative> mAlternatives;
    private Criterion mCriterion;

    @SuppressLint("ValidFragment")
    public CriterionOneStep(List<Alternative> alternatives, Criterion criterion){
        this.mAlternatives = alternatives;
        this.mCriterion = criterion;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAhpComparionItemAdapter = new AhpComparionItemAdapter(getContext(), new ArrayList<>());

        List<ComparisonItem> comparisonItemList = new ArrayList<>();
        comparisonItemList.add(new ComparisonItem(mAlternatives.get(0).getTitle(),mAlternatives.get(1).getTitle()));
        comparisonItemList.add(new ComparisonItem(mAlternatives.get(0).getTitle(),mAlternatives.get(2).getTitle()));
        comparisonItemList.add(new ComparisonItem(mAlternatives.get(0).getTitle(),mAlternatives.get(3).getTitle()));
        comparisonItemList.add(new ComparisonItem(mAlternatives.get(1).getTitle(),mAlternatives.get(2).getTitle()));
        comparisonItemList.add(new ComparisonItem(mAlternatives.get(1).getTitle(),mAlternatives.get(3).getTitle()));
        comparisonItemList.add(new ComparisonItem(mAlternatives.get(2).getTitle(),mAlternatives.get(3).getTitle()));

        mAhpComparionItemAdapter.replaceData(comparisonItemList);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.ahp_method_criterion_one_step,container,false);
        mBinding.setCriterion(mCriterion);

        mBinding.ahpMethodCriterionComparisonListRecyclerView.setNestedScrollingEnabled(false);
        mBinding.ahpMethodCriterionComparisonListRecyclerView.setFocusable(false);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mBinding.ahpMethodCriterionComparisonListRecyclerView.setLayoutManager(layout);
        mBinding.ahpMethodCriterionComparisonListRecyclerView.setAdapter(mAhpComparionItemAdapter);

        return mBinding.getRoot();
    }

    private void generateCriterionMatrice(){

        List<ComparisonItem> comparisonItems = mAhpComparionItemAdapter.getComparisonItems();
        ComparisonItem comparisonItem0 = comparisonItems.get(0);
        ComparisonItem comparisonItem1 = comparisonItems.get(1);
        ComparisonItem comparisonItem2 = comparisonItems.get(2);
        ComparisonItem comparisonItem3 = comparisonItems.get(3);
        ComparisonItem comparisonItem4 = comparisonItems.get(4);
        ComparisonItem comparisonItem5 = comparisonItems.get(5);

        float[][] matrix =
                {{1, comparisonItem0.getSecondAlternativeValue(), comparisonItem1.getSecondAlternativeValue(), comparisonItem2.getSecondAlternativeValue()},
                        {comparisonItem0.getFirstAlternativeValue(), 1, comparisonItem3.getSecondAlternativeValue(), comparisonItem4.getSecondAlternativeValue()},
                        {comparisonItem1.getFirstAlternativeValue(), comparisonItem3.getFirstAlternativeValue(), 1, comparisonItem5.getSecondAlternativeValue()},
                        {comparisonItem2.getFirstAlternativeValue(), comparisonItem4.getFirstAlternativeValue(), comparisonItem5.getFirstAlternativeValue(), 1}};

        criterionMatrix = matrix;
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
        generateCriterionMatrice();

        imprimeMatriz(criterionMatrix);

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


    public void imprimeMatriz(float [][] criterion1matrix3){
        for(float[] c : criterion1matrix3){

            for(float elemento : c)
                System.out.printf(" %.2f ", elemento);
            System.out.printf("\n");
        }

    }

    public float[][] inicializaMatriz(int l, int c ) {

        float [][] criterion1matrixNull = new float[l][c];
        for (int linha = 0; linha<criterion1matrixNull.length; linha++){
            for (int coluna =0; coluna<criterion1matrixNull.length; coluna++) {
                if(linha==coluna)
                    criterion1matrixNull[linha][coluna]=1;
                else
                    criterion1matrixNull[linha][coluna] =1/9;
            }
        }
//
//        criterion1matrix[0][0]=1;
//        criterion1matrix[1][1]=1;
//        criterion1matrix[2][2]=1;
//        criterion1matrix[3][3]=1;

        return criterion1matrixNull;
    }
}
