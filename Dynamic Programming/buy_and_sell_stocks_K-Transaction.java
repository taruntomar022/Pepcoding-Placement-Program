import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < arr.length; i++) {
         arr[i] = scn.nextInt();
      }

      int k = scn.nextInt();

      int[][] dp = new int[k + 1][n];

      // for(int i = 1; i <= k; i++){
      //    for(int j = 1; j < n; j++){
      //       int max = 0;
      //       for(int l = 0; l < j; l++){
      //          if(dp[i - 1][l] + arr[j] - arr[l] > max){
      //             max = dp[i - 1][l] + arr[j] - arr[l];
      //          }
      //       }

      //       if(max > dp[i][j - 1]){
      //          dp[i][j] = max;
      //       } else {
      //          dp[i][j] = dp[i][j - 1];
      //       }
      //    }
      // }

      for(int i = 1; i <= k; i++){
         int fadd = Integer.MIN_VALUE;

         for(int j = 1; j < n; j++){
            if(dp[i - 1][j - 1] - arr[j - 1] > fadd){
               fadd = dp[i - 1][j - 1] - arr[j - 1];
            }

            if(fadd + arr[j] > dp[i][j - 1]){
               dp[i][j] = fadd + arr[j];
            } else {
               dp[i][j] = dp[i][j - 1];
            }
         }
      }

      System.out.println(dp[k][n - 1]);
   }

}