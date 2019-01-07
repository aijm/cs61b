public class VengefulSLList<T> extends SLList<T> {
    SLList<T> deletedItems;

    public VengefulSLList(){
        super(); // VengefulSLList is-a SLList,must construct SLList first
        deletedItems = new SLList<>();
    }
    @Override
    public T removeLast(){
        T item = super.removeLast();
        deletedItems.addLast(item);
        return item;
    }

    void printLostItems(){
        deletedItems.print();
    }
    public static void main(String[] args){
        SLList<Integer> list = new VengefulSLList<>();
        list.addLast(10);
        list.addLast(15);
        list.addLast(100);
        list.removeLast();
        list.removeLast();
        list.print();
        //list.printLostItems();
    }
}
