package com.losK.advancedmasterdetails;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class InvestmentFragment extends Fragment {

    public InvestmentFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_investment, container, false);
        final EditText amountEditText = (EditText) view.findViewById(R.id.amount_EditText);
        final EditText yearsEditText = (EditText) view.findViewById(R.id.years_EditText);
        Button calcButton = (Button) view.findViewById(R.id.calc_Button);
        final EditText resultEditText = (EditText) view.findViewById(R.id.result_EditText);

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double percent = 0.02;
                try {
                    int amount = Integer.parseInt(amountEditText.getText().toString());
                    int years = Integer.parseInt(yearsEditText.getText().toString());
                    double result = amount * Math.pow(percent + 1, years);
                    resultEditText.setText(Double.toString(result));
                } catch (Exception e) {
                    resultEditText.setText(R.string.calc_error);
                }
            }
        });

        return view;
    }
}
