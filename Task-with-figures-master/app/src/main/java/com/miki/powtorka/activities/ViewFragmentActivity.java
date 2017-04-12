package com.miki.powtorka.activities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.miki.powtorka.R;
import com.miki.powtorka.fragment.FragmentCircle;
import com.miki.powtorka.fragment.FragmentRectangle;
import com.miki.powtorka.fragment.FragmentTriangle;

public class ViewFragmentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fragment);

        int MenuPick = getIntent().getIntExtra("MenuPick", 0);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        if (MenuPick == 0) {
            transaction.replace(R.id.frameFragment, new FragmentCircle());
        } else if (MenuPick == 1) {
            transaction.replace(R.id.frameFragment, new FragmentTriangle());
        } else {
            transaction.replace(R.id.frameFragment, new FragmentRectangle());
        }

        transaction.commit();
    }
}