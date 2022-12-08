import java.util.ArrayList;

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
public class LEafSimilarTree {

    ArrayList<Integer> leaf1=new ArrayList<>();
    ArrayList<Integer> leaf2=new ArrayList<>();


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        leaf1=findLeaves(root1, leaf1);
        leaf2=findLeaves(root2, leaf2);

        return leaf1.equals(leaf2);
    }

    ArrayList<Integer> findLeaves(TreeNode root, ArrayList<Integer> leaf){
        if(root==null) return null;

        if(root.left==null && root.right==null){
            leaf.add(root.val);
        }

        findLeaves(root.left, leaf);
        findLeaves(root.right, leaf);

        return leaf;
    }

    public static void main(String[] args) {
        
    }
}
