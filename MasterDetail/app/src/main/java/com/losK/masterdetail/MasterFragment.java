package com.losK.masterdetail;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MasterFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final MainActivity activity = (MainActivity) getActivity();
        View view = inflater.inflate(R.layout.master_layout, container);
        Button basicDataButton = (Button) view.findViewById(R.id.basicDataButton);
        Button detailsButton = (Button) view.findViewById(R.id.detailsButton);
        basicDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.showBasicData();
            }
        });

        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.showDetailsData();
            }
        });
        return view;
    }
}
