import java.util.LinkedList;
import java.util.Queue;

public class FindClosestNode {
    static public int closestMeetingNode(int[] edges, int node1, int node2) {
     int n=edges.length;
     int dist1[]=new int[n];
     int dist2[]=new int[n];
     
    bfs(node1, edges, dist1,n);
    bfs(node2, edges, dist2, n);

    int minDist=-1,minDistTillNow=Integer.MAX_VALUE;

    for(int currNode=0;currNode<n;currNode++){
        if(minDistTillNow>Math.max(dist1[currNode], dist2[currNode])){
            minDist=currNode;
            minDistTillNow=Math.max(dist1[currNode], dist2[currNode]);
        }
    }
    return minDist;
     
    }

    static void bfs(int startNode, int edge[], int dist[],int n){

        boolean visited[]=new boolean[n];
        Queue<Integer> q=new LinkedList<>();

        q.add(startNode);

        while(!q.isEmpty()){

            int node=q.poll();
            if(visited[node]==true){
                continue;
            }
            visited[node]=true;
            int neighbour=edge[node];
            if(neighbour!=-1 && !visited[neighbour]){
                dist[neighbour]=1+dist[node];
                q.offer(neighbour);
            }

        }

    }
    public static void main(String[] args) {
        int arr[]=new int[]{2,2,3,-1};
        System.out.println(closestMeetingNode(arr, 0, 1));
    }
}
