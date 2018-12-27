public class SLList{

    private class IntNode{
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode first;
    private int size; /** to get size with O(1) time complexity */

    /** create an empty list */
    public SLList(){
        first = null;
        size = 0;
    }
    public SLList(int x){
        first = new IntNode(x, null);
        size = 1;
    }
    /** Add a int in front of the first item */
    public void addFirst(int x){
        first = new IntNode(x, first);
        size++;
    }
    /** Return the first item of list */
    public int getFirst(){
        if(first == null){
            System.out.println("Empty List!");
            
            System.exit(1);
        }
        return first.item;
    }
    /** add an item in the end of the list */
    public void addLast(int x){
        size++;
        if(first == null){
            first = new IntNode(x, null);
            return;
        }
        IntNode p = first;
        while(p.next!=null){
            // find the last IntNode
            p = p.next;
        }
        p.next = new IntNode(x, null);
        
    }

    /** Return the last item of the list */
    public int getLast(){
        if(first == null){
            System.out.println("Empty List!");
            System.exit(1);
        }
        IntNode p = first;
        while(p.next!=null){
            p = p.next;
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
        
        if(first == null){
            System.out.println("Empty List");
            System.exit(1);
        }
        IntNode p = first;
        
        for(int j =0;j<i;j++){
            p = p.next;
            if(p==null){
                System.out.println("access "+i+"th item, out of range!");
                System.exit(1);
            }
        }
        return p.item;
    }

    /** print the list */
    public void print(String info){
        IntNode p = first;
        System.out.println(info);
        while(p!=null){
            System.out.printf("%s ",p.item);
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        
        SLList L = new SLList();
        System.out.println("size: "+L.size());
        // System.out.println("first: "+L.getFirst());
        // System.out.println("last: "+L.getLast());
        // System.out.println("1th item: "+L.get(1));
        L.addLast(3);
        L.addFirst(2);
        
        L.print("L:");
        System.out.println("size: "+L.size());
        System.out.println("first: "+L.getFirst());
        System.out.println("last: "+L.getLast());
        System.out.println("1th item: "+L.get(1));

    }

}