package com.losK.advancedmasterdetails;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //showCurrencyCalculator();
    }

    public void showCurrencyCalculator() {
        if (findViewById(R.id.fragmentFrame) != null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentFrame, new CurrencyCalculatorFragment());
            transaction.commit();
        } else {
            Intent intent = new Intent(this, CurrencyCalculatorActivity.class);
            startActivity(intent);
        }
    }

    public void showInvestmentButton() {
        if (findViewById(R.id.fragmentFrame) != null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.setCustomAnimations(R.animator.fragment_in, R.animator.fragment_out);
            transaction.replace(R.id.fragmentFrame, new InvestmentFragment());
            transaction.commit();
        } else {
            Intent intent = new Intent(this, InvestmentActivity.class);
            startActivity(intent);
        }
    }
}
