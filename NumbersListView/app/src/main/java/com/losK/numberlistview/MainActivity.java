package com.losK.numberlistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.losK.numberslistview.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity {

    private TextView maxTextView;
    private TextView minTextView;
    private TextView meanTextView;
    private List<Integer> numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.editText);
        ListView numbersListView = (ListView) findViewById(R.id.numbersListView);
        Button addButton = (Button) findViewById(R.id.addButton);
        maxTextView = (TextView) findViewById(R.id.maxTextView);
        minTextView = (TextView) findViewById(R.id.minTextView);
        meanTextView = (TextView) findViewById(R.id.meanTextView);

        numbers = generateNumbers();
        Collections.sort(numbers);

        final NumberAdapter numberAdapter = new NumberAdapter(numbers);
        numbersListView.setAdapter(numberAdapter);
        calculateFields();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stringValue = editText.getText().toString();
                try {
                    int value = Integer.parseInt(stringValue);
                    numbers.add(value);
                    Collections.sort(numbers);
                    editText.setText("");
                    numberAdapter.notifyDataSetChanged();
                    calculateFields();
                } catch (NumberFormatException e) {
                }
            }
        });

    }

    private void calculateFields() {
        if (numbers.isEmpty()) {
            minTextView.setText("-");
            maxTextView.setText("-");
        } else {
            int minValue = Statistics.min(numbers);
            minTextView.setText(String.valueOf(minValue));
            int maxValue = Statistics.max(numbers);
            maxTextView.setText(String.valueOf(maxValue));
        }
        double meanValue = Statistics.mean(numbers);
        meanTextView.setText(String.valueOf(meanValue));
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random(100);
        for (int i = 0; i < 5; i++) {
            numbers.add(random.nextInt(10));
        }
        return numbers;
    }

    private class NumberAdapter extends BaseAdapter {

        private List<Integer> numbers;

        private NumberAdapter(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int getCount() {
            return numbers.size();
        }

        @Override
        public Object getItem(int position) {
            return numbers.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView;
            if (convertView != null) {
                textView = (TextView) convertView;
            } else {
                textView = new TextView(MainActivity.this);
            }
            textView.setText(String.valueOf(numbers.get(position)));
            return textView;
        }
    }
}
