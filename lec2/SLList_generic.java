public class SLList_generic<T>{

    private class StuffNode{
        public T item;
        public StuffNode next;
        public StuffNode(T i, StuffNode n) {
            item = i;
            next = n;
        }
    }
    /** ->[sentinel_item,sentinel_next]->[item0,next0]->[item1,next1] 
     * adding a sentinel node to simply the implement of list
     * empty list: ->[sentinel_item,null]
    */
    private StuffNode sentinel;
    private int size; /** to get size with O(1) time complexity */

    /** create an empty list */
    // public SLList_generic(){
    //     T data;
    //     sentinel = new StuffNode(data,null);
    //     size = 0;
    // }
    public SLList_generic(T x){
        sentinel = new StuffNode(x, null);
        sentinel.next = new StuffNode(x, null);
        size = 1;
    }
    /** Add a int in front of the first item */
    public void addFirst(T x){
        sentinel.next = new StuffNode(x, sentinel.next);
        size++;
    }
    /** Return the first item of list */
    public T getFirst(){
        // if(first == null){
        //     System.out.println("Empty List!");
            
        //     System.exit(1);
        // }
        if(sentinel.next == null){
            System.out.println("Error getFirst(): Empty list!");
            System.exit(1);
        }
        return sentinel.next.item;
    }
    /** add an item in the end of the list */
    public void addLast(T x){
        size++;
        // if(first == null){
        //     first = new StuffNode(x, null);
        //     return;
        // }
        StuffNode p = sentinel;
        while(p.next!=null){
            // find the last StuffNode
            p = p.next;
        }
        p.next = new StuffNode(x, null);
        
    }

    /** Return the last item of the list */
    public T getLast(){
        // if(first == null){
        //     System.out.println("Empty List!");
        //     System.exit(1);
        // }
        StuffNode p = sentinel;
        while(p.next!=null){
            p = p.next;
        }
        if(p == sentinel){
            System.out.println("Error getLast(): Empty List!");
            System.exit(1);
        }
        return p.item;
    }
    /** Return the size of the list */
    public int size(){
        // int totalSize = 0;
        // StuffNode p = first;
        // while(p!=null){
        //     totalSize++;
        //     p = p.next;
        // }
        // return totalSize;
        return size;
    }

    /** Return the ith item of the list */
    public T get(int i){
        
        // if(first == null){
        //     System.out.println("Empty List");
        //     System.exit(1);
        // }
        
        if(i < 0 || i >= size){
            System.out.println("access "+i+"th item, out of range!");
            System.exit(1);
        }
        StuffNode p = sentinel.next;
        for(int j =0;j<i;j++){
            p = p.next;
        }
        return p.item;
    }

    /** print the list */
    public void print(String info){
        StuffNode p = sentinel.next;
        System.out.println(info);
        System.out.printf("[");

        while(p!=null){
            if(p.next == null){
                System.out.print(p.item);
            }else{
                System.out.print(p.item + " ");
            }
            p = p.next;
        }
        System.out.printf("]");
        System.out.println();
    }

    public static void main(String[] args){
        
        SLList_generic<Double> L = new SLList_generic<>(1.3);
        System.out.println("size: "+L.size());
        L.print("L:");
        System.out.println("first: "+L.getFirst());
        System.out.println("last: "+L.getLast());
        // System.out.println("1th item: "+L.get(1));
        L.addLast(1.5);
        L.addFirst(1.6);
        
        L.print("L:");
        System.out.println("size: "+L.size());
        System.out.println("first: "+L.getFirst());
        System.out.println("last: "+L.getLast());
        System.out.println("1th item: "+L.get(1));

    }

}