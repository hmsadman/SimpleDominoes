package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

public class Game {
    private BoneYard boneYard = new BoneYard();
    private Board board = new Board();
    private Player player1 = new Player("Player 1");
    private Player player2 = new Player("Player 2");

    public void setUpGame() throws IOException {
        System.out.println("Choose Number of Tiles for each player");
        //Enter data using BufferReader
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        // Reading data using readLine
        String input = reader.readLine();

        String numberOfTilesToTake = input;

        for(int i = 0 ; i< Integer.parseInt(numberOfTilesToTake); i++  ){
            player1.addDomino(boneYard.pickDomino());
            player2.addDomino(boneYard.pickDomino());
        }

    }

    public boolean gameFinished(){
        if(player1.handSize() == 0 && player2.handSize() == 0){
            return true;
        }else {
            return false;
        }
    }

    public void displayFinalScore(){

           int Player1totalScore = player1.score(player1);
           int Player2totalScore = player2.score(player2);

        int winningScore = 0;
        if(Player1totalScore > Player2totalScore){
            winningScore = Player1totalScore - Player2totalScore;
        } else {
            winningScore = Player2totalScore - Player1totalScore;
        }
        System.out.println("Score of Player1 : " + Player1totalScore);
        System.out.println("Score of Player2 : " + Player2totalScore);
        System.out.println(("Winning Score :") + winningScore);


    }

    public void playGame() throws IOException {

       ;
        int randomTurn = 1;
        System.out.println(gameFinished());
//        int turn = randomNum;
        boolean gameFinished = false;
        while(!gameFinished) {


            if (randomTurn == 1) {

                System.out.println("--------------------------------------------------Turn of " + player1.getName());
                System.out.println("Your Dominoes in Hand are" + player1.displayHand());
                System.out.println("Please use the { > } or { < } first and then Put your desired Domino Number. For Example : >1, >2, >3. Use { ? } to change turn");



                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(System.in));

                // Reading data using readLine
                String input = reader.readLine();

                String splitNumber = input.substring(1);
                String splitDirection = input.substring(0, 1);

                System.out.println("Direction: " + splitDirection);
                System.out.println("Number: " + splitNumber);

                switch (splitDirection){

                    case ">" :
                        System.out.println("hul");
                        Domino chosenRightDomino = player1.chooseDomino(Integer.parseInt(splitNumber));
                        boolean successRight = board.addRight(chosenRightDomino);
                        System.out.println(successRight);
                        if (successRight){
                            System.out.println("Success");
                            player1.removeDomino(Integer.parseInt(splitNumber));
                            randomTurn = changeTurn(randomTurn);
                        }else {
                            System.out.println("Fail");
                            gameFinished = true;
                            break;
                        }
                        break;
                    case "<":

                        Domino chosenLeftDomino = player1.chooseDomino(Integer.parseInt(splitNumber));
                        boolean successLeft = board.addLeft(chosenLeftDomino);
                        System.out.println(successLeft);

                        if (successLeft){
                            player1.removeDomino(Integer.parseInt(splitNumber));
                            randomTurn = changeTurn(randomTurn);
                        }else {
                            System.out.println("Fail");
                            gameFinished = true;
                            break;
                        }
                        break;
                    case "?":
                        randomTurn = changeTurn(randomTurn);
                        break;
                    default:
                        System.out.println("Enter Correct Direction");

                }



            } else {
                System.out.println("---------------------------------------------------------------Turn of " + player2.getName());
                System.out.println("Your Dominoes in Hand are" + player2.displayHand());
                System.out.println("Please use the { > } or { < } first and then Put your desired Domino Number. For Example : >1, >2, >3. Use { ? } to change turn");
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(System.in));

                // Reading data using readLine
                String input = reader.readLine();

                String splitNumber = input.substring(1);
                String splitDirection = input.substring(0, 1);

                switch (splitDirection){
                    case ">" :
                        Domino chosenRightDomino = player2.chooseDomino(Integer.parseInt(splitNumber));

                        boolean successRight = board.addRight(chosenRightDomino);
                        System.out.println(successRight);
                        if (successRight){
                            player2.removeDomino(Integer.parseInt(splitNumber));
                            randomTurn = changeTurn(randomTurn);
                        }else {
                            System.out.println("Fail");
                            gameFinished = true;
                            break;
                        }
                        break;
                    case "<":
                        Domino chosenLeftDomino = player2.chooseDomino(Integer.parseInt(splitNumber));
                        boolean successLeft = board.addRight(chosenLeftDomino);
                        System.out.println(successLeft);
                        if (successLeft){
                            player2.removeDomino(Integer.parseInt(splitNumber));
                            randomTurn = changeTurn(randomTurn);
                        }else {
                            System.out.println("Fail");
                            gameFinished = true;
                            break;
                        }
                        break;
                    case "?":
                        randomTurn = changeTurn(randomTurn);
                        break;
                    default:
                        System.out.println("Enter Correct Direction");

                }

            }


        }
        displayFinalScore();


    }

    public int changeTurn(int turn){
        int newTurn = 0;
        if (turn == 1){
            newTurn = 2;
        }else {
            newTurn = 1;
        }
        return newTurn;
    }

}
