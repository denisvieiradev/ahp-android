package com.decisionsupport.SelectAssistMethod;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.decisionsupport.R;
import com.decisionsupport.databinding.SelectAssistMethodFragBinding;
import com.decisionsupport.domain.entity.AssistMethod;

import java.util.ArrayList;
import java.util.List;

import static android.databinding.repacked.google.common.base.Preconditions.checkNotNull;

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

        mSelectAssistMethodAdapter = new SelectAssistMethodAdapter(getContext(),mAssistMethods, this);
        mBinding.assistMethods.setAdapter(mSelectAssistMethodAdapter);

        return mBinding.getRoot();
    }

    @Override
    public void goToAHP() {

    }

    @Override
    public void goToRegression() {

    }

    @Override
    public void goToProgression() {

    }

    @Override
    public void setPresenter(@NonNull SelectAssistMethodContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }
}
