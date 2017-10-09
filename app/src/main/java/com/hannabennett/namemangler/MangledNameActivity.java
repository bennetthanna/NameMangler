package com.hannabennett.namemangler;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by HannaBennett on 10/9/17.
 */

public class MangledNameActivity extends AppCompatActivity {
    private Button mResetButton;
    private Button mRemangleButton;
    private TextView mMangledName;
    private String mInputtedName;
    private String mSavedString;
    public static final String MANGLED_NAME_KEY = "Mangled name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangled_name);

        mResetButton = (Button) findViewById(R.id.reset_button);
        mRemangleButton = (Button) findViewById(R.id.remangle_button);
        mMangledName = (TextView) findViewById(R.id.mangled_name);

        Intent intent = getIntent();
        mInputtedName = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        if (savedInstanceState != null) {
            mSavedString = savedInstanceState.getString(MANGLED_NAME_KEY);
            mMangledName.setText(mSavedString);
        } else {
            mangleName();
        }
        
        mResetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        mRemangleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mangleName();
            }
        });
    }

    public void mangleName() {
        Resources res = getResources();
        String[] random_names = res.getStringArray(R.array.random_names_array);
        int index = new Random().nextInt(5) % 5;
        String mangledName = mInputtedName + " " + random_names[index].toString();
        mMangledName.setText(mangledName);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(MANGLED_NAME_KEY, mMangledName.getText().toString());
        super.onSaveInstanceState(outState);
    }

}
