import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

class Pair{
    BinaryTreeNode<Integer> node;
    int val;
    Pair(BinaryTreeNode<Integer> node,int val){
        this.node=node;
        this.val=val;
    }
}
public class TreeTraversals {
    
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
       ArrayList<Integer> pre=new ArrayList<>();
       ArrayList<Integer> in=new ArrayList<>();
       ArrayList<Integer> post=new ArrayList<>();
       List<List<Integer>> result=new ArrayList<>();
       Stack<Pair> s=new Stack<>();

       if(root==null) return result;

       s.add(new Pair(root, 1));
       while(!s.isEmpty()){
        Pair p=s.pop();

        if(p.val==1){
            pre.add(p.node.data);
            p.val++;
            s.push(p);

            if(p.node.left!=null) s.push(new Pair(p.node.left, 1));
        }else if(p.val==2){
            in.add(p.node.data);
            p.val++;
            s.push(p);

            if(p.node.right!=null) s.push(new Pair(p.node.right, 1));

        }else{
            post.add(p.node.data);
        }

       }

       result.add(in);
       result.add(pre);
       
       result.add(post);
       return result;
  
    }
   
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
        root.left = new BinaryTreeNode<Integer>(2);
        root.left.left = new BinaryTreeNode<Integer>(4);
        root.left.right = new BinaryTreeNode<Integer>(5);
        root.right = new BinaryTreeNode<Integer>(3);
        root.right.left = new BinaryTreeNode<Integer>(6);
        root.right.right = new BinaryTreeNode<Integer>(7);

        
        List<List<Integer>> result=getTreeTraversal(root);

        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }
}
