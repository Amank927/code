package trees;

public class SameTree
{
    public int isSameTree(TreeNode a, TreeNode b) {
        return isSameTreeBoolean(a, b) ? 1:0;
    }

    public boolean isSameTreeBoolean(TreeNode a, TreeNode b) {
        if (a== null && b ==null) {
            return true;
        }
        if (a== null || b==null) {
            return false;
        }

        if (a.val != b.val) {
            return false;
        } else {
            return isSameTreeBoolean(a.left, b.left) && isSameTreeBoolean(a.right, b.right);
        }
    }
}
