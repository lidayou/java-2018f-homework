package characters;
import ui.Administrator;
import java.awt.*;
import shapes.Location;;

public class CalabashBoy extends Creature{
	// -----------------------------------Variables---------------------------------
	public int rank;	
	private CalabashInfo cbInfo;
	private Image img;	
	
	
	//----------------------------------Properties-------------------------------------
	public static int boysizex = 70, boysizey = 70;
	


	public int getRank() {
		return rank;
	}

	public CalabashBoy(Location l, int rank, Administrator ad){
		this.loc = l;
		this.admin = ad;
		this.sizex = boysizex;	//重写父类中的成员变量
		this.sizey = boysizey;
		this.rank = rank;
		this.cbInfo = Administrator.cbInfo_array[rank];
		this.img = Administrator.boysImg.get(cbInfo);
	}

	public void draw(Graphics g) {
		g.drawImage(img, loc.locx, loc.locy, loc.locx+sizex, loc.locy+sizey, 0, 0, img.getWidth(null), img.getHeight(null), null);
		
	}
	
	
	
}



