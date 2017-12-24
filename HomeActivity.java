package com.example.abhishekkoranne.engineersbook.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.abhishekkoranne.engineersbook.Fragment.ArticlesFragment;
import com.example.abhishekkoranne.engineersbook.Fragment.DoubtsFragment;
import com.example.abhishekkoranne.engineersbook.Fragment.NotificationFragment;
import com.example.abhishekkoranne.engineersbook.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


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

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    private Boolean exit = false;
    @Override
    public void onBackPressed() {
  /*      if (exit) {
            System.exit(0);
            //finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }
*/        /*Intent intent = new Intent();
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);/*//***Change Here***
         startActivity(intent);
         finish();*/
//        System.exit(0);
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit Engineer's Book")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton("no", null).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //finish();

                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
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
