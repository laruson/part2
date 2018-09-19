package com.chernikovichandreygmail;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.TextView;

import com.chernikovichandreygmail.R;
import com.chernikovichandreygmail.lesson1.Swap;
import com.chernikovichandreygmail.lesson2.Flags;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class Menu extends Activity {
    private Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void taskOne(View view) {
        intent=new Intent(this, Swap.class);
        startActivity(intent);
        finish();
    }

    public void taskTwo(View view) {
        intent=new Intent(this, Flags.class);
        startActivity(intent);
        finish();
    }

    private void hello(){

    }
}
