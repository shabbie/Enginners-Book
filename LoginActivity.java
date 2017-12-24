package com.example.abhishekkoranne.engineersbook.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.abhishekkoranne.engineersbook.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends Activity {
    EditText et1, et2;
    Button btn_login;
    RequestQueue queue;
    TextView tv_uname_err, tv_password_err;

    RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        btn_login = (Button) findViewById(R.id.btn_login);
        tv_uname_err = (TextView) findViewById(R.id.tv_uname_err);
        tv_password_err = (TextView) findViewById(R.id.tv_password_err);

        queue = Volley.newRequestQueue(getApplicationContext());


/*        btn_login.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
//                Toast.makeText(LoginActivity.this, "Hi", Toast.LENGTH_SHORT).show();
                String url="http://192.168.0.6:8080/user/login";

                StringRequest sr=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            String data = response.getBytes().toString();

                            Toast.makeText(LoginActivity.this, "" + data, Toast.LENGTH_LONG).show();
                            Toast.makeText(LoginActivity.this, "Hello there", Toast.LENGTH_LONG).show();
                        }
                        catch (Exception e)
                        {
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
        });*/

        mRequestQueue = Volley.newRequestQueue(getApplicationContext());

        callPostParam();

    }

    private void callPostParam() {
        String url = "http://192.168.0.11:8080/user/login";

        JSONObject js = new JSONObject();
        try {
            js.put("login", "abhishek");
            js.put("pass", "123");

            Log.d("error", "callPostParam: " + js.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, js,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();

                        Log.d("error", "on success: " + response.toString());
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error", "on error: " + error.getMessage());

                Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                return params;
            }
        };

        mRequestQueue.add(jsonObjReq);
    }


    private void callStringParam() {
        String url = "https://api.androidhive.info/volley/string_response.html";
//        String url = "http://192.168.0.11:8080/user/login";

        StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();

                Log.d("error", "on success: " + response);
                /*try {

                    JSONObject json = new JSONObject(response);

                    String name = (String) json.get("name");
                    //int age = Integer.parseInt((String) json.get("age"));

                    JSONArray jsonObjectHotel = json.getJSONArray("hotel");

                    for (int i = 0; i < jsonObjectHotel.length(); i++) {
                        JSONObject myObj = (JSONObject) jsonObjectHotel.get(i);

                        Hotel hotel = new Hotel(myObj.get("hote"),);
                    }

                } catch (Exception e) {
                    Log.d("Response Error : ", e.getMessage());
                }*/
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error", "on error: " + error.getMessage());

                Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });


        mRequestQueue.add(sr);

    }

    public void onSignUpClick(View view) {
        startActivity(new Intent(LoginActivity.this, SignUpActivity.class));

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

        if (et1.getText().toString().equals("140410107002")) {
            if (et2.getText().toString().equals("shabbir")) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            } else {
                tv_password_err.setVisibility(View.VISIBLE);
                //et1.setBackgroundTintList(ColorStateList.valueOf(yourcolor));
            }
        } else if (et1.getText().toString().equals("140410107024")) {
            if (et2.getText().toString().equals("abhishek")) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            } else {
                tv_password_err.setVisibility(View.VISIBLE);
            }
        } else {
            tv_uname_err.setVisibility(View.VISIBLE);
        }
    }
}
