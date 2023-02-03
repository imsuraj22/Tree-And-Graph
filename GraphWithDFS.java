import java.util.ArrayList;
import java.util.Scanner;

public class GraphWithDFS {
    int vertices;
    ArrayList<ArrayList<Integer>> graph;


    GraphWithDFS(int vertices){
        this.vertices=vertices;
        graph=new ArrayList<>(vertices);
        for(int i=0;i<=vertices;i++){
            graph.add(new ArrayList<>());
        }
    }

    void addNodes(int source, int destination){
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    // void printGraph(int V){
    //     for(int i=0;i<vertices;i++){
    //         System.out.println("Adjecancy list of vertex "+i);
    //         System.out.println("Head");
    //         for(Integer vertex:graph.get(i)){
    //             System.out.println("-> "+vertex);
    //         }
    //         System.out.println();
    //     }

    // }

    void DFS(){
        boolean visited[]=new boolean[vertices+1];
        for(int i=0;i<=vertices;i++){
            if(!visited[i]){
                DFS(i,visited);
            }
        }
    }
    void DFS(int vertex, boolean visited[]){
        visited[vertex]=true;
        System.out.print(vertex+" ");
        for(Integer v:graph.get(vertex)){
            if(!visited[v]){
                DFS(v,visited);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v;
        System.out.println("enter the no of vertices ");
        v=sc.nextInt();
        GraphWithDFS g=new GraphWithDFS(v);
        int node=0;
        for(int i=1;i<=v;i++){
            while(true){
                System.out.println("Enter the adjecancy nodes of vertex "+i+" or enter -1 to move to the next vertex "+i);
                node=sc.nextInt();
                if(node==-1) break;
                
                g.addNodes(i, node);
            }
        }
        sc.close();
        //g.printGraph(v);
        g.DFS();

    }
}
