package com.example.taroteam.tarot;

import java.util.Arrays;

/**
 * Created by JK on 23/11/2017.
 */

public class main {
    public static void main(String[] args) {
        // Joueurs fixes

        Joueur joueur1 = new Joueur("Cédric", "M");
        Joueur joueur2 = new Joueur("Diana", "F");
        Joueur joueur3 = new Joueur("JK", "M");
        Joueur joueur4 = new Joueur("Aline", "F");
        Joueur joueur5 = new Joueur("Maxime", "M");

        BDD_Joueur partie = new BDD_Joueur();
        partie.ajouterJoueur(joueur1);
        partie.ajouterJoueur(joueur2);
        partie.ajouterJoueur(joueur3);
        partie.ajouterJoueur(joueur4);
        partie.ajouterJoueur(joueur5);


        System.out.println(partie.getBddJoueur()[0].getNom());
        // Tour 1

        Tour tour1 = new Tour();
        tour1.initTour(partie, 1);

    }
}
