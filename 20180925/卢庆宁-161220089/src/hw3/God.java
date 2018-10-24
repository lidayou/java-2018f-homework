package hw3;

public class God {			//主类，创建各类对象并整体操作
	private static Board b;
	private static Formation f[];
	private static Good good;
	private static Bad bad;
	private static Display display;
	God()
	{
		initBoard(10,20);
		initFormation();
		initCamp();
		initDisplay();
	}
	public void initBoard(int height,int width)
	{
		b=new Board(height,width);
	}
	public void initFormation()
	{		
		f=new Formation[4];
		f[0]=new Snake();
		f[1]=new Goose();
		f[2]=new Yoke();
		f[3]=new Crane();	
	}	
	public void initCamp()
	{
		good=new Good(0,0);
		b.testAndSet(good.boss);
		good.soldiers.upset(3);
		good.soldiers.sort();
		good.soldiers.set(b,1,1,f[0]);
		bad=new Bad(0,19,8);
		b.testAndSet(bad.boss);
	}
	public void initDisplay()
	{
		display=new Display(b,bad.soldiers.getNumber());
	}
	public void run() throws InterruptedException
	{
		bad.soldiers.set(b,1,18,f[0]);
		b.showAll(display);
		display.change(b);
		
		int i=1;
		while(true)
		{
			Thread.sleep(100);
			if (display.getButtonCount()==i)
			{
				bad.soldiers.reset(b);
				bad.soldiers.set(b,1,18,f[i++]);
				b.showAll(display);
				display.change(b);
				if(i==4)
				{
					i=0;
					display.setButtonCount(-1);
				}
			}
		}
	}
}