package com.hannabennett.namemangler;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {

    private Button mMangleButton;
    private EditText mFirstNameInput;
    private static final String TAG = "MainActivity";
    public static final String EXTRA_MESSAGE = "Name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);

        mMangleButton = (Button) findViewById(R.id.mangle_button);
        mFirstNameInput = (EditText) findViewById(R.id.first_name_input);

        mMangleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "name = " + mFirstNameInput.getText());
                String name = mFirstNameInput.getText().toString();
                if (name.isEmpty()) {
                    Toast empty_name_toast = Toast.makeText(getApplicationContext(),
                            "You must enter a name",
                            Toast.LENGTH_SHORT);
                    empty_name_toast.show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), MangledNameActivity.class);
                    intent.putExtra(EXTRA_MESSAGE, name);
                    startActivity(intent);
                }
            }
        });
    }

}
