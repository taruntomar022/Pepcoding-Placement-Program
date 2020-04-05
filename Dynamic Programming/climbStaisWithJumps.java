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
        System.out.println(climbStairs(arr,0,new int[n]));
    }
    
    public static int climbStairs(int[] arr,int n,int[] dp){
        if(n==arr.length-1){
            return 1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int totalways = 0;
        int maxClimb = arr[n];
        for(int i = 1;i <= maxClimb && i+n <= arr.length-1;i++){
            totalways += climbStairs(arr,n+i,dp);
        }
        dp[n] = totalways;
        return dp[n];
    }
}