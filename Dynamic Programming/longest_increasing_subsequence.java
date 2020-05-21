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
        lis(arr,n);
    }
    public static void lis(int arr[],int n){
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i=1;i<n;i++){
            int maxLength = 0;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]&&dp[j]>maxLength){
                    maxLength = dp[j];
                }
            }
            dp[i] = maxLength + 1;
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            if(ans<dp[i]){
                ans = dp[i];
            }
        }
        System.out.println(ans);
    }
}