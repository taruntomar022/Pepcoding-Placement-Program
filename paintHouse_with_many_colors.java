import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int arr[][] = new int[n][k];
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                arr[i][j] = scn.nextInt();
            }
        }
        System.out.println(paintHouse(arr));
    }
    
    public static int min(int dp[][],int row,int excIdx){
        int min = Integer.MAX_VALUE;
        for(int h=0;h<dp[0].length;h++){
            if(h!=excIdx){
                if(min>dp[row][h]){
                    min = dp[row][h];
                }
            }
        }
        return min;
    }
    
    public static int paintHouse(int arr[][]){
        int n = arr.length;
        int k = arr[0].length;
        int dp[][] = new int[n][k];
        for(int c=0;c<k;c++){
            dp[0][c] = arr[0][c];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<k;j++){
                dp[i][j] = arr[i][j] + min(dp,i-1,j);
            }
        }
        
        return min(dp,n-1,-1);
    }
}