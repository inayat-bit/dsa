package main.java.com.practice.dsa.fastslowpointers;

public class LinkedListCycle {

    public static boolean hasCycle(LinkedList.Node head) {
        if(head == null) {
            throw new IllegalArgumentException("Linked list is empty");
        }
        LinkedList.Node slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
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

        tail.next = head.next; // create cycle

        System.out.println("Has cycle: " + hasCycle(head));
    }
}
