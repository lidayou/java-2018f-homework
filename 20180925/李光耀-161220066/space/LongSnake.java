package space;


//只放葫芦娃
/**
* @ClassName: LongSnake
* @Description: 基本阵型
* @author 13745
* @date 2018年11月4日
*
*/
public class LongSnake extends Formation{
	public LongSnake() {
		formation.add(new Square(0,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square(1,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square(2,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square(3,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square(4,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square(5,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square(6,(int)Math.ceil((double)broadyLines/2)-1,null));
	}	
	
}