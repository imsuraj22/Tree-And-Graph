public class SearchInBST {
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

   //------------------SEARCH --------------------

   public static boolean search(Node root, int key){
    if(root.data==key){
        return true;
    }
    else if(key<root.data){
        return search(root.left, key);
    }else{
        return search(root.right, key);
    }

   }

   public static void inorder(Node root){
       if(root==null){
           return;
       }
       inorder(root.left);
       System.out.print(root.data+" ");
       inorder(root.right);
   }
   public static void main(String[] args) {
       int values[]={8,5,3,1,4,6,10,11,14};
       Node root=null;
       for(int i=0; i<values.length;i++){
           root=insert(root, values[i]);
       }
       inorder(root);
       System.out.println();

       if(search(root, 6)){
        System.out.println("Found");
       }else{
        System.out.println("Not Found");
       }
   }
}
