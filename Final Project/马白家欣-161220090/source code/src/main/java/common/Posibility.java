package common;

import java.util.Random;

/**
 * @Description
 * @Author LUCUS BAI
 * @Date 2018/12/13
 */
public class Posibility {

    static Random random = new Random();

    public static boolean percentage(int number) {
        if(random.nextInt(100) < number) {
            return true;
        }
        else {
            return false;
        }
    }
}
