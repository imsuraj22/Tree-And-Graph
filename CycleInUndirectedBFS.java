import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int first;
    int second;
    public TreeNode(int first, int second){
        this.first=first;
        this.second=second;
    }
}
public class CycleInUndirectedBFS {
    static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s, boolean vis[]){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(new TreeNode(s, -1));
        vis[s]=true;

        while(!q.isEmpty()){
            int node=q.peek().first;
            int par=q.peek().second;
            q.remove();

            for(Integer it:adj.get(node)){
                if(vis[it]==false){
                    q.add(new TreeNode(it, node));
                    vis[it]=true;
                }
                else if(par!=it){
                    return true;
                }
            }

        }
        return false;
    }

    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj){
        boolean vis[] = new boolean[v];
        Arrays.fill(vis, false);

        for(int i=0; i<v;i++){
            if(vis[i]==false){
                if(checkForCycle(adj, i, vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 5;
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                adj.get(0).add(1);
                adj.get(0).add(2);
                adj.get(2).add(3);
                adj.get(1).add(3);
                adj.get(2).add(4);

            CycleInUndirectedBFS obj = new CycleInUndirectedBFS();
            boolean ans = obj.isCycle(V, adj);
            if(ans)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

