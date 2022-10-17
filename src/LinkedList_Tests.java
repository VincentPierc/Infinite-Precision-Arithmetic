
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
        assertEquals("321", listy.printListReverse());
    }

    @Test
    public void testRemoveLeadingZeroes() {
        LinkedList listy = new LinkedList();
        LinkedList listy2 = new LinkedList();
        listy.appendNode(1);
        listy.appendNode(2);
        listy.appendNode(3);
        listy2.appendNode(0);
        listy2.appendNode(0);
        listy2.appendNode(1);
        listy2.appendNode(2);
        listy2.appendNode(3);
        LinkedList listy3 = listy2.removeLeadingZeroes();
        assertEquals(listy3.printList(), listy.printList());
    }
}
