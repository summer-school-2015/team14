package com.local.dimak.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener{
    Button b1, b2, b3;
    TextView tv;
    int sum = 0;
    int primes = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        tv = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        if (v instanceof Button) {
            Button b = (Button) v;
            int num = Integer.parseInt(b.getText().toString()) + 1;
            b.setText(""+num);
            sum++;
            boolean isPrime = true;
            if (sum < 2) {
                isPrime = false;
            }
            for (int i = 2; (i * i <= sum) && (isPrime); i++)
                if (sum % i == 0)
                    isPrime = false;
            if (isPrime) {
                b1.setBackgroundColor(Color.rgb(36, 153, 255));
                b2.setBackgroundColor(Color.rgb(36, 153, 255));
                b3.setBackgroundColor(Color.rgb(36, 153, 255));
                primes++;
                tv.setText(""+primes);
            } else {
                b1.setBackgroundColor(Color.rgb(140, 255, 78));
                b2.setBackgroundColor(Color.rgb(140, 255, 78));
                b3.setBackgroundColor(Color.rgb(140, 255, 78));
            }
        }
    }
}
