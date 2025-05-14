import java.util.*;

public class LL {
    private Node head;
    private Node tail;
    int size = 0;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


    public void addFirst(int value) {
        Node node = new Node(value);
        if( this.head == null) {
            this.head = node;
            this.tail = node;
            this.tail.next = null;
            this.size++;
            return;
        }
        node.next = head;
        head = node;
        this.size++;
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if( this.head == null) {
            this.head = node;
            this.tail = node;
            this.tail.next = null;
            this.size++;
            return;
        }
        node.next = this.tail.next;
        this.tail.next = node;
        this.tail = node;
        this.size++;
    }

    public int removeFirst() throws Exception {
        if(head == null) {
            throw new Exception("can't remove from empty list");
        }
        Node temp = this.head;
        this.head = this.head.next;
        this.size--;

        return temp.value;
    }

    public int removeLast() throws Exception {
        if ( this.head == null) throw new Exception("can't remove from empty list");
        if ( this.head == this.tail ) {
            Node temp = this.head;
            this.head = this.tail.next;
            this.tail = this.head;
            this.size--;
            return temp.value;
        }
        Node temp = this.head;
        while (temp != null) {
            if (temp.next == this.tail) {
                int value = temp.next.value;
                this.tail = temp;
                this.tail.next = null;
                this.size--;
                return value;
            }
            temp = temp.next;
        }
        return 0;
    }

    public void display() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
        System.out.println();
    }

}
