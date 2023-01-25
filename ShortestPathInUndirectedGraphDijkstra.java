import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Node implements Comparator<NodeClass>
{
    private int v;
    private int weight;
    
    Node(int _v, int _w) { v = _v; weight = _w; }
    
    Node() {}
    
    int getV() { return v; }
    int getWeight() { return weight; }
    
    @Override
    public int compare(NodeClass node1, NodeClass node2) 
    { 
        if (node1.weight < node2.weight) 
            return -1; 
        if (node1.weight > node2.weight) 
            return 1; 
        return 0; 
    } 
}

public class ShortestPathInUndirectedGraphDijkstra {

    static void shortestPath(int s, ArrayList<ArrayList<NodeClass>> adj, int N)
    {
        int dist[] = new int[N];
        
        for(int i = 0;i<N;i++) dist[i] = 100000000;
        dist[s] = 0; 
        
        PriorityQueue<NodeClass> pq = new PriorityQueue<NodeClass>(N, new NodeClass());
        pq.add(new NodeClass(s, 0));
        
        while(pq.size() > 0) {
            NodeClass node = pq.poll();
            
            for(NodeClass it: adj.get(node.getV())) {
                if(dist[node.getV()] + it.getWeight() < dist[it.getV()]) {
                    dist[it.getV()] = dist[node.getV()] + it.getWeight(); 
                    pq.add(new NodeClass(it.getV(), dist[it.getV()]));
                }
            }
        }
        System.out.println("The distances from source "+s+" are : ");
        for (int i = 0; i < N; i++)
        {
            System.out.print( dist[i] + " ");
        }
    }
    public static void main(String args[])
    {
        int n = 5;
        ArrayList<ArrayList<NodeClass> > adj = new ArrayList<ArrayList<NodeClass> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<NodeClass>());
			
		adj.get(0).add(new NodeClass(1, 2));
		adj.get(1).add(new NodeClass(0, 2));
		
		adj.get(1).add(new NodeClass(2, 4));
		adj.get(2).add(new NodeClass(1, 4));
		
		adj.get(0).add(new NodeClass(3, 1));
		adj.get(3).add(new NodeClass(0, 1));
		
		adj.get(3).add(new NodeClass(2, 3));
		adj.get(2).add(new NodeClass(3, 3));
		
		adj.get(1).add(new NodeClass(4, 5));
		adj.get(4).add(new NodeClass(1, 5));
		
		adj.get(2).add(new NodeClass(4, 1));
		adj.get(4).add(new NodeClass(2, 1));
		
		
		shortestPath(0, adj, n); 
		
    }
}
