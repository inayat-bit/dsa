package main.java.com.practice.dsa.fastslowpointers;

public class LinkedListCycle2 {
    public static int cycleNode(LinkedList.Node head) {
        if(head == null) {
            throw new IllegalArgumentException("Linked list is empty");
        }
        LinkedList.Node slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow.val;
            }
        }
        throw new IllegalStateException("No cycle found");

    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        LinkedList.Node head = list.getHead();

        LinkedList.Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = head.next.next; // cycle starts at 30

        System.out.println("Cycle starts at: " + cycleNode(head));
    }
}
