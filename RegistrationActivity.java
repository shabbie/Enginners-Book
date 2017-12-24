package com.example.abhishekkoranne.engineersbook.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.abhishekkoranne.engineersbook.R;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        changeView();

    }

    private void changeView() {

     /*   findViewById(R.id.et_address).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        findViewById(R.id.et_tpo_no).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        findViewById(R.id.et_dob).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        findViewById(R.id.et_uni_name).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        findViewById(R.id.et_college_name).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        findViewById(R.id.et_dept_name).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        findViewById(R.id.rg_gender).setLayoutParams(new LinearLayout.LayoutParams(0, 0));*/

        Spinner sp = (Spinner) findViewById(R.id.sp_user_type);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String user = (String) parent.getItemAtPosition(position);

                if (user.equals("Student")) {
                    findViewById(R.id.et_dob).setVisibility(View.VISIBLE);
                    findViewById(R.id.et_uni_name).setVisibility(View.VISIBLE);
                    findViewById(R.id.et_college_name).setVisibility(View.VISIBLE);
                    findViewById(R.id.et_dept_name).setVisibility(View.VISIBLE);
                    findViewById(R.id.rg_gender).setVisibility(View.VISIBLE);

               /*     findViewById(R.id.et_address).setVisibility(View.GONE);
                    findViewById(R.id.et_tpo_no).setVisibility(View.GONE);*/
                } else if (user.equals("Faculty")) {
                    findViewById(R.id.et_dob).setVisibility(View.VISIBLE);
                    findViewById(R.id.et_uni_name).setVisibility(View.VISIBLE);
                    findViewById(R.id.et_college_name).setVisibility(View.VISIBLE);
                    findViewById(R.id.et_dept_name).setVisibility(View.VISIBLE);
                    findViewById(R.id.rg_gender).setVisibility(View.VISIBLE);
                } else if (user.equals("Department")) {
                    findViewById(R.id.et_dob).setVisibility(View.VISIBLE);
                    findViewById(R.id.et_uni_name).setVisibility(View.VISIBLE);
                    findViewById(R.id.et_college_name).setVisibility(View.VISIBLE);
                    findViewById(R.id.et_dept_name).setVisibility(View.VISIBLE);
                    findViewById(R.id.rg_gender).setVisibility(View.VISIBLE);
                } else if (user.equals("College")) {
                    findViewById(R.id.et_tpo_no).setVisibility(View.VISIBLE);
                    findViewById(R.id.et_address).setVisibility(View.VISIBLE);
                } else if (user.equals("University")) {
                    findViewById(R.id.et_address).setVisibility(View.VISIBLE);
                } else if (user.equals("Company")) {
                    findViewById(R.id.et_address).setVisibility(View.VISIBLE);
                    findViewById(R.id.et_cpass).setVisibility(View.GONE);
                    findViewById(R.id.et_pass).setVisibility(View.GONE);
                    findViewById(R.id.et_id).setVisibility(View.GONE);
                    findViewById(R.id.et_dob).setVisibility(View.GONE);
                    findViewById(R.id.et_uni_name).setVisibility(View.GONE);
                    findViewById(R.id.et_college_name).setVisibility(View.GONE);
                    findViewById(R.id.et_dept_name).setVisibility(View.GONE);
                    findViewById(R.id.rg_gender).setVisibility(View.GONE);
                }
                /*if (user.equals("Faculty")) {
                    facultyView();
                }

                if (user.equals("Department")) {
                    departmentView();
                }


                if (user.equals("College")) {
                    collegeView();
                }

                if (user.equals("University")) {
                    universityView();
                }

                if (user.equals("Company")) {
                    companyView();
                }*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });
    }


   /* private void facultyView() {
        findViewById(R.id.et_dob).setVisibility(View.VISIBLE);
        findViewById(R.id.et_uni_name).setVisibility(View.VISIBLE);
        findViewById(R.id.et_college_name).setVisibility(View.VISIBLE);
        findViewById(R.id.et_dept_name).setVisibility(View.VISIBLE);
        findViewById(R.id.rg_gender).setVisibility(View.VISIBLE);
*//*
        findViewById(R.id.et_address).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        findViewById(R.id.et_tpo_no).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
*//*
        findViewById(R.id.et_address).setVisibility(View.GONE);
        findViewById(R.id.et_tpo_no).setVisibility(View.GONE);
    }

    private void departmentView() {
        findViewById(R.id.et_dob).setVisibility(View.VISIBLE);
        findViewById(R.id.et_uni_name).setVisibility(View.VISIBLE);
        findViewById(R.id.et_college_name).setVisibility(View.VISIBLE);
        findViewById(R.id.et_dept_name).setVisibility(View.VISIBLE);
        findViewById(R.id.rg_gender).setVisibility(View.VISIBLE);
*//*
        findViewById(R.id.et_address).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        findViewById(R.id.et_tpo_no).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
 *//*
        findViewById(R.id.et_address).setVisibility(View.GONE);
        findViewById(R.id.et_tpo_no).setVisibility(View.GONE);
    }

    private void universityView() {

        findViewById(R.id.et_address).setVisibility(View.VISIBLE);
*//*

        findViewById(R.id.et_dob).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        findViewById(R.id.et_uni_name).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        findViewById(R.id.et_college_name).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        findViewById(R.id.et_dept_name).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        findViewById(R.id.rg_gender).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
*//*
        findViewById(R.id.et_dob).setVisibility(View.GONE);
        findViewById(R.id.et_uni_name).setVisibility(View.GONE);
        ;
        findViewById(R.id.et_college_name).setVisibility(View.GONE);
        ;
        findViewById(R.id.et_dept_name).setVisibility(View.GONE);
        ;
        findViewById(R.id.rg_gender).setVisibility(View.GONE);
        ;

    }

    private void collegeView() {
        findViewById(R.id.et_tpo_no).setVisibility(View.VISIBLE);
        findViewById(R.id.et_address).setVisibility(View.VISIBLE);

   *//*     findViewById(R.id.et_dob).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        findViewById(R.id.et_uni_name).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        findViewById(R.id.et_college_name).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        findViewById(R.id.et_dept_name).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        findViewById(R.id.rg_gender).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
   *//*
        findViewById(R.id.et_dob).setVisibility(View.GONE);
        findViewById(R.id.et_uni_name).setVisibility(View.GONE);
        findViewById(R.id.et_college_name).setVisibility(View.GONE);
        findViewById(R.id.et_dept_name).setVisibility(View.GONE);
        findViewById(R.id.rg_gender).setVisibility(View.GONE);
    }

    private void companyView() {

        findViewById(R.id.et_address).setVisibility(View.VISIBLE);


*//*      findViewById(R.id.et_cpass).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        findViewById(R.id.et_pass).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        findViewById(R.id.et_id).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        findViewById(R.id.et_dob).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        findViewById(R.id.et_uni_name).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        findViewById(R.id.et_college_name).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        findViewById(R.id.et_dept_name).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        findViewById(R.id.rg_gender).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
*//*
        findViewById(R.id.et_cpass).setVisibility(View.GONE);
        findViewById(R.id.et_pass).setVisibility(View.GONE);
        findViewById(R.id.et_id).setVisibility(View.GONE);
        findViewById(R.id.et_dob).setVisibility(View.GONE);
        findViewById(R.id.et_uni_name).setVisibility(View.GONE);
        findViewById(R.id.et_college_name).setVisibility(View.GONE);
        findViewById(R.id.et_dept_name).setVisibility(View.GONE);
        findViewById(R.id.rg_gender).setVisibility(View.GONE);

    }

    private void studentView() {
        findViewById(R.id.et_dob).setVisibility(View.VISIBLE);
        findViewById(R.id.et_uni_name).setVisibility(View.VISIBLE);
        findViewById(R.id.et_college_name).setVisibility(View.VISIBLE);
        findViewById(R.id.et_dept_name).setVisibility(View.VISIBLE);
        findViewById(R.id.rg_gender).setVisibility(View.VISIBLE);

       *//* findViewById(R.id.et_address).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        findViewById(R.id.et_tpo_no).setLayoutParams(new LinearLayout.LayoutParams(0, 0));*//*

        findViewById(R.id.et_address).setVisibility(View.GONE);
        findViewById(R.id.et_tpo_no).setVisibility(View.GONE);
   */

}