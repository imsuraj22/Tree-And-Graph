import java.util.LinkedList;
import java.util.Queue;

class NodeClass{
    int height;
    int left;
    int right;
    NodeClass(int height, int left, int right){
        this.height=height;
        this.left=left;
        this.right=right;
    }
}
public class HeightUsingInorderAndLevelOrder {
    public static int heightOfTheTree(int[] inorder, int[] levelOrder, int N){

		Queue<NodeClass> q=new LinkedList<>();
        q.add(new NodeClass(0, 0, N-1));
        int pos[]=new int[N+1];
        for(int i=0;i<N;i++){

            pos[inorder[i]]=i;
           // System.out.println(pos[inorder[i]]);
        }
        System.out.println(pos.length);
        System.out.println(pos[0]);
        for(int i=0;i<pos.length;i++){
            System.out.print(pos[i]+" ");
        }
        int max=0;
        for(int i=0;i<N;i++){
            int curr=levelOrder[i];
            NodeClass node=q.poll();
           
            int currPos=pos[curr];
            if(currPos>node.left){
                q.add(new NodeClass(node.height+1, node.left, currPos-1));
                max=Math.max(max, node.height+1);
            }
            if(currPos<node.right){
                q.add(new NodeClass(node.height+1, currPos+1, node.right));
                max=Math.max(max, node.height+1);
            }
        }
        return max;
        
	}
    public static void main(String[] args) {
        int inorder[]=new int[]{7, 4, 2, 1, 5, 3, 6};
        int n=inorder.length;
        int levelOrder[]=new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println("\n"+heightOfTheTree(inorder, levelOrder, n));
    }
}
