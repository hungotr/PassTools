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
        
        String passRating = temp.passwordExam(userPassword,this);

        return passRating;

    }
    void openMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
