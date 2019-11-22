package com.company;
import java.io.Serializable;

class Player implements Serializable {
    private String name;
    private int goals;

    Player(String name) {
        this.name = name;
    }

    void setGoals(int goals) {
        this.goals += goals;
    }

    String getName() {
        return name;
    }

    int getGoals() {
        return goals;
    }
}
