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
public class DiameterOfBinaryTree {
        public int diameterOfBinaryTree(TreeNode root) {
                int diameter[]=new int[1];
                solution(root,diameter);
                return diameter[0];

            
        }

            int solution(TreeNode root,int[] diameter){
                if(root==null){
                    return 0;
                    
                }

                int left=solution(root.left, diameter);
                int right=solution(root.right, diameter);
                diameter[0]=Math.max(diameter[0], left+right);
                return 1+Math.max(left, right);

            }
    
    public static void main(String[] args) {
        
    }
}
