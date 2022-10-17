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

    public String printListReverse() {
        Node current = this.head;
        String out = "";
        if (current == null) {
            out = "null";
            return out;
        }
        while (current != null) {
            out += String.valueOf(current.val) + out.substring(0);
            current = current.next;
        }
        return out;
    }

    public LinkedList removeLeadingZeroes() {
        if (this.head.val != 0) {
            return this;
        }
        LinkedList list = new LinkedList();
        return _removeLeadingZeroes(list, this.head.next);
    }

    private LinkedList _removeLeadingZeroes(LinkedList list, Node current) {

        if (current == null) {
            return list;
        }else if (current.val == 0) {
            return _removeLeadingZeroes(list, current.next);
        } else {
            list.appendNode(current.val);
            return _removeLeadingZeroes(list, current.next);
        }
    }


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
}




