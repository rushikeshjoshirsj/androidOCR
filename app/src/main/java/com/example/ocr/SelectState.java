package com.example.ocr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SelectState extends AppCompatActivity {

    private Button next;
    private Spinner spinner;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_state);
        spinner = (Spinner)findViewById(R.id.state);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(SelectState.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.states));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        textView = (TextView)findViewById(R.id.validationMessage);
        next = (Button)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dropDownValue = spinner.getSelectedItem().toString();
                if(dropDownValue.equalsIgnoreCase("Select State")) {
                    textView.setText("* Please Select a State");
                } else {
                    ProposedInsured proposedInsured = new ProposedInsured();

                    Intent intent = new Intent(getApplicationContext(), SelectCoverage.class);
                    intent.putExtra("PI", proposedInsured);
                    startActivity(intent);
                }
            }
        });
    }
}
