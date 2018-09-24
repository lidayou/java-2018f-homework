/* XuXiang 161220153 2018/9/18 19:00 */

public class Calabash {
    private int number;
    private String color;
    private String name;
    private int order;
    public void setAttribute(int number, String color, String name, int order){
        this.number = number;
        this.color = color;
        this.name = name;
        this.order = order;
    }
    public void tellName(){
        System.out.println(name);
    }
    public void tellColor(){
        System.out.println(color);
    }
    public void changeOrder(int newOrder){
        if(newOrder!=order){
            System.out.println(name+'：'+order+"→"+newOrder);
            order = newOrder;
        }
    }
    public int getNumber(){
        return number;
    }
}
