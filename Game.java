package com.company;

import java.io.Serializable;
import java.util.ArrayList;

import static com.company.Menu.FailSafe;

class Game implements Serializable {
    private String result;
    private ArrayList<Player> team1 = new ArrayList<>();
    private ArrayList<Player> team2 = new ArrayList<>();
    String getResult() {
        return result;
    }
    void setResult(String result) {
        this.result = result;
    }

    private void Team1Add(Player player) {
        team1.add(player);
    }
    private void Team2Add(Player player) {
        team2.add(player);
    }

    void getTeam1(){
        for (Player player : team1) {
            System.out.print(player.getName()+", ");
        }
    }
    void getTeam2(){
        for (Player player : team2) {
            System.out.print(player.getName()+", ");
        }
    }
    void saveGoals(Game g1,Highscore h2){
        for (int i = 0; i <g1.team1.size(); i++) {
            System.out.println("Hur många mål gjorde: " + g1.team1.get(i).getName());
            int goals = FailSafe(Menu.input.nextLine());
            g1.team1.get(i).setGoals(goals);
            for (int j = 0; j < h2.highscoreList.size(); j++) {
                if (g1.team1.get(i).getName().equals(h2.highscoreList.get(j).getName())) {
                    h2.highscoreList.get(j).setGoals(goals);
                }
            }
        }
        for (int i = 0; i <g1.team2.size(); i++) {
            System.out.println("Hur många mål gjorde: " + g1.team2.get(i).getName());
            int goals = FailSafe(Menu.input.nextLine());
            g1.team2.get(i).setGoals(goals);
            for (int j = 0; j < h2.highscoreList.size(); j++) {
                if (g1.team2.get(i).getName().equals(h2.highscoreList.get(j).getName())) {
                    h2.highscoreList.get(j).setGoals(goals);
                }
            }
        }
    }
    void whatTeams(Session s1, Game g1){
        System.out.println("Välj vilka som spelar i lag 1:");
        s1.getPlayingToday();
        for (int i = 0; i <s1.playingToday.size()/2 ; i++) {
            try {
                g1.Team1Add(s1.playingToday.get(FailSafe(Menu.input.nextLine())));
            } catch (Exception e) {
                i--;
                s1.getPlayingToday();
                System.out.println("Skriv in en siffra mellan 0 och " + (s1.playingToday.size()-1) + ":");
            }
        }
        System.out.println("Välj vilka som spelar i lag 2:");
        for (int i = 0; i <(s1.playingToday.size()+1)/2; i++) {
            try {
                g1.Team2Add(s1.playingToday.get(FailSafe(Menu.input.nextLine())));
            } catch (Exception e) {
                i--;
                s1.getPlayingToday();
                System.out.println("Skriv in en siffra mellan 0 och " + (s1.playingToday.size()-1) + ":");
            }
        }
    }
}
