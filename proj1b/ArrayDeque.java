public class ArrayDeque<T> implements Deque<T>{
    private  T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private double incr_Factor = 2.0;
    private double decr_Factor = 0.5;
    /** Constructor for Empty LinkedListDeque */
    public ArrayDeque(){
        size = 0;
        nextFirst = 0;
        nextLast = 1;
        items = (T[]) new Object[8];
    }
    /** Resize the Deque */
    private void Resize(int capacity){
        T[] new_items = (T[]) new Object[capacity];
        int j = 0;
        int i = nextFirst + 1;
        while(i % items.length != nextLast){
            new_items[j] = items[i % items.length];
            j++;
            i++;
        }
        nextFirst = capacity-1;
        nextLast = size;
        items = new_items;
    }
    /** add an item in front of the Deque */
    @Override
    public void addFirst(T item){
        if(nextFirst == nextLast){
            int capacity = (int)(items.length * (1 + incr_Factor));
            Resize(capacity);
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst-1)%(items.length);
        size++;
    }
    /** add an item in the end of the Deque */
    @Override
    public void addLast(T item){
        if(nextFirst == nextLast){
            int capacity = (int)(items.length * (1 + incr_Factor));
            Resize(capacity);
        }
        items[nextLast] = item;
        nextLast = (nextLast+1)%(items.length);
        size++;
    }
    /** check whether Deque is empty */
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    /** Return size of the Deque */
    public int size(){
        return size;
    }
    /** print the deque, separated by a space */
    @Override
    public void printDeque(){
        int last = (nextLast-1)%items.length;
        for(int i = nextFirst + 1;i%items.length != nextLast;i++){
            if(i%items.length == last){
                System.out.print(items[last]);
            }else {
                System.out.print(items[i % items.length] + " ");
            }
        }
    }
    /** Remove the first item of the Deque */
    @Override
    public T removeFirst(){
        if(1.0*size/items.length < decr_Factor){
            int capacity = (int)(items.length*decr_Factor) + 2;
            Resize(capacity);
        }
        T item = items[(nextFirst+1)%items.length];
        nextFirst = (nextFirst+1)%items.length;
        size--;
        return item;

    }
    /** Remove the last item of the Deque */
    @Override
    public T removeLast(){
        if(1.0*size/items.length < decr_Factor){
            int capacity = (int)(items.length*decr_Factor) + 2;
            Resize(capacity);
        }
        T item = items[(nextLast-1)%items.length];
        nextLast = (nextLast-1)%items.length;
        size--;
        return item;

    }
    /** get the item by index */
    @Override
    public T get(int index){
        if(index<0 || index>=size){
            return null;
        }
        return items[(nextFirst+1+index)%items.length];
    }
}
