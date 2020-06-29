import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }

      System.out.println(isIsland(arr));
   }
   
   public static int isIsland(int arr[][]){
       // iterative traversing
       boolean visited[][] = new boolean[arr.length][arr[0].length];
       int count = 0;
       // the number of time gcc is called is the number of islands
       for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                // check if the area is unvisited and it is a land
                if(!visited[i][j] && arr[i][j] == 0){
                    // gcc
                    gccPostActive(arr,i,j,visited);
                    count++;
                }
            }
       }
       return count;
   }
   // preactive approach -> logical beneficial as we are checking condition first and then applying it
   public static void gcc(int arr[][], int row,int col,boolean[][] visited){
       // check in the directions -> north, east, west, south
       // mark visited to prevent repitition
       visited[row][col] = true;
       // north
       if(row > 0 && arr[row-1][col] == 0 && !visited[row-1][col]){
           gcc(arr,row-1,col,visited);
       }
       // east
       if(col < arr[0].length-1 && arr[row][col+1] == 0 && !visited[row][col+1]){
           gcc(arr,row,col+1,visited);
       }
       // west
       if(col > 0 && arr[row][col-1] == 0 && !visited[row][col-1]){
           gcc(arr,row,col-1,visited);
       }
       // south
       if(row < arr.length - 1 && arr[row+1][col] == 0 && !visited[row+1][col]){
           gcc(arr,row+1,col,visited);
       }
   }
   
   // postactive approach 
   public static void gccPostActive(int arr[][], int row, int col, boolean[][] visited){
       if( row >= 0 && row < arr.length && col >= 0 && col < arr[0].length && arr[row][col] == 0 && !visited[row][col]){
           visited[row][col] = true;
           // north
           gccPostActive(arr,row-1,col,visited);
           // east
           gccPostActive(arr,row,col+1,visited);
           // west
           gccPostActive(arr,row,col-1,visited);
           // south
           gccPostActive(arr,row+1,col,visited);
       }
   }

}