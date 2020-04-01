import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        printKPC(str,"");
    }

    static String[] keys = {
        ".;",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tu",
        "vwx",
        "yz"
    };

    public static void printKPC(String str,String asf) {
        
        if(str.length() == 0){
            System.out.println(asf);
            return;
        }
        
        char ch = str.charAt(0);
        String req = str.substring(1);
        
        int keyIdx = Integer.parseInt(ch+"");//String to integer conversion
        //char to integer conversion
        //int keyIdx = (ch-'0');
        String word = keys[keyIdx];
        
        for(int idx =0;idx<word.length();idx++){
            printKPC(req,asf+word.charAt(idx));
        }
    }

}