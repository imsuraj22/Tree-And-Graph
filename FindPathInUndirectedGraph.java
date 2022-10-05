import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class FindPathInUndirectedGraph {

    int v;
    ArrayList<ArrayList<Integer>> adj;

    public FindPathInUndirectedGraph(int v){
        this.v=v;
        adj=new ArrayList<>();
        for(int i=0; i<v;i++){
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int v,int w){
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

    boolean isReachable(int s, int d){
        if(s==d){
            return true;
        }
        boolean[] visited=new boolean[v];
        Queue<Integer> q=new LinkedList<>();

        visited[s]=true;
        q.add(s);

        Iterator<Integer> i;
        while(!q.isEmpty()){
            s=q.poll();
            int n;
            i=adj.get(s).listIterator();

            while(i.hasNext()){
                n=i.next();

                if(n==d){
                    return true;
                }
                if(!visited[n]){
                    visited[n]=true;
                    q.add(n);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        FindPathInUndirectedGraph g = new FindPathInUndirectedGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        int u = 1, v = 3;
        if (g.isReachable(u, v))
            System.out.println("\n There is a path from "+u+" to "+v);
        else
            System.out.println("\n There is no path from "+u+" to "+v);
    }
}
