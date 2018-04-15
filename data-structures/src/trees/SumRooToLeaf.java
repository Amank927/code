package trees;

import dp.LIS;

import java.util.ArrayList;

public class SumRooToLeaf
{

    public static void allPaths(TreeNode root, int sum ,
                                                  ArrayList<Integer> currList,ArrayList<ArrayList<Integer>> finalList )
    {
        currList.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {

            finalList.add(new ArrayList<>(currList));
            //System.out.println(currList);
            //System.out.println(finalList);
        }
        if(root.left != null) {
            allPaths(root.left, sum - root.val, currList, finalList);
        }
        if(root.right != null) {
            allPaths(root.right, sum - root.val, currList, finalList);
        }

        if (currList.size() > 0) {
            currList.remove(currList.size() -1 );
        }

    }

    public static void printAllPaths(TreeNode node, ArrayList<Integer> list) {
        list.add(node.val);
        if (node.left == null && node.right == null) {
            System.out.println(list);
        }

        if (node.left != null) {
            printAllPaths(node.left, list);
        }
        if (node.right != null) {
            printAllPaths(node.right, list);
        }
        if (list.size() > 0) {
            list.remove(list.size() -1 );
        }
    }
    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        //System.out.println(root.val);
        //return new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> finalList = new ArrayList<ArrayList<Integer>>();
        if (root == null || sum == 0) {
            return finalList;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        allPaths(root, sum, list, finalList);
        return finalList;
    }


    public static void main(String[] args)
    {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(8);
        //TreeNode treeNode4 = new TreeNode(4);
        //TreeNode treeNode5 = new TreeNode(5);
        //TreeNode treeNode6 = new TreeNode(6);
        /**
         * Basic tree
         */
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        //treeNode2.left = treeNode4;
        //treeNode2.right = treeNode5;

        System.out.println(pathSum(treeNode1, 9));
        //printAllPaths(treeNode1, new ArrayList<Integer>());
    }
}
