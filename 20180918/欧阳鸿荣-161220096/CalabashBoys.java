package calabashBrothers;

/**
 * @ Author     ：Young
 * @ Description：葫芦娃
 */

enum Color {
    RED("红色"), ORANGE("橙色"), YELLOW("黄色"), GREEN("绿色"), VERDANT("青色"), BLUE("蓝色"), PURPLE("紫色"); // 红橙黄绿蓝靛紫

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

enum CalabashBrothers {

    RED_BOY("老大", Color.RED, 0),
    ORANGE_BOY("老二", Color.ORANGE, 1),
    YELLOW_BOY("老三", Color.YELLOW, 2),
    GREEN_BOY("老四", Color.GREEN, 3),
    VERDANT_BOY("老五", Color.VERDANT, 4),
    BLUE_BOY("老六", Color.BLUE, 5),
    PURPLE_BOY("老七", Color.PURPLE, 6);

    private String name;
    private Color color;
    private int rank;
    private int number;

    CalabashBrothers(String name, Color color, int rank) {
        this.name = name;
        this.color = color;
        this.rank = rank;
        this.number = 7;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color.getColorName();
    }

    public int getRank() {
        return this.rank;
    }


}




