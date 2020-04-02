import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        ArrayList<String> result = getKPC(str);
        System.out.println(result);
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

    public static ArrayList<String> getKPC(String str) {
        if(str.length() == 0){
                ArrayList<String> list = new ArrayList<>();
                list.add("");
                return list;
        }
        
        ArrayList<String> recResult = getKPC(str.substring(1));
        ArrayList<String> myresult = new ArrayList<>();
        
        char ch = str.charAt(0);
        int keyIdx = Integer.parseInt(ch+"");
        String word = keys[keyIdx];
        
        for(int idx=0;idx<word.length();idx++){
            char letter = word.charAt(idx);
            
            for(String val:recResult){
                myresult.add(letter+val);
            }
        }
        return myresult;
    }

}