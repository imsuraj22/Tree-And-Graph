import java.util.ArrayList;

 class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}

public class MorrisPreorder{
    

    ArrayList<Integer> morisTraversal(Node root){
        ArrayList<Integer> list=new ArrayList<>();
        Node curr=root;
        while(curr!=null){
            if(curr.left==null){
                list.add(curr.data);
            }else{
                Node prev=curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev=prev.right;
                }

                if(prev.right==null){
                    prev.right=curr;
                    curr=curr.left;
                }
                else{
                    prev.right=null;
                    list.add(curr.data);
                    curr=curr.right;
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}