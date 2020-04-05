import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here\
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // System.out.println(stairpaths(n,new int[n+1]));
        System.out.println(climbPaths(n));
    }
    
    //Memoization method
    
    // public static int stairpaths(int n,int[] dp){
        
    //     if(n==0){
    //       return 1;
    //     }
        
    //     if(dp[n]!=0){
    //         //if answer already exists
    //         return dp[n];
    //     }
        
    //     int totalways = 0;
    //     for(int step=1;step<=3;step++){
    //         if(n-step>=0){
    //             totalways += stairpaths(n-step,dp);
    //         }    
    //     }
        
    //     dp[n] = totalways;
    //     return dp[n];
    // }
    
    //Tabulation mathod
    
    public static int climbPaths(int n){
        int dp[] = new int[n+1];
        dp[n] = 1;
        for(int stair = n-1;stair>=0;stair--){
            int countPaths = 0;
            for(int climb = 1; climb<=3;climb++){
                if(stair + climb <= n){
                    countPaths += dp[stair+climb];
                }
            }
            
            dp[stair] = countPaths;
        }
        return dp[0];
    }
}