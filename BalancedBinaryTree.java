class TreeNode
{
    int value;
    TreeNode left, right;
    public TreeNode(int x)
    {
        value= x;
        left = right = null;
    }
}
class BalancedBinaryTree
{
    /* BRUTE FORCE
    public static int height(treeNode root)
    {
        if(root == null)
            return 0;
            int l=height(root.left);
            int r=height(root.right);
        return Math.max(l,r) + 1;
    }
    public static boolean balanced(treeNode root)
    {
        if(root == null)
            return true;
        int l = height(root.left) , r = height(root.right);
        if(Math.abs(r - l) > 1)
            return false;
        return balanced(root.left) && balanced(root.right);
    }
    */
    public static boolean isBalanced(TreeNode root) {
        return height(root) !=-1;
    }

    static int height(TreeNode root){
        if(root==null){
            return 0;
        }

        int left=height(root.left);
        if(left==-1) return -1;
        int right=height(root.right);
        if(right==-1) return -1;

        if(Math.abs(left-right)>1) return -1;
        return Math.max(left, right)+1;
    }
    public static void main(String args[])
    {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        if(isBalanced(root))
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");
    }
}