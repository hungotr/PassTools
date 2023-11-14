Ichor
ichorfunnymoment
Online

Ichor — 09/15/2023 3:01 PM
do we have a group chat for our group
sorry for ghosting yall i was on a trip this week
anson — 09/15/2023 3:01 PM
https://discord.gg/bX6YTjvu
this should work
Ichor — 09/15/2023 3:01 PM
slay
Ichor — Today at 2:53 PM
package com.example.passtools;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
Expand
TestActivity.txt
3 KB
package com.example.passtools.model;

import android.app.Activity;

public class PassTest {
    String lowerCase = "abcdefghijklmonpqrstuvwxyz";
Expand
PassTest.txt
3 KB
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
Expand
activity_test.txt
5 KB
ill try to fix whatever is up with my project but this is what i have for now
﻿
anson
thethingswesaw
https://linktr.ee/thisisanson
package com.example.passtools;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Button;
import android.os.Bundle;
import android.widget.Toast;
import com.example.passtools.model.PassTest;

public class TestActivity extends AppCompatActivity {
    Switch hideText;
    Button test_Button_REAL, back_button;
    PassTest temp;
    EditText userInput;
    String userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        userInput = (EditText) findViewById(R.id.userInput);

        hideText = (Switch) findViewById(R.id.hideToggle);

        test_Button_REAL = (Button) findViewById(R.id.test_button);

        back_button = (Button)  findViewById(R.id.return_button);

        test_Button_REAL.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
             // hideText.setText(userInput.getText());
                String passwrdRating = testPass(userInput.getText().toString());
                Toast.makeText(v.getContext(),passwrdRating,Toast.LENGTH_SHORT).show();


            }
        });
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();

            }
        });
    }




    public void onSwitchClick(View view){
        if (hideText.isChecked()){
            userInput.setInputType(InputType.TYPE_CLASS_TEXT);
           hideText.setText("Hide Password");
        }
        else {
            userInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            hideText.setText("View Password");

        }

    }

    public String testPass(String userPassword){
        temp = new PassTest("abcdefghijklmonpqrstuvwxyz","ABCDEFGHIJKLMOPQRSTUVWXYZ","1234567890","!@#$%^&*");
       //temp = new PassTest("NULL","NULL","NULL","NULL");
        String passRating = temp.passwordExam(userPassword,this);

        return passRating;

    }
    void openMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
TestActivity.txt
3 KB
