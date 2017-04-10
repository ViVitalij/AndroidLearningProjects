package com.losK.advancedmasterdetails;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class CurrencyCalculatorFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_currency_calculator, container, false);
        final EditText resultEditText = (EditText) view.findViewById(R.id.result_EditText);
        Button calcButton = (Button) view.findViewById(R.id.calc_Button);
        final EditText valueEditText = (EditText) view.findViewById(R.id.value_EditText);
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringValue = valueEditText.getText().toString();
                try {
                    int value = Integer.parseInt(stringValue);
                    double result = value * 3.75;
                    resultEditText.setText(Double.toString(result));
                } catch (Exception e) {
                    resultEditText.setText(R.string.calc_error);
                }
            }
        });
        return view;
    }
}
