package com.example.abhishekkoranne.engineersbook.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.abhishekkoranne.engineersbook.R;

public class CompanyLoginActivity extends AppCompatActivity
{
    EditText et_cmp_id;
    Button btn_cmp_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_login);

        et_cmp_id=(EditText)findViewById(R.id.et_cmp_id);
        btn_cmp_login=(Button)findViewById(R.id.btn_cmp_login);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        btn_cmp_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
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

    public void onRegisterClick(View v)
    {
        startActivity(new Intent(CompanyLoginActivity.this,RegisterCompanyActivity.class));
    }
}
