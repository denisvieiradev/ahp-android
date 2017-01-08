package com.decisionsupport.selectassistmethod;

import android.app.ActivityOptions;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.decisionsupport.ahpmethod.AhpDashboard.AhpDashboardActivity;
import com.decisionsupport.R;
import com.decisionsupport.databinding.SelectAssistMethodFragBinding;
import com.decisionsupport.domain.entity.AssistMethod;
import com.decisionsupport.domain.enums.AssistMethodsEnum;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by denisvieira on 28/12/16.
 */
public class SelectAssistMethodFragment extends Fragment implements SelectAssistMethodContract.View{

    private SelectAssistMethodContract.Presenter mPresenter;
    private SelectAssistMethodFragBinding mBinding;
    private SelectAssistMethodAdapter mSelectAssistMethodAdapter;
    private List<AssistMethod> mAssistMethods;


    public SelectAssistMethodFragment() {}

    public static SelectAssistMethodFragment newInstance() {
        return new SelectAssistMethodFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        mAssistMethods = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,R.layout.select_assist_method_frag,container,false);

        AssistMethod assisMethodAHP = new AssistMethod("AHP",getResources().getString(R.string.select_assist_method_ahp_description), AssistMethodsEnum.AHP.getValue());
        AssistMethod assisMethodProgression = new AssistMethod("PROGRESSION","Description PROGRESSION", AssistMethodsEnum.PROGRESSION.getValue());
        AssistMethod assisMethodRegression = new AssistMethod("REGRESSION","Description REGRESSION", AssistMethodsEnum.REGRESSION.getValue());

        mAssistMethods.add(assisMethodAHP);
        mAssistMethods.add(assisMethodProgression);
        mAssistMethods.add(assisMethodRegression);

        mSelectAssistMethodAdapter = new SelectAssistMethodAdapter(getContext(),mAssistMethods, this);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mBinding.assistMethods.setLayoutManager(layout);
        mBinding.assistMethods.setNestedScrollingEnabled(false);
        mBinding.assistMethods.setAdapter(mSelectAssistMethodAdapter);

        return mBinding.getRoot();
    }

    @Override
    public void goToAHP() {
        Intent intent = new Intent(getContext(), AhpDashboardActivity.class);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
    }

    @Override
    public void goToRegression() {
        Toast.makeText(getContext(), "GO TO AHP REGRESSION METHOD", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goToProgression() {
        Toast.makeText(getContext(), "GO TO PROGRESSION METHOD", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(@NonNull SelectAssistMethodContract.Presenter presenter) {}
}
