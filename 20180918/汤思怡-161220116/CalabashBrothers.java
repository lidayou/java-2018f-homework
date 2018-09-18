package secondHomework;

public class CalabashBrothers {
	private final int COLOR = 2, RANK = 1, NUM = 7;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a1[] = { 1, 0, 3, 6, 2, 5, 4 };
		CalabashBrothers c1 = new CalabashBrothers(a1);
		c1.binarySort();

		int a2[] = { 3, 6, 1, 5, 4, 2, 0 };
		CalabashBrothers c2 = new CalabashBrothers(a2);
		c2.bubbleSort();
	}

	private class Calabash {
		private int order;
		private String color;
		private String name;

		protected Calabash(int order) {
			// TODO Auto-generated constructor stub
			this.order = order;
			this.color = rtnCharacter(order, COLOR);
			this.name = rtnCharacter(order, RANK);
		}

		protected int getOrder() {
			return this.order;
		}

		protected String getColor() {
			return this.color;
		}

		protected String getName() {
			return this.name;
		}
	}

	private Calabash calabashBrothers[] = new Calabash[NUM];

	public CalabashBrothers(int[] array) {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < NUM; i++) {
			Calabash calabash = new Calabash(array[i]);
			calabashBrothers[i] = calabash;
		}
	}

	// 按冒泡法依照各自排行排序
	public void bubbleSort() {
		System.out.println("按冒泡法依照各自排行排序：");
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6 - i; j++) {
				if (calabashBrothers[j].getOrder() > calabashBrothers[j + 1].getOrder()) {
					// 位置从0计数
					System.out.println(swapProcess(calabashBrothers[j], j, j + 1, RANK));
					System.out.println(swapProcess(calabashBrothers[j + 1], j + 1, j, RANK));
					Calabash temp = calabashBrothers[j];
					calabashBrothers[j] = calabashBrothers[j + 1];
					calabashBrothers[j + 1] = temp;

				}
			}
		}
		for (int i = 0; i < NUM; i++) {
			System.out.print(calabashBrothers[i].name + " ");
		}
		System.out.println("\n");
	}

	// 按二分法依照各自颜色排序
	public void binarySort() {
		System.out.println("按二分法依照各自颜色排序：");
		Calabash temp = null;
		for (int i = 1; i < NUM; i++) {
			temp = calabashBrothers[i];
			int left = 0, right = i - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (calabashBrothers[mid].getOrder() > temp.getOrder())
					right = mid - 1;
				else
					left = mid + 1;
			}
			for (int j = i - 1; j > right; j--) {
				calabashBrothers[j + 1] = calabashBrothers[j];
				System.out.println(swapProcess(calabashBrothers[j], j, j + 1, COLOR));
			}
			calabashBrothers[right + 1] = temp;
			System.out.println(swapProcess(temp, i, right + 1, COLOR));
		}
		for (int i = 0; i < NUM; i++) {
			System.out.print(calabashBrothers[i].color + " ");
		}
		System.out.println("\n");
	}

	// 根据排行返回相应的字符串:func = COLOR时返回颜色;fun = RANK时返回排行
	private String rtnCharacter(int index, int func) {
		String temp = null;
		switch (func) {
		case COLOR:
			switch (index) {
			case 0:
				temp = "红色";
				break;
			case 1:
				temp = "橙色";
				break;
			case 2:
				temp = "黄色";
				break;
			case 3:
				temp = "绿色";
				break;
			case 4:
				temp = "青色";
				break;
			case 5:
				temp = "蓝色";
				break;
			case 6:
				temp = "紫色";
				break;
			default:
				System.out.println("葫芦娃只有七个呀兄弟！");
				break;
			}
			break;
		case RANK:
			switch (index) {
			case 0:
				temp = "第一";
				break;
			case 1:
				temp = "第二";
				break;
			case 2:
				temp = "第三";
				break;
			case 3:
				temp = "第四";
				break;
			case 4:
				temp = "第五";
				break;
			case 5:
				temp = "第六";
				break;
			case 6:
				temp = "第七";
				break;
			default:
				System.out.println("葫芦娃只有七个呀兄弟！");
				break;
			}
		}
		return temp;
	}

	// 返回交换过程的字符串
	private String swapProcess(Calabash calabash, int i, int j, int func) {
		String temp = null;
		switch (func) {
		case COLOR:
			temp = calabash.getColor() + "：" + i + "->" + j;
			break;
		case RANK:
			temp = calabash.getName() + "：" + i + "->" + j;
			break;
		default:
			break;
		}
		return temp;
	}

}
