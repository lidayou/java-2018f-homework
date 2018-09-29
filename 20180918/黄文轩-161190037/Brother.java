enum Name{
    老大,老二,老三,老四,老五,老六,小七;
}
enum Color{
    赤,橙,黄,绿,青,蓝,紫;
}

public class Brother {
    private Name name;
    private Color color;

    Brother(int id){
        this.name = Name.values()[id-1];
        this.color = Color.values()[id-1];
    }

    public String getName(){
        return this.name.toString();
    }

    public String getColor(){
        return this.color.toString();
    }

    public Name getEnumName(){
        return this.name;
    }

    public Color getEnumColor(){
        return this.color;
    }

}
