import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int dp[] = new int[n+1];
    dp[0] = 1;
    for(int i=1;i<=n;i++){
        for(int j=0;j<i;j++){
            dp[i] += dp[j]*dp[i-1-j];
        }
    }
    
    System.out.println(dp[n]);
 }

}