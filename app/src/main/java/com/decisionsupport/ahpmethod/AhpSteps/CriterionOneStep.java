package com.decisionsupport.ahpmethod.AhpSteps;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.decisionsupport.R;
import com.decisionsupport.databinding.AhpMethodCriterionOneStepBinding;
import com.decisionsupport.domain.entity.AhpMethod;
import com.decisionsupport.domain.entity.Alternative;
import com.decisionsupport.domain.entity.ComparisonItem;
import com.decisionsupport.domain.entity.Criterion;
import com.decisionsupport.domain.enums.ComparisonDefinitionEnum;
import com.github.fcannizzaro.materialstepper.AbstractStep;

import java.util.ArrayList;
import java.util.List;

import static android.content.Intent.getIntent;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by denisvieira on 04/01/17.
 */
public class CriterionOneStep extends AbstractStep {

    AhpMethodCriterionOneStepBinding mBinding;
    private AhpComparionItemAdapter mAhpComparionItemAdapter;
    private float[][] criterion1matrix;
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


        configureSeekBars();

        return mBinding.getRoot();
    }


    public void configureSeekBars(){
//        mBinding.ahpMethodCriterionOneStepFirstSeekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
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
        mAhpComparionItemAdapter.getComparisonItems().get(0).getSecondAlternativeStringValue();

        System.out.println("onNext : "+mAhpComparionItemAdapter.getComparisonItems().get(0).getFirstAlternativeStringValue()+" - "+mAhpComparionItemAdapter.getComparisonItems().get(0).getSecondAlternativeStringValue());
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


    private void verificaSeekBar(int progress, int i, int j) {

        switch (progress) {

            case 0:
                criterion1matrix[i][j] = 1/9.2f;
                criterion1matrix[j][i] = 9;
                break;

            case 1:

//                Snackbar.make(findViewById(android.R.id.content), "Localização Muito Inferior", Snackbar.LENGTH_LONG).show();
                criterion1matrix[i][j] = 1/7.2f;
                criterion1matrix[j][i] = 7;
                break;

            case 2:
//                Snackbar.make(findViewById(android.R.id.content), "Localização com Grande Inferioridade", Snackbar.LENGTH_LONG).show();
                criterion1matrix[i][j] = 1/5.2f;
                criterion1matrix[j][i] = 5;
                break;
            case 3:
//                Snackbar.make(findViewById(android.R.id.content), "Localização com Pequena Inferioridade", Snackbar.LENGTH_LONG).show();
                criterion1matrix[i][j] = 1/3.2f;
                criterion1matrix[j][i] = 3;
                break;
            case 4:
//                Snackbar.make(findViewById(android.R.id.content), "Igual Importância", Snackbar.LENGTH_LONG).show();
                criterion1matrix[i][j] = 1;
                criterion1matrix[j][i] = 1;
                break;
            case 5:
//                Snackbar.make(findViewById(android.R.id.content), "Localização com Pequena Superioridade", Snackbar.LENGTH_LONG).show();
                criterion1matrix[i][j] = 3;
                criterion1matrix[j][i] = 1/3.2f;
                break;
            case 6:
//                Snackbar.make(findViewById(android.R.id.content), "Localização com Grande Superioridade", Snackbar.LENGTH_LONG).show();
                criterion1matrix[i][j] = 5;
                criterion1matrix[j][i] = 1/5.2f;
                break;
            case 7:
//                Snackbar.make(findViewById(android.R.id.content), "Localização Muito Superior", Snackbar.LENGTH_LONG).show();
                criterion1matrix[i][j] = 7;
                criterion1matrix[j][i] = 1/7.2f;
                break;
            case 8:
//                Snackbar.make(findViewById(android.R.id.content), "Localização Absolutamente Superior", Snackbar.LENGTH_LONG).show();
                criterion1matrix[i][j] = 9;
                criterion1matrix[j][i] = 1/9.2f;
                break;
        }



//        System.out.println("\nMatriz");
//        imprimeMatriz(criterion1matrix);
//        System.out.println("\nMatriz normalizada:");
//        float[][] criterion1matrix2;
//        AhpMethod ahp = new AhpMethod();
//        criterion1matrix2 = ahp.nomaliza(criterion1matrix);
//        imprimeMatriz(criterion1matrix2);
//        System.out.println("\nMatriz Media:");
        //imprimeMatriz(ahp.criterion1matrixMedia(criterion1matrix2));
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

        criterion1matrix[0][0]=1;
        criterion1matrix[1][1]=1;
        criterion1matrix[2][2]=1;
        criterion1matrix[3][3]=1;

        return criterion1matrixNull;
    }
}
