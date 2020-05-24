import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn =  new Scanner(System.in);
        String str = scn.nextLine();
        cps(str);
    }
    
    public static void cps(String str){
        int dp[][] = new int[str.length()][str.length()];
        for(int dia = 0;dia<str.length();dia++){
            for(int i=0,j=dia;j<str.length();i++,j++){
                if(dia==0){
                    dp[i][j] = 1;
                }
                else if(dia == 1){
                    if(str.charAt(i) == str.charAt(j)){
                        dp[i][j] = 3;
                    }else{
                        dp[i][j] = 2;
                    }
                }else{
                    if(str.charAt(i)==str.charAt(j)){
                        dp[i][j] = dp[i][j-1]+dp[i+1][j] + 1;
                    }else{
                        dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
                    }
                }
            }
        }
        System.out.println(dp[0][str.length()-1]);
    }

}