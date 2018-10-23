enum Boy {
    no_1("老大","红色"), no_2("老二","橙色"), no_3("老三", "黄色"), no_4("老四", "绿色"), no_5("老五", "青色"), no_6("老六", "蓝色"), no_7("老七","紫色");
    private String color;
    private String name;
    Boy(String a, String b) {
        this.name = a;
        this.color = b;
    }
    public String get_name(){
        return name;
    }
    public String get_color() {
        return color;
    }
}
public class Brother {
    private Boy man;
    private int x;
    private int y;
    private int rank;
    private char symbol;
    Brother(int b_rank) {
        x = 0;
        y = 0;
        rank = b_rank;
        switch (b_rank) {
            case 1:man = Boy.no_1;rank = 1;symbol = '①';break;
            case 2:man = Boy.no_2;rank = 2;symbol = '②';break;
            case 3:man = Boy.no_3;rank = 3;symbol = '③';break;
            case 4:man = Boy.no_4;rank = 4;symbol = '④';break;
            case 5:man = Boy.no_5;rank = 5;symbol = '⑤';break;
            case 6:man = Boy.no_6;rank = 6;symbol = '⑥';break;
            case 7:man = Boy.no_7;rank = 7;symbol = '⑦';break;
        }
    }
    public int get_rank() {return rank;}
    public void report_color() {
        System.out.print(man.get_color());
    }
    public void report_name() {
        System.out.print(man.get_name());
    }
    public void exchange_place(int i, int j) {
        System.out.println(man.get_name() + ": " + i + "->" + j);
    }
    public int get_index() {
        Boy[] temp= man.values();
        int i;
        for(i = 0; i < temp.length; i++) {
            if (temp[i] == man)
                break;
        }
        return i;
    }
    public void set_position(int i, int j) {
        x = i;
        y = j;
    }
    public int get_x(){
        return x;
    }
    public int get_y(){
        return y;
    }
    public char get_symbol() {
        return symbol;
    }
}
