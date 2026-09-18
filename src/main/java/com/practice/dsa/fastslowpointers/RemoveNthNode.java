package main.java.com.practice.dsa.fastslowpointers;

public class RemoveNthNode {
    public static LinkedList.Node removeNthNode(LinkedList.Node head, int n) {
        if (head == null) {
            return null;
        }
        if (n <= 0) {
            throw new IllegalArgumentException("n must be positive");
        }

        LinkedList.Node dummy = new LinkedList.Node(0);
        dummy.next = head;

        LinkedList.Node slow = dummy, fast = dummy;
        int i = 0;
        while (i < n) {
            if (fast.next == null) {
                throw new IllegalArgumentException("n is greater than list length");
            }
            fast = fast.next;
            i++;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    private static void printList(LinkedList.Node head) {
        LinkedList.Node current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.print("Before: ");
        list.traverseAndPrint();

        LinkedList.Node updatedHead = removeNthNode(list.getHead(), 2);
        System.out.print("After removing 2nd from end: ");
        printList(updatedHead);
    }
}
