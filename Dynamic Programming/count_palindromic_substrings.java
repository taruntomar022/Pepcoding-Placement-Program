import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        cpss(str);
    }
    
    public static void cpss(String str){
        int counter = 0;
        boolean strg[][] = new boolean[str.length()][str.length()];
        for(int diag = 0;diag<str.length()-1;diag++){
            int si = 0;
            int ei = diag;
            while(ei<str.length()){
                if(diag == 0){
                    strg[si][ei] = true;
                }else if(diag == 1){
                    if(str.charAt(si)==str.charAt(ei)){
                        strg[si][ei] = true;
                    }
                }else{
                    if(str.charAt(si)==str.charAt(ei)&&strg[si+1][ei-1]){
                        strg[si][ei] = true;
                    }
                }
                if(strg[si][ei]==true){
                    counter++;
                }
                ei++;
                si++;
            }
        }
        System.out.println(counter);
    }

}