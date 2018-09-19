package calabashBrothers;

/**
 * @ Author     ：Young
 * @ Description：葫芦娃
 */

enum  Color{
    RED("红色"),ORANGE("橙色"),YELLOW("黄色"),GREEN("绿色"),VERDANT("青色"),BLUE("蓝色"),PURPLE("紫色"); // 红橙黄绿蓝靛紫

    private String colorName;
    private int colorNumber;
    Color(String colorName) {
        this.colorName = colorName;
        this.colorNumber = 7;
    }

    public String getColorName() {
        return colorName;
    }
}

enum CalabashBrothers{

    RED_BOY("老大",Color.RED),
    ORANGE_BOY("老二",Color.ORANGE),
    YELLOW_BOY("老三",Color.YELLOW),
    GREEN_BOY("老四",Color.GREEN),
    VERDANT_BOY("老五",Color.VERDANT),
    BLUE_BOY("老六",Color.BLUE),
    PURPLE_BOY("老七",Color.PURPLE);

    private String name;
    private Color color;
    private int number;

    CalabashBrothers(String name, Color color) {
        this.name = name;
        this.color = color;
        this.number = 7;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color.getColorName();
    }

    public int getRank(){
        return this.ordinal();
    }


}




