package src;


public class SortedArrayList<T extends Comparable<? super T>> {
	private T[] data;
    private int numItems;
    
    private static final int DEFAULT_CAPACITY = 20;
   
    public SortedArrayList() {
        this(DEFAULT_CAPACITY);
    }
    
    public SortedArrayList(int initCapacity) {
        if (initCapacity <= 0)
            initCapacity = DEFAULT_CAPACITY;
        
        data = (T[]) new Comparable[initCapacity];
        numItems = 0;
    }
    
    public void display() {
    	if(numItems==0){System.out.println("The list is empty!");}
    	else{
        System.out.print("The list contains: ");
        for (int i=0; i<numItems; i++) {
            System.out.print(data[i]);
            if (i == (numItems-1))
                System.out.println(".");
            else
                System.out.print(", ");
        }
    	}
    }
    
    private void expandCapacity() {
        T[] newDataArray = (T[]) new Comparable[data.length*2];
        for(int i=0; i<data.length; i++)
            newDataArray[i] = data[i];
        
        data = newDataArray;
    }
    
    private void add(T newItem) {
        if (numItems == data.length)
            expandCapacity();
        
        data[numItems] = newItem;
        numItems++;
    }
    
    public T get(int index){
        if(index < 0 || index>numItems){
             throw new ArrayIndexOutOfBoundsException("There is no object at " + index);
        }
        else
             return data[index];
   }
    
    public int find(T item) {
        int foundIndex = -1;
        for (int i=0; i<numItems; i++) {
            if (data[i] == null || data[i].equals(item)) {
                foundIndex = i;
                break;
            }
        }
        return foundIndex;
    }
    
    public boolean remove(T item) {
        int atIndex = find(item);
        
        if (atIndex < 0 || atIndex> numItems) // item is not in the array
            return false;
        
        // shift subsequent items over
        for (int i=atIndex; i<numItems-1; i++) {
            data[i] = data[i+1];
        }
        numItems--;
        //data[availableSlot] = null;  //<--- this line is optional
        return true;
    }
    
    public int size(){
    	return numItems;
    }
    
    public void insert(T item){
    	add(item);
    	sort();
    }
    
    private void sort(){
    	for (int i = 0; i < numItems - 1; ++i) {
    		int minIndex = i;
    		for (int j = i+1; j < numItems; ++j) {
    			//System.out.println(i+" and "+j);
    			if (data[j].compareTo(data[minIndex])>0) {
    				minIndex = j;
    			}
    		}
    		T temp = data[i];
    		data[i] = data[minIndex];
    		data[minIndex] = temp;
    		}
    }
  
}
