public class second {


    static void swap (Gourd_boys gbs[], int pos1, int pos2){
        Gourd_boys temp = gbs[pos1];
        gbs[pos1] = gbs[pos2];
        gbs[pos2] = temp;
    }
    static void bubble_sort (Gourd_boys gbs[]){
        for(int i = 0; i < gbs.length; i++){
            for(int j = gbs.length - 1; j > i; j--){
                if(gbs[j-1].compareTo(gbs[j]) > 0){
                    gbs[j-1].report_change(j-1, j);
                    swap(gbs,j-1, j);
                }
            }
        }

    }
    static void bi_insert_sort(Gourd_boys gbs[]){
        for(int pos = 1; pos < gbs.length; pos++){
            int start = 0;
            int end = pos;
            int aim = pos / 2;
            boolean less = aim != 0 && gbs[aim - 1].compareTo(gbs[pos]) > 0;
            boolean more = gbs[aim].compareTo(gbs[pos]) < 0;
            while(less || more){
                if(more){

                    start = aim;
                    aim = (start + end) / 2 + 1;
                    less = aim != 0 && gbs[aim - 1].compareTo(gbs[pos]) > 0;
                    more = gbs[aim].compareTo(gbs[pos]) < 0;
                }
                else{
                    end = aim;
                    aim = (start + end) / 2;
                    less = aim != 0 && gbs[aim - 1].compareTo(gbs[pos]) > 0;
                    more = gbs[aim].compareTo(gbs[pos]) < 0;
                }
            }
            if(aim != pos){
                Gourd_boys temp = gbs[pos];
                for(int j = pos; j > aim; j--){
                    gbs[j - 1].report_change(j - 1, j);
                    gbs[j] = gbs[j - 1];
                }
                gbs[aim] = temp;
                gbs[aim].report_change(pos, aim);
            }
        }
    }
    public static void main(String args[]){
        Gourd_boys[] gbs1 = {Gourd_boys.老大,Gourd_boys.老三,Gourd_boys.老七,Gourd_boys.老六,Gourd_boys.老四,Gourd_boys.老二,Gourd_boys.老五};
        bubble_sort(gbs1);
        for(Gourd_boys g: gbs1){
            g.report_name();
        }
        Gourd_boys[] gbs2 = {Gourd_boys.老大,Gourd_boys.老三,Gourd_boys.老七,Gourd_boys.老六,Gourd_boys.老四,Gourd_boys.老二,Gourd_boys.老五};
        bi_insert_sort(gbs2);
        for(Gourd_boys g: gbs2){
            g.report_color();
        }
    }
}
