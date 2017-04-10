package com.losK.fragmentexample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast() {
        Toast.makeText(this, R.string.hello_world, Toast.LENGTH_LONG).show();
    }
}
