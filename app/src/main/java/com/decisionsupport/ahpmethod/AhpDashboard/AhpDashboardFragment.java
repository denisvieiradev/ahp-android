package com.decisionsupport.ahpmethod.AhpDashboard;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.decisionsupport.R;
import com.decisionsupport.databinding.AhpDashboardFragBinding;

/**
 * Created by denisvieira on 04/01/17.
 */
public class AhpDashboardFragment extends Fragment implements AhpDashboardContract.View{

    private AhpDashboardContract.Presenter mPresenter;
    private AhpDashboardFragBinding mBinding;

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
        mBinding = DataBindingUtil.inflate(inflater, R.layout.ahp_dashboard_frag,container,false);

        if (mBinding.ahpDashboardToolbar != null){
            ((AppCompatActivity) getActivity()).setSupportActionBar(mBinding.ahpDashboardToolbar);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
            mBinding.ahpDashboardToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_left));
            mBinding.ahpDashboardToolbar.setNavigationOnClickListener( View ->{
                getActivity().onBackPressed();
            });
        }

//        mBinding.ahpDashboardStartButton.setOnClickListener(view ->{
//            Intent intent = new Intent(getContext(), AhpStepperActivity.class);
//            startActivity(intent);
//        });

        setHasOptionsMenu(true);
        return mBinding.getRoot();
    }

    @Override
    public void startNew() {

    }

    @Override
    public void setPresenter(AhpDashboardContract.Presenter presenter) {}
}
