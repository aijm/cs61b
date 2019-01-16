public class InplaceHeapSort<E extends Comparable> {
    private final E[] array;
    private int size;

    public InplaceHeapSort(E[] a){
        array = a;
        size = a.length;
    }
    public void sort(){
        /** change array into a heap by reverse order sink */
        for(int i = array.length-1;i >= 0;i--){
            sink(i);
        }
        while(size > 0){
            swap(0, size-1);
            size -= 1;
            sink(0);
        }
    }
    /** left child */
    private int left(int id){
        return 2*id+1;
    }
    /** right child */
    private int right(int id){
        return 2*id+2;
    }
    /** index of parent */
    private int parent(int id){
        return (id-1)/2;
    }
    private void swap(int p, int q){
        if(p == q){
            return;
        }
        E temp = array[p];
        array[p] = array[q];
        array[q] = temp;
    }
    private boolean valid(int id){
        return id > 0 && id < size;
    }
    private int max(int p, int q){
        if(!valid(p)){
            return q;
        }else if(!valid(q)){
            return p;
        }else if(array[p].compareTo(array[q]) > 0){
            return p;
        }else{
            return q;
        }

    }
    private void sink(int id){
        int l = left(id);
        int r = right(id);
        if(!valid(l) && !valid(r)){
            return;
        }
        int max_id = max(l,r);
        if(array[id].compareTo(array[max_id]) < 0){
            swap(id, max_id);
            sink(max_id);
        }
    }



}
