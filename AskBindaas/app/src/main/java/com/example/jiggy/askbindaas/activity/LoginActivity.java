package com.example.jiggy.askbindaas.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.jiggy.askbindaas.R;

public class LoginActivity extends Activity {
    EditText et1, et2;
    Button button_login;
    RequestQueue queue;
    TextView tv_uname_err, tv_password_err;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        button_login = (Button) findViewById(R.id.button_login);

        tv_uname_err = (TextView) findViewById(R.id.tv_uname_err);
        tv_password_err = (TextView) findViewById(R.id.tv_password_err);

        queue = Volley.newRequestQueue(getApplicationContext());
        /*bsub.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Hi", Toast.LENGTH_SHORT).show();
                String url = "http://192.168.0.6:8080/user/login";

                StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            String data = response.getBytes().toString();

                            Toast.makeText(LoginActivity.this, "" + data, Toast.LENGTH_LONG).show();
                            Toast.makeText(LoginActivity.this, "Hello there", Toast.LENGTH_LONG).show();
                        } catch (Exception e) {
                            Log.d("Response Error : ", e.getMessage());
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this, "Hi", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        */
    }

    public void onSignUpClick(View view) {
        startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));

    }

    public void onForgotPassword(View view) {
        startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
    }

    public void onCompany(View view) {
        startActivity(new Intent(LoginActivity.this, CompanyLoginActivity.class));
    }

    public void onLoginClick(View view) {
        tv_uname_err.setVisibility(View.GONE);
        tv_password_err.setVisibility(View.GONE);

        //Pattern email=Pattern.compile("/^[1-9][0-9]{13}$/");
        //Matcher matcher=email.matcher(et1.getText().toString());

        if (et1.getText().toString().equals("140370107559")) {
            if (et2.getText().toString().equalsIgnoreCase("Jigish")) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            } else {
                tv_password_err.setVisibility(View.VISIBLE);
                //et1.setBackgroundTintList(ColorStateList.valueOf(yourcolor));
            }
        } else if (et1.getText().toString().equals("140370107558")) {
            if (et2.getText().toString().equalsIgnoreCase("Ronak")) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            } else {
                tv_password_err.setVisibility(View.VISIBLE);
            }
        } else if (et2.getText().toString().equalsIgnoreCase("Jigish")) {
            if (et1.getText().toString().equals("140370107559"))
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            else tv_uname_err.setVisibility(View.VISIBLE);
        }

        else if (et2.getText().toString().equalsIgnoreCase("Ronak")) {
            if (et1.getText().toString().equals("140370107558"))
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            else tv_uname_err.setVisibility(View.VISIBLE);
        }

        else {
            tv_uname_err.setVisibility(View.VISIBLE);
            tv_password_err.setVisibility(View.VISIBLE);
        }
    }

}

