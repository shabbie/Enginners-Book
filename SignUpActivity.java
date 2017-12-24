package com.example.abhishekkoranne.engineersbook.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.abhishekkoranne.engineersbook.R;

public class SignUpActivity extends AppCompatActivity {

    TextView roles;
    Button btn_student,btn_faculty,btn_hod,btn_principal,btn_chancellor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btn_student=(Button)findViewById(R.id.btn_student);
        btn_faculty=(Button)findViewById(R.id.btn_faculty);
        btn_hod=(Button)findViewById(R.id.btn_HOD);
        btn_principal=(Button)findViewById(R.id.btn_Principal);
        btn_chancellor=(Button)findViewById(R.id.btn_Chancellor);


        btn_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,StudentRegistrationActivity.class));
            }
        });

        btn_faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,FacultyRegistrationActivity.class));
            }
        });

        btn_hod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,HODRegistrationActivity.class));

            }
        });

        btn_principal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,PrincipalRegistrationActivity.class));

            }
        });

        btn_chancellor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,ChancellorRegistrationActivity.class));

            }
        });

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //finish();

                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}
