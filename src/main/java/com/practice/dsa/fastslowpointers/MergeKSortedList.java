package main.java.com.practice.dsa.fastslowpointers;

import java.util.List;

public class MergeKSortedList {

    public static LinkedList.Node merge(List<LinkedList.Node> lists) {
        int left = 0, right = lists.size() - 1;
        return mergeRange(lists, left, right);
    }

    private static LinkedList.Node mergeRange(List<LinkedList.Node> lists, int left, int right) {
        if(left == right) {
            return lists.get(left);
        }

        int mid = left + (right - left)/2;

        LinkedList.Node leftList = mergeRange(lists, left, mid);
        LinkedList.Node rightList = mergeRange(lists, mid+1, right);
        return MergedTwoSortedList.merge(leftList, rightList);
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.add(1);
        l1.add(4);
        l1.add(7);

        LinkedList l2 = new LinkedList();
        l2.add(2);
        l2.add(5);
        l2.add(8);

        LinkedList l3 = new LinkedList();
        l3.add(3);
        l3.add(6);
        l3.add(9);

        List<LinkedList.Node> lists = java.util.Arrays.asList(
                l1.getHead(),
                l2.getHead(),
                l3.getHead()
        );

        LinkedList.Node mergedHead = merge(lists);

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
