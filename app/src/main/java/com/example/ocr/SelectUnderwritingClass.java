package com.example.ocr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SelectUnderwritingClass extends AppCompatActivity {
    private Spinner underWritingClass;
    private Spinner rating;
    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_underwriting_class);
        underWritingClass = (Spinner)findViewById(R.id.underwritingClass);
        rating = (Spinner)findViewById(R.id.rating);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(SelectUnderwritingClass.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.underwritingClass));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        underWritingClass.setAdapter(arrayAdapter);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(SelectUnderwritingClass.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.rating));
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rating.setAdapter(arrayAdapter1);


        next = (Button)findViewById(R.id.next);
    }
}
