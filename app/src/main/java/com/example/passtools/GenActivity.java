package com.example.passtools;

import androidx.appcompat.app.AppCompatActivity;
import com.example.passtools.model.PasswordGenerator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


public class GenActivity extends AppCompatActivity {

    private Button passwordA, passwordB, passwordC, return_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen);
        PasswordGenerator tempGen = new PasswordGenerator(14);
        passwordA = (Button) findViewById(R.id.password1);
        passwordB = (Button) findViewById(R.id.password2);
        passwordC = (Button) findViewById(R.id.password3);

        passwordA.setText(generatePassword(tempGen));
        passwordB.setText(generatePassword(tempGen));
        passwordC.setText(generatePassword(tempGen));

        return_button = (Button) findViewById(R.id.back_button);

                 passwordA.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         passwordA.setText(generatePassword(tempGen));

                     }
                 });
                 passwordB.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         passwordB.setText(generatePassword(tempGen));
                     }
                 });
                 passwordC.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         passwordC.setText(generatePassword(tempGen));
                     }
                 });
                 return_button.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         openMainActivity();
                     }
                 });
    }

    private String generatePassword(PasswordGenerator tempGenB){
        String generatedPass = tempGenB.generatePassword();
        return generatedPass;
    }
    private void openMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
