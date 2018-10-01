package com.chernikovichandreygmail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.chernikovichandreygmail.lesson1.Swap;
import com.chernikovichandreygmail.lesson2.Flags;
import com.chernikovichandreygmail.lesson3.Picture;
import com.chernikovichandreygmail.lesson4.Lesson4Main;

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

    public void taskThree(View view) {
        intent=new Intent(this, Picture.class);
        startActivity(intent);
        finish();
    }

    public void taskFour(View view) {
        intent=new Intent(this, Lesson4Main.class);
        startActivity(intent);
        finish();
    }


}
