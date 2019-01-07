/** LinkedListDeque implemented by circular sentinel topology */
public class LinkedListDeque<T> implements Deque<T>{

    /** StuffNode of List */
    private class StuffNode{
        public StuffNode(T i, StuffNode p, StuffNode n){
            item = i;
            prev = p;
            next = n;
        }
        T item;
        StuffNode prev;
        StuffNode next;
    }

    private int size;
    private StuffNode sentinel;
    /** Constructor for Empty LinkedListDeque */
    public LinkedListDeque(){
        size = 0;
        sentinel = new StuffNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }
    /** add an item in front of the Deque */
    @Override
    public void addFirst(T item){
        size++;
        StuffNode insert_node = new StuffNode(item, sentinel, sentinel.next);
        sentinel.next = insert_node;
        if(size == 1){
            sentinel.prev = insert_node;
        }
    }
    /** add an item in the end of the Deque */
    @Override
    public void addLast(T item){
        size++;
        StuffNode last_node = sentinel.prev;
        StuffNode insert_node = new StuffNode(item, last_node, sentinel);
        last_node.next = insert_node;
        sentinel.prev = insert_node;
    }
    /** check whether Deque is empty */
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    /** Return size of the Deque */
    @Override
    public int size(){
        return size;
    }
    /** print the deque, separated by a space */
    @Override
    public void printDeque(){
        for(StuffNode ptr = sentinel.next; ptr != sentinel; ptr = ptr.next){
            if(ptr == sentinel.prev){
                System.out.print(ptr.item);
            }else{
                System.out.print(ptr.item+" ");
            }
        }
    }
    /** Remove the first item of the Deque */
    @Override
    public T removeFirst(){
        size--;
        T item = sentinel.next.item;
        StuffNode second = sentinel.next.next;
        sentinel.next = second;
        second.prev = sentinel;
        return item;
    }
    /** Remove the last item of the Deque */
    @Override
    public T removeLast(){
        size--;
        T item = sentinel.prev.item;
        StuffNode second_last = sentinel.prev.prev;
        second_last.next = sentinel;
        sentinel.prev = second_last;
        return item;
    }
    /** get the item by index */
    @Override
    public T get(int index){
        if(index < 0 || index >= size){
            return null;
        }
        StuffNode ptr = sentinel.next;
        for(int i = 0;i<index;i++){
            ptr = ptr.next;
        }
        return ptr.item;
    }
    /** helper function for recursion */
    public T getRecursive_helper(StuffNode node, int index){
        if(index == 0){
            return node.item;
        }
        return getRecursive_helper(node.next, index -1);
    }
    /** get the item by index using recursion */
    public T getRecursive(int index){
        if(index < 0 || index >= size){
            return null;
        }
        return getRecursive_helper(sentinel.next, index);
    }




}
