package com.miki.powtorka.activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.miki.powtorka.R;
import com.miki.powtorka.fragment.FragmentCircle;
import com.miki.powtorka.fragment.FragmentRectangle;
import com.miki.powtorka.fragment.FragmentTriangle;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAdapterIfViewPagerExists();
    }

    private void setAdapterIfViewPagerExists() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        if (viewPager != null) {
            viewPager.setAdapter(new MyAdapter(getFragmentManager()));
        }
    }

    public void showCircleCalculation() {
        View frameFragment = findViewById(R.id.frameFragment);
        if (frameFragment != null) {
            transactionForFragment(new FragmentCircle());
        } else {
            startActivityWithMenuPick(0);
        }
    }

    public void showTriangleCalculation() {
        View frameFragment = findViewById(R.id.frameFragment);
        if (frameFragment != null) {
            transactionForFragment(new FragmentTriangle());
        } else {
            startActivityWithMenuPick(1);
        }
    }


    public void showRectangleCalculation() {
        View frameFragment = findViewById(R.id.frameFragment);
        if (frameFragment != null) {
            transactionForFragment(new FragmentRectangle());
        } else {
            startActivityWithMenuPick(2);
        }
    }

    private void transactionForFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameFragment, fragment);
        transaction.commit();
    }

    private void startActivityWithMenuPick(int menuPick) {
        Intent intent = new Intent(this, ViewFragmentActivity.class);
        intent.putExtra("MenuPick", menuPick);
        startActivity(intent);
    }

    private class MyAdapter extends FragmentPagerAdapter {

        public static final int NUMBER_OF_PAGES = 3;
        private final int[] names = {R.string.circle, R.string.rectangle, R.string.triangle};

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0)
                return new FragmentCircle();
            if (position == 1)
                return new FragmentRectangle();
            return new FragmentTriangle();

        }

        @Override
        public int getCount() {
            return NUMBER_OF_PAGES;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return getString(names[position]);
        }
    }
}
