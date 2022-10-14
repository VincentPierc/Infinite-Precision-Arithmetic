public class LinkedList {
    private Node head = null;
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
            if(this.head == null) {
                this.head = new_node;
            } else {
                Node current = this.head;
                while(current.next != null) {
                    current = current.next;
                }
                current.next = new_node;
            }
        }

        public String printList() {
            Node current = this.head;
            String out = "";
            if(current == null) { out = "null"; return out; }
            while(current != null) {
                out += String.valueOf(current.val);
                current = current.next;
            }
            return out;
        }
}



