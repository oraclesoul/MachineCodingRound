package com.company;

import java.util.ArrayList;
import java.util.List;

public class Dice {
    int n;
    public Dice(int n) {
        this.n = 1;
    }
    // This will return what values a player  get on his turn
    public List<Integer> getMoves(){
        List<Integer> moves = new ArrayList<>();
        int val=0;
//        while((val=rollDice())==6)
//        {
//            moves.add(val);
//            if(moves.size()>3)
//            {
//                moves.clear();
//                break;
//            }
//        }
        for(int i=0;i<4;i++)
        {
            val = rollDice();
            moves.add(val);
            if(val<6) break;
        }
        if(moves.size()>2) moves.clear();

        return moves;
    }

    int rollDice()
    {
        int randomNum = (int)(Math.random() * 10);
        int diceFace = randomNum%6;
        if(diceFace==0)
        {
            diceFace = 6;
        }
        return diceFace;
    }
}
