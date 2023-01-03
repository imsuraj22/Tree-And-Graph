import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;



class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
class Pair{
    BinaryTreeNode n;
    int line;
    Pair(BinaryTreeNode n,int line){
        this.n=n;
        this.line=line;
    }
}
public class TopViewOfBinaryTree {

    public static ArrayList<Integer> getTopView(BinaryTreeNode root) {

        Queue<Pair> q=new LinkedList<>();
        Map<Integer,Integer> map=new TreeMap<>();

        Pair p=new Pair(root, 0);
        q.add(p);

        while(!q.isEmpty()){
            Pair p1=q.poll();
            BinaryTreeNode node =p1.n;
            int l=p1.line;
            if(!map.containsKey(l)){
                map.put(l, node.val);
            }

            Pair p2=null;
            if(node.left!=null){
                p2=new Pair(node.left,l-1 );
            }

            if(node.right!=null){
                p2=new Pair(node.right, l+1);
            }
        }

        ArrayList<Integer> list=new ArrayList<>();
       for(int itr:map.values()){
        list.add(itr);
       }

       return list;
		
	}
    public static void main(String[] args) {
        
    }
}
