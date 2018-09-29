package com.homework3;

public class Position
{
    int row;
    int col;

    Position(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void move(int deltaRow, int deltaCol){
        this.row += deltaRow;
        this.col += deltaCol;
    }
}
