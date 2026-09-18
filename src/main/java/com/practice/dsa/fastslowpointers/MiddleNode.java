package main.java.com.practice.dsa.fastslowpointers;

public class MiddleNode {
    public static LinkedList.Node getMiddleValue(LinkedList.Node head) {
        if(head == null) {
            throw new IllegalStateException("Linked list is empty");
        }

        LinkedList.Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        System.out.print("Linked List: ");
        list.traverseAndPrint();
        System.out.println("Middle value: " + getMiddleValue(list.getHead()));
    }
}
