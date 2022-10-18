import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBFS {

    static int[] topoSort(int n,ArrayList<ArrayList<Integer>> adj){
        int topo[]=new int[n];
        int indegree[]=new int[n];
        for(int i=0;i<n;i++){
            for(Integer it:adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int ind=0;
        while(!q.isEmpty()){
            Integer node=q.poll();
            topo[ind++]=node;

            for(Integer it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        return topo;
    }

    public static void main(String[] args) {
        int V = 6;
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                adj.get(5).add(0);
                adj.get(5).add(2);
                adj.get(2).add(3);
                adj.get(3).add(1);
                adj.get(4).add(0);
                adj.get(4).add(1);
                int result[]=topoSort(V, adj);
                for(int i=0;i<result.length;i++){
                    System.out.print(result[i]+" ");
                }
    }
}
