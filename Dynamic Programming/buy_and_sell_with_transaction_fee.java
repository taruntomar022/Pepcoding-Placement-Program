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
        int transFee = scn.nextInt();
        // int buyP = 0 - arr[0];
        // int sellP = 0;
        // for(int i=1;i<arr.length;i++){
        //     int nBuyP = Math.max(sellP - arr[i] , buyP);
        //     int nSellP = Math.max(buyP + arr[i] - transFee, sellP);
        //     buyP = nBuyP;
        //     sellP = nSellP;
        // }
        
        // System.out.println(sellP);
        System.out.println(bsstf(arr,transFee));
    }
    
    public static int bsstf(int arr[],int transFee){
        int dp[][] = new int[2][arr.length];
        dp[0][0] = 0 - arr[0];
        dp[1][0] = 0;
        for(int i=1;i<arr.length;i++){
            dp[0][i] = Math.max(dp[1][i-1] - arr[i], dp[0][i-1]);
            dp[1][i] = Math.max(dp[0][i-1] + arr[i] - transFee, dp[1][i-1]);
        }
        
        
        
        return dp[1][arr.length-1];
    }
}