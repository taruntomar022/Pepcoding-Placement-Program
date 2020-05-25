import java.io.*;
import java.util.*;

public class Main {

    static class pair implements Comparable<pair>{
        int nb;
        int sb;
        public int compareTo(pair other){
            if(this.nb != other.nb){
                return this.nb - other.nb;
            }else{
                return this.sb - other.sb;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pair[] bridges = new pair[n];
        for(int i = 0;i<n;i++){
            pair bridge = new pair();
            bridge.nb = scn.nextInt();
            bridge.sb = scn.nextInt();
            bridges[i] = bridge;
        }
        
        Arrays.sort(bridges);
        int[] dp = new int[n];
        for(int i = 0;i<n;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(bridges[i].sb > bridges[j].sb && max < dp[j]){
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
        }
        
        int lis = dp[0];
        for(int i=1;i<n;i++){
            if(lis<dp[i]){
                lis = dp[i];
            }
        }
        System.out.println(lis);
    }

}