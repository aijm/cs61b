import org.junit.Test;
import static org.junit.Assert.*;
/** junit tests */
public class TestAll {

    @Test
    public void testAList_insert(){
        AList<Integer> list = new AList<>();
        /* list = [0,1,2,3,4,5] */
        for(int i = 0;i<=5;i++){
            list.addLast(i);
        }
        list.insert(-1,0); // list = [-1,0,1,2,3,4,5]
        assertEquals(-1,(int)list.get(0));
        assertEquals(0,(int)list.get(1));
        assertEquals(5,(int)list.get(6));
        list.insert(-2,6); // list = [-1,0,1,2,3,4,-2,5]
        list.addFirst(-5); // list = [-5,-1,0,1,2,3,4,-2,5]
        assertEquals(-5,(int)list.get(0));
        assertEquals(-1,(int)list.get(1));
        assertEquals(-2,(int)list.get(7));
        assertEquals(5,(int)list.get(8));
    }

    @Test
    public void testSLList_insert(){
        SLList<Integer> list = new SLList<>();
        /* list = [0,1,2,3,4,5] */
        for(int i = 0;i<=5;i++){
            list.addLast(i);
        }
        list.insert(-1,0); // list = [-1,0,1,2,3,4,5]
        assertEquals(-1,(int)list.get(0));
        assertEquals(0,(int)list.get(1));
        assertEquals(5,(int)list.get(6));
        list.insert(-2,6); // list = [-1,0,1,2,3,4,-2,5]
        assertEquals(-1,(int)list.get(0));
        assertEquals(0,(int)list.get(1));
        assertEquals(-2,(int)list.get(6));
        assertEquals(5,(int)list.get(7));
    }
}
