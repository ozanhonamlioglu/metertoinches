package com.example.metertoinches;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*
    * 1m = 39.3701in
    * */

    private ConstraintLayout mLayout;
    private Button mButton;
    private TextView mTextView;
    private EditText mEditText;

    // input variables
    private double multiplier = 39.37;
    private double result = 0.0;
    private double meterValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init variables
        mTextView = (TextView) findViewById(R.id.textView);
        mEditText = (EditText) findViewById(R.id.editText);
        mButton = (Button) findViewById(R.id.button);
        mLayout = (ConstraintLayout) findViewById(R.id.mainLayout);

        // Listeners
        buttonListener();
        mainTapListener();
    }

    public void buttonListener() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard(v);
                meterValue = Double.parseDouble(mEditText.getText().toString());
                result = meterValue * multiplier;
                mTextView.setText(Double.toString(result));
            }
        });
    }

    public void mainTapListener() {
        mLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideKeyboard(v);
                return false;
            }
        });
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


}