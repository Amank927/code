package trees;

public class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val)
    {
        this.val = val;
        this.right = null;
        this.left = null;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TreeNode treeNode = (TreeNode) o;

        if (val != treeNode.val) {
            return false;
        }
        if (left != null ? !left.equals(treeNode.left) : treeNode.left != null) {
            return false;
        }
        return right != null ? right.equals(treeNode.right) : treeNode.right == null;
    }

    @Override
    public int hashCode()
    {
        int result = val;
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        Integer integer = new Integer(1);
        integer.intValue();
        return result;
    }
    static class Triplet
    {
        int a;
        int b;
        int c;

        @Override
        public boolean equals(Object o)
        {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Triplet triplet = (Triplet) o;

            if (a != triplet.a) {
                return false;
            }
            if (b != triplet.b) {
                return false;
            }
            return c == triplet.c;
        }

        @Override
        public int hashCode()
        {
            int result = a;
            result = 31 * result + b;
            result = 31 * result + c;
            return result;
        }
    }

}
