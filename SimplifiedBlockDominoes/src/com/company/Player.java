package com.company;

import java.util.ArrayList;

public class Player {
    private ArrayList<Domino> playersDominoes = new ArrayList<>();
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public int score(Player player){
        int Player1totalScore = 0;

           for (Domino num : player.playersDominoes){
               Player1totalScore += num.getLeftVal() + num.getRightVal();
           }
      return  Player1totalScore;

    }

    public void addDomino(Domino domino){
        playersDominoes.add(domino);
    }

    public Domino chooseDomino(int index){
        Domino chooseDomino = playersDominoes.get(index);
        return chooseDomino;
    }

    public void removeDomino(int index){

        playersDominoes.remove(index);

    }

    public boolean checkIndex(int index){
        if(index >= playersDominoes.size()){
            int value = playersDominoes.size() - 1;
            System.out.println("Please choose a value less than" + value);
            return true;
        }
        return false;
    }

    public int handSize (){
        return playersDominoes.size();
    }

    public String displayHand(){
        return "{" +
                "playersDominoes=" + playersDominoes +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
