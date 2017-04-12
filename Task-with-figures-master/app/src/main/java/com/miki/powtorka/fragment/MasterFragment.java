package com.miki.powtorka.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.miki.powtorka.R;
import com.miki.powtorka.activities.MainActivity;

public class MasterFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        final View rootView = inflater.inflate(R.layout.master_fragment, container, false);

        final MainActivity activity = (MainActivity) getActivity();

        final Button buttonCircle = (Button) rootView.findViewById(R.id.circleButton);
        buttonCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.showCircleCalculation();
            }
        });

        final Button buttonTriangle = (Button) rootView.findViewById(R.id.triangleButton);
        buttonTriangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.showTriangleCalculation();
            }
        });

        final Button buttonRectangle = (Button) rootView.findViewById(R.id.rectangleButton);
        buttonRectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.showRectangleCalculation();
            }
        });


        return rootView;
    }
}
