package com.losk.applifecycleandintentresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResultActivity extends AppCompatActivity {

    @BindView(R.id.editText)
    protected EditText editText;

    @OnClick(R.id.buttonFinish)
    protected void finishClicked() {
        Intent returnIntent = new Intent();

        //umieszczam dodatkowe informacje(zawartosc text fields)
        returnIntent.putExtra("resultString", editText.getText().toString());

        //ustawiam wynik/result tego ACTIVITY podajac rowniez intent jako zwracana wartosc
        setResult(RESULT_OK, returnIntent);

        //zamyka result activity
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
    }
}
