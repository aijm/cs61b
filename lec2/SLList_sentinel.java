public class SLList_sentinel{

    private class IntNode{
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }
    /** ->[sentinel_item,sentinel_next]->[item0,next0]->[item1,next1] 
     * adding a sentinel node to simply the implement of list
     * empty list: ->[sentinel_item,null]
    */
    private IntNode sentinel;
    private int size; /** to get size with O(1) time complexity */

    /** create an empty list */
    public SLList_sentinel(){
        sentinel = new IntNode(-1, null);
        size = 0;
    }
    public SLList_sentinel(int x){
        sentinel = new IntNode(-1, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }
    /** Add a int in front of the first item */
    public void addFirst(int x){
        sentinel.next = new IntNode(x, sentinel.next);
        size++;
    }
    /** Return the first item of list */
    public int getFirst(){
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
    public void addLast(int x){
        size++;
        // if(first == null){
        //     first = new IntNode(x, null);
        //     return;
        // }
        IntNode p = sentinel;
        while(p.next!=null){
            // find the last IntNode
            p = p.next;
        }
        p.next = new IntNode(x, null);
        
    }

    /** Return the last item of the list */
    public int getLast(){
        // if(first == null){
        //     System.out.println("Empty List!");
        //     System.exit(1);
        // }
        IntNode p = sentinel;
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
        // IntNode p = first;
        // while(p!=null){
        //     totalSize++;
        //     p = p.next;
        // }
        // return totalSize;
        return size;
    }

    /** Return the ith item of the list */
    public int get(int i){
        
        // if(first == null){
        //     System.out.println("Empty List");
        //     System.exit(1);
        // }
        
        if(i < 0 || i >= size){
            System.out.println("access "+i+"th item, out of range!");
            System.exit(1);
        }
        IntNode p = sentinel.next;
        for(int j =0;j<i;j++){
            p = p.next;
        }
        return p.item;
    }

    /** print the list */
    public void print(String info){
        IntNode p = sentinel.next;
        System.out.println(info);
        System.out.printf("[");

        while(p!=null){
            if(p.next == null){
                System.out.printf("%d",p.item);
            }else{
                System.out.printf("%d ",p.item);
            }
            p = p.next;
        }
        System.out.printf("]");
        System.out.println();
    }

    public static void main(String[] args){
        
        SLList_sentinel L = new SLList_sentinel();
        System.out.println("size: "+L.size());
        L.print("L:");
        System.out.println("first: "+L.getFirst());
        System.out.println("last: "+L.getLast());
        System.out.println("1th item: "+L.get(1));
        L.addLast(3);
        L.addFirst(2);
        
        L.print("L:");
        System.out.println("size: "+L.size());
        System.out.println("first: "+L.getFirst());
        System.out.println("last: "+L.getLast());
        System.out.println("1th item: "+L.get(1));

    }

}