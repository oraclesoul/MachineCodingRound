package com.company;

public class Player {
    String pName;
    int pPosition;

    public Player(String pName) {
        this.pName = pName;
        this.pPosition = 0;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpPosition() {
        return pPosition;
    }

    public void setpPosition(int pPosition) {
        this.pPosition = pPosition;
    }
}
