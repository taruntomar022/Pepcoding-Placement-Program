import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(subsequence(str));
    }
    
    public static int subsequence(String str){
        int n = str.length();
        int dp[][] = new int[3][n];
        
        if(str.charAt(0)=='a'){
            dp[0][0] = 1;
        }
        
    
        for(int j=1;j<n;j++){
            if(str.charAt(j)=='a'){
                dp[0][j] = 1+(2*dp[0][j-1]);
            }else{
                dp[0][j] = dp[0][j-1];
            }
            
            if(str.charAt(j)=='b'){
                dp[1][j] = dp[0][j]+(2*dp[1][j-1]);
            }
            else{
               dp[1][j] = dp[1][j-1]; 
            }
            
            if(str.charAt(j)=='c'){
                dp[2][j] = dp[1][j]+(2*dp[2][j-1]);
            }
            else{
               dp[2][j] = dp[2][j-1]; 
            }
            
        }
        
        return dp[2][n-1];
    }
}