package main.java.com.practice.dsa.fastslowpointers;

public class ReverseLinkedList {

    public static LinkedList.Node reverse(LinkedList.Node head) {
        if(head == null || head.next == null) return head;
        LinkedList.Node current = head;
        LinkedList.Node temp = null, next = null;
        while(current != null) {
            temp = current.next;
            current.next = next;
            next = current;
            current = temp;

        }
        head = next;
        return head;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.print("Before: ");
        list.traverseAndPrint();

        LinkedList.Node reversedHead = reverse(list.getHead());

        System.out.print("After:  ");
        LinkedList.Node current = reversedHead;
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
