package com.ahpandroid.home;

import android.app.Dialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahpandroid.R;
import com.ahpandroid.ahpmethod.ahpdashboard.AhpDashboardActivity;
import com.ahpandroid.databinding.AppInfoDialogBinding;
import com.ahpandroid.databinding.HomeFragBinding;

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
    private Dialog appInfoDialog;
    private AppInfoDialogBinding appInfoDialogBinding;

    public HomeFragment() {}

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        frases = new ArrayList<>();
        frases.add(getResources().getString(R.string.home_app_info_phrase_1));
        frases.add(getResources().getString(R.string.home_app_info_phrase_2));
        frases.add(getResources().getString(R.string.home_app_info_phrase_3));

        mPagerAdapter = new CustomSwipeAdapter(getContext(),frases);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.home_frag,container,false);


        mBinding.homeAppInfoPager.setAdapter(mPagerAdapter);
        mBinding.setHandler(this);
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
        mPagerAdapter.setTimer(mBinding.homeAppInfoPager,5);

        configAppInfoDialog();

        return mBinding.getRoot();
    }

    @Override
    public void goToDashboard(View view) {
        Intent intent = new Intent(getContext(), AhpDashboardActivity.class);
        startActivity(intent);
    }

    @Override
    public void showAppInfo(View view) {
        appInfoDialog.show();
    }

    @Override
    public void closeAppInfo(View view) {
     appInfoDialog.cancel();
    }

    @Override
    public void goToDenisGithub(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/fromdenisvieira"));
        startActivity(browserIntent);
    }

    @Override
    public void goToGabrielGithub(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/gabe351"));
        startActivity(browserIntent);
    }

    @Override
    public void goToProjectGithub(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/fromdenisvieira/ahp-android"));
        startActivity(browserIntent);
    }

    private void configAppInfoDialog(){

        appInfoDialog = new Dialog(getContext(), R.style.DialogTheme);
        appInfoDialogBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.app_info_dialog, null, false);
        appInfoDialogBinding.setHandler(this);
        appInfoDialog.setContentView(appInfoDialogBinding.getRoot());
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {

    }



}
