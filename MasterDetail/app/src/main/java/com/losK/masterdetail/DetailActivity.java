package com.losK.masterdetail;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

public class DetailActivity extends Activity {

    public static final int BASIC_DATA = 0;
    public static final int DETAILS = 1;
    public static final String TO_SHOW = "TO_SHOW";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int toShow = getIntent().getIntExtra(TO_SHOW, BASIC_DATA);

        FragmentManager fm = getFragmentManager();
        DetailFragment detailFragment = (DetailFragment) fm.findFragmentById(R.id.detailFragment);

        if (toShow == BASIC_DATA) {
            detailFragment.showBasicData();
        } else if (toShow == DETAILS) {
            detailFragment.showDetailsData();
        }
    }
}
