package com.example.registerform;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText ageEditText;
    private EditText mobileNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.name_edit_text);
        ageEditText = findViewById(R.id.age_edit_text);
        mobileNumberEditText = findViewById(R.id.mobile_number_edit_text);

        Button registerButton = findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String ageString = ageEditText.getText().toString();
                String mobileNumber = mobileNumberEditText.getText().toString();

                // Validate user input
                if (TextUtils.isEmpty(name)) {
                    nameEditText.setError("Name cannot be empty");
                    return;
                }
                if (name.matches(".*\\d+.*")) {
                    nameEditText.setError("Name should not contain numbers");
                    return;
                }
                int age = Integer.parseInt(ageString);
                if (age < 0) {
                    ageEditText.setError("Age cannot be negative");
                    return;
                }
                if (TextUtils.isEmpty(mobileNumber)) {
                    mobileNumberEditText.setError("Mobile number cannot be empty");
                    return;
                }

                // Show pop-up message
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Registration Successful")
                        .setMessage("Thank you for registering!")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Reset fields
                                nameEditText.setText("");
                                ageEditText.setText("");
                                mobileNumberEditText.setText("");
                            }
                        })
                        .show();
            }
        });
    }
}