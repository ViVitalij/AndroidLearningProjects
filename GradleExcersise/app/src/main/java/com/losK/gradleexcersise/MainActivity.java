package com.losK.gradleexcersise;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ArrayMath;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textField);
        int[] numbers = {1, 2, 32, 1, 2};
        textView.setText(Integer.toString(ArrayMath.max(numbers)));
    }
}
