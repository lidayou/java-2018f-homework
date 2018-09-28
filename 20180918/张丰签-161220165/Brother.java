public class Brother  {
    private String name;//葫芦娃名字
    private String color;//葫芦娃颜色
    int position;//葫芦娃当前位置
    int number;//葫芦娃应当的排序

    Brother(int get_number,String get_name,String get_color){
        number=get_number;
        name=get_name;
        color=get_color;
    }
    public void report_name(){//打印名字
        System.out.println(name);
    }
    public void report_color(){//打印颜色
        System.out.println(color);
    }
    public void move(int i,int j){//打印移动信息
        position=j;
        System.out.println(name+": "+i+"->"+j);
    }
}
class test{
    static int brother_num=7;
    public static void change_pos(Brother[] brother){//改变排序位置，即初始化位置
        for(int i=0;i<brother_num;i++){
            if(brother[i].position!=(i+1)){
                Brother temp=brother[brother[i].position-1];
                brother[brother[i].position-1]=brother[i];
                brother[i]=temp;
                i=0;
            }
        }
    }
    public static void BubbleSort(Brother[] brother){//冒泡
        for(int i=0;i<brother_num-1;i++){
            for(int j=0;j<brother_num-1-i;j++){
                if(brother[j].number>brother[j+1].number){
                    brother[j].move(j,j+1);
                    brother[j+1].move(j+1,j);
                    Brother temp=brother[j];
                    brother[j]=brother[j+1];
                    brother[j+1]=temp;
                }
            }
        }
    }

    public static void BinarySort(Brother[] brother) {//二分
        for (int i = 0; i < brother_num; i++) {
            Brother pivot = brother[i];
            int left = 0, middle = 0;
            int right = i - 1;
            while (left <= right) {
                middle = (left + right) / 2;
                if (pivot.number < brother[middle].number) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            for (int j = i - 1; j >= left; j--) {
                brother[j].move(j, j+1 );
                brother[j + 1] = brother[j];
            }
            if (left != i) {
                pivot.move(i,left);
                brother[left] = pivot;
            }
        }
    }
    public static void main(String[] args){
        String[] name={"老大","老二","老三","老四","老五","老六","老七"};//初始化对象
        String[] color={"赤","橙","黄","绿","青","蓝","紫"};
        Brother[] brother=new Brother[7];
        for(int i=0;i<7;i++) {
            brother[i] = new Brother(i + 1, name[i], color[i]);
        }
        int[] get_pos1={2,1,5,4,7,3,6};//初始排序，大娃第二个，二娃第一个，以此类推
        int[] get_pos2={4,7,2,3,1,6,5};
        System.out.println("冒泡排序：");
        for(int i=0;i<7;i++){
            brother[i].position=get_pos1[i];
        }
        change_pos(brother);
        BubbleSort(brother);
        for(int i=0;i<7;i++){
            brother[i].report_name();
        }
        System.out.println("二分排序：");
        for(int i=0;i<7;i++){
            brother[i].position=get_pos2[i];
        }
        change_pos(brother);
        BinarySort(brother);
        for(int i=0;i<7;i++){
            brother[i].report_color();
        }
    }
}