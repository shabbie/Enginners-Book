package com.example.abhishekkoranne.engineersbook.Activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.abhishekkoranne.engineersbook.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddDoubtActivity extends AppCompatActivity {

    EditText doubt_body,doubt_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doubt);

        doubt_body= (EditText) findViewById(R.id.doubt_body);
        doubt_title= (EditText) findViewById(R.id.doubt_title);
        doubt_body.setGravity(Gravity.TOP);

        final Spinner spinner = (Spinner) findViewById(R.id.tags_filter_spinner);

        String[] tags = new String[]{
                "Filter tags",
                "Java",
                "Javascript",
                "C",
                "C++",
                "Php",
                "Android",
                "SQL",
                "Dot Net MVC",
                "Compiler",
                "Operating System",
                "Web Technology"
        };

        final List<String> tagsList = new ArrayList<>(Arrays.asList(tags));

        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,tagsList){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.DKGRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(spinnerArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if(position > 0){
                    // Notify the selected item text
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
