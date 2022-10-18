
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
        listy.appendNode(4);
        assertEquals("4", listy.printList());
    }

    @Test
    public void testLinkedListConstructor2() {
        LinkedList listy = new LinkedList();
        listy.appendNode(1);
        listy.appendNode(2);
        listy.appendNode(3);
        assertEquals("123", listy.printList());
    }

    @Test
    public void testPrintList() {
        LinkedList listy = new LinkedList();
        listy.appendNode(1);
        listy.appendNode(2);
        listy.appendNode(3);
        assertEquals("123", listy.printList());
    }

    @Test
    public void testPrintListReverse() {
        LinkedList listy = new LinkedList();
        listy.appendNode(1);
        listy.appendNode(2);
        listy.appendNode(3);
        assertEquals("321", listy.printListReverse());
    }

    @Test
    public void testaddLinkedList() {
        LinkedList listy = new LinkedList();
        LinkedList listy2 = new LinkedList();

        listy.appendNode(1);
        listy2.appendNode(9);
        assertEquals("10", listy.addLinkedList(listy2).printListReverse());
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

    }

    @Test
    public void testExponentiateLinkedList() {
        LinkedList listy = new LinkedList();
        LinkedList listy2 = new LinkedList();
        listy.appendNode(2);
        listy2.appendNode(3);
        assertEquals(8, listy.exponentiateLinkedList(listy2));

    }
}
