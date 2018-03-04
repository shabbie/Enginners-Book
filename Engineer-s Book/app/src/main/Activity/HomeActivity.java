package com.example.abhishekkoranne.engineersbook.Activity;

import android.support.annotation.ColorRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.abhishekkoranne.engineersbook.R;
import com.example.abhishekkoranne.engineersbook.Fragment.ArticlesFragment;
import com.example.abhishekkoranne.engineersbook.Fragment.DoubtsFragment;
import com.example.abhishekkoranne.engineersbook.Fragment.NotificationFragment;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class HomeActivity extends AppCompatActivity {
    ImageLoaderConfiguration config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);

        final ViewPager my_pager = (ViewPager) findViewById(R.id.my_pager);
        TabLayout my_tabs = (TabLayout) findViewById(R.id.my_tabs);

        my_pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        my_tabs.setupWithViewPager(my_pager);
        //TASK = This code is to change fragment by tabs on tablayout
        // DOUBT : Commented then also task was completed.
        my_tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                my_pager.setCurrentItem(tab.getPosition()); //when we have to change frag by clicking tabs
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    class MyPagerAdapter extends FragmentPagerAdapter {
        String[] tabs = {"Article", "Doubt", "Notification"};

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) return new ArticlesFragment();
            else if (position == 1) return new DoubtsFragment();
            else if (position == 2) return new NotificationFragment();
            return null;
        }

        @Override
        public int getCount() {
            return tabs.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }
    }

}
