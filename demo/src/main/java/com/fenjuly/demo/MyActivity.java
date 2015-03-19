package com.fenjuly.demo;

import android.app.Activity;
import android.os.Bundle;

import com.fenjuly.combinationimageview.CombinationImageView;
import com.fenjuly.library.R;

/**
 * Created by liurongchan on 15/3/18.
 */
public class MyActivity extends Activity {

    CombinationImageView number5;
    CombinationImageView number6;
    CombinationImageView number7;
    CombinationImageView number8;
    CombinationImageView number9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number5 = (CombinationImageView) findViewById(R.id.number5);
        number6 = (CombinationImageView) findViewById(R.id.number6);
        number7 = (CombinationImageView) findViewById(R.id.number7);
        number8 = (CombinationImageView) findViewById(R.id.number8);
        number9 = (CombinationImageView) findViewById(R.id.number9);

        number5.addImageView(R.drawable.example5);

        number6.addImageView(R.drawable.example5);
        number6.addImageView(R.drawable.example6);

        number7.addImageView(R.drawable.example5);
        number7.addImageView(R.drawable.example6);
        number7.addImageView(R.drawable.example7);

        number8.addImageView(R.drawable.example5);
        number8.addImageView(R.drawable.example6);
        number8.addImageView(R.drawable.example7);
        number8.addImageView(R.drawable.example8);

        number9.addImageView(R.drawable.example5);
        number9.addImageView(R.drawable.example6);
        number9.addImageView(R.drawable.example7);
        number9.addImageView(R.drawable.example8);
        number9.addImageView(R.drawable.example9);
    }
}
