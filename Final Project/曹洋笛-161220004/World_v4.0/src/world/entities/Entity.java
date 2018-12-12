package world.entities;

import world.CharWindow;
import world.Global;
import world.creatures.Creature;
import world.util.*;

/**
 *	生物实体类. <br>
 *	生物 + 位置 + 线程（行为），世界的每个生物都有其对应的实体
 * 
 *	@author Mirror
 * 
 *	@see CharWindow.#entities
 *	@see #creature
 *	@see #position
 *	@see #thread
 *	@see #state
 *	@see #die()
 *	@see #out()
 *	@see #move(Point)
 *	@see #run()
 *	@see #start()
 */
public class Entity implements Runnable {

	public enum EntityState {
		LIVE, // 活着
		DEAD, // 死了
		OUT; // 超出世界范围
	}
	
	/**	状态 */
	private EntityState state;
	
	/**	生物 */
	private Creature creature;
	
	/**	位置 */
	private Point position;
	
	/**	线程 */
	private Thread thread; 
	
	/**	自己死亡 */
	public void die() {
		state = EntityState.DEAD;
	}
	
	/**	自己出界 */
	public void out() {
		state = EntityState.OUT;
	}
	
	/**	@return 状态 */
	public EntityState state() {
		return state;
	}

	/**	@return 位置 */
	public Point position() {
		return position;
	}

	/**	@return 实体 */
	public Creature creature() {
		return creature;
	}
	
	public Entity(Creature c, Point p) {
		state = EntityState.LIVE;
		creature = c.copy();
		position = p.copy();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof Entity) {
			Entity en = (Entity) obj;
			return ((this.position.equals(en.position)) && (this.creature.equals(en.creature)));
		}
		return false;
	}
	
	/**	向右下移动Entity
	 *	限制Entity类的所有实例的访问
	 */
	public void move(Point d) {
		synchronized (this) {
			// 若本次移动目标位置在世界范围之内且本实体是LIVE的
			if ((state == EntityState.LIVE) && (Global.inWorld(position.mov(d)))) {
				Entity target = CharWindow.getLiveEntityAt(position.mov(d));
				if (target != null) { // 与另一个实体相遇了
					// 同阵营则暂时重叠，反正到target的线程之后可以错开
					if (target.creature().getGroup() == creature.getGroup()) {
						position.reset(position.mov(d));
					}
					else { // 敌人决生死
						if (Global.win(creature.getGroup())) {
							target.die();
							position.reset(position.mov(d));
						}
						else this.die();
					}
				}
				else // 前面是空地，正常前进
					position.reset(position.mov(d));
			}
			else { // 本次移动目标位置超出世界范围
				position.reset(position.mov(d));
				out();
			}
		}
	}
	
	@Override
	public void run() {
		if (creature.getGroup() == GroupType.Bro)
			move(new Point(0, 1));
		else move(new Point(0, -1));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**	创建线程 */
	public void start() {
    	  thread = new Thread(this);
    	  thread.start();
	   }
}
