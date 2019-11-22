package com.company;

import java.util.ArrayList;

public interface Interface1 {
     Player Oscar = new Player("Oscar");
     Player Johan = new Player("Johan");
     Player Sven = new Player("Sven");
     Player Bagge = new Player("Bagge");
     Player Olle = new Player("Olle");
     Player Steve = new Player("Steve");
     Player Kalle = new Player("Kalle");
     Player Dennis = new Player("Dennis");
     Player StefanW = new Player("Stefan W");
     Player Klaus = new Player("Klaus");
     Player Theo = new Player("Theo");
     Player StefanS = new Player("Stefan S");
     Player Rikard = new Player("Rikard");

     ArrayList<Player> wednesdayPlayers = new ArrayList<>(){
          {
          add(Oscar);
          add(Johan);
          add(Sven);
          add(Bagge);
          add(Olle);
          add(Steve);
          add(Kalle);
          add(Dennis);
          add(StefanW);
          add(Klaus);
          }
     };
     ArrayList<Player> sundayPlayers = new ArrayList<>(){
          {
          add(Oscar);
          add(Johan);
          add(Sven);
          add(Bagge);
          add(Steve);
          add(Dennis);
          add(Klaus);
          add(Theo);
          add(StefanS);
          add(Rikard);
          }
     };
}
