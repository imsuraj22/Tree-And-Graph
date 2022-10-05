import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Test{
    private HashMap<Integer,LinkedList<Integer>> map=new HashMap<Integer,LinkedList<Integer>>();
    private Queue<Integer> que;
    Test(int v){
        
        que=new LinkedList<Integer>();
    }


void insertEdge(int v, int w){
    LinkedList<Integer> adj=map.getOrDefault(v, new LinkedList<Integer>());
    adj.push(w);
    map.put(v, adj);
    String l=map.get(v).toString();
    System.out.println(l);
}

void BFS(int source,int dest){
map.get()

    while(!que.isEmpty()){
        for(int i=que.in)
        //n=que.poll();
        System.out.println(n+" ");
        for(int i=0; i<adj[n].size();i++){
            a=adj[n].get(i);
            if(!nodes[a]){
                nodes[a]=true;
                que.add(a);
            }
        }
    }

}

public static void main(String args[])    
    {    
        Test graph = new Test(10);    
        // graph.insertEdge(0, 1);    
        // graph.insertEdge(0, 2);    
        // graph.insertEdge(0, 3);    
        // graph.insertEdge(1, 3);    
        // graph.insertEdge(2, 4);  
        // graph.insertEdge(3, 5);       
        graph.insertEdge(3, 6);    
        graph.insertEdge(3, 12);    
        // graph.insertEdge(4, 7);    
        // graph.insertEdge(4, 5);    
        // graph.insertEdge(5, 2);    
        // graph.insertEdge(6, 5);    
        // graph.insertEdge(7, 5);  
        // graph.insertEdge(7, 8);   
        System.out.println("Breadth First Traversal for the graph is:");    
        // graph.BFS(2);    
    }    

} 