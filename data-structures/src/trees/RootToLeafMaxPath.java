package trees;


import java.util.ArrayList;
import java.util.List;

public class RootToLeafMaxPath
{
    static class MaXSumPath{
        int maxSum = Integer.MIN_VALUE;
        ArrayList<Integer> path = null;
        TreeNode leafNode = null;
    }
    static class MaxSum {
        int val;
    }
    public static void maxRootLeafToPath(TreeNode root, MaXSumPath maXSumPath, int currSum) {
        if (root.left == null && root.right == null) {
            if (currSum + root.val > maXSumPath.maxSum) {
                maXSumPath.maxSum = currSum + root.val;
                maXSumPath.leafNode = root;
            }
        } else {
            maxRootLeafToPath(root.left, maXSumPath, currSum + root.val);
            maxRootLeafToPath(root.right, maXSumPath, currSum + root.val);
        }
    }
    public static void maxRootLeafToPathCopy(TreeNode root, MaXSumPath maXSumPath, ArrayList<Integer> path, int currSum) {
        if (root.left == null && root.right == null) {
            path.add(root.val);
            if (currSum + root.val > maXSumPath.maxSum) {
                maXSumPath.maxSum = currSum + root.val;
                maXSumPath.leafNode = root;
                ArrayList<Integer> res = new ArrayList<>(path);
                maXSumPath.path = res;
            }
        } else {
            path.add(root.val);
            maxRootLeafToPathCopy(root.left, maXSumPath, path, currSum + root.val);
            if(path.size() > 0) {
                path.remove(path.size() -1);
            }
            maxRootLeafToPathCopy(root.right, maXSumPath, path, currSum + root.val);
            if(path.size() > 0) {
                path.remove(path.size() -1);
            }
        }
    }

    public static int maxSumTillLeaf(TreeNode root) {
        if(root.left == null && root.right == null) {
            return root.val;
        } else {
            return Math.max(maxSumTillLeaf(root.left)  + root.val,
                    maxSumTillLeaf(root.right) + root.val);
        }
    }
    public static int maxLeafToLeafSum(TreeNode root) {
        if(root.left == null) {
            return 0;
        }
        int maxLeft = maxSumTillLeaf(root.left);
        int maxRight = maxSumTillLeaf(root.right);
        return Math.max(maxLeft + maxRight + root.val, Math.max(maxLeafToLeafSum(root.left), maxLeafToLeafSum(root.right)));

    }
    public static int maxLeafToLeafSumCopy(TreeNode root, MaxSum maxSum) {
        if(root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int maxLeft = maxLeafToLeafSumCopy(root.left, maxSum);
        int maxRight = maxLeafToLeafSumCopy(root.right, maxSum);

        if (root.left != null && root.right != null) {
            maxSum.val = Math.max(maxSum.val, maxLeft + maxRight + root.val);

            return Math.max(maxLeft, maxRight) + root.val;
        }
        return root.left == null ? root.val + maxRight : root.val + maxLeft;
    }
    public static void main(String[] args)
    {
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(-2);
        TreeNode treeNode3 = new TreeNode(-17);
        TreeNode treeNode4 = new TreeNode(8);
        TreeNode treeNode5 = new TreeNode(20);
        //TreeNode treeNode6 = new TreeNode(6);
        /**
         * Basic tree
         */
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
//        MaXSumPath cmXSumPath = new MaXSumPath();
//        //maxRootLeafToPath(treeNode1, cmXSumPath, 0);
//        maxRootLeafToPathCopy(treeNode1, cmXSumPath,new ArrayList<>() , 0);
//
//        System.out.println(cmXSumPath.maxSum);
//        System.out.println(cmXSumPath.leafNode.val);
//        System.out.println(cmXSumPath.path);
//        System.out.println(maxSumTillLeaf(treeNode1));
//        MaxSum maxSum = new MaxSum();
//        maxSum.val = Integer.MIN_VALUE;
//        maxLeafToLeafSumCopy(treeNode1, maxSum);
//        System.out.println(maxSum.val);
        String  s1 = "ce";
        String  s2 = "be";
        System.out.println(s1.charAt(0) == s2.charAt(0));
        int[] a = {1, 2, 1 , 2};
    }
}
