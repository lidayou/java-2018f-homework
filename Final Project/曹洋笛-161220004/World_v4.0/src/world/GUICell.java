package world;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import world.util.*;

/**
 *	格子，世界地图上放置实体的位置单元.
 * 
 *	@author Mirror
 *
 *	@see #cellLabel
 *	@see #x()
 *	@see #y()
 *	@see #width()
 *	@see #height()
 *	@see #setImage(CreatureType)
 */
public class GUICell {

	/**	Cell位置行，从0开始 */
	private int cRow;
	/**	Cell位置列，从0开始 */
	private int cCol;
	
	/**	Cell图片标签，默认为none.png */
	public JLabel cellLabel;
	
	/**	初始化位置和图片 */
	public GUICell(int r, int c) {
		cRow = r;
		cCol = c;
		cellLabel = new JLabel();
		setImage(null);
		cellLabel.setSize(width(), height());
		cellLabel.setLocation(x(), y());
		cellLabel.setOpaque(false);
	}
	
	/**	为cellLabel设置新图片 */
	public void setImage(CreatureType t) {
		ImageIcon creatureIcon = null;
		if (t== null)
			creatureIcon = new ImageIcon("img\\none.png");
		else
			creatureIcon = new ImageIcon("img\\" + t.imgName + ".png");
		creatureIcon.setImage(creatureIcon.getImage().getScaledInstance(width(), height(),Image.SCALE_DEFAULT));
		cellLabel.setIcon(creatureIcon);
	}
	
	/**	x坐标 */
	public int x() {
		return (Global.marginWidth + cCol * Global.span);
	}

	/**	y坐标 */
	public int y() {
		return (Global.marginHeight + cRow * Global.span);
	}

	/**	Cell宽 */
	public int width() {
		return Global.span;
	}

	/**	Cell长 */
	public int height() {
		return Global.span;
	}
}
