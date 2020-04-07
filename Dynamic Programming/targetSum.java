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
        System.out.println(targetSum(arr,tar));
    }
    
    public static boolean targetSum(int arr[],int tar){
        int n= arr.length;
        boolean dp[][] = new boolean[n+1][tar+1];
        
       
        for(int row=0;row<n+1;row++){
            
            for(int col=0;col<tar+1;col++){
                if(col==0){
                    dp[row][col] = true;
                }
                else if(row==0){
                    dp[row][col] = false;
                }
                else{
                    int coin = arr[row-1];
                    boolean inc = false;
                    boolean exc = dp[row-1][col];
                    if(coin<=col){
                        inc = dp[row-1][col-coin];
                    }
                    dp[row][col] = inc||exc;
                }
            }
             if(dp[row][tar] == true){
                    return true;
                }
        }
        return dp[n][tar];
    }
    
}