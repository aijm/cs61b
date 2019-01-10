public interface Tree<E> {
    /** check if the tree contains item */
    boolean contains(E item);
    /** add an item to the tree
     * @Return true if successed, false if failed
     * */
    boolean add(E item);
    /** remove an item in the tree
     * @Return true if successed, false if failed
     * */
    boolean remove(E item);
    /** Remove all the items */
    void clear();
    /** Return the size of the tree */
    int size();
    /** Return whether the tree is empty */
    boolean isEmpty();
}
