package com.delightful_disaster.tic_tac_toev4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playerVsProgramButton(View view) {
        Intent i = new Intent(this, singlePlayerMenuActivity.class);
        startActivity(i);
    }

    public void playerVsPlayerButton(View view) {
        Intent i = new Intent(this, GameScreen.class);
        i.putExtra("GAMEMODE", 0);
        startActivity(i);
    }
}