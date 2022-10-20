
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * This file contains test cases for the LinkedList class implementation for the project
 */
public class LinkedList_Tests {

    @Test
    public void testLinkedListConstructor() {
        LinkedList listy = new LinkedList();
        assertEquals("null", listy.printList());
        LinkedList listy2 = new LinkedList(1);
        assertEquals("1", listy2.printList());
    }
    @Test
    public void testappendNode() {
        LinkedList listy = new LinkedList();
        listy.appendNode(1);
        listy.appendNode(2);
        assertEquals("12", listy.printList());
    }

    @Test
    public void testPrintList() {
        LinkedList listy = new LinkedList();
        assertEquals("null", listy.printList());
        listy.appendNode(1);
        listy.appendNode(2);
        listy.appendNode(3);
        assertEquals("123", listy.printList());
    }

    @Test
    public void testPrintListReverse() {
        LinkedList listy = new LinkedList();
        assertEquals("null", listy.printListReverse());
        listy.appendNode(1);
        listy.appendNode(2);
        listy.appendNode(3);
        assertEquals("321", listy.printListReverse());
    }

    @Test
    public void testAddLinkedList() {
        LinkedList listy = new LinkedList();
        LinkedList listy2 = new LinkedList();
        listy.appendNode(1);
        listy.appendNode(0);
        listy2.appendNode(9);
        listy2.appendNode(0);
        assertEquals("10", listy.addLinkedList(listy2).printListReverse());
        listy2.appendNode(1);
        assertEquals("110", listy.addLinkedList(listy2).printListReverse());

    }

    @Test
    public void testAddLinkedList2() {
        LinkedList listy = new LinkedList();
        LinkedList listy2 = new LinkedList();
        listy.appendNode(0);
        listy.appendNode(6);
        listy.appendNode(9);
        listy2.appendNode(1);
        listy2.appendNode(5);
        assertEquals("1011", listy.addLinkedList(listy2).printListReverse());
        assertEquals("1011", listy2.addLinkedList(listy).printListReverse());
    }

    @Test
    public void testConvertToInt() {
        LinkedList listy = new LinkedList();
        listy.appendNode(1);
        listy.appendNode(0);
        listy.appendNode(0);
        assertEquals(1, listy.convertToInt());
        listy.appendNode(5);
        assertEquals(5001, listy.convertToInt());

    }

    @Test
    public void testMultiplyLinkedList() {
        LinkedList listy = new LinkedList();
        LinkedList listy2 = new LinkedList();
        listy.appendNode(5);
        listy.appendNode(2);
        listy.appendNode(3);

        listy2.appendNode(1);
        listy2.appendNode(4);
        assertEquals(13325, listy.multiplyLinkedList(listy2).convertToInt());
        LinkedList listy9 = new LinkedList(2);
        LinkedList listy10 = new LinkedList(2);
        assertEquals(4, listy9.multiplyLinkedList(listy10).convertToInt());
        LinkedList listy11 = new LinkedList(9);
        LinkedList listy12 = new LinkedList(9);
        listy12.appendNode(1);
        assertEquals(171, listy11.multiplyLinkedList(listy12).convertToInt());
        LinkedList listy3 = new LinkedList(4);
        LinkedList listy4 = new LinkedList(4);
        assertEquals("16", listy3.multiplyLinkedList(listy4).printListReverse());
        LinkedList listy0 = new LinkedList(0);
        assertEquals("0", listy.multiplyLinkedList(listy0).printListReverse());

    }

    @Test
    public void testdivideLinkedListby2(){
        LinkedList listy = new LinkedList(8);
        LinkedList listy2 = new LinkedList(4);
        assertEquals(listy2.printList(), listy.divideLinkedListby2().printList());
    }
    @Test
    public void testExponentiateLinkedList() {
        LinkedList listy = new LinkedList(2);
        LinkedList listy2 = new LinkedList(3);
        LinkedList listy3 = new LinkedList (0);
        listy3.appendNode(2);
        LinkedList listy0 = new LinkedList(0);
        LinkedList listy1 = new LinkedList(1);
        assertEquals("1048576", listy.exponentiateLinkedList(listy3).printListReverse());
        assertEquals("8", listy.exponentiateLinkedList(listy2).printList());
        assertEquals("9", listy2.exponentiateLinkedList(listy).printList());
        assertEquals("0", listy0.exponentiateLinkedList(listy).printList());
        assertEquals("1", listy2.exponentiateLinkedList(listy0).printList());
        assertEquals("3", listy2.exponentiateLinkedList(listy1).printList());
    }


}
