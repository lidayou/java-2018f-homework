package ui;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import characters.*;
import shapes.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Administrator extends Frame{
	
	// ----------------------Properties--------------------------------
	public static int mainwindow_sizex = 1600;
	public static int mainwindow_sizey = 900;

	//-------------------------Variables----------------------------------------
	private static final long serialVersionUID = 1L;

	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static Dimension screen = tk.getScreenSize();
	
	private static String bkpAddr = "http://i1.073img.com/130109/3848468_100453_1.jpg";
	private static Image bkp;
	
	//葫芦娃信息和形象
	public static Map <CalabashInfo, Image> boysImg = new HashMap <CalabashInfo, Image>();
	private static Image[] CalabashBoysImgs = null;
	static {
		CalabashBoysImgs = new Image[] {
			new ImageIcon("resources/characters/calabash/red.PNG").getImage(),
			new ImageIcon("resources/characters/calabash/orange.PNG").getImage(),
			new ImageIcon("resources/characters/calabash/yellow.PNG").getImage(),
			new ImageIcon("resources/characters/calabash/green.PNG").getImage(),
			new ImageIcon("resources/characters/calabash/cyan.PNG").getImage(),
			new ImageIcon("resources/characters/calabash/blue.PNG").getImage(),
			new ImageIcon("resources/characters/calabash/purple.PNG").getImage()
		};
		boysImg.put(CalabashInfo.Red, CalabashBoysImgs[0]);
		boysImg.put(CalabashInfo.Orange, CalabashBoysImgs[1]);
		boysImg.put(CalabashInfo.Yellow, CalabashBoysImgs[2]);
		boysImg.put(CalabashInfo.Green, CalabashBoysImgs[3]);
		boysImg.put(CalabashInfo.Cyan, CalabashBoysImgs[4]);
		boysImg.put(CalabashInfo.Blue, CalabashBoysImgs[5]);
		boysImg.put(CalabashInfo.Purple, CalabashBoysImgs[6]);
	}
	//随机数产生器
	public static Random r = new Random();
	
	public Snake snake;	
	public GrandFather grandfather;
	public List <CalabashBoy> calabashes = new ArrayList <CalabashBoy>();
	public List <Creature> monsters = new ArrayList <Creature>();
	public static ShapeInfo[] spInfo_array = ShapeInfo.values();	
	public static CalabashInfo[] cbInfo_array = CalabashInfo.values();	
	//绘图缓冲
	Image OffScreenImage = null;
	//葫芦娃阵型和妖怪阵型
	public static ShapeInfo calabash_shape = ShapeInfo.changshe;
	public static ShapeInfo monster_shape = ShapeInfo.changshe;
	
	private int xMove = 0;
	
	@Override
	public void update(Graphics g) {
		if(OffScreenImage == null) {
			OffScreenImage = this.createImage(mainwindow_sizex,mainwindow_sizey);
		}
		Graphics gOffScreen = OffScreenImage.getGraphics();
		paint(gOffScreen);
		g.drawImage(OffScreenImage, 0, 0, null);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(bkp, 0, 0, this.getWidth(), this.getHeight(), 0, 0, bkp.getWidth(null), bkp.getHeight(null), null);
		
		for(int i=0;i<calabashes.size();i++) {
			calabashes.get(i).draw(g);
		}
		for(int i=0;i<monsters.size();i++) {
			monsters.get(i).draw(g);
		}
		snake.draw(g);
		grandfather.draw(g);
	}	
	//设置阵型
	private void set_shape() {
		
		switch (calabash_shape) {
		case heyi:		break;
		case yanxing:	break;
		case henggui:	break;
		case changshe:
			this.calabashes.get(0).setLoc(new Location(200+xMove,100));
			this.calabashes.get(1).setLoc(new Location(200+xMove,200));
			this.calabashes.get(2).setLoc(new Location(200+xMove,300));
			this.calabashes.get(3).setLoc(new Location(200+xMove,400));
			this.calabashes.get(4).setLoc(new Location(200+xMove,500));
			this.calabashes.get(5).setLoc(new Location(200+xMove,600));
			this.calabashes.get(6).setLoc(new Location(200+xMove,700));
			break;
		case yuling:	break;
		case fangmen:	break;
		case yanyue:	break;
		case fengshi:	break;
			default: break;
		}
		
		monsters.clear();
		monsters.add(new Crab(new Location(0,0),this));	
		//妖精布阵
		switch (monster_shape) {
		case heyi:{
			for(int i=0;i<6;i++) {
				this.monsters.add(new Gangster(new Location(0,0),this));
			}
			this.monsters.get(0).setLoc(new Location(900,400));
			this.monsters.get(1).setLoc(new Location(1000,500));
			this.monsters.get(2).setLoc(new Location(1000,300));
			this.monsters.get(3).setLoc(new Location(1100,600));
			this.monsters.get(4).setLoc(new Location(1100,200));
			this.monsters.get(5).setLoc(new Location(1200,700));
			this.monsters.get(6).setLoc(new Location(1200,100));
			break;			
		}

		case yanxing:{
			for(int i=0;i<5;i++) {
				this.monsters.add(new Gangster(new Location(0,0),this));
			}
			this.monsters.get(0).setLoc(new Location(1300,150));
			this.monsters.get(1).setLoc(new Location(1220,250));
			this.monsters.get(2).setLoc(new Location(1140,350));
			this.monsters.get(3).setLoc(new Location(1060,450));
			this.monsters.get(4).setLoc(new Location(980,550));
			this.monsters.get(5).setLoc(new Location(900,650));
			break;
		}
		case henggui:{
			for(int i=0;i<5;i++) {
				this.monsters.add(new Gangster(new Location(0,0),this));
			}
			this.monsters.get(0).setLoc(new Location(1300,150));
			this.monsters.get(1).setLoc(new Location(1200,250));
			this.monsters.get(2).setLoc(new Location(1300,350));
			this.monsters.get(3).setLoc(new Location(1200,450));
			this.monsters.get(4).setLoc(new Location(1300,550));
			this.monsters.get(5).setLoc(new Location(1200,650));
			break;
		}
		case changshe:{
			for(int i=0;i<5;i++) {
				this.monsters.add(new Gangster(new Location(0,0),this));
			}
			this.monsters.get(0).setLoc(new Location(1280,170));
			this.monsters.get(1).setLoc(new Location(1300,300));
			this.monsters.get(2).setLoc(new Location(1300,400));
			this.monsters.get(3).setLoc(new Location(1300,500));
			this.monsters.get(4).setLoc(new Location(1300,600));
			this.monsters.get(5).setLoc(new Location(1300,700));
			break;
		}

		case yuling:{
			for(int i=0;i<9;i++) {
				this.monsters.add(new Gangster(new Location(0,0),this));
			}
			this.monsters.get(0).setLoc(new Location(1200,250));
			this.monsters.get(1).setLoc(new Location(1260,350));
			this.monsters.get(2).setLoc(new Location(1320,450));
			this.monsters.get(3).setLoc(new Location(1200,450));
			this.monsters.get(4).setLoc(new Location(1080,450));
			this.monsters.get(5).setLoc(new Location(1380,550));
			this.monsters.get(6).setLoc(new Location(1260,550));
			this.monsters.get(7).setLoc(new Location(1140,550));
			this.monsters.get(8).setLoc(new Location(1020,550));
			this.monsters.get(9).setLoc(new Location(1200,650));
			break;
		}
		case fangmen:{
			for(int i=0;i<7;i++) {
				this.monsters.add(new Gangster(new Location(0,0),this));
			}
			this.monsters.get(0).setLoc(new Location(1000,450));
			this.monsters.get(1).setLoc(new Location(1100,350));
			this.monsters.get(2).setLoc(new Location(1100,550));
			this.monsters.get(3).setLoc(new Location(1200,250));
			this.monsters.get(4).setLoc(new Location(1200,650));
			this.monsters.get(5).setLoc(new Location(1300,350));
			this.monsters.get(6).setLoc(new Location(1300,550));
			this.monsters.get(7).setLoc(new Location(1400,450));
			break;
		}
		case yanyue:{
			for(int i=0;i<18;i++) {
				this.monsters.add(new Gangster(new Location(0,0),this));
			}
			this.monsters.get(0).setLoc(new Location(980,440));
			this.monsters.get(1).setLoc(new Location(1000,530));
			this.monsters.get(2).setLoc(new Location(1000,370));
			this.monsters.get(3).setLoc(new Location(1100,450));
			this.monsters.get(4).setLoc(new Location(1100,530));
			this.monsters.get(5).setLoc(new Location(1100,370));
			this.monsters.get(6).setLoc(new Location(1140,290));
			this.monsters.get(7).setLoc(new Location(1140,610));
			this.monsters.get(8).setLoc(new Location(1180,210));
			this.monsters.get(9).setLoc(new Location(1180,690));
			this.monsters.get(10).setLoc(new Location(1200,450));
			this.monsters.get(11).setLoc(new Location(1200,530));
			this.monsters.get(12).setLoc(new Location(1200,370));
			this.monsters.get(13).setLoc(new Location(1240,290));
			this.monsters.get(14).setLoc(new Location(1240,610));
			this.monsters.get(15).setLoc(new Location(1280,210));
			this.monsters.get(16).setLoc(new Location(1280,690));
			this.monsters.get(17).setLoc(new Location(1320,130));
			this.monsters.get(18).setLoc(new Location(1320,770));
			break;
		}
		case fengshi:{
			for(int i=0;i<11;i++) {
				this.monsters.add(new Gangster(new Location(0,0),this));
			}
			this.monsters.get(0).setLoc(new Location(900,450));
			this.monsters.get(1).setLoc(new Location(980,350));
			this.monsters.get(2).setLoc(new Location(980,550));
			this.monsters.get(3).setLoc(new Location(1060,250));
			this.monsters.get(4).setLoc(new Location(1060,650));
			this.monsters.get(5).setLoc(new Location(1140,150));
			this.monsters.get(6).setLoc(new Location(1140,750));
			this.monsters.get(7).setLoc(new Location(1000,450));
			this.monsters.get(8).setLoc(new Location(1100,450));
			this.monsters.get(9).setLoc(new Location(1200,450));
			this.monsters.get(10).setLoc(new Location(1300,450));
			this.monsters.get(11).setLoc(new Location(1400,450));
			break;
		}
		default: break;
		}
	}
	
	//改变阵型
	public void change_shape() {
		int n = r.nextInt(spInfo_array.length);
		monster_shape = spInfo_array[n];
		xMove = r.nextInt(400)-200;	
		set_shape();
		setLocGrandfatherSnake();
	}
	//改变老爷爷和蛇精的位置
	public void setLocGrandfatherSnake() {
		do {
			int fatherX = r.nextInt(mainwindow_sizex/2)+grandfather.getSizex();
			int fatherY = r.nextInt(mainwindow_sizey-2*grandfather.getSizey())+grandfather.getSizey();
			grandfather.setLoc(new Location(fatherX,fatherY));			
		}while(grandfather.hitCalaBash(calabashes) || grandfather.hitOthers(monsters)
				|| grandfather.hitAnother(snake));
		do {
			int snakeX = r.nextInt(mainwindow_sizex/2-snake.getSizex())+mainwindow_sizex/2;
			int snakeY = r.nextInt(mainwindow_sizey-2*snake.getSizey())+snake.getSizey();
			snake.setLoc(new Location(snakeX,snakeY));
		}while(snake.hitCalaBash(this.calabashes) || snake.hitOthers(monsters));
	}
	
	//键盘事件监听
	private class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_SPACE: 	//按下空格键
				change_shape();
				break;
			default:break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		}		
	}
	
	//窗口重画线程
	private class PaintThread implements Runnable{	
		@Override
		public void run() {
			while(true) {
				repaint();	
				try {
					Thread.sleep(50);	
				} catch (InterruptedException e) {
					e.printStackTrace();
				}					
			}
		}
	}
	
	private void run() {
		try {
			URL bkpURL = new URL(bkpAddr);
			bkp = tk.getImage(bkpURL);
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}

		for(int i=0;i<cbInfo_array.length;i++) {
			calabashes.add(new CalabashBoy(new Location(0,0),i,this));
		}

		this.snake = new Snake(new Location(0,0),this);

		this.grandfather = new GrandFather(new Location(0,0),this);
		this.set_shape();
		this.setLocGrandfatherSnake();

		this.setTitle("java葫芦娃");
		this.setSize(mainwindow_sizex, mainwindow_sizey);
		this.addWindowListener(new WindowAdapter() {	
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);		
			}
		});
		//设置位置居中
		int locx = (screen.width - this.getWidth())/2;
		int locy = (screen.height - this.getHeight())/2;
		this.setLocation(locx, locy);
		this.addKeyListener(new KeyMonitor());
		this.setVisible(true);	
		this.setResizable(false);

		new Thread(new PaintThread()).start();
	}
	
	public static void main(String[] args) {
		Administrator admin = new Administrator();
		admin.run();
	}

}
