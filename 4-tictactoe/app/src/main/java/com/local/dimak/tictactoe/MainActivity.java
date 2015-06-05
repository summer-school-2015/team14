package com.local.dimak.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener{
    int a[][];
    int turn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = new int[8][8];
        turn = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                a[i][j] = 0;
            }
        }
    }

    public boolean check(int v, int u) {
        if ((a[v - 1][u] == turn) && (a[v - 2][u] == turn)) {
            return true;
        }
        if ((a[v - 1][u] == turn) && (a[v + 1][u] == turn)) {
            return true;
        }
        if ((a[v + 1][u] == turn) && (a[v + 2][u] == turn)) {
            return true;
        }

        if ((a[v][u - 1] == turn) && (a[v][u - 2] == turn)) {
            return true;
        }
        if ((a[v][u - 1] == turn) && (a[v][u + 1] == turn)) {
            return true;
        }
        if ((a[v][u + 1] == turn) && (a[v][u + 2] == turn)) {
            return true;
        }

        if ((a[v - 1][u - 1] == turn) && (a[v - 2][u - 2] == turn)) {
            return true;
        }
        if ((a[v - 1][u - 1] == turn) && (a[v + 1][u + 1] == turn)) {
            return true;
        }
        if ((a[v + 1][u + 1] == turn) && (a[v + 2][u + 2] == turn)) {
            return true;
        }

        if ((a[v - 1][u + 1] == turn) && (a[v - 2][u + 2] == turn)) {
            return true;
        }
        if ((a[v - 1][u + 1] == turn) && (a[v + 1][u - 1] == turn)) {
            return true;
        }
        if ((a[v + 1][u - 1] == turn) && (a[v + 2][u - 2] == turn)) {
            return true;
        }

        return false;
    }
    @Override
    public void onClick(View v) {
        int num = v.getId() - R.id.button1;
        int y = num % 4 + 2;
        int x = num / 4 + 2;
        if (a[x][y] == 0) {
            a[x][y] = turn + 1;
            turn++;
            if (check(x, y)) {
                Toast.makeText(MainActivity.this,
                        "Player " + (turn) + " wins!", Toast.LENGTH_LONG).show();
            }
            turn--;
            Button b = (Button) v;
            if (turn == 0)
                b.setText("X");
            if (turn == 1)
                b.setText("0");

            turn = (turn + 1) % 2;
        } else {
            Toast.makeText(MainActivity.this,
                    "Can't place here!", Toast.LENGTH_SHORT).show();
        }
    }
}
