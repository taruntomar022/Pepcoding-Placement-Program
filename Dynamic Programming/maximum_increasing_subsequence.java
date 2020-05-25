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

      int omax = Integer.MIN_VALUE;
      int[] dp = new int[arr.length];
      for(int i = 0; i < arr.length; i++){
         Integer max = null;

         for(int j = 0; j < i; j++){
            if(arr[j] <= arr[i]){
               if(max == null || dp[j] > max){
                  max = dp[j];
               }
            }
         }

         if(max != null){
            dp[i] = max + arr[i];
         } else {
            dp[i] = arr[i];
         }
         
         if(dp[i] > omax){
            omax = dp[i];
         }
      }

      System.out.println(omax);
   }

}