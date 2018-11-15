//package qt;

public class CalabashSide extends Troop{
	public CalabashSide() {
		fighters=new CalabashBrother[7];
		for(int i=0;i<7;i++) {
			fighters[i]=new CalabashBrother(Integer.toString(i+1));
		}
		audience=new Grandpa();
	}
}
