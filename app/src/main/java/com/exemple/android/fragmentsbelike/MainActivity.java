package com.exemple.android.fragmentsbelike;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewPager viewpager;
    TabLayout tablayout;
    TabItem chat;
    TabItem call;
    PagerAdapter pagerAdapter;
    TabItem note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initializing Variables
        toolbar = findViewById(R.id.toolbar);
        viewpager = findViewById(R.id.viewpager);
        tablayout = findViewById(R.id.tablayout);
        chat = findViewById(R.id.chat);
        call = findViewById(R.id.call);
        note = findViewById(R.id.note);

        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),tablayout.getTabCount());
        viewpager.setAdapter(pagerAdapter);

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 1){
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,android.R.color.holo_purple));
                    tablayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,android.R.color.holo_purple));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,android.R.color.holo_purple));
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
    }
}
