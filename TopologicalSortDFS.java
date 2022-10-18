import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFS {


    static void findTopoSort(int node,int vis[],ArrayList<ArrayList<Integer>> adj,Stack<Integer> st){
        vis[node]=1;
        for(Integer it:adj.get(node)){
            if(vis[it]==0){
                findTopoSort(it, vis, adj, st);
            }
        }
        st.push(node);

    }

    
    static int[] topoSort(int n, ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> st=new Stack<>();
        int visited[]=new int[n];

        for(int i=0;i<n;i++){
            if(visited[i]==0){
                findTopoSort(i, visited, adj, st);
            }
        }

        int topo[]=new int[n];
        int ind=0;
        while(!st.isEmpty()){
            topo[ind++]=st.pop();
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

    
