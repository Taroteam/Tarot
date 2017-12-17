package com.example.taroteam.tarot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class scores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        Button btnNouvelleDonne = (Button) findViewById(R.id.nouvelleDonne);
        btnNouvelleDonne.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(scores.this, newDeal.class));

            }});

        Button btnGoHome = (Button) findViewById(R.id.goHome);
        btnGoHome.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(scores.this, homepage.class));

            }});

    }
}
