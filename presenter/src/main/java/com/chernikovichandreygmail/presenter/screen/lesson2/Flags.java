package com.chernikovichandreygmail.presenter.screen.lesson2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.chernikovichandreygmail.presenter.screen.Menu;
import com.chernikovichandreygmail.R;

public class Flags extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag_lesson2);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, Menu.class));
        finish();
    }
}
