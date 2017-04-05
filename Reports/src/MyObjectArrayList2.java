
public class MyObjectArrayList2 <T>{
     
    private T[] data;
    private int availableSlot;
    
    private static final int DEFAULT_CAPACITY = 20;
   
    public MyObjectArrayList2() {
        this(DEFAULT_CAPACITY);
    }
    
    public MyObjectArrayList2(int initCapacity) {
        if (initCapacity <= 0)
            initCapacity = DEFAULT_CAPACITY;
        
        data = (T[]) new Object[initCapacity];
        availableSlot = 0;
    }
    
    public void add(T newItem) {
        if (availableSlot == data.length)
            expandCapacity();
        
        data[availableSlot] = newItem;
        availableSlot++;
    }
    
    public void insert(T newItem, int indexToInsert) {
         if (indexToInsert < 0 || indexToInsert > availableSlot){
            throw new ArrayIndexOutOfBoundsException("Invalid index: " 
                                                         + indexToInsert);
         }
        if (availableSlot == data.length)
            expandCapacity();

        // shift subsequent items over
        for (int i = availableSlot; i > indexToInsert; i--) {
            data[i] = data[i-1];
        }
        
        // put the item in the array
        data[indexToInsert] = newItem;
        availableSlot++;
    }
    
    public int find(T item) {
        int foundIndex = -1;
        for (int i=0; i<availableSlot; i++) {
            System.out.print("Checking index " + i);
            if (data[i] == null || data[i].equals(item)) {
                foundIndex = i;
                break;
            }
            System.out.println(". Have checked item " + data[i]);
        }
        return foundIndex;
    }
    
    public boolean delete(T item) {
        int atIndex = find(item);
        
        if (atIndex < 0) // item is not in the array
            return false;
        
        // shift subsequent items over
        for (int i=atIndex; i<availableSlot-1; i++) {
            data[i] = data[i+1];
        }
        availableSlot--;
        //data[availableSlot] = null;  //<--- this line is optional
        return true;
    }

    public void display() {
        System.out.print("The list contains: ");
        for (int i=0; i<availableSlot; i++) {
            System.out.print(data[i]);
            if (i == (availableSlot-1))
                System.out.println(".");
            else
                System.out.print(", ");
        }
    }

    private void expandCapacity() {
        T[] newDataArray = (T[]) new Object[data.length*2];
        for(int i=0; i<data.length; i++)
            newDataArray[i] = data[i];
        
        data = newDataArray;
    }

    public T get(int index){
         if(index < 0 || index<availableSlot){
              throw new ArrayIndexOutOfBoundsException("There is no object at " + index);
         }
         else
              return data[index];
    }
}
