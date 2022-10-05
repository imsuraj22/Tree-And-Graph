import java.util.LinkedList;
import java.util.*;

public class RangeSumOfBST {
    
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

   
   

   //------------------USING QUEUE---------------------
   public static int rangeSum(Node root, int L, int R){
    int sum=0;
    if(root==null){
        return sum;
    }
    Queue<Node> queue=new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()){
        Node current=queue.remove();
        if(current.data>= L && current.data<=R){
            sum+=current.data;
        }
        if(current.left!=null && current.data>=L){
            queue.add(current.left);
        }
        if(current.right!=null && current.data<=R){
            queue.add(current.right);
        }

    }
    return sum;
   }
   
   public static void main(String[] args) {
       int values[]={8,5,3,1,4,6,10,11,14};
       Node root=null;
       for(int i=0; i<values.length;i++){
           root=insert(root, values[i]);
       }
       inorder(root);
       System.out.println();

     
       int res=rangeSum(root, 1, 10);
       System.out.println("\nsum using queue is : "+res);
       
   }
}
