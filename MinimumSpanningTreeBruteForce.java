import java.util.ArrayList;

class Node 
{
    private int v;
    private int weight;
    
    Node(int _v, int _w) { v = _v; weight = _w; }
    
    Node() {}
    
    int getV() { return v; }
    int getWeight() { return weight; }
}

public class MinimumSpanningTreeBruteForce {

    static void primeAlgo(int n, ArrayList<ArrayList<Node>> adj){
        int key[]=new int[n];
        int parent[]=new int[n];
        boolean mstSet[]=new boolean[n];

        for(int i=0;i<n;i++){
            key[i]=Integer.MAX_VALUE;
            parent[i]=-1;
            mstSet[i]=false;
        }

        key[0]=0;
        for(int i=0;i<n-1;i++){
            int mini = 1000000,u=0;
            for(int v=0;v<n;v++){
                if(mstSet[v]==false && key[v]<mini){
                    mini=key[v];
                    u=v;
                }
            }
            mstSet[u]=true;

            for(Node it:adj.get(u)){
                if(mstSet[it.getV()]==false && it.getWeight() < key[it.getV()]){
                    parent[it.getV()]=u;
                    key[it.getV()]=it.getWeight();
                }
            }
        }

        for(int i=1;i<n;i++){
            System.out.println(parent[i]+" - "+i);
        }
    }
    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Node> > adj = new ArrayList<ArrayList<Node> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Node>());
			
		adj.get(0).add(new Node(1, 2));
		adj.get(1).add(new Node(0, 2));
		
		adj.get(1).add(new Node(2, 3));
		adj.get(2).add(new Node(1, 3));
		
		adj.get(0).add(new Node(3, 6));
		adj.get(3).add(new Node(0, 6));
		
		adj.get(1).add(new Node(3, 8));
		adj.get(3).add(new Node(1, 8));
		
		adj.get(1).add(new Node(4, 5));
		adj.get(4).add(new Node(1, 5));
		
		adj.get(2).add(new Node(4, 7));
		adj.get(4).add(new Node(2, 7));

        primeAlgo(n, adj);
    }
}
