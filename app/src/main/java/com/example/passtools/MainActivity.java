package com.example.passtools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button openTest, openGen,openStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openTest = (Button) findViewById(R.id.test_button);
        openGen =(Button) findViewById(R.id.make_button);
        openStore = (Button) findViewById(R.id.store_button);
        openGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGenActivity();
            }
        });
        openTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTestActivity();
            }
        });
        openStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStoreActivity();
            }
        });

    }

    void openGenActivity(){
        Intent intent = new Intent(this,GenActivity.class);
        startActivity(intent);
    }

    void openTestActivity(){
        Intent intent = new Intent(this,TestActivity.class);
        startActivity(intent);
    }
    void openStoreActivity(){
        Intent intent = new Intent(this,RecallActivity.class);
        startActivity(intent);
    }
}
