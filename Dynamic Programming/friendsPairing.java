import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(friendsPair(n));
    }

    public static int friendsPair(int n) {
        int dp[] = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i <= 2) {
                dp[i] = i;
            } else {
                dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
            }
        }

        return dp[n];
    }

}