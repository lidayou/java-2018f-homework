package position;

import gui.Controller;

import static gui.Controller.FIELD_WIDTH;

/**
 * @Description 点的坐标
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */

public class Position {

    private int row;
    private int col;

    public Position(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    public Position(Position position) {
        this.row = position.row;
        this.col = position.col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public static Position move(Position position, int deltaRow, int deltaCol){
        return new Position(position.getRow() + deltaRow, position.getCol() + deltaCol);
    }

    public int toInt() {
        return row * FIELD_WIDTH + col;
    }

    public static boolean isExceedBoundary (Position position){
        if(position.getCol() >= Controller.FIELD_WIDTH  || position.getCol() < 0
                || position.getRow() >= Controller.FIELD_HEIGHT || position.getRow() < 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString () {
        return this.row + " " + this.col;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(row) + Integer.hashCode(col);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Position other = (Position) obj;
        if (other.row == this.row && other.col == this.col) {
            return true;
        } else {
            return false;
        }
    }
}
