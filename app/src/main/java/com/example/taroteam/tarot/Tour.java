package com.example.taroteam.tarot;

import java.util.Scanner;

/**
 * Created by JK on 23/11/2017.
 */

public class Tour {
    // Attributs
    private Joueur Attaquant;
    private Joueur Appelé;
    private String Contrat;
    private double Points;
    private String PetitAuBout;
    private String Poignée;
    private int NbBouts;
    private boolean ChelemAnnoncé;
    private boolean ChelemRéalisé;
    private String RoiAppelé;

    // Constructor
    public Tour() {
    }

    // Setters
    public void setAttaquant(Joueur attaquant) {
        Attaquant = attaquant;
    }

    public void setAppelé(Joueur appelé) {
        Appelé = appelé;
    }

    public void setContrat(String contrat) {
        Contrat = contrat;
    }

    public void setPoints(double points) {
        Points = points;
    }

    public void setPetitAuBout(String petitAuBout) {
        PetitAuBout = petitAuBout;
    }

    public void setPoignée(String poignée) {
        Poignée = poignée;
    }

    public void setNbBouts(int nbBouts) {
        NbBouts = nbBouts;
    }

    public void setChelemAnnoncé(boolean chelem) {
        ChelemAnnoncé = chelem;
    }

    public void setChelemRéalisé(boolean chelem) {
        ChelemRéalisé = chelem;
    }

    public void setRoiAppelé(String roiAppelé) {
        RoiAppelé = roiAppelé;
    }

    // Getters
    public Joueur getAttaquant() {
        return Attaquant;
    }

    public Joueur getAppelé() {
        return Appelé;
    }

    public String getContrat() {
        return Contrat;
    }

    public double getPoints() {
        return Points;
    }

    public String getPetitAuBout() {
        return PetitAuBout;
    }

    public String getPoignée() {
        return Poignée;
    }

    public int getNbBouts() {
        return NbBouts;
    }

    public boolean isChelemAnnoncé() {
        return ChelemAnnoncé;
    }

    public boolean isChelemRéalisé() {
        return ChelemRéalisé;
    }

    public String getRoiAppelé() {
        return RoiAppelé;
    }

    // Méthodes

    // Multiplicateurs de contrats

    public int multipleContrat(){
        if (Contrat == "Petite") return 1;
        if (Contrat == "Garde") return 2;
        if (Contrat == "Garde Sans") return 4;
        if (Contrat == "Garde Contre") return 6;
        return 0;
    }

    // Points à faire en fonction des bouts

    public int seuilContrat(){
        if (NbBouts == 3){
            return 36;
        }
        if (NbBouts == 2){
            return 41;
        }
        if (NbBouts == 1){
            return 51;
        }
        if (NbBouts == 0){
            return 56;
        }
        return 0;
    }

    // Equipe du petit au bout

    public int multiplePetitAuBout(){
        if (PetitAuBout == "Attaque") return 1;
        if (PetitAuBout == "Défense") return -1;
        return 0;
    }

    // Bonus Poignée
    public int bonusPoignée(){
        if (Poignée == "Simple") return 20;
        if (Poignée == "Double") return 30;
        if (Poignée == "Triple") return 40;
        return 0;
    }

    // Bonus Chelem
    public int bonusChelem(){
        if (ChelemAnnoncé == true && ChelemRéalisé == true) {
            return 400;
        }
        if (ChelemAnnoncé == false && ChelemRéalisé == true) {
            return 200;
        }
        if (ChelemAnnoncé == true && ChelemRéalisé == false) {
            return -200;
        }
        return 0;
    }

    // Contrat rempli
    public int contratRempli() {
        if (Points - seuilContrat() >= 0) {
            return 1;
        }
        if (Points - seuilContrat() < 0) {
            return -1;
        }
        return 0;
    }

