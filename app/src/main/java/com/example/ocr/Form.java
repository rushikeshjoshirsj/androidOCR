package com.example.ocr;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class Form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Intent intent = getIntent();
        ArrayList<String> detailsForForm =intent.getStringArrayListExtra("details");
        String fName = detailsForForm.get(0);
        String lName = detailsForForm.get(1);
        //String address = detailsForForm.get();

        TextInputLayout textInputLayout1 = findViewById(R.id.textInputLayout);
        TextInputEditText textInputEditText1 = findViewById(R.id.textInputEditText);
        textInputLayout1.setHintAnimationEnabled(true);
        textInputEditText1.setText(fName);

        TextInputLayout textInputLayout2 = findViewById(R.id.textInputLayout2);
        TextInputEditText textInputEditText2 = findViewById(R.id.textInputEditText);
        textInputLayout2.setHintAnimationEnabled(true);
        textInputEditText2.setText(lName);
    }
}
