package com.company;

public class Domino {
    private int leftVal;
    private int rightVal;

    public Domino(int leftVal, int rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    public void rotate(){
        int tempRightValue = getRightVal();
        setRightVal(getLeftVal());
        setLeftVal(tempRightValue);
    }

    public int getLeftVal() {
        return leftVal;
    }

    public void setLeftVal(int leftVal) {
        this.leftVal = leftVal;
    }

    public int getRightVal() {
        return rightVal;
    }

    public void setRightVal(int rightVal) {
        this.rightVal = rightVal;
    }

    @Override
    public String toString() {
        return
                " { " +leftVal +
                " | " + rightVal +
                        " } "
                ;
    }
}
