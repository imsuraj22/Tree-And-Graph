import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
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

public class LevelOrderTraversal {
    public static List<List<Integer>> getLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return result;

        q.add(root);
        while(!q.isEmpty()){

        int level=q.size();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<level;i++){
            if(q.peek().left!=null) q.add(q.peek().left);
            if(q.peek().right!=null) q.add(q.peek().right);

           list.add(q.poll().val);
        }

        result.add(list);
    }
        return result;
        

      }
    
    public static void main(String[] args) {
        
    }
}
