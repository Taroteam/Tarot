package com.example.taroteam.tarot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class newGame extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        // Bouton StartGame à faire apparaître dès que nb(joueurs sélectionnés) > 5
        Button btnStartGame = (Button) findViewById(R.id.startGame);
        btnStartGame.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(newGame.this, scores.class));
            }

        });


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

        ArrayList<String> joueurs = new ArrayList<>();
        for (int i = 0; i <= bddJ.getBddCount()-1; i++){
            joueurs.add(bddJ.getBddJoueur()[i].getNom());
        }


        Spinner spinnerJ1 = (Spinner) findViewById(R.id.spinnerP1);
        ArrayAdapter adapter = new ArrayAdapter(newGame.this, android.R.layout.simple_spinner_item, joueurs);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJ1.setAdapter(adapter);
        spinnerJ1.setOnItemSelectedListener(this);

        }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        String selectedJ1 = parent.getItemAtPosition(position).toString();

       }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
