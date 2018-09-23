public class Test{
	
	HuLuWas brothers;
	Test(){
		brothers=new HuLuWas();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test=new Test();

		test.brothers.randomStand();
		System.out.println("随机排列:");
		test.brothers.speakName();
		test.brothers.bubbleSortId();
		System.out.println("冒泡排序后:");
		test.brothers.speakName();
		
		test.brothers.randomStand();
		System.out.println("随机排列:");
		test.brothers.speakColor();
		test.brothers.binarySort();
		System.out.println("二分排序后:");
		test.brothers.speakColor();
	}
}
