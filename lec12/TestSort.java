import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort {
    @Test
    public void TestselectionSort(){
        int[] array = {1, 3, 2, 5, 0, 7};
        int[] sorted = {0, 1, 2, 3, 5, 7};
        Sort.selectSort(array);
        assertArrayEquals(sorted, array);
    }
    @Test
    public void TestinsertSort(){
        int[] array = {1, 3, 2, 5, 0, 7};
        int[] sorted = {0, 1, 2, 3, 5, 7};
        Sort.insertSort(array);
        assertArrayEquals(sorted, array);
    }

    @Test
    public void TestheapSort(){
        int[] array = {1, 3, 2, 5, 0, 7};
        int[] sorted = {0, 1, 2, 3, 5, 7};
        Sort.heapSort(array);
        assertArrayEquals(sorted, array);
    }
    @Test
    public void TestmergeSort(){
        int[] array = {1, 3, 2, 5, 0, 7};
        int[] sorted = {0, 1, 2, 3, 5, 7};
        Sort.mergeSort(array);
        assertArrayEquals(sorted, array);
    }
    @Test
    public void TestInplaceHeapSort(){
        Integer[] array = {1, 3, 2, 5, 0, 7};
        Integer[] sorted = {0, 1, 2, 3, 5, 7};
        InplaceHeapSort<Integer> heapSort = new InplaceHeapSort<>(array);
        heapSort.sort();
        assertArrayEquals(sorted, array);

        String[] a = {"hello", "ai", "jia", "ming"};
        String[] expected = {"ai", "hello", "jia", "ming"};
        InplaceHeapSort<String> strSort = new InplaceHeapSort<>(a);
        strSort.sort();
        assertArrayEquals(expected, a);

    }
    @Test
    public void TestquickSort(){
        int[] array = {1, 3, 2, 5, 0, 7, 4};
        int[] sorted = {0, 1, 2, 3, 4, 5, 7};
        Sort.quickSort(array);
        assertArrayEquals(sorted, array);
    }
}
