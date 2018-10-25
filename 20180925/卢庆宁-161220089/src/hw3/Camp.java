package hw3;

class Camp {
	public Creature boss;
	public Creatures soldiers;
}
class Good extends Camp
{
	Good(int x_boss,int y_boss)
	{
		boss=new GrandFather(x_boss, y_boss);
		soldiers=new CalabashBrothers(7);
	}
}
class Bad extends Camp
{
	Bad(int x_boss,int y_boss,int number)
	{
		boss=new SnakeMonster(x_boss,y_boss);
		soldiers=new Monsters(number);
	}
}
