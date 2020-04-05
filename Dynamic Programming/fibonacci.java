import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(fibonacci(n,new int[n+1]));
 }
 
 public static int fibonacci(int n,int[] dp){
     if(n==0||n==1){
         return n;
     }
     
     if(dp[n]!=0){
         //answer already exists
         return dp[n];
     }
     
     int f1 = fibonacci(n-1,dp);
     int f2 = fibonacci(n-2,dp);
     int res = f1+f2;
     dp[n] = res;
     
     return dp[n];
 }

}