import java.util.ArrayList;
import java.util.Stack;


class Pair{
    int v;
    int weight;
    Pair(int _v, int _w){
        v=_v;
        weight=_w;
    }
    int getV() {return v;}
    int getWeight(){return weight;}

}
public class ShortestPathInDirectedGraph {

    static void topologicalSortUtil(int node,Boolean visited[], Stack stack,ArrayList<ArrayList<Pair>> adj){
        visited[node]=true;
        for(Pair it:adj.get(node)){
            if(visited[it.getV()]==false){
                topologicalSortUtil(it.getV(), visited, stack, adj);
            }
        }
        stack.add(node);
    }

    static void shortestPath(int s, ArrayList<ArrayList<Pair>> adj, int n){
        Stack stack=new Stack<>();
        int distance[]=new int[n];

        Boolean visited[]=new Boolean[n];
        for(int i=0;i<n;i++){
            visited[i]=false;
        }

        for(int i=0;i<n;i++){
            if(visited[i]==false){
                topologicalSortUtil(i, visited, stack, adj);
            }
        }

        for(int i=0;i<n;i++){
            distance[i]=Integer.MAX_VALUE;
        }

        distance[s]=0;

        while(!stack.isEmpty()){
            int node=(int)stack.pop();

            if(distance[node]!=Integer.MAX_VALUE){
                for(Pair it:adj.get(node)){
                    if(distance[node] + it.getWeight() < distance[it.getV()]){
                        distance[it.getV()]=distance[node]+it.getWeight();
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            if(distance[i]==Integer.MAX_VALUE){
                System.out.print("Infinity/unreachable");
            }
            else{
                System.out.print (distance[i]+" ");
            }
        }
    }


    public static void main(String[] args) {
        int V = 6;
            ArrayList<ArrayList<Pair>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Pair>());
                
                adj.get(0).add(new Pair(1, 2));
                adj.get(0).add(new Pair(4, 1));
                adj.get(1).add(new Pair(2, 3));
                adj.get(2).add(new Pair(3, 6));
                adj.get(4).add(new Pair(2, 2));
                adj.get(4).add(new Pair(5, 4));
                adj.get(5).add(new Pair(3, 1));
    }
}