    // Initialisation tour
    public void initTour(BDD_Joueur partie, int j){

        System.out.println("################### Tour n°" + j +" ###################");

        // Identité de l'attaquant
        Scanner scAtt = new Scanner(System.in);
        System.out.print("Attaquant : ");
        String strAtt = scAtt.nextLine().intern();

        // Affectation à un joueur de la partie
        int indexAtt = 1;
        Attaquant = partie.getJoueur(indexAtt);
        while (strAtt != Attaquant.getNom()){
            Attaquant = partie.getJoueur(indexAtt);
            indexAtt++;
        }

        // Identité de l'appelé
        Scanner scApp = new Scanner(System.in);
        System.out.print("Appelé : ");
        String strApp = scApp.nextLine().intern();

        // Affectation à un joueur de la partie
        int indexApp = 1;
        Appelé = partie.getJoueur(indexApp);
        while (strApp != Appelé.getNom()){
            Appelé = partie.getJoueur(indexApp);
            indexApp++;
        }

        // Chelem annoncé ?
        Scanner scChelemA = new Scanner(System.in);
        System.out.print("Chelem Annoncé (oui/non) : ");
        String strChelemA = scChelemA.nextLine().intern();
        switch (strChelemA) {
            case "oui": ChelemAnnoncé = true;
                break;
            case "non": ChelemAnnoncé = false;
                break;
        }

        // Chelem Réalisé ?
        Scanner scChelemR = new Scanner(System.in);
        System.out.print("Chelem Réalisé (oui/non) : ");
        String strChelemR = scChelemR.nextLine().intern();
        switch (strChelemR) {
            case "oui": ChelemRéalisé = true;
                break;
            case "non": ChelemRéalisé = false;
                break;
        }

        // Contrat
        Scanner scContrat = new Scanner(System.in);
        System.out.print("Petite, Garde, Garde Sans, Garde Contre : ");
        String strContrat = scContrat.nextLine().intern();
        Contrat = strContrat;

        // # de bouts
        Scanner scNbBouts = new Scanner(System.in);
        System.out.print("Nombre de bouts : ");
        int intNbBouts = scNbBouts.nextInt();
        NbBouts = intNbBouts;

        // # de points
        Scanner scPoints = new Scanner(System.in);
        System.out.print("Points : ");
        double doublePoints = scPoints.nextDouble();
        Points = doublePoints;

        // Petit au bout ?
        Scanner scPetitAuBout = new Scanner(System.in);
        System.out.print("Pli du Petit au Bout fait par Attaque, Défense, non : ");
        String strPetitAuBout = scPetitAuBout.nextLine().intern();
        PetitAuBout = strPetitAuBout;

        // Poignée ?
        Scanner scPoignée = new Scanner(System.in);
        System.out.print("Poignée Simple (8 atouts), Double (10), Triple (13), non : ");
        String strPoignée = scPoignée.nextLine().intern();
        Poignée = strPoignée;

        // Roi Appelé
        Scanner scRoiAppelé = new Scanner(System.in);
        System.out.print("Roi appelé : ");
        String strRoiAppelé = scRoiAppelé.nextLine().intern();
        RoiAppelé = strRoiAppelé;


        // Calcul
        double enjeu = multipleContrat() * (25 + Math.abs(seuilContrat()-Points)) + multiplePetitAuBout() * multipleContrat() * 10 + bonusPoignée() + bonusChelem();
        System.out.println("");
        System.out.println("Points en jeu : " + enjeu);
        System.out.println("");

        // Affectation des points

        if (Attaquant.getNom() == Appelé.getNom()) {
            Attaquant.setScore(4 * contratRempli() * enjeu, j);
            for (int i = 1; i <= 5; i++){
                if (partie.getJoueur(i).getNom() != Attaquant.getNom()){
                    partie.getJoueur(i).setScore(-Attaquant.getScore()[j-1]/4, j);
                }
            }
        }
        else {
            Attaquant.setScore(2 * contratRempli() * enjeu, j);
            Appelé.setScore(contratRempli() * enjeu, j);
            for (int i = 1; i <= 5; i++) {
                if (partie.getJoueur(i).getNom() != Attaquant.getNom() && partie.getJoueur(i).getNom() != Appelé.getNom()) {
                    partie.getJoueur(i).setScore(-(Attaquant.getScore()[j-1] + Appelé.getScore()[j-1])/3,j);
                } else {
                    if (partie.getJoueur(i).getNom() == Attaquant.getNom()) {
                        partie.getJoueur(i).setScore(Attaquant.getScore()[j - 1], j);
                    }
                    if (partie.getJoueur(i).getNom() == Appelé.getNom()) {
                        partie.getJoueur(i).setScore(Appelé.getScore()[j - 1], j);
                    }
                }
            }
        }


        // Afficher les scores
        System.out.println("############## Résultats cumulés au tour n°" + j +" ##############");
        for (int i = 1; i <=5; i++){
            System.out.println(partie.getJoueur(i).getNom() + " : " + partie.getJoueur(i).getCumulScore(j));
        }
        System.out.println("###########################################################");
        System.out.println("");

        // Partie suivante ?
        Scanner scPartie = new Scanner(System.in);
        System.out.print("Jouer le tour n°" + (j+1) +" (oui/non) : ");
        String strPartie = scPartie.nextLine().intern();
        System.out.println("");

        switch (strPartie){
            case "oui":
                Tour tourSuivant = new Tour();
                tourSuivant.initTour(partie, j+1);
                break;
            case "non":
                System.out.println("################################");
                break;
        }

    }
}
