import java.lang.reflect.Array;
import java.util.PriorityQueue;
import java.util.Random;

public class Sort {
    private static void swap(int[] array, int i, int j){
        if(i == j){
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void selectSort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            int minPos = i;
            for(int j = i + 1; j < array.length;j++){
                if(array[j] < array[minPos]){
                    minPos = j;
                }
            }
            swap(array, i, minPos);
        }
    }

    public static void insertSort(int[] array){
        for(int i = 0;i < array.length;i++){
            int key = array[i];
            int j = i-1;
            for(; j>=0 && key < array[j];j--){
                array[j+1] = array[j];
            }
            array[j+1] = key;
        }
    }
    /** merge array[l:m] and array[m+1,r] */
    public static void merge_helper(int[] array, int l, int m, int r){
        // copy to temp array a1,a2
        int[] a1 = new int[m-l+1];
        int[] a2 = new int[r-m];
        System.arraycopy(array,l,a1,0,a1.length);
        System.arraycopy(array,m+1,a2,0,a2.length);

        int k = l;
        int i = 0;
        int j = 0;
        // merge to array[l,r]
        while(i < a1.length && j < a2.length){
            if(a1[i] <= a2[j]){
                // using <= to get a stable sort
                array[k] = a1[i];
                i++;
            }else {
                array[k] = a2[j];
                j++;
            }
            k++;
        }
        // add the remain items
        if(i == a1.length){
            System.arraycopy(a2, j, array, k, a2.length-j);
        }else{
            System.arraycopy(a1, i, array, k, a1.length-i);
        }

    }
    public static void mergeSort(int[] array,int l, int r){
        if(l >= r){
            return;
        }
        int mid = (l+r)/2;
        mergeSort(array, l, mid);
        mergeSort(array, mid + 1, r);
        merge_helper(array, l, mid, r);
    }
    public static void mergeSort(int[] array){
        mergeSort(array, 0, array.length-1);
    }

    public static void heapSort(int[] array){
        PriorityQueue<Integer> pq = new PriorityQueue<>(array.length);
        for(int item : array){
            pq.add(item);
        }
        for(int i = 0;i < array.length;i++){
            array[i] = pq.remove();
        }
    }
    public static int Hoare_partition(int[] array, int l, int r, int pivot){
        int pivot_value = array[pivot];
        swap(array, pivot, l);
        int i = l+1;
        int j = r;
        for(;i <= j;i++, j--){
            // i pointer love value < pivot_value
            for(;i <= r && array[i] < pivot_value;i++);
            // j pointer love value > pivot_value
            for(;j >= l+1 && array[j] > pivot_value;j--);
            if(i > j){
                break;
            }else{
                swap(array, i, j);
            }
        }
        swap(array, l, j);
        return j;
    }
    public static int partition(int[] array, int l, int r, int pivot){
        int pivot_value = array[pivot];
        swap(array, pivot, r); // move pivot_value to the right
        int larger_index = l;
        for(int i = l;i <= r-1;i++){
            if(array[i] < pivot_value){
                swap(array, i, larger_index);
                larger_index++;
            }
        }
        swap(array, larger_index, r);
        return larger_index;
    }
    public static void quickSort(int[] array, int l, int r){
        if(l >= r){
            return;
        }
        int pivot = l;
        // pratition
        pivot = Hoare_partition(array, l, r, pivot);
        quickSort(array, l, pivot-1);
        quickSort(array, pivot+1, r);
    }
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length-1);
    }
}
