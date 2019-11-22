package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

class Highscore implements Interface1, Serializable {
    ArrayList<Player> highscoreList = new ArrayList<>(){
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
            add(Theo);
            add(StefanS);
            add(Rikard);
        }
    };
    static void saveHighScore(Highscore h1){
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("HighScore"));
            os.writeObject(h1);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
