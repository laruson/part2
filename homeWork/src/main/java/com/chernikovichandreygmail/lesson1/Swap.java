package com.chernikovichandreygmail.lesson1;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.TextView;

import com.chernikovichandreygmail.R;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class Swap extends Activity implements View.OnClickListener {
    private TextView mTextViewOne;
    private TextView mTextViewTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_one);

        mTextViewOne = findViewById(R.id.textOne);
        mTextViewTwo = findViewById(R.id.textTwo);

        mTextViewOne.setOnClickListener(this);
        mTextViewTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swap();
            }
        });
    }

    public void buttonClick(View view) {
        swap();
    }

    @Override
    public void onClick(View v) {
        swap();
    }

    private void swap() {
        swapTextView();
        swapColorView();
    }

    private void swapTextView() {
        CharSequence textView = mTextViewOne.getText();
        mTextViewOne.setText(mTextViewTwo.getText());
        mTextViewTwo.setText(textView);
    }

    private void swapColorView() {
        Drawable colorView = mTextViewOne.getBackground();
        mTextViewOne.setBackground(mTextViewTwo.getBackground());
        mTextViewTwo.setBackground(colorView);
    }
}
