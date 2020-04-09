import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        System.out.println(tiling(n,m));
    }
    
    public static int tiling(int n,int m){
        int dp[] = new int[n+1];
        for(int pos = 1;pos<=n;pos++){
            if(pos<m){
                dp[pos] = 1;
            }else if(pos==m){
                dp[pos] = 2;
            }else{
                dp[pos] = dp[pos-1] + dp[pos-m]; 
            }
        }
        return dp[n];
    }
}