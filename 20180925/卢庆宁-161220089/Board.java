package hw3;

class Board {
	private int length,width;
	private Creature c[][];
	Board(int x,int y)
	{
		length=x;
		width=y;
		c=new Creature[length][width];
		for(int i=0;i<length;i++)
		{
			for(int j=0;j<width;j++)
			{
				c[i][j]=new Creature();
			}
		}
	}
	public int getLength() {return length;}
	public int getWidth() {return width;}
	public void testAndSet(Creature c)
	{
		if(test(c.getX(),c.getY())==false) this.c[c.getX()][c.getY()]=c;
	}
	public void set(Creature c) {this.c[c.getX()][c.getY()]=c;}
	public void reset(Creature c) {this.c[c.getX()][c.getY()]=new Creature();}
	public boolean test(int x,int y)
	{
		if(x<0||x>=length||y<0||y>=width) return true;
		else return c[x][y].getExist();
	}
	public void init()
	{
		for(int i=0;i<length;i++)
		{
			for(int j=0;j<width;j++)
			{
				c[i][j]=new Creature();
			}
		}
	}
	public void show(int x,int y){System.out.print(c[x][y].getCh());}
	public void showAll()
	{
		for(int j=0;j<width+2;j++)
		{
			System.out.print("#");
		}
		System.out.print("\n");
		for(int i=0;i<length;i++)
		{
			System.out.print("#");
			for(int j=0;j<width;j++)
			{
				show(i,j);
			}
			System.out.print("#\n");
		}
		for(int j=0;j<width+2;j++)
		{
			System.out.print("#");
		}
		System.out.print("\n");
	}
}
