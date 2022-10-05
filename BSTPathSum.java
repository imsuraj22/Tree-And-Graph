
import java.util.Stack;


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
class BSTPathSum
{
    static boolean hassum(TreeNode root, int sum){
        Stack<TreeNode> nodeStack=new Stack<>();
        Stack<Integer> sumStack=new Stack<>();

        if(root==null){
            return false; 
        }

        nodeStack.add(root);
        sumStack.add(sum-root.value);

        while(!nodeStack.isEmpty()){
            TreeNode currentNode=nodeStack.pop();
            int currentSum=sumStack.pop();

            if(currentNode.left==null && currentNode.right==null && currentSum==0){
                return true;
            }

            if(currentNode.left!=null){
                nodeStack.add(currentNode.left);
                sumStack.add(currentSum-currentNode.left.value);
            }
            if(currentNode.right!=null){
                nodeStack.add(currentNode.right);
                sumStack.add(currentSum-currentNode.right.value);
            }

        }
        return false;
    }
    public static void main(String args[])
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(4);
        root.right.right=new TreeNode(8);
        System.out.println(hassum(root, 8));

        
    }
}