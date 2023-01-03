
import java.util.Stack;


class TreeNode
{
    int value;
    BinaryTreeNode left, right;
    public TreeNode(int x)
    {
        value= x;
        left = right = null;
    }
}
class BSTPathSum
{
    static boolean hassum(BinaryTreeNode root, int sum){
        Stack<BinaryTreeNode> nodeStack=new Stack<>();
        Stack<Integer> sumStack=new Stack<>();

        if(root==null){
            return false; 
        }

        nodeStack.add(root);
        sumStack.add(sum-root.value);

        while(!nodeStack.isEmpty()){
            BinaryTreeNode currentNode=nodeStack.pop();
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
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(6);
        root.left.left=new BinaryTreeNode(1);
        root.left.right=new BinaryTreeNode(4);
        root.right.right=new BinaryTreeNode(8);
        System.out.println(hassum(root, 8));

        
    }
}