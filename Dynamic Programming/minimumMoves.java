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
        
        //memoization
        System.out.println(minMoves(arr));
        //recursion
        // System.out.pritnln(minMoves(arr,0);
        
    }
    
    //by recursion
    // public static int minMoves(int steps[],int pos){
    //     if(pos==steps.length-1){
    //         //destination reached
    //         return 0;
    //     }
        
    //     int maxMove = steps[pos];
    //     if(maxMove == 0){
    //         return Integer.MAX_VALUE;
    //     }
    //     int min = Integer.MAX_VALUE;
    //     for(int len = 1;len<=maxMove&&pos+len<steps.length;len++){
    //         min = Math.min(min,minMoves(steps,pos+len));  //minimum till now
    //     }
    //     return min+1;
    // }

    //memoization
    public static int minMoves(int[] arr,int n){
        int dp[] = new int[n];
        dp[n-1] = 1;
        int min = Integer.MAX_VALUE;
        for(int j=n-2;j>=0;j--){
            int ways = 0;
            int maxclimb = arr[j];
            for(int i=1;i<=maxclimb&&i+j<=n-1;i++){
                
                if(j+i<=n-1){
                    if(j==0){
                        ways++;
                    }
                    
                    dp[j] += dp[i+j];
                }
            }
            if(ways<min){
                min = ways;
            }
        }
        return min+1;
    
    }
}
