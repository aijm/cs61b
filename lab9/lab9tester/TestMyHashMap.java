package lab9tester;

import static org.junit.Assert.*;

import org.junit.Test;
import lab9.MyHashMap;

/**
 * Tests by Brendan Hu, Spring 2015, revised for 2018 by Josh Hug
 */
public class TestMyHashMap {

    @Test
    public void sanityGenericsTest() {
        try {
            MyHashMap<String, String> a = new MyHashMap<String, String>();
            MyHashMap<String, Integer> b = new MyHashMap<String, Integer>();
            MyHashMap<Integer, String> c = new MyHashMap<Integer, String>();
            MyHashMap<Boolean, Integer> e = new MyHashMap<Boolean, Integer>();
        } catch (Exception e) {
            fail();
        }
    }

    //assumes put/size/containsKey/get work
    @Test
    public void sanityClearTest() {
        MyHashMap<String, Integer> b = new MyHashMap<String, Integer>();
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, 1);
            //make sure put is working via containsKey and get
            assertTrue(null != b.get("hi" + i)
                    && b.containsKey("hi" + i));
        }
        b.clear();
        assertEquals(0, b.size());
        for (int i = 0; i < 455; i++) {
            assertTrue(null == b.get("hi" + i) && !b.containsKey("hi" + i));
        }
    }

    // assumes put works
    @Test
    public void sanityContainsKeyTest() {
        MyHashMap<String, Integer> b = new MyHashMap<String, Integer>();
        assertFalse(b.containsKey("waterYouDoingHere"));
        b.put("waterYouDoingHere", 0);
        assertTrue(b.containsKey("waterYouDoingHere"));
    }

    // assumes put works
    @Test
    public void sanityGetTest() {
        MyHashMap<String, Integer> b = new MyHashMap<String, Integer>();
        assertEquals(null, b.get("starChild"));
        b.put("starChild", 5);
        assertNotEquals(null, b.get("starChild"));
        b.put("KISS", 5);
        assertNotEquals(null, b.get("KISS"));
        assertNotEquals(null, b.get("starChild"));
    }

    // assumes put works
    @Test
    public void sanitySizeTest() {
        MyHashMap<String, Integer> b = new MyHashMap<String, Integer>();
        assertEquals(0, b.size());
        b.put("hi", 1);
        assertEquals(1, b.size());
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, 1);
        }
        assertEquals(456, b.size());
    }

    //assumes get/containskey work
    @Test
    public void sanityPutTest() {
        MyHashMap<String, Integer> b = new MyHashMap<String, Integer>();
        b.put("hi", 1);
        assertTrue(b.containsKey("hi") && b.get("hi") != null);
    }

    /*
     * Test for general functionality and that the properties of Maps hold.
     */
    @Test
    public void functionalityTest() {
        MyHashMap<String, String> dictionary = new MyHashMap<>();
        assertEquals(0, dictionary.size());

        // can put objects in dictionary and get them
        dictionary.put("hello", "world");
        assertTrue(dictionary.containsKey("hello"));
        assertEquals("world", dictionary.get("hello"));
        assertEquals(1, dictionary.size());

        // putting with existing key updates the value
        dictionary.put("hello", "kevin");
        assertEquals(1, dictionary.size());
        assertEquals("kevin", dictionary.get("hello"));

        // putting key in multiple times does not affect behavior
        MyHashMap<String, Integer> studentIDs = new MyHashMap<>();
        studentIDs.put("sarah", 12345);
        assertEquals(1, studentIDs.size());
        assertEquals(12345, studentIDs.get("sarah").intValue());
        studentIDs.put("alan", 345);
        assertEquals(2, studentIDs.size());
        assertEquals(12345, studentIDs.get("sarah").intValue());
        assertEquals(345, studentIDs.get("alan").intValue());
        studentIDs.put("alan", 345);
        assertEquals(2, studentIDs.size());
        assertEquals(12345, studentIDs.get("sarah").intValue());
        assertEquals(345, studentIDs.get("alan").intValue());
        studentIDs.put("alan", 345);
        assertEquals(2, studentIDs.size());
        assertEquals(12345, studentIDs.get("sarah").intValue());
        assertEquals(345, studentIDs.get("alan").intValue());
        assertTrue(studentIDs.containsKey("sarah"));
        assertTrue(studentIDs.containsKey("alan"));

        // handle values being the same
        assertEquals(345, studentIDs.get("alan").intValue());
        studentIDs.put("evil alan", 345);
        assertEquals(345, studentIDs.get("evil alan").intValue());
        assertEquals(studentIDs.get("evil alan"), studentIDs.get("alan"));
    }

    @Test
    public void sanityRemoveTest(){
        MyHashMap<String, Integer> b = new MyHashMap<>();
        assertNull(b.remove("hi"));
        b.put("hi", 1);
        assertTrue(b.containsKey("hi"));
        assertTrue(b.get("hi") != null);
        assertEquals(Integer.valueOf(1), b.remove("hi"));
        assertNull(b.remove("haha"));
        assertEquals(0, b.size());

        b.put("b",2);
        b.put("a",1);
        b.put("c",3);
        assertEquals(Integer.valueOf(2), b.remove("b"));
        assertNull(b.get("b"));
        assertEquals(Integer.valueOf(1),b.get("a"));
        assertEquals(Integer.valueOf(3),b.get("c"));

        assertEquals(Integer.valueOf(1), b.remove("a"));
        assertNull(b.get("a"));
        assertEquals(Integer.valueOf(3),b.get("c"));

        assertEquals(Integer.valueOf(3), b.remove("c"));
        assertNull(b.get("c"));
        assertEquals(0, b.size());
    }

    @Test
    public void sanityIteratorTest(){
        MyHashMap<String, Integer> b = new MyHashMap<>();
        b.put("jia",1);
        b.put("ai",2);
        b.put("ming",3);
        b.put("hello",4);
        for(String s : b){
            System.out.println(s);
        }
    }
    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests(TestMyHashMap.class);
    }
}
