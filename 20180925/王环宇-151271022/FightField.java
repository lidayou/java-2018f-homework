/*
 * 以造世主的角度，创建双方上场的战士，并将其组织放入战场中。
 * @see class FightFileld, class Formation, Class Team.
 * @author why
 * @Time 2018-11-12
 * @version 3.0
 * 
 * version 4.0 修改建议：
 * 增加乱序操作和排序操作，使得程序更加符合要求 ，完成了乱序操作，而没有完成排序操作
 * 排序操作是一个大问题，Bad阵营中，一大一小，其随；Good阵营中，完成了Enum之后比较会简单些
 * 在Java中，对于容器的排序是否也是那么简单？
 * 
 * 使用泛型完成代码，尝试泛型中的那些方法，同时也利用这个时间来回顾一下泛型的一些内容
 * 
 * */

package javahw3;
import java.util.Random;
//import java.util.ArrayList;
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
	static int SHUFFLE = 50;
	
	private static final int N = 15;
	public Warrior[][] fields;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		FightField ff = new FightField();
		//登录每队的战士并且显示其基本信息
		Team teamGood = new Team("GoodMan");
		Team teamBad = new Team("BadMan");
		loading(teamGood, teamBad);
		try {
			teamGood.checkMember();
			teamBad.checkMember();
		}catch(MyException e) {
		}
		teamGood.showTeam();
		teamBad.showTeam();
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
		
		teamGood.showTeam();
		teamBad.showTeam();
	}
	//Constructor
	private FightField() {
		initialization();
	}

	private void initialization() {
		fields = new Warrior[N][N];
	}
	
	private static void loading(Team teamGood, Team teamBad) {
		System.out.println("创建即将上场进行对决的对象......");
		String name = "大二三四五六七";
		for (int i=0; i<7; i++) {
			teamGood.add(new CalabashBrothers(name.charAt(i) + "娃", ""));
		}
		teamGood.add(new Warrior("老爷爷", "看戏", teamBad.getSide()));
		teamBad.add(new Warrior("蝎子精", "领队", teamBad.getSide()));
		for (int i=0; i<5; i++) {
			teamBad.add(new Warrior("小兵"+i, "冲锋", teamBad.getSide()));
		}
		teamBad.add(new Warrior("小兵"+6, "冲锋", teamGood.getSide()));
		teamBad.add(new Warrior("蛇精", "看戏", teamBad.getSide()));
		// shuffle
		shuffle(teamGood);
		shuffle(teamBad);
	}
	
	public static void shuffle(Team team) {
		Random rdm = new Random();
		for(int i=0; i<SHUFFLE; i++) {
			int t1 = Math.abs(rdm.nextInt()) % team.team.size();
			int t2 = Math.abs(rdm.nextInt()) % team.team.size();
			if(t1 == t2)
				continue;
			else {
				Warrior w;
				w = team.team.get(t1);
				team.team.set(t1, team.team.get(t2));
				team.team.set(t2, w);
			}
		}
	}
	
	// show the fields
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
	private void goBattle(Team team, int[][] place) {
		team.goBattle(fields, place);
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
		this.goBattle(teamGood, Formation.getForm(0, 1));
		try {
			f1 = in.nextInt();
			this.goBattle(teamBad, Formation.getForm(f1, 2));
		}catch( IndexOutOfBoundsException e){
			System.out.println("your input is out of bound! please input again!");
			f1 = in.nextInt();
			this.goBattle(teamBad, Formation.getForm(f1, 2));
		}
	}
}


