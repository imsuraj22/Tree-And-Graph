import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class FindPathInDirectedGraph {
    int v;
    ArrayList<ArrayList<Integer>> adj;

    public FindPathInDirectedGraph(int v){
        this.v=v;
        adj=new ArrayList<>();
        for(int i=0; i<v;i++){
            adj.add(new ArrayList<>());
        }
    }
    void addEdge(int v, int w){
        adj.get(v).add(w);
    }

    boolean isReachable(int s, int d){
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
        FindPathInDirectedGraph g = new FindPathInDirectedGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        int u = 1;
        int v = 3;
        if (g.isReachable(u, v))
            System.out.println("There is a path from " + u +" to " + v);
        else
            System.out.println("There is no path from " + u +" to " + v);;
 
        u = 3;
        v = 1;
        if (g.isReachable(u, v))
            System.out.println("There is a path from " + u +" to " + v);
        else
            System.out.println("There is no path from " + u +" to " + v);;
    }
}
