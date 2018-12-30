public class AList<T>{
     
    private int size;
    private T[] items;


    public AList(){
        size = 0;
        items = (T[]) new Object[100];
    }
    /** Resize the list according to the capacity */
    public void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items,0,a,0,size);
        items = a;
    }
    /** add the item from the back of the list */
    public void addLast(T x){
        if(size == items.length){
            resize(2*size);
        }
        items[size] = x;
        size++;

    }
    /** Return the last item from the back of the list */
    public T getLast(){
        return items[size-1];
    }

    
    /** Return the size of the list */
    public int size(){
        
        return size;
    }

    /** Return the ith item of the list */
    public T get(int i){
        return items[i];
    }
    /** Remove the last item from the back of list */
    public T removeLast(){
        if(size == 0){
            System.out.println("Empty AList!");
        }
        T z = getLast();
        items[size-1] = null;
        size--;
        if(size < items.length/4){
            resize(items.length/2);
        }
        return z;
    }
}