package calabashBrothers;

/**
 * @ Author     ：Young
 * @ Description：一个有关葫芦娃的程序
 */
public class Main {
    public static void main(String[] args) {

        Grandpa grandpa = new Grandpa();
        System.out.println("----有一天，爷爷在山上发现了七个葫芦娃，于是爷爷让他们报数：");
        grandpa.boysReportDetails();
        System.out.println("----他们竟然是，有组织有纪律作风优良的葫芦娃？爷爷很吃惊，打乱了他们");
        grandpa.disruptQueue();
        System.out.println("----打乱了他们后，爷爷又让他们报数");
        grandpa.boysReportDetails();
        System.out.println("----“果然是一群机灵的小鬼！”爷爷心里想。于是爷爷决定教他们用冒泡排序法的思想排队");
        grandpa.calabashBrothersBubbleSort();
        System.out.println("----打乱了他们后，爷爷又让他们报数");
        grandpa.boysReportNames();
        System.out.println("----“只教一遍就会，太强了吧！！”爷爷摸着自己的光亮的额头，感到很欣慰,于是爷爷决定教他们用二分排序法的思想排队");
        System.out.println("----排序前，先打乱一下");
        grandpa.disruptQueue();
        System.out.println("----打乱了他们后，爷爷又让他们报数");
        grandpa.boysReportDetails();
        grandpa.calabashBrothersBinarysort();
        grandpa.boysReportColors();
        System.out.println("----“这辈子掉的头发值了！”爷爷激动得说，然后带着葫芦娃回家了");

    }
}
