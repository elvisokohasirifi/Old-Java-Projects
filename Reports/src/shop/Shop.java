package shop;
import java.util.*;
import java.io.*;

public class Shop {
	
	private static class Sale{
		private String customer, item;
		private int quantity;
		private double price;
		Sale(String customer, String item, int quantity, double price){
			this.customer = customer;
			this.item = item;
			this.price = price;
			this.quantity = quantity;
		}
	}
	
	private static class Item{
		private String item;
		private int quantity;
		private double price;
		Item(String item, int quantity, double price){
			this.item = item;
			this.price = price;
			this.quantity = quantity;
		}
	}
		
	private static HashMap<String, Item> items = new HashMap<>();
	private static LinkedList<Sale> sales = new LinkedList<>(); 
	
	public static void purchase(String supplier, String item, int quantity, double price){
		if(items.containsKey(item))
			quantity = quantity + items.remove(item).quantity;	
		items.put(item, new Item(item, quantity, price));
		saveItems();
	}
	
	public static void clear(){
		sales.clear();
		saveTransactions();
	}
	
	public static boolean sell(String customer, String item, int quantity, double price){
		Item m = items.remove(item);
		if(m.quantity < quantity)
			return false;
		items.put(item, new Item(item, m.quantity - quantity, m.price))	;	
		sales.add(new Sale(customer, item, quantity, price));
		saveTransactions();
		saveItems();
		return true;
	}
	public static void editItem(String item, String newName){
                Item m = items.remove(item);
		m.item = newName;
		items.put(newName, m);
                saveItems();
        }
	public static void removeItem(String item){
		items.remove(item);
		saveItems();
	}
	
	public static void addItem(String item, int quantity, double price){
		Item n = new Item(item, quantity, price);
		items.put(item, n);
		saveItems();
	}
	
	public static void setPrice(String item, double newPrice){
		Item m = items.remove(item);
		m.price = newPrice;
		items.put(item, m);
                saveItems();
	}
	
	public static void saveTransactions(){
		try {

			String content = "";
			Iterator<Sale> it = sales.iterator();
			while(it.hasNext()){
				Sale s = (Sale) it.next();
				content = content + s.customer + "\t" + s.item + "\t" + s.quantity + "\t" + s.price + "\n";
			}
			File file = new File("actions.txt");
			
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveItems(){
		Collection<Item> m = items.values();
		String content = "";
		for (Item i : m)
			content = content + i.item + "\t" + i.quantity + "\t" + i.price + "\n"; 
		try {
			File file = new File("items.txt");
			
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void load(){
		File file = new File("actions.txt");
	    Scanner fileInput = null;
	    try {
	      fileInput = new Scanner(file);
	    }
	    catch (FileNotFoundException e) {
	      System.out.println("Error opening the file: " + "actions.txt");
	    }

	    while (fileInput.hasNext()){
	    	String[] items = fileInput.nextLine().split("\t");
	    	Sale s = new Sale(items[0], items[1], Integer.parseInt(items[2]), Double.parseDouble(items[3]));
	    	sales.add(s);
	    }
	  
	    File file2 = new File("items.txt");
	    Scanner fileInput2 = null;
	    try {
	      fileInput2 = new Scanner(file2);
	    }
	    catch (FileNotFoundException e) {
	      System.out.println("Error opening the file: " + "items.txt");
	    }

	    while (fileInput2.hasNext()){
	    	String[] item = fileInput2.nextLine().split("\t");
	    	Item s = new Item(item[0], Integer.parseInt(item[1]), Double.parseDouble(item[2]));
	    	items.put(item[0], s);
	    }

	}
	
	public static String itemsInStock(){
		String content = "Item\t\t\tQuantity\t\tPrice \n";
		Collection<Item> it = items.values();
		for(Item i : it)
			content = content + i.item + "\t\t\t " + i.quantity + "\t\t" + i.price + "\n";
		return content;
	}
	
	public static String viewSales(){
		ListIterator<Sale> it = sales.listIterator();
		String content = "Name of customer \t\t\t\tItem\t\t\tQuantity\t\tPrice \n";
		while (it.hasNext()){
			Sale m = it.next();
			content = content + m.customer + "\t\t\t\t\t" + m.item + "\t\t\t" + m.quantity + "\t\t" + m.price + "\n";
		}
		return content;
	}
	
	public static void undoSale(String customer, String item, int quantity, double price){		
	}
	
	public static void printReceipt(String customer, String item, int quantity, double price){}
	
	public static String[] itemInStock(){
            ArrayList<String> a = new ArrayList<>();
            for (Item i: items.values()){
                a.add(i.item);
            }
            String[] k = new String[a.size()];
            for (int i = 0; i < a.size(); i ++)
                k[i] = a.get(i);
            return k;
        }
        
        public static double getPrice(String item){
            double p = 0;
            for (Item i : items.values()){
                if(i.item.equals(item))
                    p = i.price;
            }
            return p;
        }
        
        public static double getQuantity(String item){
            int p = 0;
            for (Item i : items.values()){
                if(i.item.equals(item))
                    p = i.quantity;
            }
            return p;
        }
	
        public static void main(String[] args){
		load();
		System.out.println(itemsInStock());
		sell("Elvis","Malt",12, 14);
		System.out.println(itemsInStock());
		System.out.println(viewSales());
	}
}

