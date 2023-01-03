import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
class Pair{
    Node n;
    int line;
    Pair(Node n,int line){
        this.n=n;
        this.line=line;
    }
}
public class BottomViewBinaryTree{

    public static ArrayList<Integer> bottomView(Node root) {
       Queue<Pair> q=new LinkedList<>();
       Pair p=new Pair(root, 0);
       q.add(p);

       HashMap<Integer,Integer> map=new HashMap<>();
       while(!q.isEmpty()){
            Pair p1=q.poll();
            int l=p1.line;
            Node n=p1.n;
            map.put(l, n.val);

            Pair p2;
            if(n.left!=null){
                 p2=new Pair(n.left, l-1);
                q.add(p2);
            }
            if(n.right!=null){
                p2=new Pair(n.right, l+1);
                q.add(p2);
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