package trees;

public class DiameterOfTree
{
    public static int height(TreeNode node) {
        if(node == null) {
            return 0;
        } else {
            return Math.max(1 + height(node.left) , 1 + height(node.right));
        }
    }
    public static int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh + rh + 1, Math.max(diameter(root.left), diameter(root.right)));
    }

    static class Diameter {
        int d;
    }
    public static int diameterOpt(TreeNode root, Diameter diameter) {
        if(root == null) {
            diameter.d = 0;
            return 0;
        }
        int ld = diameterOpt(root.left, diameter);
        int rd = diameterOpt(root.right, diameter);
        if (diameter != null && diameter.d < ld + rd + 1) {
            diameter.d = ld + rd +1;
        }
        return Math.max(ld, rd) +1;
    }

    public static void main(String[] args)
    {
        int n  = 3;
        char ch = (char) (64 + n);
        System.out.println(ch);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode1.left.left = treeNode4;
        treeNode1.left.right = treeNode5;
        treeNode1.left.right.right = treeNode6;

        treeNode1.left.right.right.right = new TreeNode(7);

        System.out.println(diameter(treeNode1));
        Diameter diameter = new Diameter();
        diameterOpt(treeNode1, diameter);
        System.out.println(diameter.d);
    }
}
