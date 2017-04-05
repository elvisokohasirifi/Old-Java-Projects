
import java.util.*;
import java.io.*;

/**
 *
 * @author sirel
 */
public class TryBible {
   private static class Book{
       private String name;
       private int numChapters;
       private String content;
       
       Book(String name,int numChapters, String content){
           this.name = name;
           this.numChapters = numChapters;
           this.content = content;
       }
   }
   private static String[] books = {"Genesis	50", "Exodus	40", "Leviticus	27", "Numbers	36", "Deuteronomy	34", "The Book of Joshua	24", "The Book of Judges	21", "The Book of Ruth	4", "The First Book of Samuel	31", "The Second Book of Samuel	24", "The Third Book of the Kings	22", "The Fourth Book of the Kings	25", "The First Book of the Chronicles	29", "The Second Book of the Chronicles	36", "The Book of Ezra	10", "The Book of Nehemiah	13", "The Book of Esther	10", "The Book of Job	42", "The Book of Psalms	150", "The Proverbs	31", "Ecclesiastes	12", "The Song of Solomon	8", "The Book of the Prophet Isaiah	66", "The Book of the Prophet Jeremiah	52", "The Lamentations of Jeremiah	5", "The Book of the Prophet Ezekiel	48", "The Book of Daniel	12", "The Book of Hosea	14", "The Book of Joel	3", "The Book of Amos	9", "The Book of Obadiah	1", "The Book of Jonah	4", "The Book of Micah	7", "The Book of Nahum	3", "The Book of Habakkuk	3", "The Book of Zephaniah	3", "The Book of Haggai	2", "The Book of Zechariah	14", "The Book of Malachi	4", "The Gospel According to Saint Matthew	28", "The Gospel According to Saint Mark	16", "The Gospel According to Saint Luke	24", "The Gospel According to Saint John	21", "The Acts of the Apostles	28", "The Epistle of Paul the Apostle to the Romans	16", "The First Epistle of Paul the Apostle to the Corinthians	16", "The Second Epistle of Paul the Apostle to the Corinthians	13", "The Epistle of Paul the Apostle to the Galatians	6", "The Epistle of Paul the Apostle to the Ephesians	6", "The Epistle of Paul the Apostle to the Philippians	4", "The Epistle of Paul the Apostle to the Colossians	4", "The First Epistle of Paul the Apostle to the Thessalonians	5", "The Second Epistle of Paul the Apostle to the Thessalonians	3", "The First Epistle of Paul the Apostle to Timothy	6", "The Second Epistle of Paul the Apostle to Timothy	4", "The Epistle of Paul the Apostle to Titus	3", "The Epistle of Paul the Apostle to Philemon	1", "The Epistle of Paul the Apostle to the Hebrews	13", "The General Epistle of James	5", "The First Epistle General of Peter	5", "The Second General Epistle of Peter	3", "The First Epistle General of John	5", "The Second Epistle General of John	1", "The Third Epistle General of John	1", "The General Epistle of Jude	1", "The Revelation of Saint John the Devine	22"};
   private static HashMap<String, Book> bible = new HashMap<>();
   
   private String[] getBooks(){return books;}
   
   public static void load(){
       for(int i = 0; i < 1; i++){
           File file = new File("C:\\Users\\sirel\\Desktop\\bible\\" + books[i].split("\t")[0] + ".txt");
	   Scanner fileInput = null;
           String content = "";
	    try {
	      fileInput = new Scanner(file);
	    }
	    catch (FileNotFoundException e) {
	      System.out.println("Error opening the file: " + books[i].split("\t")[0]);
	    }

	    while (fileInput.hasNext()){
	    	content = content + fileInput.nextLine() + "\n";
	    }
	  bible.put(books[i].split("\t")[0], new Book(books[i].split("\t")[0],Integer.parseInt(books[i].split("\t")[1]),content));
          
       }
   }
   
   public static String search(String book, String word){
	String lines = "";
	String[] n = bible.get(book).content.split("\n");
	for(int i=0; i < n.length; i++){
            if (n[i].equalsIgnoreCase(word) || n[i].contains(word)) {
            	lines = lines + n[i] + "\n\n";
            	//System.out.println(n[i]);
            }
				
        }
		return lines;
    }
   
   public static String read(String book, String verse){
	   String lines = "";
	   String next = Integer.parseInt(verse.split(":")[0]) + 1 + ":" + 1;
		String[] n = bible.get(book).content.split("\n");
		for(int i=0; i < n.length; i++){
			if (n[i].equalsIgnoreCase(verse) || n[i].contains(verse)){
				//System.out.println(i);
				for (int k = i; k < n.length && n[k].contains(next) == false; k++){
					lines = lines + n[k] + "\n\n";
					//System.out.print(n[k] + "\n");
				}
				break;
			}
		}
		return lines;
	}
   
   public static void main(String args[]){
		load();
		try {

			String content = read("Genesis", "14:14");
			File file = new File("C:\\Users\\sirel\\Desktop\\g.txt");
			
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
		System.out.print("done");
		//System.out.println(search("Genesis","Joseph"));
		//System.out.print(read("Exodus", "14:14"));
		//search("Genesis","Joseph");
		
	}
}

	
	
	
	

