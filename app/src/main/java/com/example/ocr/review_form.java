package com.example.ocr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class review_form extends AppCompatActivity {

    EditText ed ;
    EditText ed1 ;
    EditText ed2 ;
    EditText ed3 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_form);


        ed = (EditText)findViewById(R.id.Name);
        ed1 = (EditText)findViewById(R.id.state);
        ed2 = (EditText)findViewById(R.id.phone);
        ed3 = (EditText)findViewById(R.id.coverage);


        String values = (String)getIntent().getExtras().get("data");
        String[] value = values.split("\\s+");
        ed.setText(value[0]);
        ed1.setText(value[1]);
        ed2.setText(value[2]);
        ed3.setText(value[4]);
    }
}
