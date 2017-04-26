package com.qg.route.moments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.qg.route.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr_Do on 2017/4/25.
 */

public class MomentsActivity extends AppCompatActivity {

    private CoordinatorLayout mMomentsLayout;
    private Toolbar mToolBar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private final static String MOMENTS_FRAGMENT_TITLE = "动态";
    private final static String DATA_FRAGMENT_TITLE = "我的资料";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moments);
        mMomentsLayout = (CoordinatorLayout) findViewById(R.id.moments_layout);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mToolBar = (Toolbar) findViewById(R.id.moments_toolbar);
        mViewPager = (ViewPager) findViewById(R.id.moments_view_pager);
        initUI();
    }

    private void initUI() {
        setSupportActionBar(mToolBar);
        MomentsPagerAdapter adapter = new MomentsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MomentsFragment() , MOMENTS_FRAGMENT_TITLE);
        adapter.addFragment(new DataFragment() , DATA_FRAGMENT_TITLE);
        mViewPager.setAdapter(adapter);
        mTabLayout.addTab(mTabLayout.newTab().setText("ONE"));
        mTabLayout.addTab(mTabLayout.newTab().setText("TWO"));
    }

    private class MomentsPagerAdapter extends FragmentPagerAdapter{

        private List<Fragment> mFragments = new ArrayList<>();
        private List<String> mFragmentTitles = new ArrayList<>();

        public MomentsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment ,String name){
            mFragments.add(fragment);
            mFragmentTitles.add(name);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}
