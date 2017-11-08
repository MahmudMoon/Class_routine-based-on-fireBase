package com.example.moonc.cse_ru_3_1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Opening extends AppCompatActivity {

    int i = 0;
    ProgressBar progressBar;
    TextView textView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_opening);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        textView = (TextView)findViewById(R.id.textView3);

        final Handler handler = new Handler();



        Thread thread = new Thread()
        {
            public void run(){
                for(i = 1; i <100; )
                {
                    i+=1;
                    try {

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText(Integer.toString(i) + "%");
                            }
                        });

                        sleep(15);
                        progressBar.setProgress(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        thread.start();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Opening.this,MainActivity.class);
                startActivity(intent);
            }
        },1500);


    }
}
