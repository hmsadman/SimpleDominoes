package com.company;

import java.util.ArrayList;

public class Board {
    private ArrayList<Domino> leftSideDominoes = new ArrayList<>();
    private ArrayList<Domino> rightSideDominoes = new ArrayList<>();

    public boolean addLeft(Domino domino){
        boolean success;
        if(leftSideDominoes.isEmpty()){
            System.out.println("Initial Domino");
            leftSideDominoes.add(domino);
            success = true;
        } else {
            Domino lastDomino = leftSideDominoes.get(leftSideDominoes.size() -1);
            int leftValue = lastDomino.getLeftVal();

            int newDominoRightValue = domino.getRightVal();

            if (leftValue == newDominoRightValue){
                leftSideDominoes.add(domino);
                success = true;
            }else{
                success = false;
            }
        }


        return success;

    }

    public boolean addRight(Domino domino){
        boolean success;
        if(rightSideDominoes.isEmpty()){
            System.out.println("Initial Domino");
            rightSideDominoes.add(domino);
            success = true;
        } else {
            Domino lastDomino = rightSideDominoes.get(rightSideDominoes.size() -1);
            int rightValue = lastDomino.getRightVal();

            int newDominoLeftValue = domino.getLeftVal();

            if (rightValue == newDominoLeftValue){
                rightSideDominoes.add(domino);
                success = true;
            }else{
                success = false;
            }
        }


        return success;

    }

    @Override
    public String toString() {
        return "Board{" +
                "leftSideDominoes=" + leftSideDominoes +
                ", rightSideDominoes=" + rightSideDominoes +
                '}';
    }
}
