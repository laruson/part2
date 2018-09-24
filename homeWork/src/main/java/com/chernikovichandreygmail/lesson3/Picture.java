package com.chernikovichandreygmail.lesson3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.chernikovichandreygmail.Menu;
import com.chernikovichandreygmail.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class Picture extends Activity {
    private ImageView image;
    private EditText url;
    private ProgressBar progress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        image = findViewById(R.id.image);
        url = findViewById(R.id.urlPicture);
        progress = findViewById(R.id.progress);
    }

    public void load(View view) {
        progress.setVisibility(View.VISIBLE);
        Picasso.get()
                .load(String.valueOf(url.getText()))
                .transform(new CircularTransformation())
                .into(image, new Callback() {
            @Override
            public void onSuccess() {
                progress.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, Menu.class));
        finish();
    }
}
