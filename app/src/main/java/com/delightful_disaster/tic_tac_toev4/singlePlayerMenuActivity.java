package com.delightful_disaster.tic_tac_toev4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class singlePlayerMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player_menu);
    }

    public void noobButton(View view) {
        Intent i = new Intent(this, GameScreen.class);
        i.putExtra("GAMEMODE", 1);
        startActivity(i);
    }

    public void veteranButton(View view) {
        Intent i = new Intent(this, GameScreen.class);
        i.putExtra("GAMEMODE", 2);
        startActivity(i);
    }

    public void proButton(View view) {
        Intent i = new Intent(this, GameScreen.class);
        i.putExtra("GAMEMODE", 3);
        startActivity(i);
    }

    public void infoButton(View view) {
        Intent i = new Intent(this, InfoActivity.class);
        startActivity(i);
    }
}