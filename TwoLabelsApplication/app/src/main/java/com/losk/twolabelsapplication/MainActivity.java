package com.losk.twolabelsapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView_one)
    protected TextView textView1;
    @BindView(R.id.textView_two)
    protected TextView textView2;
    @BindView(R.id.click_button)
    protected Button clickButton;
    @BindView(R.id.click_button2)
    protected Button clickButton2;
    @BindView(R.id.click_button3)
    protected Button clickButton3;

    @OnClick({R.id.click_button, R.id.click_button2, R.id.click_button3})
    protected void onButtonClick(View v) {
        if (v instanceof Button) {
            Button casted = (Button) v;

            if (casted == clickButton) {
                textView1.setText("Text from button 1");
            } else if (casted == clickButton2) {
                textView2.setText("Text from button 2");
            } else {
                textView1.setText("");
                textView2.setText("");
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
