public class LinkedList {
    Node head = null;
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            next = null;
        }

        public void appendNode(LinkedList list, int val) {
            Node new_node = new Node(val);
            if(list.head == null) {
                list.head = new_node;
            }



        }
    }
}


