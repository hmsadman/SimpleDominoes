package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BoneYard {

    ArrayList<Domino> playableDominoesList = new ArrayList<>();

    public BoneYard() {
               playableDominoesList.add(new Domino(0,0));
               playableDominoesList.add(new Domino(0,1));
               playableDominoesList.add(new Domino(0,2));
               playableDominoesList.add(new Domino(0,3));
               playableDominoesList.add(new Domino(0,4));
               playableDominoesList.add(new Domino(0,5));
               playableDominoesList.add(new Domino(0,6));
               playableDominoesList.add(new Domino(1,1));
               playableDominoesList.add(new Domino(1,2));
               playableDominoesList.add(new Domino(1,3));
               playableDominoesList.add(new Domino(1,4));
               playableDominoesList.add(new Domino(1,5));
               playableDominoesList.add(new Domino(1,6));
               playableDominoesList.add(new Domino(2,2));
               playableDominoesList.add(new Domino(2,3));
               playableDominoesList.add(new Domino(2,4));
               playableDominoesList.add(new Domino(2,5));
               playableDominoesList.add(new Domino(2,6));
               playableDominoesList.add(new Domino(3,3));
               playableDominoesList.add(new Domino(3,4));
               playableDominoesList.add(new Domino(3,5));
               playableDominoesList.add(new Domino(3,6));
               playableDominoesList.add(new Domino(4,4));
               playableDominoesList.add(new Domino(4,5));
               playableDominoesList.add(new Domino(4,6));
               playableDominoesList.add(new Domino(5,5));
               playableDominoesList.add(new Domino(5,6));
               playableDominoesList.add(new Domino(6,6));


    }

    public Domino generateDoubleSix(){
        return new Domino(6,6);
    }

    public Domino pickDomino(){
        Random random = new Random();
        int index = random.nextInt(playableDominoesList.size());
        Domino pickedDomino = playableDominoesList.get(index);
        playableDominoesList.remove(index);
        return pickedDomino;
    }

    @Override
    public String toString() {
        return "BoneYard{" +
                "playableDominoesList=" + playableDominoesList +
                '}';
    }
}
