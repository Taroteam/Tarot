package com.example.taroteam.tarot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class newGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        Button btnValider = (Button) findViewById(R.id.startGame);
        btnValider.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(newGame.this, scores.class));
            }

        });
    }
}
