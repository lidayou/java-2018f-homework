package HuluBrother;

public class HuluBrotherTest 
{
	public static void main(String[] args)
	{
		HuluBrother list[] = HuluBrother.getRandomList().clone();
		for(HuluBrother i: list)
			System.out.print(i.name() + "." + i.getRank() + " ");
		System.out.println();
		HuluBrotherSort.BubbleSort(list);
		for(HuluBrother i: list)
			System.out.print(i.name() + "." + i.getRank() + " ");
		System.out.println();

		HuluBrother list2[] = HuluBrother.getRandomList().clone();
		for(HuluBrother i: list2)
			System.out.print(i.name() + "." + i.getRank() + " ");
		System.out.println();
		HuluBrotherSort.BinarySort(list2);
		for(HuluBrother i: list2)
			System.out.print(i.name() + "." + i.getRank() + " ");
		System.out.println();
		System.out.print("Color Report:");
		for(HuluBrother i: list2)
			i.ColorReport();
	}
}
