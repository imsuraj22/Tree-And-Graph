import java.util.Stack;

public class MergeTwoBinaryTreeIteration {
    static class Node{
        int data;
        Node right;
        Node left;

        Node(int data){
           this.data=data;
        }
   }
   static class NodePair{
    Node l;
    Node r;
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

   public static Node mergeTrees(Node node1, Node node2){
    if(node1==null){
        return node2;
    }
    if(node2==null){
        return node1;
    }

    Stack<NodePair> stack=new Stack<>();
    NodePair p = new NodePair();
    p.l=node1;
    p.r=node2;
    stack.push(p);
    NodePair temp=null;

    while(!stack.isEmpty()){
        temp=stack.pop();
        if(temp.l==null || temp.r==null)
        continue;

        temp.l.data+=temp.r.data;
        if(temp.l.left==null){
            temp.l.left=temp.r.left;
        }else{
            NodePair n=new NodePair();
            n.l=temp.l.left;
            n.r=temp.r.left;
            stack.push(n);
        }
        if(temp.l.right==null){
            temp.l.right=temp.r.right;
        }else{
            NodePair n=new NodePair();
            n.l=temp.l.right;
            n.r=temp.r.right;
            stack.push(n);
        }
    }
    return node1;

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
