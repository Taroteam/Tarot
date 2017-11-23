package com.example.taroteam.tarot;

/**
 * Created by JK on 23/11/2017.
 */

public class Joueur {
    // Attributs
    private String nom;
    private String sexe;
    private double[] score = new double[100];

    // Constructor
    public Joueur(String nom, String sexe) {
        this.nom = nom;
        this.sexe = sexe;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setScore(double points, int i) {
        score[i-1] = points;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getSexe() {
        return sexe;
    }

    public double[] getScore() {
        return score;
    }

    // Méthodes
    public double getCumulScore(int j){
        double temp = 0;
        for (int i = 1; i <= j; i++){
            temp = temp + score[i-1];
        }
        return temp;
    }
}
