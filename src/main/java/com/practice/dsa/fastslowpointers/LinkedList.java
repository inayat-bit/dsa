package main.java.com.practice.dsa.fastslowpointers;

public class LinkedList {
    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;

    public void add(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public Node getHead() {
        return head;
    }

    public void traverseAndPrint() {
        Node current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

}
