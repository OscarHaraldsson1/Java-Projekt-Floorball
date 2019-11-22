package com.company;

import java.io.*;
import java.util.Scanner;
abstract class Menu {
    static Scanner input = new Scanner(System.in);
    //Felsäkra input från användare
    static int FailSafe(String s1){
        try{
            return Integer.parseInt(s1);
        } catch (NumberFormatException e) {
            System.out.println("Skriv in en siffra!");
            return FailSafe(input.nextLine());
        }
    }
    private static int howMany(){
        System.out.println("Hur många ska spela?:");
        int howMany = FailSafe(input.nextLine());
        System.out.println("Välja vilka som ska spela:");
        return howMany;
    }
    static int Menu1Run() {
        System.out.println("[1] Se statistik\n[2] Skapa ny session");
        return FailSafe(input.nextLine());
    }
    static void Menu2Run(int m2) throws IOException, ClassNotFoundException {
        if (m2 == 1) {
        Menu4Run();
        }
        else if (m2 == 2) {
            Menu3Run();
        }
        // Metod som används för att rensa skytteligan, skall ej vara tillgänglig för användare.
    /*    else if (m2 == 3){
            Highscore h6 = new Highscore();
            try{
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("HighScore"));
                os.writeObject(h6);
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } */
        else {
            System.out.println("Skriv in 1 eller 2!");
            Menu2Run(FailSafe(input.nextLine()));
        }
    }
    private static void Menu3Run() throws IOException, ClassNotFoundException {
        Session s1 = new Session();
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("HighScore"));
        Highscore h2 = (Highscore) is.readObject();
        int choice = 4;
        while (choice > 2){
        System.out.println("[1] Onsdag\n[2] Söndag");
        choice = FailSafe(input.nextLine());
        }
        if (choice == 1) {
            int i = howMany();
            s1.whoPlays(s1,i,true);
        }
        else if (choice == 2) {
            int i = howMany();
            s1.whoPlays(s1,i,false);
        }
        System.out.println("Skriv in dagens datum, enligt formatet YYYY-MM-DD:");
        String date = input.nextLine();
        boolean b1 = true;
        while (b1) {
            System.out.println("[1] Ny match\n[2] Klar för idag");
            choice = FailSafe(input.nextLine());
            if(choice == 1) {
                Game g1 = new Game();
                g1.whatTeams(s1,g1);
                System.out.println("Skriv in matchens resultat:");
                g1.setResult(input.nextLine());
                g1.saveGoals(g1,h2);
                s1.games.add(g1);
            }
            else {
                Highscore.saveHighScore(h2);
                try {
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(date));
                    os.writeObject(s1);
                    os.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                b1 = false;
            }
        }
    }
    private static void Menu4Run(){
        try {
            int choice = 4;
            while (choice > 2) {
                System.out.println("[1] Skytteligan\n[2] Se en specifik tränings statistik");
                choice = FailSafe(input.nextLine());
            }
            if (choice == 1){
                ObjectInputStream is = new ObjectInputStream(new FileInputStream("HighScore"));
                Highscore h2 = (Highscore) is.readObject();
                Statistics.goalList(h2);
            }
            if (choice == 2){
                System.out.println("Skriv in datum för träningen du vill ta fram enligt formatet YYYY-MM-DD");
                String date = input.nextLine();
                ObjectInputStream is = new ObjectInputStream(new FileInputStream(date));
                Session s2 = (Session) is.readObject();
                Statistics.whoPlayed(s2);
            }
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Träningen hittades inte, försök igen.");
            Menu4Run();
        }
    }
}

