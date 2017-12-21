package com.example.taroteam.tarot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class newGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        final Button btnStartGame = (Button) findViewById(R.id.startGame);



        // Création (artificielle) de la base de données de joueurs (à remplacer par appel des données de SharedPreferences (cf
        // Udemy, Permanent Data Storage))

        // Création (artificielle) des joueurs

        Joueur joueur1 = new Joueur("Cédric", "M");
        Joueur joueur2 = new Joueur("Diana", "F");
        Joueur joueur3 = new Joueur("JK", "M");
        Joueur joueur4 = new Joueur("Aline", "F");
        Joueur joueur5 = new Joueur("Maxime", "M");
        BDD_Joueur bddJ = new BDD_Joueur();
        bddJ.ajouterJoueur(joueur1);
        bddJ.ajouterJoueur(joueur2);
        bddJ.ajouterJoueur(joueur3);
        bddJ.ajouterJoueur(joueur4);
        bddJ.ajouterJoueur(joueur5);


        // Création de la partie

        BDD_Joueur partie = bddJ;

        String[] joueurs = new String[bddJ.getBddCount()+1];
        joueurs[0] = "(sélectionner)";
        for (int i = 1; i <= bddJ.getBddCount(); i++){
            joueurs[i] = bddJ.getBddJoueur()[i-1].getNom();
        }

        // Spinner J1
        final TextView txtP1 = (TextView) findViewById(R.id.txtJoueur1);
        final Spinner spinnerJ1 = (Spinner) findViewById(R.id.spinnerP1);
        ArrayAdapter adapter1 = new ArrayAdapter(newGame.this, android.R.layout.simple_spinner_item, joueurs);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJ1.setAdapter(adapter1);

        // Spinner J2
        final TextView txtP2 = (TextView) findViewById(R.id.txtJoueur2);
        final Spinner spinnerJ2 = (Spinner) findViewById(R.id.spinnerP2);
        ArrayAdapter adapter2 = new ArrayAdapter(newGame.this, android.R.layout.simple_spinner_item, joueurs);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJ2.setAdapter(adapter2);

        // Spinner J3
        final TextView txtP3 = (TextView) findViewById(R.id.txtJoueur3);
        final Spinner spinnerJ3 = (Spinner) findViewById(R.id.spinnerP3);
        ArrayAdapter adapter3 = new ArrayAdapter(newGame.this, android.R.layout.simple_spinner_item, joueurs);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJ3.setAdapter(adapter3);

        // Spinner J4
        final TextView txtP4 = (TextView) findViewById(R.id.txtJoueur4);
        final Spinner spinnerJ4 = (Spinner) findViewById(R.id.spinnerP4);
        ArrayAdapter adapter4 = new ArrayAdapter(newGame.this, android.R.layout.simple_spinner_item, joueurs);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJ4.setAdapter(adapter4);

        // Spinner J5
        final TextView txtP5 = (TextView) findViewById(R.id.txtJoueur5);
        final Spinner spinnerJ5 = (Spinner) findViewById(R.id.spinnerP5);
        ArrayAdapter adapter5 = new ArrayAdapter(newGame.this, android.R.layout.simple_spinner_item, joueurs);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJ5.setAdapter(adapter5);

        // Spinner J6
        final TextView txtP6 = (TextView) findViewById(R.id.txtJoueur6);
        final Spinner spinnerJ6 = (Spinner) findViewById(R.id.spinnerP6);
        ArrayAdapter adapter6 = new ArrayAdapter(newGame.this, android.R.layout.simple_spinner_item, joueurs);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJ6.setAdapter(adapter6);

        spinnerJ1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {

                    // set Selected Player as Player 1 (link with position in "joueurs" and in bddJ)?
                    spinnerJ2.setVisibility(View.VISIBLE);
                    txtP2.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerJ2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    spinnerJ3.setVisibility(View.VISIBLE);
                    txtP3.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerJ3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    spinnerJ4.setVisibility(View.VISIBLE);
                    txtP4.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerJ4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    spinnerJ5.setVisibility(View.VISIBLE);
                    txtP5.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerJ5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    spinnerJ6.setVisibility(View.VISIBLE);
                    txtP6.setVisibility(View.VISIBLE);
                    // Bouton StartGame

                    btnStartGame.setVisibility(View.VISIBLE);


                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        if (btnStartGame.getVisibility() == View.VISIBLE) {
            btnStartGame.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    startActivity(new Intent(newGame.this, scores.class));
                }
            });
        }


    }}
