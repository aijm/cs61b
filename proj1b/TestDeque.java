import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestDeque{
    @Test
    public void Test_LinkedListDeque(){
        Deque<String> d = new LinkedListDeque<>();
        assertTrue(d.isEmpty());
        assertEquals(0,d.size());
        assertNull(d.get(0));
        d.addFirst("hello");
        d.addLast("ai");
        d.addLast("jia");
        d.addFirst("haha");
        d.printDeque();
        System.out.println();
        assertEquals("haha",d.removeFirst());
        assertEquals("jia",d.removeLast());
        assertEquals(2,d.size());
        d.printDeque();
    }

    @Test
    public void Test_ArrayDeque(){
        Deque<Integer> d = new LinkedListDeque<>();
        assertTrue(d.isEmpty());
        assertEquals(0,d.size());
        assertNull(d.get(0));
        d.addFirst(1);
        d.addLast(2);
        d.addLast(3);
        d.addFirst(4);
        d.printDeque();
        System.out.println();
        assertEquals(Integer.valueOf(4), d.removeFirst());
        assertEquals(Integer.valueOf(3),d.removeLast());
        assertEquals(2,d.size());
        d.printDeque();
    }
    @Test
    public void Test_bigDeque(){
        Deque<Integer> d = new LinkedListDeque<>();
        for(int i = 0;i<=1000;i++){
            d.addLast(i);
        }
        d.printDeque();
        assertEquals(1001,d.size());
        assertEquals(Integer.valueOf(0), d.get(0));
        assertEquals(Integer.valueOf(1000),d.get(1000));
        assertEquals(Integer.valueOf(300),d.get(300));

        for(int i = 0;i<=999;i++){
            d.removeFirst();
        }
        assertEquals(1,d.size());
        assertEquals(Integer.valueOf(1000),d.get(0));

    }
}
