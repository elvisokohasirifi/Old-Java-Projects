import java.util.*;

public class Trawler {
	private static int numHauls = 0;
	private static double weight = 0;
	private static LinkedList<Double> reverseCatches = new LinkedList<Double>();
	private static LinkedList<Double> catches = new LinkedList<Double>();
	private static double maxCatch = 0;
	private static double minCatch = 0;
	
	public static boolean done(){
		return (weight == 1000 || numHauls == 100);
	}
	
	public static boolean isFull(){
		return weight == 1000;
	}
	
	public static double weight(){
		return weight;
	}
	
	public static int hauls(){
		return numHauls;
	}
	
	public static boolean addCatch(double weightOfCatch){
		System.out.println("Total weight of fish available in stock is " + weight + "kg");
		if (done() || weightOfCatch < 0) return false;
		
		double size = 1000 - weight;
		if (size < weightOfCatch) weightOfCatch = size;
		weight += weightOfCatch;
		numHauls++;
		catches.addLast(weightOfCatch);
		reverseCatches.addFirst(weightOfCatch);
		if (weightOfCatch > maxCatch || numHauls == 1) maxCatch = weightOfCatch;
		if (weightOfCatch < minCatch || numHauls == 1) minCatch = weightOfCatch;	
		return true;
	}
	
	public static void displayCatchesInOrder(){
		Iterator iter = catches.iterator();
		while(iter.hasNext())
			print(String.valueOf(iter.next()));
	}
	
	public static void displayCatchesInReverse(){
		Iterator iter = reverseCatches.iterator();
		while(iter.hasNext())
			print(String.valueOf(iter.next()));
	}
	
	public static void main(String[] args) {
		for (int i = 1; i < 12; i++)
			addCatch(i * 100);
		print("\nTotal weight of catches -> "+ String.valueOf(weight()));
		print("\nTotal number of hauls -> "+ String.valueOf(numHauls));
		print("\nAverage catch -> " + String.valueOf(averageWeight()));
		print("\nCatches in order: ");
		displayCatchesInOrder();
		print("\nCatches in reverse: ");
		displayCatchesInReverse();
		print("\nThe highest catch was " + String.valueOf(maxCatch));
		print("\nThe smallest catch was " + String.valueOf(minCatch));
		
		for (int i = 1; i < 300; i++)
			System.out.println(i + " " + (char) i);
	}
	
	public static double averageWeight(){
		return weight/numHauls;
	}
	
	public static double maxCatch(){
		return maxCatch;
	}
	
	public static double minCatch(){
		return minCatch;
	}
	
	public static void print(String a){System.out.println(a);}

}
