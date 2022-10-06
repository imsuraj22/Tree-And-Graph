import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTraversalFromLeaft {
    // static class Node{
    //     int data;
    //     Node right;
    //     Node left;

    //     Node(int data){
    //        this.data=data;
    //     }
    static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }
   
   public static TreeNode insert(TreeNode root, int val){
       if(root==null){
           root=new TreeNode(val);
           return root;
       }
       if(val<root.val){
           root.left=insert(root.left, val);
       }
       if(val>root.val){
           root.right=insert(root.right, val);
       }
       return root;
   }

   public static void inorder(TreeNode root){
       if(root==null){
           return;
       }
       inorder(root.left);
       System.out.print(root.val+" ");
       inorder(root.right);
   }

   static public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> nodes=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                nodes.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            result.add(0,nodes);
        }
        return result;
    }
   
   public static void main(String[] args) {
       int values[]={8,5,3,1,4,6,10,11,14};
       TreeNode root=null;
       for(int i=0; i<values.length;i++){
           root=insert(root, values[i]);
       }
       inorder(root);
       System.out.println();

       List<List<Integer>> list= new ArrayList<List<Integer>>(); 
       
       list=levelOrderBottom(root);
       for(int i=0;i<list.size();i++){
        System.out.println(list.get(i));
       }
       
   }
}
