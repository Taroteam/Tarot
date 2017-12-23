package com.example.taroteam.tarot;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class newDeal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_deal);


        FloatingActionButton btnGoHome = findViewById(R.id.goHome);
        btnGoHome.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(newDeal.this, homepage.class));

            }});

        Button btnGoPodium = (Button) findViewById(R.id.goPodium);
        btnGoPodium.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(newDeal.this, podium.class));

            }});
    }
}
