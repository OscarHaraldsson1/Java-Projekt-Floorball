package com.company;

import java.util.ArrayList;
import java.io.Serializable;

import static com.company.Menu.FailSafe;

class Session implements Interface1, Serializable{

    ArrayList<Player> playingToday = new ArrayList<>();
    ArrayList<Game> games = new ArrayList<>();

    private void addPlayerTodayW(int i) { playingToday.add(wednesdayPlayers.get(i)); }
    private void addPlayerTodayS(int i) { playingToday.add(sundayPlayers.get(i)); }

    private void getWednesdayPlayers() {
        for (int i = 0; i <wednesdayPlayers.size() ; i++) {
            System.out.println("[" + i + "] " + wednesdayPlayers.get(i).getName());
        }
    }
    void getPlayingToday() {
        for (int i = 0; i <playingToday.size(); i++) {
            System.out.println("[" + i + "] " + playingToday.get(i).getName());
        }
    }
    private void getSundayPlayers() {
        for (int i = 0; i <sundayPlayers.size(); i++) {
            System.out.println("[" + i + "] " + sundayPlayers.get(i).getName());
        }
    }
    void whoPlays(Session s1, int i1, boolean b1){
        if (b1){
            s1.getWednesdayPlayers();
            for (int i = 0; i < i1; i++) {
                try{
                    s1.addPlayerTodayW(FailSafe(Menu.input.nextLine()));
                    System.out.println(s1.playingToday.get(i).getName() + " är nu med å spelar!");
                }catch (Exception e) {
                    i--;
                    System.out.println("Skriv in en siffra mellan 0 och 9");
                }
            }
        }
        if (!b1){
            s1.getSundayPlayers();
            for (int i = 0; i < i1; i++) {
                try{
                    s1.addPlayerTodayS(FailSafe(Menu.input.nextLine()));
                    System.out.println(s1.playingToday.get(i).getName()+" är nu med och spelar!");
                } catch (Exception e) {
                    i--;
                    System.out.println("Skriv in en siffra mellan 0 och 9");
                }
            }
        }
    }
}
