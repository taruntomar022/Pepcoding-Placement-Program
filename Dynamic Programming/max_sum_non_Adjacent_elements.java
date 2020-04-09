import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(maxSum(arr));
    }
    
    public static int maxSum(int arr[]){
        int n = arr.length;
        int dp[][] = new int[2][n];
        dp[0][0] = 0;
        dp[1][0] = arr[0];
        for(int col=1;col<n;col++){
            dp[0][col] = Math.max(dp[0][col-1],dp[1][col-1]);
            dp[1][col] = dp[0][col-1] + arr[col];
        }
        
        int max = Math.max(dp[0][n-1],dp[1][n-1]);
        return max;
    }
}