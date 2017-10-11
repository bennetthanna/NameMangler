package com.hannabennett.namemangler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by HannaBennett on 10/9/17.
 */

public class MangledNameActivity extends AppCompatActivity {
    private Button mResetButton;
    private Button mRemangleButton;
    private TextView mMangledName;
    private String mInputtedName;
    public static final String MANGLED_NAME_KEY = "Mangled name";
    private NameMangler mNameMangler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangled_name);

        mResetButton = (Button) findViewById(R.id.reset_button);
        mRemangleButton = (Button) findViewById(R.id.remangle_button);
        mMangledName = (TextView) findViewById(R.id.mangled_name);

        Intent intent = getIntent();
        mInputtedName = intent.getStringExtra(MainActivity.EXTRA_INPUTTED_NAME);

        if (savedInstanceState != null) {
            mMangledName.setText(savedInstanceState.getString(MANGLED_NAME_KEY));
        } else {
            mNameMangler = new NameMangler(mInputtedName, getLastNames());
            mMangledName.setText(mNameMangler.getMangledName());
        }
        
        mResetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        mRemangleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mNameMangler = new NameMangler(mInputtedName, getLastNames());
                mMangledName.setText(mNameMangler.getMangledName());
            }
        });
    }

    public String[] getLastNames() {
        return getResources().getStringArray(R.array.random_names_array);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(MANGLED_NAME_KEY, mMangledName.getText().toString());
        super.onSaveInstanceState(outState);
    }

}
