package space;


/**
* @ClassName: FishScale
* @Description: 基本阵型
* @author 13745
* @date 2018年11月4日
*
*/
public class FishScale extends Formation{
	public FishScale() {
		formation.add(new Square(broadxLines-1,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square(broadxLines-2,(int)Math.ceil((double)broadyLines/2)-1-2,null));
		formation.add(new Square(broadxLines-2,(int)Math.ceil((double)broadyLines/2)-1-1,null));
		formation.add(new Square(broadxLines-2,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square(broadxLines-2,(int)Math.ceil((double)broadyLines/2)-1+1,null));
		formation.add(new Square(broadxLines-2,(int)Math.ceil((double)broadyLines/2)-1+2,null));
		formation.add(new Square(broadxLines-3,(int)Math.ceil((double)broadyLines/2)-1-1,null));
		formation.add(new Square(broadxLines-3,(int)Math.ceil((double)broadyLines/2)-1,null));
		formation.add(new Square(broadxLines-3,(int)Math.ceil((double)broadyLines/2)-1+1,null));
		formation.add(new Square(broadxLines-4,(int)Math.ceil((double)broadyLines/2)-1-1,null));
		formation.add(new Square(broadxLines-5,(int)Math.ceil((double)broadyLines/2)-1,null));
	}
	
}
