import javafx.scene.transform.Rotate;

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
public class MaximumDiffrenceBetweenNodeAndAncestor {

    int maxdiff=0;
    public int maxAncestorDiff(TreeNode root) {

        return findDiff(root, root.val,root.val);
        
    }   

    int findDiff(TreeNode root, int maxAns, int minAns){
        if(root==null) return 0;

        maxdiff=Math.max(maxdiff, Math.max(Math.abs(root.val-minAns), Math.abs(maxAns-root.val)));

        if(root.val>maxAns) maxAns=root.val;
        if(root.val<minAns) minAns=root.val;

        findDiff(root.left, maxAns, minAns);
        findDiff(root.right, maxAns, minAns);

        return maxdiff;

    }
    public static void main(String[] args) {
        
    }
}
