import java.util.ArrayList;
import java.util.List;

public class TreeLeftSideView {
    static class Node{
        int data;
        Node right;
        Node left;

        Node(int data){
           this.data=data;
        }
   }
   public static Node insert(Node root, int val){
       if(root==null){
           root=new Node(val);
           return root;
       }
       if(val<root.data){
           root.left=insert(root.left, val);
       }
       if(val>root.data){
           root.right=insert(root.right, val);
       }
       return root;
   }

   public static void inorder(Node root){
       if(root==null){
           return;
       }
       inorder(root.left);
       System.out.print(root.data+" ");
       inorder(root.right);
   }

   static public List<Integer> leftSideView(Node root) {
    /*   -------ITERATIVE  
    List<Integer> list=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node curr=q.poll();
                if(i==0) list.add(curr.data);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);

            }
        }
        return list;
        */
        // RECURSIVE
        List<Integer> result=new ArrayList<>();
        leftView(root, result, 0);
        return result;
        
}
static void leftView(Node curr, List<Integer> result, int currLevel){
    if(curr==null){
        return;
    }
    if(currLevel==result.size()){
        result.add(curr.data);
    }
    leftView(curr.left, result, currLevel+1);
    leftView(curr.right, result, currLevel+1);
}
   
   public static void main(String[] args) {
       int values[]={8,5,3,1,4,6,10,11,14};
       Node root=null;
       for(int i=0; i<values.length;i++){
           root=insert(root, values[i]);
       }
       inorder(root);
       System.out.println();
       List<Integer> list= new ArrayList<Integer>(); 
       
       list=leftSideView(root);
       for(int i=0;i<list.size();i++){
        System.out.print(list.get(i)+" ");
       }
       
       
   }
}
