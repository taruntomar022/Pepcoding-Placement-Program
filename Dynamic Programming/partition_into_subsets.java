import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int k = scn.nextInt();
      if(n==0||k==0||n<k){
            System.out.println("0");
        }else{
            System.out.println(partitionSubsets(n,k));
        }
   }

    public static long partitionSubsets(int n,int k){
        long dp[][] = new long[n+1][k+1];
        
    
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                if(i==1||j==1||i==j){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j-1] + j*dp[i-1][j];
                }
            }
        }
        return dp[n][k];
    }

}