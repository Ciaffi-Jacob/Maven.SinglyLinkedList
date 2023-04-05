package com.zipcodewilmington.singlylinkedlist;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.jvm.hotspot.runtime.VM;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    SinglyLinkedList<String> list;
    @Before
    public void before(){
        list = new SinglyLinkedList<String>();
    }
    @Test
    public void testAdd() {
        String expected = "test";
        list.add(expected);

        Assert.assertTrue(expected, list.contains(expected));
    }
    @Test
    public void testRemove() {
        String expected = "test";
        list.add(expected);

        list.remove(expected);

        Assert.assertFalse(expected, list.contains(expected));
    }

    @Test
    public void testContains() {
        String expected = "test";
        list.add(expected);

        Assert.assertTrue(expected, list.contains(expected));
    }

    @Test
    public void testFindExists() {
        int expected = 1;
        String val = "target";
        list.add("");
        list.add(val);

        int actual = list.find(val);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testFindNull(){
        int expected = -1;
        String val = "target";
        list.add("");
        list.add("");

        int actual = list.find(val);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testSize(){
        int expected = 2;

        list.add("");
        list.add("");

        int actual = list.size();

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testGet() {
        String expected = "target";
        list.add("");
        list.add(expected);

        String actual = list.get(1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCopy() {
        list.add("");
        list.add("1");
        list.add("thirds");

        SinglyLinkedList<String> listCopy = list.copy(list);

        Assert.assertEquals(list.toString(), listCopy.toString());
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(list.get(i), listCopy.get(i));
        }
    }

    @Test
    public void testSort() {
        list.add("F");
        list.add("Z");
        list.add("A");

        list.sort();

        Assert.assertEquals(list.get(0).data, "A");
        Assert.assertEquals(list.get(1).data, "F");
        Assert.assertEquals(list.get(2).data, "Z");
    }
}
