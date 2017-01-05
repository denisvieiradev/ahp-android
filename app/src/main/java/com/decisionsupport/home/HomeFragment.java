package com.decisionsupport.home;

import android.app.FragmentManager;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.decisionsupport.R;
import com.decisionsupport.ahpmethod.AhpSteps.AhpStepperActivity;
import com.decisionsupport.databinding.HomeFragBinding;
import com.decisionsupport.selectassistmethod.SelectAssistMethodActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by denisvieira on 04/01/17.
 */
public class HomeFragment extends Fragment implements HomeContract.View{

    private HomeContract.Presenter mPresenter;
    private HomeFragBinding mBinding;
    private CustomSwipeAdapter mPagerAdapter;
    private List<String> frases;

    public HomeFragment() {}

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        frases = new ArrayList<>();
        frases.add("Veja agora a melhor decisão a se tomar .");
        frases.add("Justifique qualquer escolha sua .");
        frases.add("Tome a melhor decisão sempre, inicie já o " + getResources().getString(R.string.app_name) + ".");

        mPagerAdapter = new CustomSwipeAdapter(getContext(),frases);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.home_frag,container,false);

        mBinding.startDecisionsupportButton.setOnClickListener(view ->{
            Intent intent = new Intent(getContext(), SelectAssistMethodActivity.class);
            startActivity(intent);
        });

        mBinding.homeAppInfoPager.setAdapter(mPagerAdapter);
        mBinding.homePagerRadioGroup.check(mBinding.homePagerRadioGroup.getChildAt(0).getId());
        mBinding.homeAppInfoPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBinding.homePagerRadioGroup.check(mBinding.homePagerRadioGroup.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mBinding.homeAppInfoPager.setCurrentItem(0);
        mPagerAdapter.setTimer(mBinding.homeAppInfoPager,4);

        return mBinding.getRoot();
    }

    @Override
    public void goToDashboard() {

    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {

    }



}
