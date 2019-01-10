package lab9;

import java.util.*;

/**
 * Implementation of interface Map61B with BST as core data structure.
 *
 * @author Your name here
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private class Node {
        /* (K, V) pair stored in this Node. */
        private K key;
        private V value;

        /* Children of this Node. */
        private Node left;
        private Node right;

        private Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    private Node root;  /* Root node of the tree. */
    private int size; /* The number of key-value pairs in the tree */

    /* Creates an empty BSTMap. */
    public BSTMap() {
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /** Returns the value mapped to by KEY in the subtree rooted in P.
     *  or null if this map contains no mapping for the key.
     */
    private V getHelper(K key, Node p) {
        if(p == null){
            return null;
        }
        int cmp = key.compareTo(p.key);
        if(cmp == 0){
            return p.value;
        }else if(cmp < 0){
            return getHelper(key, p.left);
        }else{
            return getHelper(key, p.right);
        }
    }

    /** Returns the value to which the specified key is mapped, or null if this
     *  map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        return getHelper(key, root);
    }

    /** Returns a BSTMap rooted in p with (KEY, VALUE) added as a key-value mapping.
      * Or if p is null, it returns a one node BSTMap containing (KEY, VALUE).
     */
    private Node putHelper(K key, V value, Node p) {
        if(p == null){
            size++;
            Node node = new Node(key, value);
            return node;
        }
        int cmp = key.compareTo(p.key);
        if(cmp < 0){
            // put int the left
            p.left = putHelper(key, value, p.left);
        }else if(cmp > 0){
            // put in the right
            p.right = putHelper(key, value, p.right);
        }else{
            p.value = value;
        }
        return p;
    }

    /** Inserts the key KEY
     *  If it is already present, updates value to be VALUE.
     */
    @Override
    public void put(K key, V value) {
        root = putHelper(key,value,root);
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size;
    }

    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////
    private void Inorder(Node p, Set<K> keyset){
        if(p == null){
            return;
        }
        Inorder(p.left, keyset);
        keyset.add(p.key);
        Inorder(p.right, keyset);
    }
    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        Set<K> keyset = new TreeSet<>();
        Inorder(root, keyset);
        return keyset;
    }
    /** find the largest node of the tree */
    private Node largest(Node p){
        if(p == null){
            return null;
        }
        Node largest = p;
        while(largest.right != null){
            largest = largest.right;
        }
        return largest;
    }
    /** find the smallest node of the tree */
    private Node smallest(Node p){
        if(p == null){
            return null;
        }
        Node smallest = p;
        while(smallest.left!=null){
            smallest = smallest.left;
        }
        return smallest;
    }

    /** Helper function for remove
     *  if tree p contains key, then remove,
     *  and Return the new root for this tree
     */
    private Node removeHelper(K key, Node p, Node saveRemove){
        if(p == null){
            saveRemove.value = null;
            return null;
        }
        int cmp = key.compareTo(p.key);
        if(cmp < 0){
            p.left = removeHelper(key, p.left, saveRemove);
        }else if(cmp > 0){
            p.right = removeHelper(key, p.right, saveRemove);
        }else{
            // found the key
            size--;
            // found the key, consider 3 case of remove
            saveRemove.value = p.value;
            if(p.left == null && p.right == null){
                // case 0: no children
                return null;
            }
            if(p.left == null && p.right != null){
                // case 1: one children
                return p.right;
            }
            if(p.left != null && p.right == null){
                // case 1: one children
                return p.left;
            }
            if(p.left !=null && p.right != null) {
                // case 2: two children
                /** find the parent of left largest node of the tree */
                Node left_largest = largest(p.left);
                // move to p as new root
                p.key = left_largest.key;
                p.value = left_largest.value;
                // remove the left largest node, belongs to case 0
                p.left = removeHelper(left_largest.key, p.left, new Node(null, null));
                // the size will -1 after remove the left largest, so we need to +1
                size++;
                return p;
            }
        }
        return p; // just to avoid missing return argument error
    }
    /** Removes KEY from the tree if present
     *  returns VALUE removed,
     *  null on failed removal.
     */
    @Override
    public V remove(K key) {
        // just using a temp node to save the the .value of the removed node.
        Node saveRemove = new Node(null, null);
        root = removeHelper(key, root, saveRemove);
        return saveRemove.value;
    }

    /** Helper function for remove
     *  if tree p contains key, then remove,
     *  and Return the new root for this tree
     */
    private Node removeHelper(K key, V value, Node p, Node saveRemove){
        if(p == null){
            saveRemove.value = null;
            return null;
        }
        int cmp = key.compareTo(p.key);
        if(cmp < 0){
            p.left = removeHelper(key, value, p.left, saveRemove);
        }else if(cmp > 0){
            p.right = removeHelper(key, value, p.right, saveRemove);
        }else if(p.value == value){
            // found the key
            size--;
            // found the key, consider 3 case of remove
            saveRemove.value = p.value;
            if(p.left == null && p.right == null){
                // case 0: no children
                return null;
            }
            if(p.left == null && p.right != null){
                // case 1: one children
                return p.right;
            }
            if(p.left != null && p.right == null){
                // case 1: one children
                return p.left;
            }
            if(p.left !=null && p.right != null) {
                // case 2: two children
                /** find the parent of left largest node of the tree */
                Node left_largest = largest(p.left);
                // move to p as new root
                p.key = left_largest.key;
                p.value = left_largest.value;
                // remove the left largest node, belongs to case 0
                p.left = removeHelper(left_largest.key, left_largest.value, p.left, new Node(null, null));
                // the size will -1 after remove the left largest, so we need to +1
                size++;
                return p;
            }
        }
        return p; // just to avoid missing return argument error
    }
    /** Removes the key-value entry for the specified key only if it is
     *  currently mapped to the specified value.  Returns the VALUE removed,
     *  null on failed removal.
     **/
    @Override
    public V remove(K key, V value) {
        Node saveRemove = new Node(null,null);
        root = removeHelper(key,value,root,saveRemove);
        return saveRemove.value;
    }

    @Override
    public Iterator<K> iterator() {
//        return new BSTMap_Iterator();
        return keySet().iterator();
    }
    /** iterator by the key less order */
    private class BSTMap_Iterator implements Iterator<K>{
        /** using List to save the pointer by order */
        private List<Node> order_pointer;
        private int id;

        /** using Inorder to save the Node by order */
        public void Inorder(Node p, List<Node> order_pointer){
            if(p == null){
                return;
            }
            Inorder(p.left, order_pointer);
            order_pointer.add(p);
            Inorder(p.right, order_pointer);
        }
        public BSTMap_Iterator(){
            order_pointer = new ArrayList<>();
            Inorder(root, order_pointer);
            id = 0;
        }
        @Override
        public boolean hasNext(){
            return id != order_pointer.size();
        }

        @Override
        public K next(){
            K item = order_pointer.get(id).key;
            id++;
            return item;
        }
    }
}
