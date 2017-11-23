package com.example.taroteam.tarot;

/**
 * Created by JK on 23/11/2017.
 */

public class BDD_Joueur {
    // Attributs
    private Joueur[] bddJoueur = new Joueur[100];
    private int bddCount;

    // Constructor
    public BDD_Joueur(){
        bddJoueur = new Joueur[100];
        bddCount = 0;
    }

    // Getter bddCount

    public int getBddCount() {
        return bddCount;
    }

    // Getter Joueur indexé

    public Joueur getJoueur(int numJoueur){
        return bddJoueur[numJoueur-1];
    }

    // Méthode d'ajout d'un joueur à la BDD
    public void ajouterJoueur(Joueur joueur){
        bddJoueur[bddCount] = joueur;
        bddCount = bddCount + 1 ;
    }
}
