package world;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import world.entities.Entity;
import world.entities.Entity.EntityState;
import world.util.*;

/**
 *	世界内容的显示，包括：背景 + 实体图像.
 *
 *	@author Mirror
 *
 *	@see #ground
 *	@see #cells
 *	@see #paintWindow()
 *	@see #clearWindow()
 *	@see GUIWindow
 *	@see GUICell
 */
public class GUIPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**	每个生物占据一个格子 */
	public GUICell[][] cells;
	
	/**	背景图片 */
	private JLabel ground;
	
	/**	初始化 */
	public GUIPanel(CharWindow w) {
		// 必须设layout布局不存在，否则组件不能重叠
		this.setLayout(null);
		this.setVisible(true);
		// 初始化cells并添加到视图
		cells = new GUICell[Global.rowNum][Global.colNum];
		for (int i = 0; i < Global.rowNum; i++) {
			for (int j = 0; j < Global.colNum; j++) {
				cells[i][j] = new GUICell(i, j); 
				this.add(cells[i][j].cellLabel);
			}
		}
		// 添加背景图片
		ImageIcon groundIcon = new ImageIcon("img\\BackGround.png");
		groundIcon.setImage(groundIcon.getImage().getScaledInstance(Global.groundWidth, Global.groundHeight,Image.SCALE_DEFAULT));
		//groundIcon.setImage(groundIcon.getImage().getScaledInstance(Range.span, Range.span,Image.SCALE_DEFAULT));
		ground = new JLabel(groundIcon, JLabel.CENTER);
		ground.setSize(Global.groundWidth, Global.groundHeight);
		ground.setLocation(0, 0);
		this.add(ground);
	}

	/**	根据生物类型绘制一个格子 */
	private void paintCell(int r, int c, CreatureType t){
		cells[r][c].setImage(t);
	}

	/**	擦除一个格子 */
	private void clearCell(int r, int c) {
		cells[r][c].setImage(null);
	}

	/**	绘制所有格子 */
	public void paintWindow() {
		for (Entity en: CharWindow.entities) {
			if (en.state() == EntityState.LIVE) {
				paintCell(en.position().row(), en.position().col(), en.creature().getType());
			}
		}
	}
	
	/**	擦除所有格子 */
	public void clearWindow() {
		for (Entity en: CharWindow.entities) {
			if (en.state() == EntityState.LIVE) {
				clearCell(en.position().row(), en.position().col());
			}
		}
	}
}
