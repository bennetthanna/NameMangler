package com.hannabennett.namemangler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mMangleButton;
    private EditText mFirstNameInput;
    public static final String EXTRA_INPUTTED_NAME = "Name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);

        mMangleButton = (Button) findViewById(R.id.mangle_button);
        mFirstNameInput = (EditText) findViewById(R.id.first_name_input);

        mMangleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = mFirstNameInput.getText().toString();
                if (name.isEmpty()) {
                    Toast.makeText(getApplicationContext(),
                            "You must enter a name",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), MangledNameActivity.class);
                    intent.putExtra(EXTRA_INPUTTED_NAME, name);
                    startActivity(intent);
                }
            }
        });
    }

}
