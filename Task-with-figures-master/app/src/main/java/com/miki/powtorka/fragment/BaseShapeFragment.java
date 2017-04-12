package com.miki.powtorka.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.miki.powtorka.R;
import com.miki.powtorka.calculations.Calculations;


public abstract class BaseShapeFragment extends Fragment {


    private EditText[] editTexts;
    private String[] editTextsLabels;
    private int imageRes;

    protected BaseShapeFragment(int fieldsNumber, int imageRes) {
        this(fieldsNumber, imageRes, new String[]{});
    }

    protected BaseShapeFragment(int fieldsNumber, int imageRes, String... editTextsLabels) {
        this.editTexts = new EditText[fieldsNumber];
        this.imageRes = imageRes;
        this.editTextsLabels = editTextsLabels;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.shape_calculation_fragment, container, false);
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.linearLayout);


        ImageView imgView = new ImageView(rootView.getContext());
        imgView.setImageResource(imageRes);
        linearLayout.addView(imgView);

        final TextView resultField = new TextView(rootView.getContext());
        resultField.setTextSize(24);

        generateFields(rootView, linearLayout);

        Button buttonArea = generateAreaButton(inflater, resultField);
        linearLayout.addView(buttonArea);

        Button buttonCircuit = generateCircuitButton(inflater, resultField);
        linearLayout.addView(buttonCircuit);

        linearLayout.addView(resultField);


        return rootView;

    }

    @NonNull
    private Button generateCircuitButton(final LayoutInflater inflater, final TextView resultField) {
        Button buttonCircuit = new Button(getContext());
        buttonCircuit.setText(R.string.circuit);
        buttonCircuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Calculations calculation = new Calculations();
                    double result = getCircuit(calculation);
                    String resultString = String.valueOf(result);
                    resultField.setText(resultString);
                } catch (NumberFormatException e) {
                    Toast.makeText(inflater.getContext(), R.string.wrong_data, Toast.LENGTH_SHORT).show();
                }

            }

        });
        return buttonCircuit;
    }

    @NonNull
    private Button generateAreaButton(final LayoutInflater inflater, final TextView resultField) {
        Button buttonArea = new Button(getContext());
        buttonArea.setText(R.string.area);
        buttonArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Calculations calculation = new Calculations();
                    double result = getArea(calculation);
                    String resultString = String.valueOf(result);
                    resultField.setText(resultString);
                } catch (NumberFormatException e) {
                    Toast.makeText(inflater.getContext(), R.string.wrong_data, Toast.LENGTH_SHORT).show();
                }
            }
        });
        return buttonArea;
    }

    private void generateFields(View rootView, LinearLayout linearLayout) {
        for (int i = 0; i < editTexts.length; i++) {
            editTexts[i] = new EditText(rootView.getContext());
            editTexts[i].setInputType(InputType.TYPE_CLASS_NUMBER);
            if (i < editTextsLabels.length) {
                editTexts[i].setHint(editTextsLabels[i]);
            } else {
                editTexts[i].setHint(generateHint(i));
            }

            linearLayout.addView(editTexts[i]);
        }
    }

    @NonNull
    private String generateHint(int i) {
        char c = (char) (i + 'a');
        return String.valueOf(c);
    }

    protected double valueOfField(int id) throws NumberFormatException {
        return Double.valueOf(editTexts[id].getText().toString());
    }

    abstract double getCircuit(Calculations calculations) throws NumberFormatException;

    abstract double getArea(Calculations calculations) throws NumberFormatException;


}



















