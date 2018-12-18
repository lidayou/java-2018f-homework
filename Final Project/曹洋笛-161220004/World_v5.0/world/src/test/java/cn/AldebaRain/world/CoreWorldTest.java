package cn.AldebaRain.world;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import cn.AldebaRain.world.CoreWorld;
import cn.AldebaRain.world.util.*;

public class CoreWorldTest {

	private CoreWorld cWrd;
	
	private static final Integer[] BroCS_IdArray = new Integer[] {
			1018, 1000, 1126, 1108, 1090, 1072, 1054, 1036
	};
	private static final Integer[] MonHY_IdArray = new Integer[] {
			2037, 2020, 2003, 2054, 2073, 2092, 2111, 2055
	};

	private static final Integer[] BroHY_IdArray = new Integer[] {
			1056, 1000, 1019, 1038, 1057, 1108, 1091, 1074
	};
	private static final Integer[] BroYX_IdArray = new Integer[] {
			1000, 1019, 1038, 1057, 1076, 1095, 1114, 1133
	};
	private static final Integer[] BroCE_IdArray = new Integer[] {
			1000, 1019, 1108, 1127, 1072, 1091, 1036, 1055
	};
	private static final Integer[] BroYL_IdArray = new Integer[] {
			1037, 1056, 1019, 1001, 1039, 1073, 1036, 1055
	};
	private static final Integer[] BroFY_IdArray = new Integer[] {
			1019, 1057, 1002, 1021, 1040, 1036, 1055, 1074
	};
	private static final Integer[] BroYY_IdArray = new Integer[] {
			1037, 1056, 1000, 1019, 1038, 1090, 1073, 1055
	};
	private static final Integer[] BroFS_IdArray = new Integer[] {
			1037, 1056, 1038, 1001, 1020, 1039, 1073, 1036
	};

	private static final Integer[] MonYX_IdArray = new Integer[] {
			2075, 2058, 2041, 2024, 2007, 2126, 2109, 2092
	};
	private static final Integer[] MonCE_IdArray = new Integer[] {
			2018, 2037, 2001, 2126, 2090, 2109, 2054, 2073
	};
	private static final Integer[] MonCS_IdArray = new Integer[] {
			2018, 2000, 2126, 2108, 2090, 2072, 2054, 2036
	};
	private static final Integer[] MonYL_IdArray = new Integer[] {
			2037, 2056, 2075, 2020, 2039, 2058, 2003, 2054, 2092, 2111
	};
	private static final Integer[] MonFY_IdArray = new Integer[] {
			2019, 2057, 2002, 2021, 2040, 2036, 2055, 2074
	};
	private static final Integer[] MonYY_IdArray = new Integer[] {
			2056, 2038, 2039, 2021, 2022, 2005, 2090, 2072, 2091, 2110, 2129, 2054, 2073, 2092, 2111, 2130, 2149, 2055, 2074
	};
	private static final Integer[] MonFS_IdArray = new Integer[] {
			2056, 2019, 2057, 2058, 2002, 2059, 2072, 2091, 2110, 2054, 2036, 2055
	};
	
	public CoreWorldTest() {
		System.out.println("# 开始构造测试类 CoreWorldTest");
        cWrd = new CoreWorld();
		System.out.println("# 测试类构造成功");
    }

	/**	两数组合并	*/
	private Integer[] combineArrays(Integer[] a1, Integer[] a2) {
		Integer a[] = new Integer[a1.length + a2.length];
        for (int i = 0; i < a.length; i++) {
            if (i < a1.length) a[i] = a1[i];
            else a[i] = a2[i - a1.length];
        }
        return a;
	}
	
	/**	获取实际值	*/
	private Integer[] getActualIdArray(FormationType broForm, FormationType monForm) {
		cWrd.initFormation(broForm, GroupType.Bro);
		cWrd.initFormation(monForm, GroupType.Mon);
		Integer[] actualArray = CoreWorld.entities.keySet().toArray(new Integer[0]);
		Arrays.sort(actualArray);
		return actualArray;
	}
	
	@Test
	public void testInitFormation() {
		System.out.println("# 测试方法 initFormation");
		// HY + CE
		Integer[] actualHYCE = getActualIdArray(FormationType.HY, FormationType.CE);
		Integer[] expectedHYCE = combineArrays(BroHY_IdArray, MonCE_IdArray);
		Arrays.sort(expectedHYCE);
		assertArrayEquals(expectedHYCE, actualHYCE);
		
		// YX + CS
		Integer[] actualYXCS = getActualIdArray(FormationType.YX, FormationType.CS);
		Integer[] expectedYXCS = combineArrays(BroYX_IdArray, MonCS_IdArray);
		Arrays.sort(expectedYXCS);
		assertArrayEquals(expectedYXCS, actualYXCS);
		
		// CE + YL
		Integer[] actualCEYL = getActualIdArray(FormationType.CE, FormationType.YL);
		Integer[] expectedCEYL = combineArrays(BroCE_IdArray, MonYL_IdArray);
		Arrays.sort(expectedCEYL);
		assertArrayEquals(expectedCEYL, actualCEYL);
		
		// CS + FY
		Integer[] actualCSFY = getActualIdArray(FormationType.CS, FormationType.FY);
		Integer[] expectedCSFY = combineArrays(BroCS_IdArray, MonFY_IdArray);
		Arrays.sort(expectedCSFY);
		assertArrayEquals(expectedCSFY, actualCSFY);
		
		// YL + YY
		Integer[] actualYLYY = getActualIdArray(FormationType.YL, FormationType.YY);
		Integer[] expectedYLYY = combineArrays(BroYL_IdArray, MonYY_IdArray);
		Arrays.sort(expectedYLYY);
		assertArrayEquals(expectedYLYY, actualYLYY);
		
		// FY + FS
		Integer[] actualFYFS = getActualIdArray(FormationType.FY, FormationType.FS);
		Integer[] expectedFYFS = combineArrays(BroFY_IdArray, MonFS_IdArray);
		Arrays.sort(expectedFYFS);
		assertArrayEquals(expectedFYFS, actualFYFS);
		
		// YY + HY
		Integer[] actualYYHY = getActualIdArray(FormationType.YY, FormationType.HY);
		Integer[] expectedYYHY = combineArrays(BroYY_IdArray, MonHY_IdArray);
		Arrays.sort(expectedYYHY);
		assertArrayEquals(expectedYYHY, actualYYHY);
		
		// FS + YX
		Integer[] actualFSYX = getActualIdArray(FormationType.FS, FormationType.YX);
		Integer[] expectedFSYX = combineArrays(BroFS_IdArray, MonYX_IdArray);
		Arrays.sort(expectedFSYX);
		assertArrayEquals(expectedFSYX, actualFSYX);
		
		System.out.println("# 通过测试");
	}
}
