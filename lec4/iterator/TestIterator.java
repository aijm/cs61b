import org.junit.Test;
import org.junit.Assert.*;
public class TestIterator {
    @Test
    public void testAListIterator(){
        AList<String> list = new AList<>();
        list.addLast("hello");
        list.addLast("ai");
        list.addLast("jia");
        list.addLast("ming");
        for(String str : list){
            System.out.println(str);
        }
    }
    @Test
    public void testSLListIterator(){
        SLList<String> list = new SLList<>();
        list.addLast("hello");
        list.addLast("ai");
        list.addLast("jia");
        list.addLast("ming");
        for(String str : list){
            System.out.println(str);
        }
    }
}
