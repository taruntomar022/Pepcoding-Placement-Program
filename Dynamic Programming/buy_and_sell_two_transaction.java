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
        System.out.println(buySell(arr));
    }

    public static int buySell(int arr[]){
        int n = arr.length;
        int dp[] = new int[n];
        int msf = arr[0];
        dp[0] = 0;
        for(int i=1;i<n;i++){
            if(arr[i]<msf){
                msf = arr[i];
            }
            if(arr[i]-msf > dp[i-1]){
                dp[i] = arr[i] - msf;
            }else{
                dp[i] = dp[i-1];
            }
        }
        
        int dp2[] = new int[n];
        int max_so_far = arr[n-1]; 
        dp2[n-1] = 0;
        for(int j=n-2;j>=0;j--){
            if(arr[j]>max_so_far){
                max_so_far = arr[j];  
            }
            if(Math.abs(arr[j]-max_so_far) > dp2[j+1]){
                dp2[j] = Math.abs(arr[j] - max_so_far);
            }else{
                dp2[j] = dp2[j+1];
            }
            
        }
        
        int res = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(dp[i]+dp2[i]>res){
                res = dp[i] + dp2[i];
            }
        }
        
        return res;
    }
}