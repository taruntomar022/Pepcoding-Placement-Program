import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(buySell(arr));
    }

    public static int buySell(int arr[]){
        int n = arr.length;
        int dp[][] = new int[2][n];
        dp[0][0] = arr[0];
        dp[1][0] = 0;
        for(int i=1;i<n;i++){
            if(arr[i]<dp[0][i-1]){
                dp[0][i] = arr[i];
            }else{
                dp[0][i] = dp[0][i-1];
            }
            
            if(arr[i]-dp[0][i] > dp[1][i-1]){
                dp[1][i] = arr[i] - dp[0][i];
            }else{
                dp[1][i] = dp[1][i-1];
            }
        }
        
        return dp[1][n-1];
    }
}