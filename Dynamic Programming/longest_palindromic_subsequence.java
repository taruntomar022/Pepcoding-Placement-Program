import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        lps(str);
    }
    
    public static void lps(String str){
        int dp[][] = new int[str.length()][str.length()];
        for(int diag = 0;diag<str.length();diag++){
            int si = 0;
            int ei = diag;
            while(ei<str.length()){
                if(diag == 0){
                    dp[si][ei] = 1;
                }
                else if(diag == 1){
                    if(str.charAt(si) == str.charAt(ei))
                        dp[si][ei] = 2;
                    else
                        dp[si][ei] = 1;
                }
                else {
                    if(str.charAt(si) == str.charAt(ei)){
                        dp[si][ei] = dp[si+1][ei-1] + 2;
                    }
                    else{
                        dp[si][ei] = Math.max(dp[si+1][ei] , dp[si][ei-1]);
                    }
                }
                si++;
                ei++;
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<str.length();i++){
            if(max<dp[0][i]){
                max = dp[0][i];
            }
        }
        
        System.out.println(max);
    }

}