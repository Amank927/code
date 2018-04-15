package LinkedList;

import dp.LIS;

public class ReverseIt
{
    /// 1->2->3->4
    //
    public static ListNode reverse(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode rev = reverse(head.next);
        if(head.next == null) {
            return head;
        }
        else  {
            head.next.next = head;
            head.next = null;
            return rev;
        }

    }

    public static ListNode reverseItr(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }


    public static void main(String[] args)
    {
        System.out.println((1&0) != 0);
        System.out.println("-----------");
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
//        while (head != null) {
//            System.out.println(head.val);
//            head = head.next;
//        }
        ListNode newHead = reverseItr(head);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
