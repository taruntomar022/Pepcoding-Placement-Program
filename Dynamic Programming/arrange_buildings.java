import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(binarycon(n));  
 }
 
 public static long binarycon(int n){
     long dp[][] = new long[2][n+1];
     
     dp[0][1] = 1;
     dp[1][1] = 1;
     for(int col=2;col<=n;col++){
         dp[0][col] = dp[0][col-1]+dp[1][col-1];
         dp[1][col] = dp[0][col-1];
     }
     long config = dp[0][n] + dp[1][n];
    return config*config;
}
}