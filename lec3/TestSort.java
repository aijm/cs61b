import org.junit.Test;
import static org.junit.Assert.*;
public class TestSort {
    @Test
    public void testSort() {
        String[] input = {"hello", "world", "ai", "jiaming"};
        String[] expected = {"ai", "hello", "jiaming", "world"};
//        Sort.sort_itrative(input);
//        Sort.sort_recursive(input,0);
        Sort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testswap() {
        String[] input = {"ai", "jia", "ming"};
        String[] expected = {"ming", "jia", "ai"};
        Sort.swap(input, 0, 2);
        assertArrayEquals(expected, input);
    }
}
