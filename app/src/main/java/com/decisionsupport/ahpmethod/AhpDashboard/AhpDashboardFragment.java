package com.decisionsupport.ahpmethod.AhpDashboard;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.decisionsupport.ahpmethod.AhpSteps.AhpStepperActivity;
import com.decisionsupport.R;
import com.decisionsupport.databinding.AhpMultistepsFragBinding;

/**
 * Created by denisvieira on 04/01/17.
 */
public class AhpDashboardFragment extends Fragment implements AhpDashboardContract.View{

    private AhpDashboardContract.Presenter mPresenter;
    private AhpMultistepsFragBinding mBinding;

    public AhpDashboardFragment() {}

    public static AhpDashboardFragment newInstance() {
        return new AhpDashboardFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.ahp_multisteps_frag,container,false);

        if (mBinding.ahpMultiStepsToolbar != null){
            ((AppCompatActivity) getActivity()).setSupportActionBar(mBinding.ahpMultiStepsToolbar);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
            mBinding.ahpMultiStepsToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_left));
            mBinding.ahpMultiStepsToolbar.setNavigationOnClickListener( View ->{
                getActivity().onBackPressed();
            });
        }

        mBinding.ahpDashboardStartButton.setOnClickListener(view ->{
            Intent intent = new Intent(getContext(), AhpStepperActivity.class);
            startActivity(intent);
        });

        setHasOptionsMenu(true);
        return mBinding.getRoot();
    }

    @Override
    public void startNew() {

    }

    @Override
    public void setPresenter(AhpDashboardContract.Presenter presenter) {}
}
