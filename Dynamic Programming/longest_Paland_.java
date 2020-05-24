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
        for(int dia = 0; dia < str.length();dia++){
            //diagonal = j-i
            for(int i=0,j=dia;j<str.length();i++,j++){
                if(dia==0){
                    dp[i][j] = 1;
                }else if(dia == 1){
                    if(str.charAt(i) == str.charAt(j)){
                        dp[i][j] = 2;
                    }else{
                        dp[i][j] = 1;
                    }
                }else{
                    if(str.charAt(i) == str.charAt(j)){
                        dp[i][j] =2 + dp[i+1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                    }
                }
            }
            
        }
        System.out.println(dp[0][str.length()-1]);
    }

}