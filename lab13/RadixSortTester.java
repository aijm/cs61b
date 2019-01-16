import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class RadixSortTester {
    @Test
    public void testRadixSort(){
        String[] asciis = {"123","5","6","78","1300","854","45"};
        String[] sorted = RadixSort.sort(asciis);
        String[] expected = {"5","6","45","78","123","854","1300"};
        assertArrayEquals(expected, sorted);

    }
    @Test
    public void RandomTestRadixSort(){
        int N = 10000;
        int[] numbers = new int[N];
        Random random = new Random();
        for(int i = 0;i < N;i++){
            numbers[i] = random.nextInt(1000000000);
//            System.out.println(numbers[i]);
        }
        String[] asciis = new String[N];
        for(int i = 0;i < N;i++){
            asciis[i] = Integer.toString(numbers[i]);
        }
        String[] sorted_string = new String[N];
        sorted_string = RadixSort.sort(asciis);
        int[] sorted_int = new int[N];
        for(int i = 0;i < N;i++){
            sorted_int[i] = Integer.parseInt(sorted_string[i]);
        }
        int[] expected = numbers.clone();
        Arrays.sort(expected);
        assertArrayEquals(expected, sorted_int);
    }
}
