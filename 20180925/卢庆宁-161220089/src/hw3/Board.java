package hw3;

class Board {
	private int height,width;
	private Creature c[][];
	Board(int x,int y)
	{
		height=x;
		width=y;
		c=new Creature[height][width];
		for(int i=0;i<height;i++)
		{
			for(int j=0;j<width;j++)
			{
				c[i][j]=new Creature();
			}
		}
	}
	public int getHeight() {return height;}
	public int getWidth() {return width;}
	public void testAndSet(Creature c)
	{
		if(test(c.getX(),c.getY())==false) this.c[c.getX()][c.getY()]=c;
	}
	public void set(Creature c) {this.c[c.getX()][c.getY()]=c;}
	public void reset(Creature c) {this.c[c.getX()][c.getY()]=new Creature();}
	public boolean test(int x,int y)
	{
		if(x<0||x>=height||y<0||y>=width) return true;
		else return c[x][y].getExist();
	}
	public void init()
	{
		for(int i=0;i<height;i++)
		{
			for(int j=0;j<width;j++)
			{
				c[i][j]=new Creature();
			}
		}
	}
	public char getCh(int x,int y){ return c[x][y].getCh();}
	public void showAll(Display disp)
	{
		for(int j=0;j<width+2;j++)
		{
			System.out.print("#");
			disp.setLog("#");
		}
		System.out.print("\n");
		disp.setLog("\n");
		for(int i=0;i<height;i++)
		{
			System.out.print("#");
			disp.setLog("#");
			for(int j=0;j<width;j++)
			{
				System.out.print(getCh(i,j));
				disp.setLog(""+getCh(i,j));
			}
			System.out.print("#\n");
			disp.setLog("#\n");
		}
		for(int j=0;j<width+2;j++)
		{
			System.out.print("#");
			disp.setLog("#");
		}
		System.out.print("\n");
		disp.setLog("\n");
		System.out.print("\n");
		disp.setLog("\n");
	}
}
