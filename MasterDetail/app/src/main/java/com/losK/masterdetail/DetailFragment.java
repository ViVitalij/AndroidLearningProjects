package com.losK.masterdetail;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {

    private TextView titleTextView;
    private TextView detailsTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_layout, container);

        titleTextView = (TextView) view.findViewById(R.id.titleTextView);
        detailsTextView = (TextView) view.findViewById(R.id.detailsTextView);

        return view;
    }

    public void showBasicData() {
        titleTextView.setText(R.string.general_information);
        detailsTextView.setText(R.string.dummy_kowalski);
    }

    public void showDetailsData() {

        titleTextView.setText(R.string.specific_information);
        detailsTextView.setText(R.string.dummy_ageHeight);
    }
}
