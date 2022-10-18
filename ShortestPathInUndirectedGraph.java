import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPathInUndirectedGraph {

    static void shortestPath(int src, int n, ArrayList<ArrayList<Integer>> adj){
        int distance[]=new int[n];
        for(int i=0;i<n;i++){
            distance[i]=1000000000;
        }

        Queue<Integer> q=new LinkedList<>();

        distance[src]=0;
        q.add(src);

        while(!q.isEmpty()){
            Integer node=q.poll();

            for(Integer it:adj.get(node)){
                if(distance[node]+1 < distance[it]){
                    distance[it]=distance[node]+1;
                    q.add(it);
                }
            }
        }

        for(int i=0;i<n;i++){
            System.out.print(distance[i]+" ");
        }

    }
    public static void main(String[] args) {
        int V = 18;
        Scanner sc=new Scanner(System.in);
        
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());

                System.out.println("Enter from to where :");
                for(int i=0;i<V;i++){
                    int from,to;
                    
                    System.out.println("From : ");
                    from=sc.nextInt();
                    System.out.println("To : ");
                    to=sc.nextInt();
                    adj.get(from).add(to);

                }

                shortestPath(0, V, adj);

                
                // adj.get(5).add(0);
                // adj.get(5).add(2);
                // adj.get(2).add(3);
                // adj.get(3).add(1);
                // adj.get(4).add(0);
                // adj.get(4).add(1);
    }
}
