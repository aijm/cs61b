public class SLList<T> implements List61B<T>{

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
    private int size; /* to get size with O(1) time complexity */

    /** create an empty list */
     public SLList(){
         sentinel = new StuffNode(null,null);
         size = 0;
     }
    public SLList(T x){
        sentinel = new StuffNode(null, null);
        sentinel.next = new StuffNode(x, null);
        size = 1;
    }
    /** Add a int in front of the first item */
    @Override
    public void addFirst(T x){
        sentinel.next = new StuffNode(x, sentinel.next);
        size++;
    }
    /** Return the first item of list */
    @Override
    public T getFirst(){
        if(sentinel.next == null){
            System.out.println("Error getFirst(): Empty list!");
            System.exit(1);
        }
        return sentinel.next.item;
    }
    /** add an item in the end of the list */
    @Override
    public void addLast(T x){
        size++;
        StuffNode p = sentinel;
        while(p.next!=null){
            // find the last StuffNode
            p = p.next;
        }
        p.next = new StuffNode(x, null);
        
    }

    /** Return the last item of the list */
    @Override
    public T getLast(){

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

    /** Remove the last item in the end of the list */
    @Override
    public T removeLast(){
        StuffNode p = sentinel;
        while(p.next.next!=null){
            p = p.next;
        }
        T data = p.next.item;
        p.next = null;
        size--;
        return data;
    }
    /** Return the size of the list */
    @Override
    public int size(){
        return size;
    }

    /** Return the ith item of the list */
    @Override
    public T get(int i){
        
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
    /** insert an item into position i in the list */
    @Override
    public void insert(T item, int position){
        if(position<0 || position >=size){
            System.out.println("insert Error: "+ position +"is out of range!");
            System.exit(1);
        }
        /* find the (position-1)th node */
        StuffNode p = sentinel;
        for(int i=0;i<position;i++){
            p = p.next;
        }
        StuffNode insertnode = new StuffNode(item,p.next);
        p.next = insertnode;
        size++;
    }
    @Override
    public void print(){
        System.out.print("[");
        for(StuffNode p = sentinel.next;p!=null;p = p.next){
            if(p.next==null){
                System.out.print(p.item);
            }else{
                System.out.print(p.item + " ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args){
        
        SLList<Double> L = new SLList<>();
        L.addLast(10.0);
        System.out.println("size: "+L.size());
        L.print();
        System.out.println("first: "+L.getFirst());
        System.out.println("last: "+L.getLast());
        // System.out.println("1th item: "+L.get(1));
        L.addLast(1.5);
        L.addFirst(1.6);
        System.out.println(L.removeLast());
        L.print();
        System.out.println("size: "+L.size());
        System.out.println("first: "+L.getFirst());
        System.out.println("last: "+L.getLast());
        System.out.println("1th item: "+L.get(1));

    }

}