
public class MultiplicationTables {
	
	public static void printMultiplicationTablesUsingAforLoop(int end){
		for(int i = 1; i <= end; i++)
			System.out.println("3 * " + i + " = " + 3 * i);
	}
	
	public static void printMultiplicationTablesUsingAwhileLoop(int end){
		int n = 0;
		while (++n <= end)
			System.out.println("3 * " + n + " = " + 3 * n);
	}
	
	public static void printMultiplicationTablesUsingAdoWhileLoop(int end){
		if(end < 0){
			System.out.print("Invalid index!");
			return;
		}
		int n = 1;
		do{System.out.println("3 * " + n + " = " + 3 * n);}
		while (++n <= end);
	}
	
	public static void main(String[] args) {
		printMultiplicationTablesUsingAforLoop(10);
		System.out.println();
		printMultiplicationTablesUsingAwhileLoop(12);
		System.out.println();
		printMultiplicationTablesUsingAdoWhileLoop(12);
	}

}
