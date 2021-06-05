package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Number of Dice ");
        int numberOfDice = input.nextInt();

        System.out.println("Enter End Point (Size of Board) ");
        int endPoint = input.nextInt();

        List<Snake>snakes = new ArrayList<>();
        List<Ladder>ladders = new ArrayList<>();
        List<Player>players = new ArrayList<>();

        Dice dice =new Dice(numberOfDice);

        System.out.println("Enter Number of Snakes on Board ");
        int numberOfSnakes = input.nextInt();
        System.out.println("Enter Snakes Head and Tail");
        for(int i=0;i<numberOfSnakes;i++)
        {
            int head = input.nextInt();
            int tail = input.nextInt();
            snakes.add(new Snake(head,tail));
        }

        System.out.println("Enter Number of Ladders on Board ");
        int numberOfLadders = input.nextInt();
        System.out.println("Enter Ladder start and End ");
        for(int i=0;i<numberOfLadders;i++)
        {
            int start = input.nextInt();
            int end = input.nextInt();
            ladders.add(new Ladder(start,end));
        }

        System.out.println("Enter Number of Player going to Play");
        int numberOfPlayers = input.nextInt();
        System.out.println("Enter Player Names");
        for(int i=0;i<numberOfPlayers;i++)
        {
            String name = input.next();
            players.add(new Player(name));
        }
        input.close();
	    Game game = new Game(snakes,ladders,players,dice,endPoint);
	    game.playGame();
        System.out.println("Game Ends");
    }
}
