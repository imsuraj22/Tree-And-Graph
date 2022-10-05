import java.util.ArrayList;

public class Root2PathBST {
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
   public static void printPath(ArrayList<Integer> path){
    for(int i=0; i<path.size();i++){
        System.out.print(path.get(i)+"->");
    }
    System.out.println();
   }

   public static void printRoot2Path(Node root,ArrayList<Integer> path){
    if(root==null){
        return;
    }
    path.add(root.data);

    //leat
    if(root.left==null && root.right==null){
        printPath(path);
    }else{
        //non leaf
        printRoot2Path(root.left, path);
        printRoot2Path(root.right, path);
    }
    path.remove(path.size()-1);
   }
   
   public static void main(String[] args) {
       int values[]={8,5,3,1,4,6,10,11,14};
       Node root=null;
       for(int i=0; i<values.length;i++){
           root=insert(root, values[i]);
       }
       inorder(root);
       System.out.println();

       printRoot2Path(root, new ArrayList<>());;
       
   }
}
