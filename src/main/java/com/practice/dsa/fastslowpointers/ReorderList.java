package main.java.com.practice.dsa.fastslowpointers;

public class ReorderList {

    public static LinkedList.Node reorder(LinkedList.Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkedList.Node slow = MiddleNode.getMiddleValue(head);

        LinkedList.Node second = ReverseLinkedList.reverse(slow.next);
        slow.next = null;
        LinkedList.Node first = head;
        while (second != null) {
            LinkedList.Node firstNext = first.next;
            LinkedList.Node secondNext = second.next;
            first.next = second;
            second.next = firstNext;
            first = firstNext;
            second = secondNext;
        }

        return head;
    }
}
