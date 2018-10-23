package hw3;

public class FormationSolve {			//主类，创建各类对象并整体操作
	public static void main(String[] args)
	{
		Board b=new Board(10,20);
		Formation f[]=new Formation[4];
		f[0]=new Snake();
		f[1]=new Goose();
		f[2]=new Yoke();
		f[3]=new Crane();
		
		GrandFather good0=new GrandFather(0,0);
		b.testAndSet(good0);
		
		CalabashBrothers good1=new CalabashBrothers(7);
		good1.upset(3);
		good1.sort();
		good1.set(b,1,1,f[0]);
		
		SnakeMonster bad0=new SnakeMonster(0,19);
		b.testAndSet(bad0);
		
		Monsters bad1=new Monsters(8);
		for(int i=1;i<4;i++)
		{
			if(i!=1) bad1.reset(b);
			bad1.set(b,1,18,f[i]);
			b.showAll();
		}
	}
}