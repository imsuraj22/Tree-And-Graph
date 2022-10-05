import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteUsingBFS {

    boolean check(ArrayList<ArrayList<Integer>> adj, int node, int color[]){
        Queue<Integer> q =new LinkedList<>();
        q.add(node);
        color[node]=1;

        while(!q.isEmpty()){
            int nde=q.poll();

            for(Integer it:adj.get(nde)){
                if(color[it]==-1){
                    color[it]=1-color[nde];
                    q.add(it);
                }else if(color[it]==color[nde]){
                    return false;
                }
            }
        }
        return true;
    }
    boolean isBipartile(ArrayList<ArrayList<Integer>> adj, int n){
        int color[]=new int[n];
        for(int i=0;i<n;i++){
            color[i]=-1;
        }
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!check(adj,i,color)){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0; i<4;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        BipartiteUsingBFS obj = new BipartiteUsingBFS();
        boolean ans = obj.isBipartile(adj,4);
        if(ans)
            System.out.println("its Bipartile");
        else System.out.println("its not a bipartile");
    }
}
