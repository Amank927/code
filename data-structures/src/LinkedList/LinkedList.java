package LinkedList;

public class LinkedList
{
    Node head;
    Node left;

    static class Node
    {
        int data;
        Node next;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int nodeVal) {
        Node node = new Node(nodeVal);
        node.next = head;
        head = node;
    }

    public boolean isPalindrome(Node start) {
        left = head;
        if (start == null) {
            return true;
        }
        boolean isPalin = isPalindrome(start.next);
        if(!isPalin) {
            return false;
        }
        if (left.data != start.data) {
            isPalin = false;
        }
        left = left.next;
        return isPalin;
    }

    public void printList() {
        Node start = head;
        while (start!=null) {
            System.out.println(start.data);
            start = start.next;
        }
    }

    public static void main(String[] args)
    {
        LinkedList linkedList = new LinkedList();
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(1);
        linkedList.printList();
        System.out.println(linkedList.isPalindrome(linkedList.head));
    }
}
