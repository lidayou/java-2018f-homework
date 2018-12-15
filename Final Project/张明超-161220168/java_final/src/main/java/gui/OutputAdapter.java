package gui;
import beings.Being;
public interface OutputAdapter {
    abstract public void output(Being being);
    abstract public void move(Being being, int newx, int newy, int oldx, int oldy);
}
