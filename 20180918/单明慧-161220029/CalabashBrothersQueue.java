package calabashbrothers;

enum COLOR {
	RED, ORANGE, YELLOW, GREEN, BLUE, CYAN, PURPLE
}

class OneCalabash {
    private int number;
    private COLOR color;
    private String colorName;
    private String name;
    OneCalabash(int i) {
    	if(i>6 || i<0) {
    		System.out.println("初始化失败。");
    	}else {
    		this.number = i;
    		switch (i) {
    		case 0:
    			this.color = COLOR.RED;
    			this.colorName = "红色";
    			this.name = "老大"; 
    			break;
    		case 1:
    			this.color = COLOR.ORANGE;
    			this.colorName = "橙色";
    			this.name = "老二"; 
    			break;
    		case 2:
    			this.color = COLOR.YELLOW;
    			this.colorName = "黄色";
    			this.name = "老三"; 
    			break;
    		case 3:
    			this.color = COLOR.GREEN;
    			this.colorName = "绿色";
    			this.name = "老四"; 
    			break;
    		case 4:
    			this.color = COLOR.BLUE;
    			this.colorName = "蓝色";
    			this.name = "老五"; 
    			break;
    		case 5:
    			this.color = COLOR.CYAN;
    			this.colorName = "青色";
    			this.name = "老六"; 
    			break;
    		case 6:
    			this.color = COLOR.PURPLE;
    			this.colorName = "紫色";
    			this.name = "老七"; 
    		}
    	}
    }
    int tellNo() {
    	return this.number;
    }
    String tellName() {
    	return this.name;
    }
    String tellColorName() {
    	return this.colorName;
    }
    COLOR tellColor() {
    	return this.color;
    }
}

class CalabashBrothers {
	OneCalabash[] sevenBrothers = new OneCalabash[7];
	int[] queue = new int[7];
	CalabashBrothers() {		
		for (int i = 0; i < 7; i++) {
			sevenBrothers[i] = new OneCalabash(i);
		}
	}
	private void initQueue() {
		queue[0] = 3;
		queue[1] = 1;
		queue[2] = 6;
		queue[3] = 2;
		queue[4] = 0;
		queue[5] = 4;
		queue[6] = 5;
	}
	void sortByNo() {
		initQueue();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6 - i; j++) {
				if (sevenBrothers[queue[j]].tellNo() > sevenBrothers[queue[j + 1]].tellNo()) {
					int tmp = queue[j];
					queue[j] = queue[j + 1];
					queue[j + 1] = tmp;
					System.out.println(sevenBrothers[queue[j + 1]].tellName() + ": "+ (j + 1) + " -> " + (j + 2));
					System.out.println(sevenBrothers[queue[j]].tellName() + ": "+ (j + 2) + " -> " + (j + 1));
				}
			}
		}
		for (int i = 0; i < 7; i++) {
			System.out.println(sevenBrothers[queue[i]].tellName());
		}
	}
	void sortByColor() {
		initQueue();
		for (int i = 0; i < 7 ;i++ ) {
			int tmp = queue[i];
			int left = 0;
			int right = i - 1;
			int middle = 0;
			while (left <= right) {
				middle = (left + right) / 2;
				if (sevenBrothers[queue[i]].tellColor().compareTo(sevenBrothers[queue[middle]].tellColor()) > 0) {
					left = middle + 1;
				}else {
					right = middle - 1;
				}
			}
			for (int j = i - 1; j >= left; j--) {
				queue[j+1] = queue[j];
				System.out.println(sevenBrothers[queue[j]].tellName() + ": "+ (j + 1) + " -> " + (j + 2));
			}
			if (left != i) {
				queue[left] = tmp;
				System.out.println(sevenBrothers[queue[left]].tellName() + ": "+ (i + 1) + " -> " + (left + 1));
			}
		}
		for (int i = 0; i < 7; i++) {
			System.out.println(sevenBrothers[queue[i]].tellColorName());
		}
	}
}

public class CalabashBrothersQueue {
	public static void main(String[] args) {
		CalabashBrothers ourCalabashBro = new CalabashBrothers();
		ourCalabashBro.sortByNo();
		ourCalabashBro.sortByColor();
		return;
	}
}
