package com.example.taroteam.tarot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        // Listener - Bouton "Nouvelle Partie"
        Button btnNouvellePartie = (Button) findViewById(R.id.nouvellePartie);
        btnNouvellePartie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homepage.this, newGame.class));
            }
        });

        // Listener - Bouton "Règles"
        Button btnGoHelp = (Button) findViewById(R.id.goHelp);
        btnGoHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homepage.this, help.class));
            }
        });

        // Listener - Bouton "Statistiques"
        Button btnStats = (Button) findViewById(R.id.stats);
        btnStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homepage.this, statistics.class));
            }
        });

        // Listener - Bouton "Règles"
        Button btnJoueurs = (Button) findViewById(R.id.joueurs);
        btnJoueurs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homepage.this, players.class));
            }
        });

        // Listener - Bouton "Charger partie"
        Button btnReprendrePartie = (Button) findViewById(R.id.reprendrepartie);
        btnReprendrePartie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homepage.this, loadGame.class));
            }
        });


    }
}
