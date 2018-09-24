enum ColorOfCalabashBrother {
    RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE
}
enum RankOfCalabashBrother {
    BIG, SECOND, THIRD, FOURTH, FIFTH, SIXTH, LITTLE
}
public class CalabashBrother {
    private ColorOfCalabashBrother color;
    private RankOfCalabashBrother rank;

    public CalabashBrother(ColorOfCalabashBrother color, RankOfCalabashBrother rank) {
        this.color = color;
        this.rank = rank;
    }

    public RankOfCalabashBrother getRank() {
        return rank;
    }

    public ColorOfCalabashBrother getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "CalabashBrother{" +
                "color=" + color +
                ", rank=" + rank +
                '}';
    }
}
