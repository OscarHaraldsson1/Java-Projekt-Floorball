package com.company;

abstract class Statistics {
    private static void showGames(Session s1){
        for (int i = 0; i <s1.games.size(); i++) {
            System.out.println("Match: " + (i+1));
            s1.games.get(i).getTeam1();
            System.out.println("\nSpelade mot:");
            s1.games.get(i).getTeam2();
            System.out.println("\nMatchens resultat: " + s1.games.get(i).getResult() + "\n");
        }
    }
    private static void showGoals(Session s1){
        for (int i = 0; i < s1.playingToday.size(); i++) {
            System.out.println(s1.playingToday.get(i).getName() + ": " + s1.playingToday.get(i).getGoals() + " mål");
        }
    }
    static void whoPlayed(Session s2){
        System.out.println("\n"+"Antal matcher som spelades: "+s2.games.size());
        Statistics.showGames(s2);
        System.out.println("Träningens mål:");
        Statistics.showGoals(s2);
    }
    static void goalList(Highscore h2){
        System.out.println("Skytteligan!:");
        for (int i = 0; i < h2.highscoreList.size(); i++) {
            System.out.println(h2.highscoreList.get(i).getName() +": "+ h2.highscoreList.get(i).getGoals() + " mål!");
        }
    }
}
