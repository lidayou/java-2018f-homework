package world;

import java.util.Random;

import world.util.*;

/**	
 *	全局常量变量和全局函数.
 *	包括：定值，特殊位置，胜利概率，随机计算等
 *	
 *	@author Mirror
 */
public final class Global {

	/**	行数 {@value} */
	public static final int rowNum = 17; // 0 ~ 16
	
	/**	列数 {@value} */
	public static final int colNum = 18; // 0 ~ 17
	
	/**	左侧战场中心点 */
	public static final Point leftCenterP = new Point(7, 4);

	/**	右侧战场中心点 */
	public static final Point rightCenterP = new Point(7, 13);	

	/**	窗口位置 {@value} */
	public static final int winLocationXY = 0;
	
	/**	窗口长 {@value} */
	public static final int winWidth = 814;
	
	/**	窗口宽 {@value} */
	public static final int winHeight = 822;

	/**	图片长 {@value} */
	public static final int groundWidth = 800;
	
	/**	图片宽 {@value} */
	public static final int groundHeight = 760;	

	/**	图片边距（宽） {@value} */
	public static final int marginWidth = 40;	
	
	/**	图片边距（高） {@value} */
	public static final int marginHeight = 40 + 25;	
	
	/**	网格宽度 {@value} */
	public static final int span = 40;

	/**	主进程sleep */
	public static final void worldSleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	/**	某点p是否在世界范围内 */
	public static final boolean inWorld(Point p) {
		return p.in(new Point(0, 0), new Point(rowNum - 1, colNum - 1));
	}
	
	/**	相遇时葫芦娃的胜率 */
	public static final int BroWinPercent = 50;
	
	/**	相遇时妖怪的胜率 */
	public static final int MonWinPercent = 100 - BroWinPercent;
	
	public static Random rand = null;

	/**	返回[min, max]的随机整数 */
	public static final int getRandom(int min, int max) {
		rand = new Random();
		return (rand.nextInt(max - min + 1) + min);
	}
	
	/**	随机结果胜利 */
	public static final boolean win(GroupType type) {
		if (type == GroupType.Bro)
			return (getRandom(0, 99) < BroWinPercent);
		else
			return (getRandom(0, 99) < MonWinPercent);
	}
	
}
