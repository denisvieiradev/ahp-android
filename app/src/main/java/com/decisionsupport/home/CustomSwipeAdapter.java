package com.decisionsupport.home;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.decisionsupport.R;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by denisvieira on 29/09/16.
 */
public class CustomSwipeAdapter extends PagerAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<String> mAppInformations;
    final Handler handler = new Handler();
    public Timer swipeTimer ;

    public CustomSwipeAdapter(Context context, List<String> imageResources){
        this.mContext        = context;
        this.mAppInformations = imageResources;
    }

    @Override
    public int getCount() {
        return mAppInformations.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){

        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view  = mLayoutInflater.inflate(R.layout.home_pager_item,container,false);

        TextView infoText = (TextView) item_view.findViewById(R.id.home_app_info_text);
        infoText.setText(mAppInformations.get(position));

        container.addView(item_view);

        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){}

    public void setTimer(final ViewPager myPager, int time){
        final int size = mAppInformations.size();


        final Runnable Update = new Runnable() {
            int NUM_PAGES =size;
            int currentPage = 0 ;
            public void run() {
                if (currentPage == NUM_PAGES ) {
                    currentPage = 0;
                }
                myPager.setCurrentItem(currentPage++, true);
            }
        };

        swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(Update);
            }
        }, 1000, time*1000);
    }
}
