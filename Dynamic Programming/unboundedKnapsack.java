	import java.io.*;
	import java.util.*;

	public class Main {

	    public static void main(String[] args) throws Exception {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int val[] = new int[n];
            for(int i=0;i<n;i++){
                val[i] = scn.nextInt();
            }
            int weight[] = new int[n];
            for(int i=0;i<n;i++){
                weight[i] = scn.nextInt();
            }
            int tar = scn.nextInt();
            System.out.println(unboundKnapsack(val,weight,tar));
	    }
	    
	    public static int unboundKnapsack(int val[],int weight[],int tar){
	        
	        int dp[] = new int[tar+1];
	        for(int i = 0; i <= tar; i++){ 
            for(int j = 0; j < val.length; j++){ 
                if(weight[j] <= i){ 
                    dp[i] = Math.max(dp[i], dp[i - weight[j]] +  
                                val[j]); 
                } 
            } 
        } 
        return dp[tar]; 
	    }
	}