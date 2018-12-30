public class AList<T> implements List61B<T>{
     
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
    @Override
    public void addLast(T x){
        if(size == items.length){
            resize(2*size);
        }
        items[size] = x;
        size++;

    }
    /** add the item from the front of the list */
    @Override
    public void addFirst(T x){
        insert(x,0);

    }

    /** Return the first item from the front of the list */
    @Override
    public T getFirst(){
        return items[0];
    }

    /** Return the last item from the back of the list */
    @Override
    public T getLast(){
        return items[size-1];
    }

    
    /** Return the size of the list */
    @Override
    public int size(){
        
        return size;
    }

    /** Return the ith item of the list */
    @Override
    public T get(int i){
        return items[i];
    }
    /** Remove the last item from the back of list */
    @Override
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
    /** insert an item into position i in the list */
    @Override
    public void insert(T item,int position){
        if(position >= size || position < 0){
            System.out.println("insert Error: "+ position +"is out of range!");
            System.exit(1);
        }
        if(size == items.length){
            resize(2*size);
        }
        System.arraycopy(items,position,items,position+1,size-position);
        items[position] = item;
        size++;
    }
}