import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        System.out.print(coinPer(arr,tar));
    }
    
    public static int coinPer(int arr[],int tar){
        int dp[] = new int[tar+1];
        
        dp[0] = 1;
        
        for(int pos = 1;pos<=tar;pos++){
            
            for(int i=0;i<arr.length;i++){
                int coin = arr[i];
                if(coin<=pos){
                    dp[pos] += dp[pos-coin];
                }
            }
        }
        return dp[tar];
    }
}