public class SortTest {
    public static void main(String[] args) {
        CalabashBrothers clBrothers=new CalabashBrothers();
        clBrothers.shuffle();
        System.out.print("置乱：");
        clBrothers.showBrothers();
        clBrothers.bubbleSortByRanking();
        System.out.print("结果：");
        clBrothers.showBrothers();
        clBrothers.shuffle();
        System.out.print("置乱：");
        clBrothers.showBrothers();
        clBrothers.binarySortByColor();
        System.out.print("结果：");
        clBrothers.showBrothers();
    }
}
