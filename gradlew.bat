
package com.example.progressbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private TextView mTextViewTienDo;
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewTienDo = (TextView) findViewById(R.id.textviewTienDo);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_horizontal);
        thread = new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        wait(5000);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                for( int i=0; i<=100; i++){
                                    mProgressBar.setProgress(i);
                                    mTextViewTienDo.setText(String.valueOf(i) + "%");
                                }
                            }
                        });

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            ;
        };
        thread.start();
    }

//
//    public class runProgressBar extends Thread {
//        @Override
//        public void run() {
//           runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    for (int i = 0; i < 100; i+=1) {
//                        try {
//                            Thread.sleep(500);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        mProgressBar.setProgress(i);
//                        mTextVi