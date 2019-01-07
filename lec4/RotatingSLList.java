/** RotatingSLList extends SLList */
public class RotatingSLList<T> extends SLList<T> {
    /** needn't rewrite all the methods */
    public void rotateRight(){
        T item = removeLast();
        addFirst(item);
    }
}
