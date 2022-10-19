import java.util.Scanner;

public class DisjoinSet{

    static int parent[]=new int[1000000];
    static int rank[]=new int[1000000];

    static void makeSet(int n){
        for(int i=1;i<=n;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }

    static int findPar(int node){
        if(node==parent[node]){
            return node;
        }
        return parent[node]=findPar(parent[node]);
    }

    static void union(int u, int v){
        u=findPar(u);
        v=findPar(v);

        if(rank[u]<rank[v]){
            parent[u]=v;
        }else if(rank[v]<rank[u]){
            parent[v]=u;
        }else{
            parent[v]=u;
            rank[u]++;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("Enter the no of unions");
        n=sc.nextInt();
        makeSet(n);
        
        while(n>0){
            int u,v;
            System.out.println("Enter U : ");
            u=sc.nextInt();
            System.out.println("Enter V : ");
            v=sc.nextInt();
            union(u, v);
            n--;
        }

        if(findPar(2)!=findPar(3)){
            System.out.println("Diffrent componnent : ");
        }else{
            System.out.println("Same component : ");
        }
    }
}