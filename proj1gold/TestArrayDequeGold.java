import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDequeGold {
    @Test
    public void testArrayDeque(){
        Deque<Integer> d = new ArrayDeque<>();
        ArrayDequeSolution<Integer> d_solution = new ArrayDequeSolution<>();

        for(int i =0;i<1000;i++){
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne < 0.5) {
                d.addLast(i);
                d_solution.addLast(i);
            } else {
                d.addFirst(i);
                d_solution.addFirst(i);
            }
        }
        for(int i = 0;i <1000;i++){
            int expected = d_solution.removeLast();
            int actual = d.removeLast();
            assertEquals("i: "+ i + " expected: " + expected + " actual: "+ actual,
                    expected, actual);
        }
    }
}
