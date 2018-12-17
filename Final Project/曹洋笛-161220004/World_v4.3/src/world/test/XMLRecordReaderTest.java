package world.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

import world.CoreWorld;
import world.Entity;
import world.Global;
import world.util.EntityState;
import world.util.FormationType;
import world.util.GroupType;
import world.util.Point;
import world.xml.XMLRecordReader;

public class XMLRecordReaderTest {

	private CoreWorld cWrd;
	
	private XMLRecordReader recordReader;
	
	private Map<Integer, Entity> expectedEntities;
	
	public XMLRecordReaderTest() {
		System.out.println("# 开始构造测试类 XMLRecordReaderTest");
		cWrd = new CoreWorld();
		// 测试文件的初始形态是 YL + CE
		cWrd.initFormation(FormationType.YL, GroupType.Bro);
		cWrd.initFormation(FormationType.CE, GroupType.Mon);
		// 正确的entities集合应该如下
		expectedEntities = new HashMap<>();
		for (Point p : cWrd.broForm.formMap.keySet()) { // 加入全部葫芦娃
			Point pos = Global.leftCenterP.mov(cWrd.broForm.getFormCen().reverse()).mov(p);
			Entity en = new Entity(p, cWrd.broForm.getCreature(p), pos);
			expectedEntities.put(en.id, en);
		}
		for (Point p : cWrd.monForm.formMap.keySet()) { // 加入全部妖怪
			Point pos = Global.rightCenterP.mov(cWrd.monForm.getFormCen().reverse()).mov(p);
			Entity en = new Entity(p, cWrd.monForm.getCreature(p), pos);
			expectedEntities.put(en.id, en);
		}
		// 以下两个测试都需要这一步初始化
		// 此时的CoreWorld.entities已经是从文件读取的结果了
		recordReader = new XMLRecordReader(Global.defaultTestFilename);
		System.out.println("# 测试类构造成功");
	}
	
	@Test
	public void testXMLRecordReader() {
		System.out.println("# 测试方法 XMLRecordReader");
		// 在这里测试XMLRecordReader(String)调用的(private)方法 initEntitiesByElement()
		// 即测试从文件读取的CoreWorld.entities与expectedEntities是否相等
		Iterator<Integer> it = CoreWorld.entities.keySet().iterator();
        while (it.hasNext()) {
            Integer actualId = it.next();
            Entity actualEntity = CoreWorld.entities.get(actualId);
            Entity expectedEntity = expectedEntities.get(actualId);
            // expectedEntity != null
            assertNotNull(expectedEntity); 
            // expectedEntity equals actualEntity
            assertTrue(expectedEntity.id == actualEntity.id);
            assertTrue(expectedEntity.state == actualEntity.state);
            assertTrue(expectedEntity.creature.equals(actualEntity.creature));
            assertTrue(expectedEntity.position.equals(actualEntity.position));
            assertTrue(expectedEntity.direction.equals(actualEntity.direction));
        }
		System.out.println("# 通过测试");
	}
	
	/**	将战斗复盘到 Round 18	*/
	private void setExpectedEntitiesToRound18() {
		expectedEntities.get(1056).resetEntity(EntityState.DEAD, 8, 8, 0, 0);
		expectedEntities.get(2018).resetEntity(EntityState.DEAD, 5, 9, 0, 0);
		expectedEntities.get(2054).resetEntity(EntityState.DEAD, 6, 9, 0, 0);
		expectedEntities.get(1001).resetEntity(EntityState.DEAD, 5, 10, 0, 0);
		expectedEntities.get(2090).resetEntity(EntityState.DEAD, 7, 7, 0, 0);
		expectedEntities.get(1036).resetEntity(EntityState.DEAD, 9, 6, 0, 0);
		expectedEntities.get(1037).resetEntity(EntityState.LIVE, 8, 7, 0, 0);
		expectedEntities.get(2126).resetEntity(EntityState.LIVE, 9, 6, 0, -1);
		expectedEntities.get(1039).resetEntity(EntityState.LIVE, 7, 10, 0, 0);
		expectedEntities.get(1073).resetEntity(EntityState.DEAD, 8, 9, 0, 0);
		expectedEntities.get(2001).resetEntity(EntityState.LIVE, 4, 11, 1, 0);
		expectedEntities.get(2037).resetEntity(EntityState.DEAD, 5, 10, 0, 0);
		expectedEntities.get(2073).resetEntity(EntityState.LIVE, 5, 10, -1, 0);
		expectedEntities.get(1019).resetEntity(EntityState.LIVE, 5, 9, 0, 0);
		expectedEntities.get(2109).resetEntity(EntityState.DEAD, 7, 10, 0, 0);
		expectedEntities.get(1055).resetEntity(EntityState.DEAD, 9, 10, 0, 0);
	}

	@Test
	public void testSetEntityByRound() {
		System.out.println("# 测试方法 SetEntityByRound");
		// 在这里测试读取 Round 18 的正确性
		setExpectedEntitiesToRound18(); // 计算正确值
		// 期望值
		Iterator<Integer> it = CoreWorld.entities.keySet().iterator();
        while (it.hasNext()) {
            Integer actualId = it.next();
            Entity actualEntity = CoreWorld.entities.get(actualId);
            recordReader.setEntityByRound(actualEntity, 18);
            // 现在CoreWorld.entities已经是从文件读取的结果了
            Entity expectedEntity = expectedEntities.get(actualId);
            assertNotNull(expectedEntity); 
            // expectedEntity equals actualEntity
            assertTrue(expectedEntity.id == actualEntity.id);
            assertTrue(expectedEntity.state == actualEntity.state);
            assertTrue(expectedEntity.creature.equals(actualEntity.creature));
            assertTrue(expectedEntity.position.equals(actualEntity.position));
            assertTrue(expectedEntity.direction.equals(actualEntity.direction));
        }
		System.out.println("# 通过测试");
	}

}
