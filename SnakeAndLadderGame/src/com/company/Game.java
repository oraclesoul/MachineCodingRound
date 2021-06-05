package com.company;


import java.util.List;

public class Game {
    List<Snake> snakes;
    List<Ladder> ladders;
    List<Player> players;
    Dice dice;
    int endPoint;

    public Game(List<Snake> snakes, List<Ladder> ladders, List<Player> players, Dice dice, int endPoint) {
        this.snakes = snakes;
        this.ladders = ladders;
        this.players = players;
        this.dice = dice;
        this.endPoint = endPoint;
    }
    // move player to its final position
    int findEndPos(int curPos)
    {
        for(Snake snake : snakes)
        {
            if(snake.getsHead() == curPos)
            {
                return findEndPos(snake.getsTail());
            }
        }
        for(Ladder ladder : ladders)
        {
            if(ladder.getlStart() == curPos)
            {
                return findEndPos(ladder.getlEnd());
            }
        }
        return curPos;
    }

    // Main Function for Executing Game
    public void playGame()
    {
            int winnerCnt=0;

            while (winnerCnt<players.size()-1)
            {
                 for(int i=0;i<players.size();i++)
                {
                    if(players.get(i).pPosition == endPoint)
                    {
                        continue;
                    }
                    else
                    {
                        Player dummyPlayer = players.get(i);
                        List<Integer> moves = dice.getMoves();

                        if(moves.isEmpty())
                        {
                            System.out.println(dummyPlayer.getpName() + " Got 3 Consecutive 6 , so his move got Cancelled");
                            continue;
                        }

                        for(int move:moves)
                        {
                            int currPos = dummyPlayer.getpPosition();
                            if(currPos+move > endPoint) continue;
                            else if(currPos+move==endPoint)
                            {
                                dummyPlayer.setpPosition(endPoint);
                            }
                            else
                            {
                                int newPos = findEndPos(currPos+move);
                                dummyPlayer.setpPosition(newPos);
                            }
                            System.out.println(dummyPlayer.getpName() + " rolled a "+move + " and moved from " + currPos + " to " + dummyPlayer.getpPosition());
                        }
                        players.set(i,dummyPlayer);
                        if(dummyPlayer.getpPosition() == endPoint)
                        {
                            System.out.println(dummyPlayer.getpName() + " Wins the Game");
                            winnerCnt++;
                        }

                    }
                }
            }

            for(Player p:players)
            {
                if(p.getpPosition()<endPoint)
                {
                    System.out.println("Last Player left "+ p.getpName());
                    break;
                }
            }
    }
}
