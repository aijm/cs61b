import edu.princeton.cs.algs4.Merge;
import org.junit.Test;
import static org.junit.Assert.*;
import edu.princeton.cs.algs4.Queue;

public class TestSort {
    @Test
    public void TestmergeSort(){
        Queue<String> q = new Queue<>();
        q.enqueue("yes");
        q.enqueue("but");
        q.enqueue("ai");
        q.enqueue("ming");
        q.enqueue("jia");
        q.enqueue("last");
        q.enqueue("crazy");
        Queue<String> q1 = new Queue<>();
        q1.enqueue("jia");
        q1.enqueue("ai");
        System.out.println(q1.toString());
        q1 =  MergeSort.mergeSort(q1);
        System.out.println(q1.toString());

        System.out.println(q.toString());
        q = MergeSort.mergeSort(q);
        System.out.println(q.toString());
    }

    @Test
    public void TestQuickSort(){
        Queue<String> q = new Queue<>();
        q.enqueue("yes");
        q.enqueue("but");
        q.enqueue("ai");
        q.enqueue("ming");
        q.enqueue("jia");
        q.enqueue("last");
        q.enqueue("crazy");
        System.out.println(q.toString());
        q = QuickSort.quickSort(q);
        System.out.println(q.toString());
    }
}
