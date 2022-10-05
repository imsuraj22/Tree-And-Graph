public class MergeTwoBinaryTree {
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

   public static Node mergeTrees(Node t1, Node t2){
    if(t1==null){
        return t2;
    }
    if(t2==null){
        return t1;
    }
    t1.data+=t2.data;
    t1.left=mergeTrees(t1.left, t2.left);
    t1.right=mergeTrees(t1.right, t2.right);

    return t1;
   }

   public static void main(String[] args) {
       int values[]={8,5,3,1,4,6,10,11,14};
       int values1[]={3,6,3,7,9};
       Node root=null;
       for(int i=0; i<values.length;i++){
           root=insert(root, values[i]);
       }
       Node root1=null;
       for(int i=0; i<values1.length;i++){
           root1=insert(root1, values1[i]);
       }

       Node res=mergeTrees(root, root1);
       inorder(res);
       System.out.println();

       
   }
}
