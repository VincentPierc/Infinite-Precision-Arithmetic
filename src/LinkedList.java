import java.util.ArrayList;

public class LinkedList {
    private Node head = null;

    public LinkedList() {
        this.head = null;
    }
    static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
            next = null;
        }
    }

    public void appendNode(int val) {
        Node new_node = new Node(val);
        if (this.head == null) {
            this.head = new_node;
        } else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new_node;
        }
    }

    public String printList() {
        Node current = this.head;
        String out = "";
        if (current == null) {
            out = "null";
            return out;
        }
        while (current != null) {
            out += String.valueOf(current.val);
            current = current.next;
        }
        return out;
    }

    /**
     * Takes a linkedlist with head as ones digit and converts to string from highest(left) order to lowest(right) order
     * @return String
     */
    public String printListReverse() {
        Node current = this.head;
        String out = "";
        if (current == null) {
            out = "null";
            return out;
        }
        while (current != null) {
            out = String.valueOf(current.val) + out.substring(0);
            current = current.next;
        }
        return out;
    }

    /**
     * Adds two linked lists, assuming head is ones digit
     * @param other
     * @return LinkedList
     */
    public LinkedList addLinkedList(LinkedList other) {
        LinkedList sum = new LinkedList();
        sum = _addLinkedList(this.head, other.head, new LinkedList(), false);
        return sum;
    }

    private static LinkedList _addLinkedList(Node self, Node other, LinkedList sum, boolean carry) {
        int carryOver = 0;
        boolean carryOverFlag = false;
        if (carry) {
            carryOver = 1;
        }
        if (self != null && other == null) {
            int val = self.val + carryOver;
            if (val >= 10) {
                val -= 10;
                carryOverFlag = true;
            }
            sum.appendNode(val);
            _addLinkedList(self.next, other, sum, carryOverFlag);
        }

        else if (self == null && other != null) {
            int val = other.val + carryOver;
            if (val >= 10) {
                val -= 10;
                carryOverFlag = true;
            }
            sum.appendNode(val);
            _addLinkedList(self, other.next, sum, carryOverFlag);


        } else if (self != null && other != null) {
            int val = self.val + other.val + carryOver;
            if (val >= 10) {
                val -= 10;
                carryOverFlag = true;
            }
            sum.appendNode(val);
            _addLinkedList(self.next, other.next, sum, carryOverFlag);

        } else if (self == null && other == null) {
            if (carry) {
                sum.appendNode(1);
            }
            return sum;
        }
        return sum;
    }

    /**
     * multiplies two linked lists. Assuming head is ones digit
     * @param other
     * @return LinkedList
     */
    public LinkedList multiplyLinkedList(LinkedList other) {
        Node current = this.head;
        int zPadding = 0;
        LinkedList total =  new LinkedList();
        ArrayList<LinkedList> aListy = new ArrayList<>();
        while(current != null) {
            LinkedList lListy = new LinkedList();       // every multiplication will produce a new linked list in
            for(int i = 0; i < zPadding; i++) {
                lListy.appendNode(0);
            }
            int temp = current.val * other.convertToInt();
            while(temp > 0) {
                lListy.appendNode(temp % 10);
                temp = temp / 10;
            }
            aListy.add(lListy);
            zPadding += 1;
            current = current.next;
        }
        for(LinkedList cur: aListy) {
            total = total.addLinkedList(cur);
        }
        return total;
    }

    /**
     * Takes LinkedList and converts to int, BEWARE assumed head is ones place of linkedList
     * @return integer
     */
    public int convertToInt() {
        String str = this.printListReverse();
        return Integer.parseInt(str);
    }
}




