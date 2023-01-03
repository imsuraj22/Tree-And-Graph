import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class BinaryTreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    BinaryTreeNode(){

    }
    BinaryTreeNode(int val){
        this.val=val;
    }
    BinaryTreeNode(int val,TreeNode left,TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
public class PostOrderTraversalUsingRecursion {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new LinkedList<>();    
        
        if(root==null) return res;

        Stack<TreeNode> stack=new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode top=stack.pop();
            res.add(0,top.val);
            if(top.left!=null){
                stack.add(top.left);
            }
            if(top.right!=null){
                stack.add(top.right);
            }
        }
    
        return res;
    }

    public static void main(String[] args) {
        
        PostOrderTraversalUsingRecursion p=new PostOrderTraversalUsingRecursion();
        List<Integer> l=new LinkedList<>();
        l.add(1);
        l.add(4);
        l.add(5);
        l.add(2);
        l.add(6);
        int a[]=p.postorderTraversal(l);
    }
}
