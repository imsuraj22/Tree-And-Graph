import java.util.ArrayList;

public class BipartiteUsingDFS {

    static boolean dfsCheck(ArrayList<ArrayList<Integer>> adj, int node, int color[]){
        if(color[node]==-1){
            color[node]=1;
        }

        for(Integer it:adj.get(node)){
            if(color[it]==-1){
                color[it]=1-color[node];
                if(!dfsCheck(adj, it, color)){
                    return false;
                }
            }
            else if(color[it]==color[node]){
                return false;
            }
           
        }
        return true;
    }
    static boolean checkBipartile(ArrayList<ArrayList<Integer>> adj, int n){
        int color[] = new int[n];
        for(int i=0; i<n;i++){
            color[i]=-1;
       }
       for(int i=0; i<n;i++){
        if(color[i]==-1){
            if(!dfsCheck(adj,i,color)){
                return false;
            }
        }
       }
       return true;
    }
    public static void main(String[] args) {
        int n = 6;
        ArrayList < ArrayList < Integer >> graph = new ArrayList < ArrayList < Integer >> ();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList < Integer > ());

        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(1).add(2);
        graph.get(2).add(1);

        graph.get(1).add(4);
        graph.get(4).add(1);

        graph.get(1).add(5);
        graph.get(5).add(1);

        graph.get(2).add(3);
        graph.get(3).add(2);

        graph.get(3).add(4);
        graph.get(4).add(3);

        graph.get(3).add(5);
        graph.get(5).add(3);

        if (checkBipartile(graph, n))
            System.out.println("It is a Bipartite Graph");
        else
            System.out.println("It is not a Bipartite Graph");
    }
    }

