import edu.princeton.cs.algs4.Queue;

public class MergeSort {
    /**
     * Removes and returns the smallest item that is in q1 or q2.
     *
     * The method assumes that both q1 and q2 are in sorted order, with the smallest item first. At
     * most one of q1 or q2 can be empty (but both cannot be empty).
     *
     * @param   q1  A Queue in sorted order from least to greatest.
     * @param   q2  A Queue in sorted order from least to greatest.
     * @return      The smallest item that is in q1 or q2.
     */
    private static <Item extends Comparable> Item getMin(
            Queue<Item> q1, Queue<Item> q2) {
        if (q1.isEmpty()) {
            return q2.dequeue();
        } else if (q2.isEmpty()) {
            return q1.dequeue();
        } else {
            // Peek at the minimum item in each queue (which will be at the front, since the
            // queues are sorted) to determine which is smaller.
            Comparable q1Min = q1.peek();
            Comparable q2Min = q2.peek();
            if (q1Min.compareTo(q2Min) <= 0) {
                // Make sure to call dequeue, so that the minimum item gets removed.
                return q1.dequeue();
            } else {
                return q2.dequeue();
            }
        }
    }

    /** Returns a queue of queues that each contain one item from items. */
    private static <Item extends Comparable> Queue<Queue<Item>>
            makeSingleItemQueues(Queue<Item> items) {
        Queue<Queue<Item>> singleItemQ = new Queue<>();
        for(Item item : items){
            Queue<Item> q = new Queue<>();
            q.enqueue(item);
            singleItemQ.enqueue(q);
        }
        return singleItemQ;
    }

    /**
     * Returns a new queue that contains the items in q1 and q2 in sorted order.
     *
     * This method should take time linear in the total number of items in q1 and q2.  After
     * running this method, q1 and q2 will be empty, and all of their items will be in the
     * returned queue.
     *
     * @param   q1  A Queue in sorted order from least to greatest.
     * @param   q2  A Queue in sorted order from least to greatest.
     * @return      A Queue containing all of the q1 and q2 in sorted order, from least to
     *              greatest.
     *
     */
    private static <Item extends Comparable> Queue<Item> mergeSortedQueues(
            Queue<Item> q1, Queue<Item> q2) {
        Queue<Item> merge = new Queue<>();
        while(!q1.isEmpty() || !q2.isEmpty()){
            merge.enqueue(getMin(q1, q2));
        }
        return merge;
    }

    /** Returns a Queue that contains the given items sorted from least to greatest. */
    public static <Item extends Comparable> Queue<Item> mergeSort(
            Queue<Item> items) {
        if(items.size() <= 1) {
            return items;
        }
        Queue<Queue<Item>> singleItem = makeSingleItemQueues(items);
        Queue<Item> q1 = new Queue<>();
        Queue<Item> q2 = new Queue<>();
        int n = singleItem.size();
        for(int i = 0;i < n-n/2;i++){
            q2.enqueue(singleItem.dequeue().dequeue());
        }
        while(!singleItem.isEmpty()){
            q1.enqueue(singleItem.dequeue().dequeue());
        }
        q1 = mergeSort(q1);
        q2 = mergeSort(q2);
        items = mergeSortedQueues(q1, q2);
        return items;
    }


    public static void TestmergeSortedQueues(){
        Queue<String> q1 = new Queue<>();
        Queue<String> q2 = new Queue<>();
        q1.enqueue("ai");
        q1.enqueue("but");
        q1.enqueue("jia");
        q1.enqueue("ming");
        q2.enqueue("crazy");
        q2.enqueue("last");
        q2.enqueue("yes");
        System.out.println(q1.toString());
        System.out.println(q2.toString());
        Queue<String> merge =  mergeSortedQueues(q1, q2);
        System.out.println(merge.toString());
    }

    public static void main(String[] args){
        TestmergeSortedQueues();
    }
}
