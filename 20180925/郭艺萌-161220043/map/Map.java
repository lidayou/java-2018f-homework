package map;

import creature.*;
import formation.*;

public class Map {
	
	private int row, col;               //大小
	private Position[][] pos;           //位置信息
	private CalabashBrother brothers;   //七个葫芦娃
	private GrandFather grandpa;        //一个爷爷
	private Minion[] minions;           //一组小喽啰
	private SnakeMonster snake;         //一个蛇精
	private ScorpionMonster scorpion;   //一个蝎子精
	
	//初始化地图：输入规格大小，生成整个地图的位置信息；生成一定存在的各类生物
	public Map(int row, int col) {
		this.row = row;
		this.col = col;
		//位置信息
		pos = new Position[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				pos[i][j] = new Position(i, j);
			}
		}
		
		//生物Creature
		brothers = new CalabashBrother();
		
		grandpa = new GrandFather();
		
		minions = new Minion[19];
		for (int i = 0; i < minions.length; i++) {
			minions[i] = new Minion();
		}
		
		snake = new SnakeMonster();
		
		scorpion = new ScorpionMonster();
	}

	//获取
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	public Position[][] getPos() {
		return pos;
	}
	public CalabashBrother getBrother() {
		return brothers;
	}
	public GrandFather getGrandpa() {
		return grandpa;
	}
	public Minion[] getMinions() {
		return minions;
	}
	public SnakeMonster getSnake() {
		return snake;
	}
	public ScorpionMonster getScorpion() {
		return scorpion;
	}
	
	public boolean canStand(int x, int y) {
		if (x < 0 || x >= row) {
			return false;
		}
		if (y < 0 || y >= col) {
			return false;
		}
		if (pos[x][y].getIsSet()) { //先保证不出界 再查看该位置是否有生物
			return false;
		}		
		return true;
	}
	public boolean canRemove(int x, int y) {
		if (x < 0 || x >= row) {
			return false;
		}
		if (y < 0 || y >= col) {
			return false;
		}
		if (!pos[x][y].getIsSet()) { 
			return false;
		}		
		return true;
	}
	
	//打印信息
	public void printMap() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				Creature curCre = pos[i][j].getCreature();
				if (curCre instanceof CalabashBody) {
					System.out.print('&');
				} else if (curCre instanceof GrandFather) {
					System.out.print('#');
				} else if (curCre instanceof ScorpionMonster) {
					System.out.print('$');
				} else if (curCre instanceof Minion) {
					System.out.print('*');
				} else if (curCre instanceof SnakeMonster) {
					System.out.print('@');
				} else {
					System.out.print('-');
				}
			}
			System.out.println();
		}	
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
		Map map = new Map(10, 20);
		
		//葫芦娃 长蛇阵
		SingleLine changSheZhen = new SingleLine();
		map.getBrother().bubbleSort();  //乱序葫芦娃进行排队
		changSheZhen.form(map, map.getBrother().getOrder(), 0, 2);
		
		//爷爷助威
		map.getGrandpa().cheer(map, 3, 4);
		
		//蝎子精领队
		map.getScorpion().lead(map, 0, 18);
		
		//小喽啰
		EnEchelon yanXingZhen = new EnEchelon();
		yanXingZhen.form(map, map.getMinions(), 1, 17);
		
		//蛇精助威
		map.getSnake().cheer(map, 4, 16);
		
		map.printMap();
		
		//小喽啰阵型消失
		yanXingZhen.loose(map, map.getMinions(), 1, 17);
		
		//小喽啰变换阵型
		Yoke hengEZhen = new Yoke();
		hengEZhen.form(map, map.getMinions(), 1, 19);
		
		map.printMap();
	}

}
