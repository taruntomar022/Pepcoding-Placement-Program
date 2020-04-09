import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(tiling(n));
    }
    
    public static int tiling(int n){
        int dp[] = new int[n+1];
       
     dp[1] = 1;
     dp[2] = 2;
     
     for(int pos=3;pos<=n;pos++){
         dp[pos] = dp[pos-1]+dp[pos-2];
     }
     return dp[n];
    }
}