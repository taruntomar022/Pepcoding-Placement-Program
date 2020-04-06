import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int rows = scn.nextInt();
        int cols = scn.nextInt();
        int arr[][] = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        System.out.println(minMoves(arr));
    }
    
    public static int minMoves(int arr[][]){
        
        int n = arr.length;
        int m = arr[0].length;
        int dp[][] = new int[n][m];
       
        for(int row=n-1;row>=0;row--){
            for(int col=m-1;col>=0;col--){
                if(row == n-1 && col == m-1){
                    dp[row][col] = arr[row][col];
                }else if(row == n-1){
                    dp[row][col] = arr[row][col] + dp[row][col+1];
                }else if(col == m-1){
                    dp[row][col] = arr[row][col] + dp[row+1][col];
                }else{
                    int h = dp[row][col+1];
                    int v = dp[row+1][col];
                    dp[row][col] = Math.min(h,v) + arr[row][col];
                }
            }
        }
        return dp[0][0];
    }
}