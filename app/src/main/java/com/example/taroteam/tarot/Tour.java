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
    private String Poignée1;
    private String Poignée2;
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

    public void setPoignée1(String poignée) {
        Poignée1 = poignée;
    }

    public void setPoignée2(String poignée) {
        Poignée2 = poignée;
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

    public String getPoignée1() {
        return Poignée1;
    }

    public String getPoignée2() {
        return Poignée2;
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
        int bonus = 0;
        if (Poignée1 == "Simple"){
            bonus = bonus + 20;
        }
        if (Poignée1 == "Double"){
            bonus = bonus + 30;
        };
        if (Poignée1 == "Triple"){
            bonus = bonus + 40;
        }

        if (Poignée2 == "Simple"){
            bonus = bonus + 20;
        }
        if (Poignée2 == "Double"){
            bonus = bonus + 30;
        };
        if (Poignée2 == "Triple"){
            bonus = bonus + 40;
        }
        return bonus;
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
        System.out.print("Poignée Simple (8 atouts), Double (10), Triple (13), Multiple, non: ");
        String strPoignée = scPoignée.nextLine().intern();
        Poignée1 = strPoignée;
        if (strPoignée == "Multiple"){
            Scanner scPoignée1 = new Scanner(System.in);
            System.out.print("1. Simple (8), Double (10), Triple (13): ");
            String strPoignée1 = scPoignée1.nextLine().intern();
            Poignée1 = strPoignée1;

            Scanner scPoignée2 = new Scanner(System.in);
            System.out.print("2. Simple (8), Double (10), Triple (13): ");
            String strPoignée2 = scPoignée2.nextLine().intern();
            Poignée2 = strPoignée2;
        }


        // Roi Appelé
        Scanner scRoiAppelé = new Scanner(System.in);
        System.out.print("Roi appelé : ");
        String strRoiAppelé = scRoiAppelé.nextLine().intern();
        RoiAppelé = strRoiAppelé;


        // Calcul
        double contrat = multipleContrat() * (25 + Math.abs(seuilContrat()-Points));
        double primes = multiplePetitAuBout() * multipleContrat() * 10 + bonusChelem()+ bonusPoignée();
        double enjeu = contratRempli() * contrat + primes;
        System.out.println("");
        System.out.println("Contrat : " + contratRempli() * contrat);
        System.out.println("+ Primes : " + primes);
        System.out.println("= Enjeu : " + enjeu);
        System.out.println("");

        // Affectation des points

        if (Attaquant.getNom() == Appelé.getNom()) {
            Attaquant.setScore(4 * enjeu, j);
            for (int i = 1; i <= 5; i++){
                if (partie.getJoueur(i).getNom() != Attaquant.getNom()){
                    partie.getJoueur(i).setScore(-Attaquant.getScore()[j-1]/4, j);
                }
            }
        }
        else {
            Attaquant.setScore(2 * enjeu, j);
            Appelé.setScore(enjeu, j);
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

        // Trier les scores
        for (int i = 1; i <= 5; i++){
            partie.switchRows(i,partie.getBestRow(i,5,j));
        }

        // Afficher les scores
        System.out.println("############## Résultats cumulés au tour n°" + j +" ##############");
        for (int i = 1; i <=5; i++){
            System.out.println(i + ". " + partie.getJoueur(i).getNom() + " : " + partie.getJoueur(i).getCumulScore(j));
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
