import java.util.*;
import java.io.*;
public class printTriangles {
	public static void main(String[] elvis){
		System.out.println("Enter number here: ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String text = "";
		for(int i = 1; i <= n; i++){
			for (int k = 1; k <= i; k++){
				System.out.print(k + " ");
				text += (k + " ");
			}
			System.out.println();
			text += "\n";
		}
		for(int i = n-1; i >= 1; i--){
			for (int k = 1; k <= i; k++){
				System.out.print(k + " ");
				text += (k + " ");
			}
			System.out.println();
			text += "\n";
		}
	PrintWriter out = null;
	try{
		out = new PrintWriter(new FileWriter("triangle.txt"));
		out.println(text);
		System.out.println("Success!");
	}
	
	catch (Exception e){
		System.out.println("Error!");
	}
	
	finally {out.close();}
	}
}
