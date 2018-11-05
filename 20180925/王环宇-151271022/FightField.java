/*
 * 以造世主的角度，创建双方上场的战士，并将其组织放入战场中。
 * @see class FightFileld, class Formation, Class Team.
 * @author why
 * @Time 2018-11-5
 * @version 2.0
 * 
 * */

package javahw3;
import java.util.ArrayList;
import java.util.Scanner;

public class FightField {
	/*
	 * 程序主要的执行入口，在此类中导入战场，加入战士，选择阵型，显示战场信息.
	 * <p>
	 *     在此类中生成Warrior的成员，作为参与战斗的主体成员<br>
	 *     此类中还用到的Team类的成员以及Formation类的成员<br>
	 *     所有的执行性动作在本类中完成。<br>
	 * @param true: 正确, false: 错误
	 * @return： boolean 
	 * */
	private static final int N = 15;
	private Warrior[][] fields;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		FightField ff = new FightField();
		//登录每队的战士，并且显示其基本信息
		Team teamGood = new Team("GoodMan");
		Team teamBad = new Team("BadMan");
		loading(teamGood, teamBad);
		try {
			teamGood.checkMember();
			teamBad.checkMember();
		}catch(MyException e) {
		}
		teamGood.showWarriors();
		teamBad.showWarriors();
		//初始化阵型
		Formation.initialization();
		/*-----------------------ROUND 1------------------------*/
		System.out.println("ROUND1");
		ff.round(teamGood, teamBad, in);
		ff.showFields();
		
		System.out.println();
		/*-----------------------ROUND 2------------------------*/
		ff.initialization();
		System.out.println("ROUND2");
		ff.round(teamGood, teamBad, in);
		ff.showFields();
		
		in.close();
		
		teamGood.showWarriors();
		teamBad.showWarriors();
	}
	//Constructor
	private FightField() {
		initialization();
	}
	//初始化战场信息
	private void initialization() {
		fields = new Warrior[N][N];
	}
	//登录两只队伍的武将
	private static void loading(Team teamGood, Team teamBad) {
		System.out.println("创建即将上场进行对决的对象......");
		String name = "大二三四五六七";
		for (int i=0; i<7; i++) {
			teamGood.add(new CalabashBrothers(name.charAt(i) + "娃", ""));
		}
		teamGood.add(new Warrior("老爷爷", "看戏", teamBad.getSide()));
		teamBad.add(new Warrior("蝎子精", "领队", teamBad.getSide()));
		for (int i=0; i<6; i++) {
			teamBad.add(new Warrior("小兵 ", "冲锋", teamBad.getSide()));
		}
		teamBad.add(new Warrior("蛇精", "看戏", teamBad.getSide()));
	}
	//显示战场的对决情况
	private void showFields() {
		System.out.println("***************************************************战场对阵情况****************************************************");
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if(fields[i][j]==null)
					System.out.print("---");
				else
					System.out.print(fields[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
		System.out.println("***************************************************战场对阵情况****************************************************");
	}
	//将双方的武将送上战场
	private void goBattle(ArrayList<Warrior> team, int[][] place) {
		for (int i=0; i<team.size(); i++) {
			int m = place[i][0];
			int n = place[i][1];
			team.get(i).changePosition(m, n);
			fields[m][n] = team.get(i);
		}
	}
	//自定义选择双方的阵型
	private void round(Team teamGood, Team teamBad, Scanner in) {
		System.out.println("************双方战士上场*************");
		System.out.println("********请选择妖精上场的阵型*********");
		System.out.println("**********0----------长蛇阵**********");
		System.out.println("**********1----------雁形阵**********");
		System.out.println("**********2----------鹤翼阵**********");
		System.out.println("**********3----------冲轭阵**********");
		int f1 = -1;
		// deal with the error: index out of bounds
		this.goBattle(teamGood.team, Formation.getForm(0, 1));
		try {
			f1 = in.nextInt();
			this.goBattle(teamBad.team, Formation.getForm(f1, 2));
		}catch( IndexOutOfBoundsException e){
			System.out.println("your input is out of bound! please input again!");
			f1 = in.nextInt();
			this.goBattle(teamBad.team, Formation.getForm(f1, 2));
		}
	}
}

class Formation{
	/*
	 * 阵型类，保存双方的阵型信息
	 * Variables: ArrayList<int[][]> book1, ArrayList<int[][]> book1;
	 * Methods: initialization(), getForm(), convert();
	 * */
	private static ArrayList<int[][]> book1;
	private static ArrayList<int[][]> book2;
	
	public static void initialization() {
		book1 = new ArrayList<int[][]>();
		book2 = new ArrayList<int[][]>();
		int x1[][] = {{4,4},{5,4},{6,4},{7,4},{8,4},{9,4},{10,4},{7,2}} ;
		int x2[][] = {{4,6},{5,5},{6,4},{7,3},{8,2},{9,1},{10,0},{5,1}} ;
		int x3[][] = {{4,6},{5,5},{6,4},{7,3},{6,2},{5,1},{4,0},{4,3}} ;
		int x4[][] = {{3,3},{4,4},{5,3},{6,4},{7,3},{8,4},{9,3},{6,1}} ;
		
		book1.add(x1);
		book2.add(convert(x1));
		book1.add(x2);
		book2.add(convert(x2));
		book1.add(x3);
		book2.add(convert(x3));
		book1.add(x4);
		book2.add(convert(x4));
	}
	
	public static int[][] getForm(int m, int team){
		if (team == 1)
			return book1.get(m);
		else
			return book2.get(m);
	}
	private static int[][] convert(int[][] xx){
		int[][] y = new int[8][2];
		for (int i=0; i<7; i++) {
			y[i][1] = 14 - xx[i][1];
			y[i][0] = xx[i][0];
		}
		y[7][1] = 14 - xx[7][1];
		y[7][0] = xx[7][0];
		return y;
	}
	
}
