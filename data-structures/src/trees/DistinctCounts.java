package trees;

import java.util.HashMap;
import java.util.Map;

public class DistinctCounts
{
    public static int maxNodes = 0;
    public static void count(TreeNode root, Map<Integer, Integer> hash) {

        if(root == null) {
            return;
        }
        if(hash.containsKey(root.val)) {
            hash.put(root.val, hash.get(root.val) +1);
        } else {
            hash.put(root.val, 1);
        }
        maxNodes = Math.max(maxNodes, hash.size());
        count(root.left, hash);
        count(root.right, hash);
        if(hash.containsKey(root.val)) {
            if(hash.get(root.val) > 1) {
                hash.put(root.val, hash.get(root.val) -1);
            } else {
                hash.remove(root.val);
            }
        }

    }
    public static void main(String[] args)
    {
//        TreeNode treeNode1 = new TreeNode(4);
//        TreeNode treeNode2 = new TreeNode(5);
//        TreeNode treeNode3 = new TreeNode(6);
//        TreeNode treeNode4 = new TreeNode(4);
//        TreeNode treeNode5 = new TreeNode(1);
//        TreeNode treeNode6 = new TreeNode(6);
//        TreeNode treeNode7 = new TreeNode(5);
//
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        treeNode1.left.left = treeNode4;
//        treeNode1.left.left.left = treeNode7;
//        treeNode1.right.left = treeNode5;
//        treeNode1.right.right = treeNode6;

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(3);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode1.left.left = treeNode4;
        treeNode1.left.right = treeNode5;
        treeNode1.right.left = treeNode6;
        treeNode1.right.right  = treeNode7;
        treeNode1.right.left.right = treeNode8;
        treeNode1.right.right.right = treeNode9;

        //System.out.println(maxNodes);
        count(treeNode1, new HashMap<>());
        System.out.println(maxNodes);
    }
}
