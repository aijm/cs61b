public interface List61B<T> {
    public void addFirst(T x);
    public T getFirst();
    public void addLast(T x);
    public T getLast();
    public int size();
    public T get(int i);
    public T removeLast();
    public void insert(T item,int position);
    default public void print(){
        System.out.print("[");
        for(int i=0;i<size();i++){
            if(i == size()-1){
                System.out.print(get(i));
            }else{
                System.out.print(get(i) + " ");
            }
        }
        System.out.print("]");
        System.out.println();
    }
}
