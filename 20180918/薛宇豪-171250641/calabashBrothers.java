public enum calabashBrothers{
    老大,老二,老三,老四,老五,老六,老七;

    public String getColor(calabashBrothers c){
        String color="";
        switch (c){
            case 老大:color="红色";break;
            case 老二:color="橙色";break;
            case 老三:color="黄色";break;
            case 老四:color="绿色";break;
            case 老五:color="青色";break;
            case 老六:color="蓝色";break;
            case 老七:color="紫色";break;
        }
        return color;
    }
}