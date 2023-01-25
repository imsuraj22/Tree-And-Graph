import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.text.html.FormSubmitEvent;

class Test{
    
    static public int[][] rangeAddQueries(int n, int[][] queries) {
        int mat[][]=new int[n][n];
        HashMap<Integer, ArrayList<Integer>>[] array = (HashMap<Integer, ArrayList<Integer>>[]) new HashMap[n];


        for(int i=0;i<queries.length;i++){
            
                int row1=queries[i][0];
                int col1=queries[i][1];
                int row2=queries[i][2];
                int col2=queries[i][3];
  
               
                for(int j=row1;j<=row2;j++){
                    int c1=col1;
                        array[j].put(j, new ArrayList(n));
                        while(c1<=col2){
                            array[j].get(1).add(c1, +1);
                            c1++;
                        }
                    
                }

                for (int i : array.keySet()) {
                    for (array.Entry<Integer, ArrayList<Integer>> entry : array.get(i).entrySet()) {
                         V value = entry.getValue();
                    }
                 }

                 
                    ArrayList<Integer> element = map[i].get(j);
                 }




                //     for(int j=0;j<n;j++){
                //         for(int k=0;k<n;k++){
                //             if(j>=row1 && j<=row2 && k>=col1 && k<=col2){
                //                 mat[j][k]+=1;
                //             }
                //         }
                    
                // }

                
            
        }
        return mat;
  }
    

public static void main(String args[])  {  
   int arr[][]=new int[][]{
    {1,1,2,2},
    {0,0,1,1}
   };
   int ans[][]=rangeAddQueries(3, arr);
   for(int i=0;i<ans.length;i++){
    System.out.println(ans[i]);
   }

} 
}