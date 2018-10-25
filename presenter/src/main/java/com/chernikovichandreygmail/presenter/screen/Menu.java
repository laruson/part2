package com.chernikovichandreygmail.presenter.screen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.chernikovichandreygmail.R;
import com.chernikovichandreygmail.presenter.screen.lesson1.Swap;
import com.chernikovichandreygmail.presenter.screen.lesson10.InfoActivity;
import com.chernikovichandreygmail.presenter.screen.lesson2.Flags;
import com.chernikovichandreygmail.presenter.screen.lesson3.Picture;
import com.chernikovichandreygmail.presenter.screen.lesson4.Main;
import com.chernikovichandreygmail.presenter.screen.lesson5.Wifi;
import com.chernikovichandreygmail.presenter.screen.lesson6.WifiControl;
import com.chernikovichandreygmail.presenter.screen.lesson7.LessonSevenActivityMain;
import com.chernikovichandreygmail.presenter.screen.lesson9.TimerActivity;

public class Menu extends Activity {
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void taskOne(View view) {
        intent = new Intent(this, Swap.class);
        startActivity(intent);
        finish();
    }

    public void taskTwo(View view) {
        intent = new Intent(this, Flags.class);
        startActivity(intent);
        finish();
    }

    public void taskThree(View view) {
        intent = new Intent(this, Picture.class);
        startActivity(intent);
        finish();
    }

    public void taskFour(View view) {
        intent = new Intent(this, Main.class);
        startActivity(intent);
        finish();
    }

    public void taskFive(View view) {
        intent = new Intent(this, Wifi.class);
        startActivity(intent);
        finish();
    }

    public void taskSix(View view) {
        intent = new Intent(this, WifiControl.class);
        startActivity(intent);
        finish();
    }

    public void taskSeven(View view) {
        intent = new Intent(this, LessonSevenActivityMain.class);
        startActivity(intent);
        finish();
    }
    public void taskNine(View view) {
        intent = new Intent(this, TimerActivity.class);
        startActivity(intent);
        finish();
    }
    public void taskTen(View view) {
        intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
        finish();
    }
}

