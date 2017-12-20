package com.example.taroteam.tarot;

import java.util.ArrayList;

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

    // Getter bddJoueur

    public Joueur[] getBddJoueur() {
        return bddJoueur;
    }

    // Getter bddJoueur Name indexé

    public String getBddJoueurName(int numJoueur){
        return bddJoueur[numJoueur-1].getNom();
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

    // Récupérer le joueur avec le meilleur score sur une plage donnée (pour tri)
    public int getBestRow(int start, int end, int numTour){
        Joueur max = bddJoueur[start - 1];
        int rowMax = start;
        for (int i = start; i <= end - 1; i++){
            if (bddJoueur[i].getCumulScore(numTour) > max.getCumulScore(numTour)) {
                max = bddJoueur[i];
                rowMax = i + 1;
            }
        }
        return rowMax;
    }

    // Intervertir la place des joueurs (pour tri)
    public void switchRows(int row1, int row2){
        Joueur temp = bddJoueur[row1 - 1];
        bddJoueur[row1 - 1] = bddJoueur[row2 - 1];
        bddJoueur[row2 - 1] = temp;
    }

}
