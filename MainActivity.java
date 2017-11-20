package com.example.jiggy.askbindass;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends Activity
{
EditText et1,et2;
    Button bsub;
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText) findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        bsub=(Button)findViewById(R.id.bsub);

        queue = Volley.newRequestQueue(getApplicationContext());

        bsub.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Hi", Toast.LENGTH_SHORT).show();
                String url="http://192.168.0.6:8080/user/login";

                StringRequest sr=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            String data = response.getBytes().toString();

                            Toast.makeText(MainActivity.this, "" + data, Toast.LENGTH_LONG).show();
                            Toast.makeText(MainActivity.this, "Hello there", Toast.LENGTH_LONG).show();
                        }
                        catch (Exception e)
                        {
                            Log.d("Response Error : ", e.getMessage());
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Hi", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public void onSignUpClick(View view) {
        startActivity(new Intent(MainActivity.this,StudentRegActivity.class));


    }
}
