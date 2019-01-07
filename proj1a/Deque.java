public interface Deque<T> {
    /** add an item in front of the Deque */
    public void addFirst(T item);
    /** add an item in the end of the Deque */
    public void addLast(T item);
    /** check whether Deque is empty */
    public boolean isEmpty();
    /** Return size of the Deque */
    public int size();
    /** print the deque, separated by a space */
    public void printDeque();
    /** Remove the first item of the Deque */
    public T removeFirst();
    /** Remove the last item of the Deque */
    public T removeLast();
    /** get the item by index */
    public T get(int index);
}
