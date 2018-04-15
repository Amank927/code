package trees;

public class KthSmallest
{
    static int count = 0;
    static class Count {
        int count =0;
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static void inorder(TreeNode root, int k, Count currCount) {
        if(root == null) {
            return;
        }
        inorder(root.left, k,currCount);
        currCount.count = currCount.count + 1;
        if(currCount.count == k ) {
            System.out.println(root.val);
        }
        inorder(root.right, k, currCount);
    }
    static class Prev {
        TreeNode prev = null;
    }
    public static boolean isValidBst(TreeNode root, Prev prev) {
        if (root == null) {
            return true;
        }
        boolean isValid = isValidBst(root.left, prev);
        if(prev.prev != null && prev.prev.val >= root.val) {
            isValid = false;
            return isValid;
        }
        prev.prev  = root;
        return isValid && isValidBst(root.right, prev);
    }
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right = new TreeNode(22);
        //inorder(root, 4, new Count());
        System.out.println(isValidBst(root, new Prev()));
    }
}
