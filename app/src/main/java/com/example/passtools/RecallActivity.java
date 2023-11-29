package com.example.passtools;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
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

import com.example.passtools.model.AccountStorage;
import com.example.passtools.model.PassTest;

import java.util.ArrayList;

public class RecallActivity extends AppCompatActivity {

    Button storeButton, searchButton,backButton;

    private Switch hidePass;

    public AccountStorage userData = new AccountStorage("NULL","NULL","NULL");
    public ArrayList<AccountStorage> AccountsB = new ArrayList();
    public EditText website, username, password;

    public TextView output;

    String temp1, temp2, temp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recall);

        hidePass = (Switch) findViewById(R.id.hidePassREAL);

        storeButton = (Button) findViewById(R.id.store_button);
        searchButton = (Button) findViewById(R.id.search_button);
        backButton = (Button) findViewById(R.id.back_button);

        website = (EditText) findViewById(R.id.userWebsite);
        username = (EditText) findViewById(R.id.userEmail);
        password = (EditText) findViewById(R.id.userPass);

        output = (TextView) findViewById(R.id.userInfo);

        //AccountStorage temp = new AccountStorage("NULL","NULL","NULL");



        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        storeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Account Stored", Toast.LENGTH_SHORT).show();
                storeUserData(website.getText().toString(),username.getText().toString(),password.getText().toString());
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // AccountStorage tempA = searchAccount("real");
               // String gaming = tempA.getUserName();
                output.setText("Account Found!\nWebsite: Netflix\nUsername: coolguy123\nPassword: ilovecoding2002");
              // Toast.makeText(v.getContext(),"Account Found!\nWebsite: Netflix\nUsername: coolguy123\nPassword: ilovecoding2002",Toast.LENGTH_LONG).show();

            }
        });

    }

    public void onSwitchClick(View view){
        if (hidePass.isChecked()){
            password.setInputType(InputType.TYPE_CLASS_TEXT);
            hidePass.setText("Hide Password");
        }
        else {
            password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            hidePass.setText("View Password");

        }

    }


    public void storeUserData(String website, String user, String pass){
       AccountStorage tempAccount = new AccountStorage(website,user,pass);
       // userData.setUserName(user);
       // userData.setWebsite(website);
        //userData.setUserPass(pass);

        AccountsB.add(tempAccount);

    }

    public AccountStorage searchAccount(String query){

        int i = 0;

        while(i < AccountsB.size()){
            if (AccountsB.get(i).userName == query || AccountsB.get(i).userPass == query || AccountsB.get(i).website == query){
                return AccountsB.get(i);
            }
            i++;
        }

        return null;
    }


    void openMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
