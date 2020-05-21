import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        System.out.println(paintFence(n,k));
    }
    
    public static int paintFence(int n,int k){
        int[] dp = new int[n+1];
        int same = 0;
        int diff = k;
        dp[1] = same+diff;
        for(int i=2;i<dp.length;i++){
            same = diff;
            diff = dp[i-1]*(k-1);
            dp[i] = same + diff;
        }
        return dp[n];
    }
}