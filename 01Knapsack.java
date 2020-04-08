import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int val[] = new int[n];
        int weight[] = new int[n];
        for(int i=0;i<n;i++){
            val[i] = scn.nextInt();
        }
        for(int i=0;i<n;i++){
            weight[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        System.out.println(knapsack(val,weight,tar));
    }
    
    public static int knapsack(int val[],int weight[],int tar){
        int dp[][] = new int[val.length+1][tar+1];
        for(int row=0;row<val.length+1;row++){
            for(int col=0;col<tar+1;col++){
                if(col==0||row==0){
                    dp[row][col] = 0;
                }
                else if(weight[row-1]<=col){
                    dp[row][col] = Math.max(val[row - 1] + dp[row - 1][col - weight[row - 1]], dp[row - 1][col]); 
                }
                else{
                    dp[row][col] = dp[row-1][col];
                }
            }
        }
        return dp[val.length][tar];
    
    }
}