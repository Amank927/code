package LinkedList;

import dp.LIS;

public class ReverseALinkedList
{

    public static void main(String[] args)
    {
        ListNode root = new ListNode(1);
        //root.next = new ListNode(2);
        //root.next.next = new ListNode(3);
        //root.next.next.next = new ListNode(4);
        //printReverse(root);
        root = reverseAgain(root);
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }

    }

    public static ListNode reverseAgain(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
















    public static void printReverse(ListNode start) {
        if (start == null){
            return;
        } else {
            printReverse(start.next);
            System.out.println(start.val);
        }
    }

    public static ListNode reverse(ListNode node, ListNode prev) {
        if (node == null) {
            return null;
        }
        if (node.next == null) {
            node.next = prev;
            return node;
        } else {

            ListNode next = node.next ;
            node.next = prev;
            return reverse(next, node);
        }
    }
    public static ListNode reverse2(ListNode node) {
        if (node == null) {
            return null;
        }
        if (node.next == null) {
            return node;
        } else {
            ListNode newNode = reverse2(node.next);
            node.next.next = node;
            node.next = null;
            return newNode;
        }
    }
    public static void reverseIterative(ListNode root)
    {
        ListNode reverse = root;
        ListNode current = reverse;
        ListNode prev = null;
        while (current!= null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        reverse = prev;
        System.out.println("Printing Reversed Linked List");

        while (reverse!=null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
}
