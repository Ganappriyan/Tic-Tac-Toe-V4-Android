package com.delightful_disaster.tic_tac_toev4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {
    static TicTacToe o = new TicTacToe();
    static int GAMEMODE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        o.initialize();
        GAMEMODE = getIntent().getIntExtra("GAMEMODE", 0);
    }

    public void button1(View view) {
        button(view, 1);
    }
    public void button2(View view) {
        button(view, 2);
    }
    public void button3(View view) {
        button(view, 3);
    }
    public void button4(View view) {
        button(view, 4);
    }
    public void button5(View view) {
        button(view, 5);
    }
    public void button6(View view) {
        button(view, 6);
    }
    public void button7(View view) {
        button(view, 7);
    }
    public void button8(View view) {
        button(view, 8);
    }
    public void button9(View view) {
        button(view, 9);
    }

    public void resetGame(View view) {
        o.initialize();
        setButtonsText();
        setButtonEnabled(true);
        ((Button) findViewById(R.id.RetryButton)).setText("");
        ((Button) findViewById(R.id.RetryButton)).setEnabled(false);
    }

    void button(View view, int n) {
        ((Button)view).setText(o.CURRENT_PLAYER_SIGN);
        o.placeMove(n, o.CURRENT_PLAYER_SIGN);
        o.switchPlayer();
        checkWin();
        if(GAMEMODE > 0) {
            if(GAMEMODE == 1) {
                findButton(o.noobMove()).setText(String.valueOf(o.CURRENT_PLAYER_SIGN));
            }
            else if (GAMEMODE == 2) {
                findButton(o.veteranMove()).setText(String.valueOf(o.CURRENT_PLAYER_SIGN));
            }
            else if (GAMEMODE == 3) {
                findButton(o.proMove()).setText(String.valueOf(o.CURRENT_PLAYER_SIGN));
            }
            checkWin();
            o.switchPlayer();
        }
    }
    void checkWin() {
        int tmp = o.checkWin();
        if(tmp == 1) {
            ((TextView) findViewById(R.id.CommandText)).setText(R.string.draw);
            setButtonEnabled(false);
            ((Button) findViewById(R.id.RetryButton)).setText(R.string.play_again);
            ((Button) findViewById(R.id.RetryButton)).setEnabled(true);
        }
        else if(tmp == 2) {
            String a = o.playerInfo[(o.CURRENT_PLAYER_SIGN == 'X') ? 0 : 1]+" Won";
            ((TextView) findViewById(R.id.CommandText)).setText(a);
            setButtonEnabled(false);
            ((Button) findViewById(R.id.RetryButton)).setText(R.string.play_again);
            ((Button) findViewById(R.id.RetryButton)).setEnabled(true);
        }
    }
    void setButtonEnabled(Boolean state) {
        ((Button) findViewById(R.id.button1)).setEnabled(state);
        ((Button) findViewById(R.id.button2)).setEnabled(state);
        ((Button) findViewById(R.id.button3)).setEnabled(state);
        ((Button) findViewById(R.id.button4)).setEnabled(state);
        ((Button) findViewById(R.id.button5)).setEnabled(state);
        ((Button) findViewById(R.id.button6)).setEnabled(state);
        ((Button) findViewById(R.id.button7)).setEnabled(state);
        ((Button) findViewById(R.id.button8)).setEnabled(state);
        ((Button) findViewById(R.id.button9)).setEnabled(state);
    }
    void setButtonsText() {
        ((Button) findViewById(R.id.button1)).setText("");
        ((Button) findViewById(R.id.button2)).setText("");
        ((Button) findViewById(R.id.button3)).setText("");
        ((Button) findViewById(R.id.button4)).setText("");
        ((Button) findViewById(R.id.button5)).setText("");
        ((Button) findViewById(R.id.button6)).setText("");
        ((Button) findViewById(R.id.button7)).setText("");
        ((Button) findViewById(R.id.button8)).setText("");
        ((Button) findViewById(R.id.button9)).setText("");
    }
    Button findButton(int n) {
        switch(n) {
            case 1:
                return (Button) findViewById(R.id.button1);
            case 2:
                return (Button) findViewById(R.id.button2);
            case 3:
                return (Button) findViewById(R.id.button3);
            case 4:
                return (Button) findViewById(R.id.button4);
            case 5:
                return (Button) findViewById(R.id.button5);
            case 6:
                return (Button) findViewById(R.id.button6);
            case 7:
                return (Button) findViewById(R.id.button7);
            case 8:
                return (Button) findViewById(R.id.button8);
            case 9:
                return (Button) findViewById(R.id.button9);
        }
        return null;
    }
}