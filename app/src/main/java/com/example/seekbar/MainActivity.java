package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SeekBar mSeekBar;
    private TextView mTextView;
    private Button mButtonIncrease;
    private Button mButtonReduce;
    private Button mButtonNhap;

    private RatingBar mRatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSeekBar = (SeekBar) findViewById(R.id.seekbar);
        mTextView = (TextView) findViewById(R.id.textView);
        mButtonReduce = (Button) findViewById(R.id.buttonGiam);
        mButtonIncrease = (Button) findViewById(R.id.buttonTang);
        mButtonNhap = (Button) findViewById(R.id.buttonNhap);
        mRatingBar = (RatingBar) findViewById(R.id.ratingBar);
        mRatingBar.setStepSize(2);

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mTextView.setText(String.valueOf(mSeekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "Start change seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "Stop change seekbar", Toast.LENGTH_SHORT).show();
            }
        });

        mButtonReduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSeekBar.setProgress(mSeekBar.getProgress()-1);
            }
        });
        mButtonIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSeekBar.setProgress(mSeekBar.getProgress()+1);
            }
        });


        mButtonNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( !mButtonNhap.getText().equals("Ok")){
                    EditText mTextView = (EditText) findViewById(R.id.textView);
                    mTextView.setText("");
                    mTextView.setSelection(mTextView.getText().length());
                    mTextView.requestFocus();
                    mButtonNhap.setText("Ok");
                }else{
                    try{
                        int temp = Integer.parseInt(mTextView.getText().toString());
                        mButtonNhap.setText("Re-input");
                        mSeekBar.setProgress(temp);
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(), "The input data must be a number!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
