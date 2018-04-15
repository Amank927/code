package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class TreeTraversals
{
    public static ArrayList<Integer> inorderTraversal(TreeNode a) {
        if (a == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        stack.add(a);
        TreeNode current = a;
        while (!stack.empty() ) {
            while (current!= null && current.left != null) {
                stack.push(current.left);
                current = current.left;
            }
            current = stack.pop();
            arrayList.add(current.val);
            current = current.right;
            if (current != null) {
                stack.push(current);
            }
        }
        return arrayList;
    }
    public static ArrayList<Integer> preorderTraversal(TreeNode a) {
        if (a == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        stack.add(a);
        TreeNode current = a;
        arrayList.add(current.val);
        while (!stack.empty()) {
            while (current!= null && current.left != null) {
                stack.push(current.left);
                current = current.left;
                arrayList.add(current.val);
            }
            current = stack.pop();
            current = current.right;
            if (current != null) {
                arrayList.add(current.val);
                stack.push(current);
            }
        }
        return arrayList;
    }

    /**
     * Incomplete
     * @param a
     * @return
     */
    public static ArrayList<Integer> postorderTraversal(TreeNode a) {
        if (a == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        stack.push(a);
        TreeNode current = a;
        while (!stack.empty()) {
            while (current!= null && current.left != null) {
                stack.push(current.left);
                current = current.left;
            }
            if (current.right == null) {
                arrayList.add(current.val);
            } else {
                current = current.right;
                stack.push(current);
            }
        }
        return arrayList;

    }

    public static void isValidBst(TreeNode a, TreeNode prev) {
        if (a == null)
            return;
        isValidBst(a.left, prev);
        prev = a;
        System.out.println("Prev" + prev.val);
        System.out.println("Now" +a.val);
        isValidBst(a.right, prev);
    }

    public static void main(String[] args)
    {
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//        TreeNode treeNode4 = new TreeNode(4);
//        TreeNode treeNode5 = new TreeNode(5);
//        TreeNode treeNode6 = new TreeNode(6);
//        /**
//         * Basic tree
//         */
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        treeNode2.left = treeNode4;
//        treeNode2.right = treeNode5;
//        //treeNode5.left = treeNode6;
//
//
//        isValidBst(treeNode1, null);
        /**
         * Only left tree
         */
//        treeNode1.right = treeNode2;
//        treeNode2.left = treeNode3;
//        treeNode3.left = treeNode4;
        //System.out.println(postorderTraversal(treeNode1));
        List<Integer> arrayList = Arrays.asList(1, 2);

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        for (Integer integer : treeSet) {
            System.out.println(integer);
        }
        int i=0;
        System.out.println(i);
    }
}
