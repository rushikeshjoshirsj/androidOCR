package com.example.ocr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SelectState extends AppCompatActivity {

    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_state);
        Spinner spinner = (Spinner)findViewById(R.id.state);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(SelectState.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.states));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        next = (Button)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SelectCoverage.class);
                startActivity(intent);
            }
        });
    }
}
