package main.java.com.practice.dsa.fastslowpointers;

public class MergedTwoSortedList {

    public static LinkedList.Node merge(LinkedList.Node head1, LinkedList.Node head2) {
        LinkedList.Node dummy = new LinkedList.Node(0);
        LinkedList.Node tail = dummy;
        while (head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        tail.next = (head1 != null) ? head1 : head2;

        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.add(1);
        list1.add(3);
        list1.add(5);

        LinkedList list2 = new LinkedList();
        list2.add(2);
        list2.add(4);
        list2.add(6);

        LinkedList.Node mergedHead = merge(list1.getHead(), list2.getHead());

        LinkedList.Node current = mergedHead;
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
