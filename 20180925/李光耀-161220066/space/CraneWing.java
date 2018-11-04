package space;


//只放怪物
/**
* @ClassName: CraneWing
* @Description: 基本阵型
* @author 13745
* @date 2018年11月4日
*
*/
public class CraneWing extends Formation{
	public CraneWing() {
		formation.add(new Square(broadxLines-1,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square(broadxLines-2,(int)Math.ceil((double)broadyLines/2)-1-1,null));
		formation.add(new Square(broadxLines-2,(int)Math.ceil((double)broadyLines/2)-1+1,null));
		formation.add(new Square(broadxLines-3,(int)Math.ceil((double)broadyLines/2)-1-2,null));
		formation.add(new Square(broadxLines-3,(int)Math.ceil((double)broadyLines/2)-1+2,null));
		formation.add(new Square(broadxLines-4,(int)Math.ceil((double)broadyLines/2)-1-3,null));
		formation.add(new Square(broadxLines-4,(int)Math.ceil((double)broadyLines/2)-1+3,null));
	}
	
}
