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
        System.out.println(goldmine(arr));
    }
    
    
    //tabulation
    public static int goldmine(int arr[][]){
        int n = arr.length;
        int m = arr[0].length;
        int dp[][] = new int[n][m];
        for(int col=m-1;col>=0;col--){
            for(int row=0;row<n;row++){
                if(col==m-1){
                    dp[row][col] = arr[row][col];
                }else if(row == n-1){
                    dp[row][col] = arr[row][col] + Math.max(dp[row][col+1],dp[row-1][col+1]);
                }else if(row==0){
                    dp[row][col] = arr[row][col] + Math.max(dp[row][col+1],dp[row+1][col+1]);
                }else{
                    dp[row][col] = arr[row][col] + Math.max(dp[row-1][col+1],Math.max(dp[row][col+1],dp[row+1][col+1]));
                }
            }
        }
        
        int max = dp[0][0];
        for(int row=0;row<n;row++){
            if(dp[row][0]>max){
                max = dp[row][0];
            }
        }
        return max;
    } 
}