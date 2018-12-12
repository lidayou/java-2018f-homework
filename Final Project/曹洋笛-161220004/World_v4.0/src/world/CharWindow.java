package world;

import java.util.HashSet;
import java.util.Set;

import world.entities.*;
import world.entities.Entity.EntityState;
import world.formations.*;
import world.util.*;

/**
 *	里世界，世界的基础. <br>
 *	用于终端显示整个世界
 *
 *	@author Mirror
 *
 *	@see #broForm
 *	@see #monForm
 *	@see #entities
 *	@see #getLiveEntityAt(Point)
 *	@see #initEntities()
 *	@see #start()
 *	@see #changeFormation(FormationType, GroupType)
 *	@see #showWorld()
 *	@see GUIWindow
 */
public final class CharWindow {

	// 阵型，仅仅用于对实体的初始化
	/**	定义葫芦娃阵型对象 */
	public Formation broForm;
	/**	定义妖怪阵型对象 */
	public Formation monForm;

	// 实体
	/**	即生物+位置+线程，一切行为的发起者 */
	public static Set<Entity> entities = new HashSet<>();

	/**	判断某位置是否有实体
	 *	@return 有则返回该实体Entity，没有则返回null
	 */
	public static Entity getLiveEntityAt(Point pos) {
		for (Entity en: entities) {
			if ((en.position().equals(pos)) && (en.state() == EntityState.LIVE))
				return en;
		}
		return null;
	}
	
	/**	根据当前阵型重新写入初始化的实体 */
	public void initEntities() {
		// 先移除以前阵型的全部实体
		entities.removeAll(entities);
		for (Point p : broForm.formMap.keySet()) { // 加入全部葫芦娃
			Point pos = Global.leftCenterP.mov(broForm.getFormCen().reverse()).mov(p);
			entities.add(new Entity(broForm.getCreature(p), pos));
		}
		for (Point p : monForm.formMap.keySet()) { // 加入全部妖怪
			Point pos = Global.rightCenterP.mov(monForm.getFormCen().reverse()).mov(p);
			entities.add(new Entity(monForm.getCreature(p), pos));
		}
	}

	/**	开启所有实体的线程.<br>
	 *	所有葫芦娃向右前进，所有妖怪向左前进 
	 */
	public void start() {
		for (Entity en: entities) {
			en.start();
		}
	}
	
	/**	初始化 */
	public void initAll() {
		broForm = new ChangShe(GroupType.Bro); // 葫芦娃阵型，初始化为长蛇阵
		monForm = new HeYi(GroupType.Mon); // 妖怪阵型，初始化为鹤翼阵
		// 根据阵型生成实体集
		initEntities();
	}
	
	/**	构造函数，初始化所有对象及其位置 */
	public CharWindow() {
		initAll();
	}
	
	/**	@param type 阵型类型值
	 *	@return 妖怪阵型对象 */
	private Formation setForm(FormationType type, GroupType ctype) {
		switch (type) {
		case HY: return new HeYi(ctype); 
		case YX: return new YanXing(ctype); 
		case CE: return new ChongE(ctype);
		case CS: return new ChangShe(ctype);
		case YL: return new YuLin(ctype);
		case FY: return new FangYuan(ctype);
		case YY: return new YanYue(ctype);
		case FS: return new FengShi(ctype);
		default: return new ChangShe(ctype); 
		}
	}

	/**	改变阵型的同时重置，位置初始化为默认位置 */
	public void changeFormation(FormationType type, GroupType ctype) {
		if (ctype == GroupType.Bro) 
			broForm = setForm(type, GroupType.Bro);
		else 
			monForm = setForm(type, GroupType.Mon);
		initEntities();
	}
	
	/**	显示里世界 */
	public void showWorld() {
		 // 初始化显示的地图
		char[][] cMap = new char[Global.rowNum][Global.colNum];
		for (int i = 0; i < Global.rowNum; i++) { 
			for (int j = 0; j < Global.colNum; j++)
				cMap[i][j] = ' '; 
		}
		// 放置所有实体
		for (Entity en: entities) {
			if (en.state() == EntityState.LIVE) {
				cMap[en.position().row()][en.position().col()] = en.creature().getSymbol();
			}
		}
		// 开始打印地图
		char boundary = '#';
		// 第一行，地图边界
		for (int j = 0; j < Global.colNum + 2; j++)
			System.out.print(boundary + " ");
		System.out.println();
		// 地图主体
		for (int i = 0; i < Global.rowNum; i++) {
			System.out.print(boundary);
			for (int j = 0; j < Global.colNum; j++)
				System.out.print(" " + cMap[i][j]);
			System.out.println(" " + boundary);
		}
		// 最后一行，地图边界
		for (int j = 0; j < Global.colNum + 2; j++)
			System.out.print(boundary + " ");
		System.out.println();
	}
}
