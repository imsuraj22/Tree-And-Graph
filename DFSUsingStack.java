import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFSUsingStack {
    private LinkedList<Integer> adj[];
    private boolean visited[];

    DFSUsingStack(int v){
        visited=new boolean[v];
        adj=new LinkedList[v];

        for(int i=0;i<v;i++){
            adj[i]=new LinkedList<Integer>();
        }
        for(int i=0;i<v;i++){
            visited[i]=false;
        }
    }

    void insertEdge(int src, int dest){
        adj[src].add(dest);
        }

        void DFS(int s){
            Stack<Integer> stack=new Stack<>();
            stack.push(s);

            while(!stack.isEmpty()){
                s=stack.pop();

                if(!visited[s]){
                    System.out.print(s+" ");
                    visited[s]=true;
                }

                Iterator<Integer> itr=adj[s].listIterator();
                while(itr.hasNext()){
                    int v=itr.next();
                    if(!visited[v]){
                        stack.push(v);
                    }
                }
            }
        }
    public static void main(String[] args) {
        DFSUsingStack graph = new DFSUsingStack(8);  
  
        graph.insertEdge(0, 1);    
        graph.insertEdge(0, 2);    
        graph.insertEdge(2, 1);    
        graph.insertEdge(0, 3);    
        graph.insertEdge(1, 4);  
        graph.insertEdge(3, 5);       
        graph.insertEdge(3, 6);    
        graph.insertEdge(4, 7);    
        graph.insertEdge(4, 5);    
        graph.insertEdge(5, 2);    
          
        System.out.println("Depth First Traversal for the graph is:");    
        graph.DFS(0);    
    }
}
