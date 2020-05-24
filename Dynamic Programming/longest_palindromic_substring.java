import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        lpss(str);
    }
    
    public static void lpss(String str){
        boolean dp[][] = new boolean[str.length()+1][str.length()+1];
        int maxLength = 0;
        for(int dia=0;dia<str.length();dia++){
            for(int i=0,j=dia;j<str.length();i++,j++){
                if(dia==0){
                    dp[i][j] = true;
                }else if(dia==1){
                    if(str.charAt(i) == str.charAt(j)){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }else{
                    if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1] == true){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }
                if(dp[i][j]==true){
                    maxLength = dia+1;
                }
            }
        }
        System.out.println(maxLength);
    }

}