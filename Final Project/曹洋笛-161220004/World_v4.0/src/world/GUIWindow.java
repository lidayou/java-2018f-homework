package world;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import world.util.*;

/**
 *	表世界，世界的衍生. <br>
 *	完全基于里世界{@code CharWindow}，以保证同步 <br>
 *	用于GUI显示整个世界
 *
 *	@author Mirror
 *	
 *	@see #menuBar
 *	@see #menuMonitor
 *	@see #keyMonitor
 *	@see #cWin
 *	@see #pWin
 *	@see CharWindow
 *	@see GUIPanel
 */
public final class GUIWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	/**	定义菜单栏 */
	private JMenuBar menuBar;
	
	/**	定义“开始”菜单，菜单项为“重置” */
	private JMenu menuStart; 
	/**	“开始”菜单项：“重置” */
	private JMenuItem menuItReset;
	
	/**	定义“阵型”菜单，菜单项为妖怪/葫芦娃的阵型 */
	private JMenu menuMonFormation, menuBroFormation;
	/**	“阵型”菜单项：妖怪的阵型 */
	private JMenuItem menuMonItHY, menuMonItYX, menuMonItCE, menuMonItCS, 
						menuMonItYL, menuMonItFY, menuMonItYY, menuMonItFS;
	/**	“阵型”菜单项：葫芦娃的阵型 */
	private JMenuItem menuBroItHY, menuBroItYX, menuBroItCE, menuBroItCS, 
						menuBroItYL, menuBroItFY, menuBroItYY, menuBroItFS;
	
	/**	菜单事件监听 */
	private MenuMonitor menuMonitor;
	
	/**	键盘事件监听 */
	private KeyMonitor keyMonitor;

	/**	GUI世界的原型 —— char世界 */
	private CharWindow cWin;
	
	/**	GUI世界的显示 */
	private GUIPanel pWin;

	/**	构造函数，以char世界为基础，产生GUI世界窗口 */
	public GUIWindow(CharWindow w) {
		super("葫芦娃大战妖怪"); // 设置标题
		// 设置菜单栏
		menuBar = new JMenuBar();
		menuStart = new JMenu("开始");
		menuItReset = new JMenuItem("重置");
		menuBroFormation = new JMenu("葫芦娃阵型");
		menuBroItHY = new JMenuItem("鹤翼阵");
		menuBroItYX = new JMenuItem("雁行阵");
		menuBroItCE = new JMenuItem("冲轭阵");
		menuBroItCS = new JMenuItem("长蛇阵");
		menuBroItYL = new JMenuItem("鱼鳞阵");
		menuBroItFY = new JMenuItem("方円阵");
		menuBroItYY = new JMenuItem("偃月阵");
		menuBroItFS = new JMenuItem("锋矢阵");
		menuMonFormation = new JMenu("妖怪阵型");
		menuMonItHY = new JMenuItem("鹤翼阵");
		menuMonItYX = new JMenuItem("雁行阵");
		menuMonItCE = new JMenuItem("冲轭阵");
		menuMonItCS = new JMenuItem("长蛇阵");
		menuMonItYL = new JMenuItem("鱼鳞阵");
		menuMonItFY = new JMenuItem("方円阵");
		menuMonItYY = new JMenuItem("偃月阵");
		menuMonItFS = new JMenuItem("锋矢阵");
		menuStart.add(menuItReset);
		menuBroFormation.add(menuBroItHY);
		menuBroFormation.add(menuBroItYX);
		menuBroFormation.add(menuBroItCE);
		menuBroFormation.add(menuBroItCS);
		menuBroFormation.add(menuBroItYL);
		menuBroFormation.add(menuBroItFY);
		menuBroFormation.add(menuBroItYY);
		menuBroFormation.add(menuBroItFS);
		menuMonFormation.add(menuMonItHY);
		menuMonFormation.add(menuMonItYX);
		menuMonFormation.add(menuMonItCE);
		menuMonFormation.add(menuMonItCS);
		menuMonFormation.add(menuMonItYL);
		menuMonFormation.add(menuMonItFY);
		menuMonFormation.add(menuMonItYY);
		menuMonFormation.add(menuMonItFS);
		menuBar.add(menuStart);
		menuBar.add(menuBroFormation);
		menuBar.add(menuMonFormation);
		this.add(menuBar, BorderLayout.NORTH); // 添加菜单栏
		this.setSize(Global.winWidth, Global.winHeight);
		this.setLocation(Global.winLocationXY, Global.winLocationXY); // 窗口位置
		this.setResizable(false); // 窗口大小不可更改
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 设置键盘项监听
		keyMonitor = new KeyMonitor();
		this.addKeyListener(keyMonitor);
		// 设置菜单项监听
		menuMonitor = new MenuMonitor();
		menuItReset.addActionListener(menuMonitor);
		menuBroItHY.addActionListener(menuMonitor);
		menuBroItYX.addActionListener(menuMonitor);
		menuBroItCE.addActionListener(menuMonitor);
		menuBroItCS.addActionListener(menuMonitor);
		menuBroItYL.addActionListener(menuMonitor);
		menuBroItFY.addActionListener(menuMonitor);
		menuBroItYY.addActionListener(menuMonitor);
		menuBroItFS.addActionListener(menuMonitor);
		menuMonItHY.addActionListener(menuMonitor);
		menuMonItYX.addActionListener(menuMonitor);
		menuMonItCE.addActionListener(menuMonitor);
		menuMonItCS.addActionListener(menuMonitor);
		menuMonItYL.addActionListener(menuMonitor);
		menuMonItFY.addActionListener(menuMonitor);
		menuMonItYY.addActionListener(menuMonitor);
		menuMonItFS.addActionListener(menuMonitor);
		// 基于char世界，开始构建和绘制
		cWin = new CharWindow();
		pWin = new GUIPanel(cWin);
		this.add(pWin, BorderLayout.CENTER);
		this.setVisible(true);
		cWin.showWorld();
		pWin.paintWindow();
	}
	
	/**	监听键盘项 */
	class KeyMonitor implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {
		}
		@Override
		public void keyPressed(KeyEvent e) {
		}
		@Override
		public void keyReleased(KeyEvent e) {
			pWin.clearWindow(); // 清除所有生物
			switch (e.getKeyCode()) {
			// 空格，start()
			case KeyEvent.VK_SPACE: 
				cWin.start();
				break;
			}
			Global.worldSleep(100); // 等待所有线程执行完再打印
			cWin.showWorld();
			pWin.paintWindow(); // 绘制所有生物
		}
	}
	
	/**	监听菜单项 */
	class MenuMonitor implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == menuItReset)
				handleReset();
			else if (e.getSource() == menuBroItHY)
				handleForm(FormationType.HY, GroupType.Bro);
			else if (e.getSource() == menuBroItYX)
				handleForm(FormationType.YX, GroupType.Bro);
			else if (e.getSource() == menuBroItCE)
				handleForm(FormationType.CE, GroupType.Bro);
			else if (e.getSource() == menuBroItCS)
				handleForm(FormationType.CS, GroupType.Bro);
			else if (e.getSource() == menuBroItYL)
				handleForm(FormationType.YL, GroupType.Bro);
			else if (e.getSource() == menuBroItFY)
				handleForm(FormationType.FY, GroupType.Bro);
			else if (e.getSource() == menuBroItYY)
				handleForm(FormationType.YY, GroupType.Bro);
			else if (e.getSource() == menuBroItFS)
				handleForm(FormationType.FS, GroupType.Bro);
			else if (e.getSource() == menuMonItHY)
				handleForm(FormationType.HY, GroupType.Mon);
			else if (e.getSource() == menuMonItYX)
				handleForm(FormationType.YX, GroupType.Mon);
			else if (e.getSource() == menuMonItCE)
				handleForm(FormationType.CE, GroupType.Mon);
			else if (e.getSource() == menuMonItCS)
				handleForm(FormationType.CS, GroupType.Mon);
			else if (e.getSource() == menuMonItYL)
				handleForm(FormationType.YL, GroupType.Mon);
			else if (e.getSource() == menuMonItFY)
				handleForm(FormationType.FY, GroupType.Mon);
			else if (e.getSource() == menuMonItYY)
				handleForm(FormationType.YY, GroupType.Mon);
			else if (e.getSource() == menuMonItFS)
				handleForm(FormationType.FS, GroupType.Mon);
		}
	}
	
	/**	菜单栏“开始”->“重置” */
	public void handleReset() {
		pWin.clearWindow(); // 清除所有生物
		cWin.initAll();
		cWin.showWorld();
		pWin.paintWindow(); // 绘制所有生物
	}
	
	/**	菜单栏“开始”->“阵型” */
	public void handleForm(FormationType type, GroupType ctype) {
		pWin.clearWindow(); // 清除所有生物
		cWin.changeFormation(type, ctype);
		cWin.showWorld();
		pWin.paintWindow(); // 绘制所有生物
	}

}
